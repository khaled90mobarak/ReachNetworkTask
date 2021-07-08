package com.reachnetwork.task.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.reachnetwork.task.R
import com.reachnetwork.task.databinding.FragmentDiscoverBinding
import com.reachnetwork.task.models.offers.OffersResponse
import com.reachnetwork.task.ui.adapters.OffersAdapter
import com.reachnetwork.task.utils.Resource
import com.reachnetwork.task.viewmodel.MainViewModel

class DiscoverFragment: Fragment(R.layout.fragment_discover) {

    private lateinit var searchView: SearchView
    private lateinit var binding: FragmentDiscoverBinding
    private lateinit var  offersAdapter: OffersAdapter
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDiscoverBinding.bind(view)

    viewLifecycleOwner.lifecycleScope.launchWhenStarted {
        mainViewModel.onOffersRequested()
    }

     setupRecyclerView()
        mainViewModel.offersLiveData.observe(viewLifecycleOwner){ response ->
            when(response){
                is Resource.Loading -> {
                    // show progress dialog
                }

                is Resource.Success -> {
                    // hide progress bar
                    response.data?.let { offersResponse ->
                        var list = ArrayList<OffersResponse>()
                        list.add(offersResponse)
                    offersAdapter.submitList(list)
                    }
                }
            }
        }


        setHasOptionsMenu(true)
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.search_menu,menu)
        val searchItem = menu.findItem(R.id.action_search)
        searchView = searchItem.actionView as SearchView

    }

    private fun setupRecyclerView(){
        offersAdapter = OffersAdapter()
        binding.recyclerViewOffers.apply {
            adapter = offersAdapter
            val snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(this)
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }
    }

}