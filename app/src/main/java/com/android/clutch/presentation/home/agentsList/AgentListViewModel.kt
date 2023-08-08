package com.android.clutch.presentation.home.agentsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.clutch.domain.model.AgentModel
import com.android.clutch.domain.usecase.GetAgentListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AgentListViewModel (
    private val getAgentListUseCase: GetAgentListUseCase
) : ViewModel() {

    private val _agentList = MutableLiveData<List<AgentModel>>()
    val agentList: LiveData<List<AgentModel>> get() = _agentList

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
                    getAgentListUseCase.invoke()
                }
                _agentList.value = result
            } catch (t: Throwable) {
                _errorMessage.value = "Error al cargar los datos"
            }
        }
    }
}