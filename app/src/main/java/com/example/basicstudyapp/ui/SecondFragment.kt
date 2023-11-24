package com.example.basicstudyapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.basicstudyapp.R
import com.example.basicstudyapp.ViewModel.MyViewModel
import com.example.basicstudyapp.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment() {
    private val viewModel: MyViewModel by viewModels()
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("LogNotTimber")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.postHideProgress()
        super.onViewCreated(view, savedInstanceState)
        val naviController = findNavController()

        binding.apply {
            backButton.setOnClickListener {
//            naviController.popBackStack(R.id.fragment1,false)
                naviController.navigate(R.id.action_fragment2_to_fragment1)
            }

            webViewButton.setOnClickListener {
                naviController.navigate(R.id.action_fragment2_to_web_view)
            }

            browseButton.setOnClickListener {
                naviController.navigate(R.id.action_fragment2_to_web_view)
                val intent = Intent()
                intent.action = "android.intent.action.VIEW"
                val url = Uri.parse("https://www.google.com")
                intent.data = url
                activity?.startActivity(intent)
            }
        }
    }

//    companion object {
//    }
}
