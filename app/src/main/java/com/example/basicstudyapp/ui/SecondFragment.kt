package com.example.basicstudyapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.basicstudyapp.R
import com.example.basicstudyapp.ViewModel.MyViewModel

class SecondFragment : BaseFragment() {
    private val viewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    @SuppressLint("LogNotTimber")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.postHideProgress()
        super.onViewCreated(view, savedInstanceState)
        val naviController = findNavController()

        val button = view.findViewById<Button>(R.id.test_button)
        button?.setOnClickListener {
            Log.d("test_log", "${this.javaClass.name} button_click")
//            naviController.popBackStack(R.id.fragment1,false)
            naviController.navigate(R.id.action_fragment2_to_fragment1)
        }
    }

//    companion object {
//    }
}
