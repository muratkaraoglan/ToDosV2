package com.reve.todosv2.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reve.todosv2.R
import com.reve.todosv2.databinding.FragmentSaveScreenBinding

class SaveScreen : Fragment() {

    private lateinit var viewBinding: FragmentSaveScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSaveScreenBinding.inflate(inflater,container,false)

        return viewBinding.root
    }

}