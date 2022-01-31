package com.kevinhao426.cryptocurrencylist.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevinhao426.cryptocurrencylist.dao.AppDatabase
import com.kevinhao426.cryptocurrencylist.model.CurrencyData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    val currencyListLiveData = MutableLiveData<List<CurrencyData>>()

    fun fetchCurrencyList(appDatabase: AppDatabase) {
        viewModelScope.launch {
            appDatabase.currencyDataDao().getAll().let {
                if (it.isNullOrEmpty()) {
                    //todo: io to inject data from json string to db
                } else {
                    currencyListLiveData.postValue(it)
                }
            }
        }

    }
}