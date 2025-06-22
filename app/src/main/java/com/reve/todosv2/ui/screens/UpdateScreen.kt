package com.reve.todosv2.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.reve.todosv2.databinding.FragmentUpdateScreenBinding
import com.reve.todosv2.ui.viewmodel.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateScreen : Fragment() {

    private lateinit var binding: FragmentUpdateScreenBinding
    private lateinit var viewModel: UpdateViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateScreenBinding.inflate(inflater, container, false)

        val bundle: UpdateScreenArgs by navArgs()
        val todo = bundle.toDo

        binding.editTextNameUpdate.setText(todo.name)

        binding.buttonUpdate.setOnClickListener {
            val name = binding.editTextNameUpdate.text.toString()
            viewModel.update(todo.id, name)

            it.findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: UpdateViewModel by viewModels()
        viewModel = tempViewModel
    }

}