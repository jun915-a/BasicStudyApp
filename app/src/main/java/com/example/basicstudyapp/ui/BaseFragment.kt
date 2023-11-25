package com.example.basicstudyapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.basicstudyapp.ViewModel.MyViewModel

open class BaseFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        afterViewCreated()
    }

    private val viewModel: MyViewModel by viewModels()
    protected open fun afterViewCreated() {

    }
}

