package com.example.basicstudyapp.ui

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.basicstudyapp.R
import timber.log.Timber

open class BaseFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        afterViewCreated()
    }

    protected open fun afterViewCreated() {
        Timber.d("BaseFragment afterViewCreated")
    }

    fun showProgress(showFlg: Boolean) {
        val progressDialog = Dialog(requireContext())

        if (showFlg) {
            progressDialog.hide()
        } else {
            progressDialog.apply {
                window?.setBackgroundDrawableResource(R.color.black)
                setContentView(R.layout.dialog_progress)
//                setCancelable(false)
                show()
            }


        }
    }
}
