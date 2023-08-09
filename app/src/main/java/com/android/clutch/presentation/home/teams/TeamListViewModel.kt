package com.android.clutch.presentation.home.teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.clutch.domain.model.TeamModel
import com.android.clutch.domain.usecase.GetTeamListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TeamListViewModel(
    private val getTeamListUseCase: GetTeamListUseCase
) : ViewModel() {

    private val _teamList = MutableLiveData<List<TeamModel>>()
    val teamList: LiveData<List<TeamModel>> get() = _teamList

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            try {
                _errorMessage.value = null
                val result = withContext(Dispatchers.IO) {
                    getTeamListUseCase.invoke()
                }
                _teamList.value = result
            } catch (t: Throwable) {
                _errorMessage.value = "Error al cargar los datos"
            }
        }
    }
}