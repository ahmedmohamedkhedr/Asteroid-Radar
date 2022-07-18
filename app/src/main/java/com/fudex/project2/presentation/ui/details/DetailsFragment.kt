package com.fudex.project2.presentation.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.fudex.project2.R
import com.fudex.project2.databinding.FragmentDetailsBinding
import com.fudex.project2.utils.showDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val ui: FragmentDetailsBinding by lazy {
        FragmentDetailsBinding.inflate(LayoutInflater.from(requireContext()))
    }

    private val viewModel by viewModels<DetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ui.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            ui.asteroid = DetailsFragmentArgs.fromBundle(it).dataModel
        }
        ui.helpButton.setOnClickListener {
            requireContext().showDialog(getString(R.string.astronomica_unit_explanation))
        }
    }

    companion object {
        fun newInstance() =
            DetailsFragment()
    }
}