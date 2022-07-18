package com.fudex.project2.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.fudex.project2.R
import com.fudex.project2.databinding.FragmentHomeBinding
import com.fudex.project2.domain.models.DataModel
import com.fudex.project2.presentation.ui.adapters.HomeAdapter
import com.fudex.project2.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeAdapter.OnItemClickListener {

    private val ui: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(LayoutInflater.from(requireContext()))
    }

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ui.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getImageOfTheDay()
        viewModel.getData()
        observe()
    }

    private fun observe() {
        with(viewModel) {
            loadingLiveData.observe(viewLifecycleOwner) {
                ui.progressBar.isVisible = it
            }

            liveData.observe(viewLifecycleOwner) {
                setupRecyclerView(it)
            }

            imageOfTheDayLiveData.observe(viewLifecycleOwner) {
                ui.bannerIV.loadImage(it)
            }

            errorLiveData.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupRecyclerView(data: MutableList<DataModel>) {
        val adapter = HomeAdapter(data, this)
        ui.itemsRV.adapter = adapter
    }

    override fun onClick(item: DataModel) {
        findNavController()
            .navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item))
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}