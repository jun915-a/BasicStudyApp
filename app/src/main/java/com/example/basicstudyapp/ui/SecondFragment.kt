package com.example.basicstudyapp.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.basicstudyapp.R
import com.example.basicstudyapp.ViewModel.MyViewModel
import com.example.basicstudyapp.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment() {
    private val viewModel: MyViewModel by viewModels()
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val REQUEST_IMAGE_CAPTURE = 1

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
            photoButton.setOnClickListener {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                try {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                } catch (e: ActivityNotFoundException) {
                    // display error state to the user
                    Log.d("error_log", "$e")
                }
            }
        }
        viewModel.imageView.observe(viewLifecycleOwner) {
            binding.imageView.setImageBitmap(it)

        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            viewModel.postImageView(imageBitmap)
        }
    }

//    companion object {
//    }
}
