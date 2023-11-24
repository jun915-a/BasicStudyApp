package com.example.basicstudyapp.ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.basicstudyapp.R
import com.example.basicstudyapp.ViewModel.MyViewModel

open class BaseFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        afterViewCreated()
    }

    private var progressDialog: Dialog? = null
    private val viewModel: MyViewModel by viewModels()
    protected open fun afterViewCreated() {
        showProgress()
    }

    @SuppressLint("LogNotTimber")
    fun showProgress() {
        viewModel.showProgressBar.observe(viewLifecycleOwner) {
            Log.d("test_log", "showProgressAA${it.nowShowFlg}")
            if (it.nowShowFlg) {
                Log.d("test_log", "dismiss")
                progressDialog?.dismiss()
            } else {
                progressDialog = Dialog(requireContext())
                progressDialog?.apply {
                    window?.setBackgroundDrawableResource(R.color.black)
                    setContentView(R.layout.dialog_progress)
                    show()
                }
                Handler(Looper.getMainLooper()).postDelayed({
                    progressDialog?.dismiss()
                }, 1000)
            }
        }
    }
}
