package com.reachnetwork.task.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reachnetwork.task.models.offers.OffersResponse
import com.reachnetwork.task.models.users.UsersResponse
import com.reachnetwork.task.repository.TaskRepository
import com.reachnetwork.task.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    val taskRepository = TaskRepository()
    val offersLiveData: MutableLiveData<Resource<OffersResponse>> = MutableLiveData()
    var offersResponse: OffersResponse? = null
    val usersLievData: MutableLiveData<Resource<UsersResponse>> = MutableLiveData()
    var usersResponse: UsersResponse? = null

    fun onOffersRequested() = viewModelScope.launch {
        val response = taskRepository.getOffers()
        offersLiveData.postValue(handleOffersResponse(response))
    }

    private fun handleOffersResponse(response: Response<OffersResponse>): Resource<OffersResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(offersResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun onUsersRequested() = viewModelScope.launch {
        val response = taskRepository.getUsers()
        usersLievData.postValue(handleUsersResponse(response))
    }

    private fun handleUsersResponse(response: Response<UsersResponse>): Resource<UsersResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(usersResponse ?: resultResponse)

            }
        }
        return Resource.Error(response.message())
    }

}