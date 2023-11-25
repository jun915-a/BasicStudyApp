package com.example.basicstudyapp.ViewModel

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicstudyapp.ProgressData

class MyViewModel : ViewModel() {
    //TODO:ライブデータ
    //mutableLiveData<List<T>>

    //TODO: モーションレイアウト

    //TODO:jetpack compose

    // MutableLiveDataを使用して変更可能なLiveDataを作成
    private val mShowProgressBar = MutableLiveData<ProgressData>()

    // 外部に公開される不変のLiveData
    val showProgressBar: LiveData<ProgressData> = mShowProgressBar

    private val mImageView = MutableLiveData<Bitmap>()
    val imageView: LiveData<Bitmap> = mImageView




    fun postHideProgress() {
        mShowProgressBar.postValue(ProgressData(true))
    }

    fun postShowProgress() {
        mShowProgressBar.postValue(ProgressData(false))
    }
    fun postImageView(imageView: Bitmap) {
        mImageView.postValue(imageView)
    }
}
