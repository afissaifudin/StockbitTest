package com.afisdev.core.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.afisdev.core.extension.isVisible
import com.afisdev.core.extension.showSnackBar

abstract class BaseFragment<DB: ViewDataBinding, VM: BaseViewModel>: Fragment() {

    lateinit var mContext: Context
    lateinit var binding: DB
    lateinit var viewModel: VM

    abstract val layoutResource: Int

    abstract fun bindViewModel()
    abstract fun viewDidLoad()

    private var loadingView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResource, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        setRegisterObserver()
        viewDidLoad()
//        setupViewRoot()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

//    private fun setupViewRoot() {
//        loadingView = binding.root.findViewById(R.id.loadingView)
//    }

    fun navigate(action: NavDirections){
        findNavController().navigate(action)
    }

    private fun setRegisterObserver() {
        viewModel.isLoading.observe(viewLifecycleOwner, {
            loadingView?.isVisible = it
        })
        viewModel.message.observe(viewLifecycleOwner, { message ->
            binding.root.showSnackBar(message, 4000)
        })
    }


}