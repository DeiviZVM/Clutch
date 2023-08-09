package com.android.clutch.presentation.home.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.clutch.domain.model.AgentModel
import com.android.clutch.domain.usecase.GetDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val getDetailUseCase: GetDetailUseCase
) : ViewModel(){

    private val _agent = MutableLiveData<AgentModel>()
    val agent: LiveData<AgentModel> get() = _agent

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    fun getAgent(id:String) = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO) {
                getDetailUseCase.invoke(id)
            }
            _agent.value = result
        } catch (_: Throwable) {
            _errorMessage.value = "Error lunched from ViewModel"
        }
    }
}