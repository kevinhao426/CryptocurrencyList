package com.kevinhao426.cryptocurrencylist.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kevinhao426.cryptocurrencylist.R
import com.kevinhao426.cryptocurrencylist.dao.AppDatabase
import com.kevinhao426.cryptocurrencylist.model.CurrencyData
import com.kevinhao426.cryptocurrencylist.utils.getJsonFromAssets
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.reflect.Type
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    val currencyListLiveData = MutableLiveData<List<CurrencyData>>()
    val dataErrorLiveData = MutableLiveData<String>()

    fun fetchCurrencyList(context: Context, appDatabase: AppDatabase) {
        viewModelScope.launch {
            appDatabase.currencyDataDao().getAll().let {
                if (it.isNullOrEmpty()) {
                    val str = getJsonFromAssets(context, "CurrencyList.json")
                    if (str.isNullOrEmpty()) {
                        dataErrorLiveData.postValue(context.getString(R.string.dataError))
                    } else {
                        val collectionType: Type =
                            object : TypeToken<List<CurrencyData?>?>() {}.type

                        val data = Gson().fromJson(str, collectionType) as List<CurrencyData>
                        appDatabase.currencyDataDao().insertAll(*data.toTypedArray())
                        currencyListLiveData.postValue(data)
                    }
                } else {
                    currencyListLiveData.postValue(it)
                }
            }
        }
    }

    fun clearDB(appDatabase: AppDatabase) {
        viewModelScope.launch {
            appDatabase.currencyDataDao().deleteAll()
            currencyListLiveData.postValue(listOf())
        }
    }

    fun sortCurrencyList() {
        currencyListLiveData.value?.let {
            val sortedList = it.sortedBy { item ->
                item.id
            }
            currencyListLiveData.postValue(sortedList)
        }
    }
}