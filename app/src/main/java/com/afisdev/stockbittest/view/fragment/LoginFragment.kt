package com.afisdev.stockbittest.view.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.afisdev.core.ui.BaseFragment
import com.afisdev.stockbittest.R
import com.afisdev.stockbittest.databinding.FragmentLoginBinding
import com.afisdev.stockbittest.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    val text:String = "test"

    override val layoutResource: Int
        get() = R.layout.fragment_login

    override fun bindViewModel() {
        viewModel = getViewModel()
    }

    override fun viewDidLoad() {
        binding.fragment = this
    }

    fun nextFragment(){
        navigate(LoginFragmentDirections.actionLoginFragmentToWatchlistFragment())
    }

}