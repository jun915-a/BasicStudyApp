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


class FirstFragment : Fragment() {
//    private lateinit var binding: FragmentFirst

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val naviController = findNavController()

        val button = view.findViewById<Button>(R.id.move_second_fragment_button)
        button?.setOnClickListener {
            Timber.d("!!! ${this.javaClass.name} button_click")
            naviController.navigate(R.id.action_fragment1_to_fragment2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    companion object {
        fun newInstance(param1: String, param2: String): FirstFragment {
            return FirstFragment()
        }
    }
}
