package com.android.clutch.presentation.home.mapsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.clutch.domain.model.MapModel
import com.android.clutch.domain.usecase.GetAgentListUseCase
import com.android.clutch.domain.usecase.GetMapListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MapListViewModel (
    private val getMapListUseCase: GetMapListUseCase
) : ViewModel() {

    private val _mapList = MutableLiveData<List<MapModel>>()
    val mapList: LiveData<List<MapModel>> get() = _mapList

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            //examples.exampleFold()
            try {
                _errorMessage.value = null
                val result = withContext(Dispatchers.IO) {
                    getMapListUseCase.invoke()
                }
                _mapList.value = result
            } catch (t: Throwable) {
                _errorMessage.value = "Error"
            }
        }
    }

}