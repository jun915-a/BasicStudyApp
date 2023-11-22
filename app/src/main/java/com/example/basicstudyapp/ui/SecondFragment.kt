package com.example.basicstudyapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.basicstudyapp.R
import timber.log.Timber

class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val naviController = findNavController()

        val button = view.findViewById<Button>(R.id.test_button)
        button?.setOnClickListener {
            Timber.d("test_log ")
            naviController.popBackStack(R.id.fragment1,false)
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String): SecondFragment {
            return SecondFragment()
        }
    }
}
