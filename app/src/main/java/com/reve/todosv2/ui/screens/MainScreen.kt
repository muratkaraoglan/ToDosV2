package com.reve.todosv2.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reve.todosv2.R
import com.reve.todosv2.databinding.FragmentMainScreenBinding

class MainScreen : Fragment() {
    private lateinit var viewBinding: FragmentMainScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentMainScreenBinding.inflate(inflater,container,false)



        return viewBinding.root
    }
}