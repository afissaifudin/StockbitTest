package com.afisdev.stockbittest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.afisdev.core.network.ResultState
import com.afisdev.core.ui.BaseViewModel
import com.afisdev.stockbittest.model.Toplist
import com.afisdev.stockbittest.model.ToplistResponse
import com.afisdev.stockbittest.repository.MainRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WatchlistViewModel(private val repository: MainRepository) : BaseViewModel() {
    var toplistApiResponse = MutableLiveData<ResultState<ToplistResponse>>()
    var toplistResult = MutableLiveData<List<Toplist>>()

    fun getToplist(tsym: String, limit: Int = 20) {
        viewModelScope.launch {
            repository.fetchTopTier(tsym, limit).collect {
                toplistApiResponse.value = it
            }
        }
    }

    fun handleToplistApiResponse(result: ResultState<ToplistResponse>) {
        when (result.status) {
            ResultState.Status.LOADING -> isLoading.value = true
            ResultState.Status.SUCCESS -> {
                isLoading.value = false
                result.data?.let {
                    toplistResult.value = it.Data
                }
            }
            ResultState.Status.ERROR -> {
                isLoading.value = false
                message.value = result.message
            }
        }
    }

}