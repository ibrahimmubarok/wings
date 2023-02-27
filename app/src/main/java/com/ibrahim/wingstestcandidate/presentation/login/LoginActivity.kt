package com.ibrahim.wingstestcandidate.presentation.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ibrahim.wingstestcandidate.R
import com.ibrahim.wingstestcandidate.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAction()
    }

    private fun setupAction() {
        binding.apply {
            btnLogin.setOnClickListener {
                if (isLoggedIn()) {
                    // TODO : navigate product list page
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
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
        }
        return true
    }
}