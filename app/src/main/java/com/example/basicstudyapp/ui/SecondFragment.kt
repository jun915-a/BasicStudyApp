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
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicstudyapp.R
import com.example.basicstudyapp.ViewModel.MyViewModel
import com.example.basicstudyapp.adapter.ButtonPattern
import com.example.basicstudyapp.adapter.MenuButtonAdapter
import com.example.basicstudyapp.databinding.FragmentSecondBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        super.onViewCreated(view, savedInstanceState)
        val naviController = findNavController()

        binding.apply {
            val items = mutableListOf<ButtonPattern>()
            for (i in ButtonPattern.values()) {
                items.add(i)
            }
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.layoutManager = layoutManager
            val adapter = context?.let {
                MenuButtonAdapter(items, it) { pattern ->
                    when (pattern) {
                        ButtonPattern.BACK -> {
//                          naviController.popBackStack(R.id.fragment1,false)
                            naviController.navigate(R.id.action_fragment2_to_fragment1)
                        }

                        ButtonPattern.WEB -> {
                            naviController.navigate(R.id.action_fragment2_to_web_view)
                        }

                        ButtonPattern.BROWSE -> {
                            openBrowse(naviController)

                        }

                        ButtonPattern.PHOTO -> {
                            startPhoto()
                        }

                        ButtonPattern.MAP -> {
//                            holder.button.text = context.getText(R.string.map_button)
                        }
                    }
                }
            }
            recyclerView.adapter = adapter
        }
        viewModel.imageView.observe(viewLifecycleOwner) {
            binding.imageView.setImageBitmap(it)
        }
    }

    @SuppressLint("LogNotTimber")
    private fun startPhoto() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
            Log.d("error_log", "$e")
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
    private fun openBrowse(naviController: NavController) {
        naviController.navigate(R.id.action_fragment2_to_web_view)
        val intent = Intent()
        intent.action = "android.intent.action.VIEW"
        val url = Uri.parse("https://www.google.com")
        intent.data = url
        activity?.startActivity(intent)
    }

}
