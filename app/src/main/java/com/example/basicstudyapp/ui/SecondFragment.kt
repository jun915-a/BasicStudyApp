package com.example.basicstudyapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
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

        val backButton = view.findViewById<Button>(R.id.back_button)
        backButton?.setOnClickListener {
//            naviController.popBackStack(R.id.fragment1,false)
            naviController.navigate(R.id.action_fragment2_to_fragment1)
        }
        val webViewButton = view.findViewById<Button>(R.id.web_view_button)
        webViewButton?.setOnClickListener {
            naviController.navigate(R.id.action_fragment2_to_web_view)
        }

        val browseButton = view.findViewById<Button>(R.id.browse_button)
        browseButton?.setOnClickListener {
            naviController.navigate(R.id.action_fragment2_to_web_view)
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            val url = Uri.parse("https://www.google.com")
            intent.data = url

            activity?.startActivity(intent)

        }

    }

//    companion object {
//    }
}
