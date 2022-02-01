package com.kevinhao426.cryptocurrencylist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.kevinhao426.cryptocurrencylist.databinding.FragmentCurrencyListBinding
import com.kevinhao426.cryptocurrencylist.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CurrencyListFragment @Inject constructor() : Fragment() {
    @Inject
    lateinit var listAdapter: CurrencyListAdapter

    private val activityViewModel by activityViewModels<MainViewModel>()

    private lateinit var binding: FragmentCurrencyListBinding

    companion object {
        fun newInstance(): CurrencyListFragment {
            return CurrencyListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCurrencyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingUIEvents()
        observeData()
    }

    private fun bindingUIEvents() {
        binding.currencyListView.apply {
            this.layoutManager = LinearLayoutManager(context, VERTICAL, false)
            this.adapter = listAdapter
        }
    }

    private fun observeData() {
        activityViewModel.currencyListLiveData.observe(viewLifecycleOwner) {
            listAdapter.updateNewsList(it)
        }
    }
}