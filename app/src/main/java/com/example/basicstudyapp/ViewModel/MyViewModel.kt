package com.example.basicstudyapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicstudyapp.ProgressData

class MyViewModel : ViewModel() {
    //TODO:ライブデータ
    //mutableLiveData<List<T>>

    //TODO: モーションレイアウト

    //TODO:jetpack compose

    private val mShowProgressBar = MutableLiveData<ProgressData>()
    val showProgressBar: LiveData<ProgressData> = mShowProgressBar

    fun postHideProgress() {
        mShowProgressBar.postValue(ProgressData(true))
    }

    fun postShowProgress() {
        mShowProgressBar.postValue(ProgressData(false))
    }
}
