package com.afisdev.stockbittest.view.fragment

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afisdev.core.extension.infiniteScrollListener
import com.afisdev.core.ui.BaseFragment
import com.afisdev.stockbittest.R
import com.afisdev.stockbittest.adapter.ToplistAdapter
import com.afisdev.stockbittest.databinding.FragmentWatchlistBinding
import com.afisdev.stockbittest.viewmodel.WatchlistViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * A simple [Fragment] subclass.
 */
class WatchlistFragment : BaseFragment<FragmentWatchlistBinding, WatchlistViewModel>() {

    var adapter: ToplistAdapter? = null
    override val layoutResource = R.layout.fragment_watchlist

    private var limit: Int = 20

    override fun bindViewModel() {
        viewModel = getViewModel()
    }

    override fun viewDidLoad() {
        binding.fragment = this
        viewModel.getToplist(CURRENCY, limit)
        registerObserver()
        setupView()
    }

    private fun registerObserver() {
        viewModel.toplistApiResponse.observe(this, {
            viewModel.handleToplistApiResponse(it)
        })

        viewModel.toplistResult.observe(this, {
            adapter?.addItems(it)
        })
    }

    private fun setupView() {
        setupRecylerview()
        binding.swipeContainer.setOnRefreshListener {
            adapter?.clear()
            viewModel.getToplist(CURRENCY, limit)
            binding.swipeContainer.isRefreshing = false
        }
    }

    private fun setupRecylerview(){
        adapter = ToplistAdapter(mutableListOf())

        binding.topListRecyler.apply {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val position = (binding.topListRecyler.layoutManager as LinearLayoutManager?)
                        ?.findFirstCompletelyVisibleItemPosition()
                    binding.swipeContainer.isEnabled = position == 0
                }
            })

            infiniteScrollListener(2){
                viewModel.getToplist(CURRENCY, limit+10)
            }
        }

    }

    companion object{
        const val CURRENCY = "IDR"
    }
}