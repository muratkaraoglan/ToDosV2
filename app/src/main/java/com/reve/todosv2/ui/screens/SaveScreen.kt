package com.reve.todosv2.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.reve.todosv2.databinding.FragmentSaveScreenBinding
import com.reve.todosv2.ui.viewmodel.SaveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveScreen : Fragment() {
    private lateinit var binding: FragmentSaveScreenBinding
    private lateinit var viewModel: SaveViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveScreenBinding.inflate(inflater,container,false)

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextNameSave.text.toString()
            viewModel.save(name)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : SaveViewModel by viewModels()
        viewModel = tempViewModel
    }
}