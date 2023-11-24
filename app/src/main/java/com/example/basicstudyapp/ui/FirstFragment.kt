package com.example.basicstudyapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.basicstudyapp.R
import com.example.basicstudyapp.ViewModel.MyViewModel


class FirstFragment : BaseFragment() {
//    private lateinit var binding: FragmentFirst

    //    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//    }
    private val viewModel: MyViewModel by viewModels()

    override fun afterViewCreated() {
        val naviController = findNavController()
        val button = view?.findViewById<Button>(R.id.next_button)
        button?.setOnClickListener {
            showProgress()
            viewModel.postShowProgress()
            naviController.navigate(R.id.action_fragment1_to_fragment2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

//    companion object {
//
//    }
}
