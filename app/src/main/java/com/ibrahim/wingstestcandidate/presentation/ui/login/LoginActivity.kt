package com.ibrahim.wingstestcandidate.presentation.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ibrahim.wingstestcandidate.App
import com.ibrahim.wingstestcandidate.R
import com.ibrahim.wingstestcandidate.data.model.Login
import com.ibrahim.wingstestcandidate.databinding.ActivityLoginBinding
import com.ibrahim.wingstestcandidate.presentation.ui.product_list.ProductListActivity
import com.ibrahim.wingstestcandidate.presentation.ui.viewmodel.SellingViewModel
import com.ibrahim.wingstestcandidate.presentation.ui.viewmodel.ViewModelFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val sellingViewModel: SellingViewModel by viewModels {
        ViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAction()
    }

    private fun setupAction() {
        binding.apply {
            btnLogin.setOnClickListener {
                checkedLogin()
            }
        }
    }

    private fun checkedLogin() {
        binding.apply {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            sellingViewModel.getLogin(username).observe(this@LoginActivity) { item ->
                if (item != null) {
                    val loginItem = Login(
                        user = item.user,
                        password = item.password
                    )
                    val isLogin = username == loginItem.user && password == loginItem.password
                    navigateToProductList(isLogin, username)
                }else{
                    Toast.makeText(this@LoginActivity, getString(R.string.error_login_not_success), Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun navigateToProductList(isLogin: Boolean, user: String) {
        if (isLogin) {
            ProductListActivity.start(this@LoginActivity, user)
        }
    }
}