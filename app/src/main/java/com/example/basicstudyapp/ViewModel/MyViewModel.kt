package com.example.basicstudyapp.ViewModel

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicstudyapp.R

class MyViewModel : ViewModel() {

    //TODO: モーションレイアウト
    var progressDialog: Dialog? = null

    // MutableLiveDataを使用して変更可能なLiveDataを作成
    private val mImageView = MutableLiveData<Bitmap>()

    // 外部に公開される不変のLiveData
    val imageView: LiveData<Bitmap> = mImageView

    fun postImageView(imageView: Bitmap) {
        mImageView.postValue(imageView)
    }

    @SuppressLint("LogNotTimber")
    fun showProgress(context: Context) {
        Log.d("test_log","showProgress")
        if (progressDialog == null) {
            progressDialog = Dialog(context)
        }
        progressDialog?.apply {
            window?.setBackgroundDrawableResource(R.color.black)
            setContentView(R.layout.dialog_progress)
            show()
        }
    }

    @SuppressLint("LogNotTimber")
    fun hideProgress() {
        Log.d("test_log","hideProgress")
        progressDialog?.hide()
        progressDialog?.dismiss()
    }
}
