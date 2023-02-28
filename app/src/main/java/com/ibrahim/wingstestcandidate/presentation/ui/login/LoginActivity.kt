package com.ibrahim.wingstestcandidate.presentation.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ibrahim.wingstestcandidate.R
import com.ibrahim.wingstestcandidate.data.model.LoginResponse
import com.ibrahim.wingstestcandidate.databinding.ActivityLoginBinding
import com.ibrahim.wingstestcandidate.presentation.ui.product_list.ProductListActivity
import com.ibrahim.wingstestcandidate.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private var accountData: LoginResponse? = null
    private val mainViewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAction()
        initProcess()
    }

    private fun initProcess() {
        mainViewModel.getUserAccount()
        mainViewModel.resultAccount.observe(this@LoginActivity) { account ->
            if (account.data != null) {
                accountData = account.data
            }
        }
    }

    private fun setupAction() {
        binding.apply {
            btnLogin.setOnClickListener {
                if (isLoggedIn()) {
                    ProductListActivity.start(this@LoginActivity)
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        getString(R.string.error_login_not_success),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun isLoggedIn(): Boolean {
        binding.apply {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            return if (accountData != null) {
                username == accountData?.user && password == accountData?.password
            } else {
                false
            }
        }
    }
}