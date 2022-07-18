package com.fudex.project2.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fudex.project2.domain.models.DataModel
import com.fudex.project2.domain.use_cases.GetDataUseCase
import com.fudex.project2.domain.use_cases.GetImageOfDayUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase,
    private val getImageOfDayUseCase: GetImageOfDayUseCase
) :
    ViewModel() {
    private val mutableLiveData = MutableLiveData<MutableList<DataModel>>()
    val liveData: LiveData<MutableList<DataModel>> get() = mutableLiveData

    private val loadingMutableLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = loadingMutableLiveData

    private val imageOfTheDayMutableLiveData = MutableLiveData<String>()
    val imageOfTheDayLiveData: LiveData<String> get() = imageOfTheDayMutableLiveData

    private val errorMutableLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = errorMutableLiveData

    fun getImageOfTheDay() = viewModelScope.launch {
        try {
            val imageOfTheDay = withContext(Dispatchers.IO) { getImageOfDayUseCase() }
            imageOfTheDayMutableLiveData.postValue(imageOfTheDay)
        } catch (e: Exception) {
            errorMutableLiveData.postValue(e.message)
        }
    }

    fun getData() = viewModelScope.launch {
        loadingMutableLiveData.postValue(true)
        try {
            val data = withContext(Dispatchers.IO) { getDataUseCase() }
            mutableLiveData.postValue(data)
        } catch (e: Exception) {
            errorMutableLiveData.postValue(e.message)
        } finally {
            loadingMutableLiveData.postValue(false)
        }
    }
}