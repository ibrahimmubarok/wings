package com.ibrahim.wingstestcandidate.presentation.ui.product_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahim.wingstestcandidate.databinding.ActivityProductListBinding
import com.ibrahim.wingstestcandidate.presentation.adapter.ProductAdapter
import com.ibrahim.wingstestcandidate.presentation.ui.checkout.CheckoutActivity
import com.ibrahim.wingstestcandidate.presentation.ui.product_detail.ProductDetailActivity
import com.ibrahim.wingstestcandidate.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductListActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ProductListActivity::class.java))
        }
    }

    private lateinit var binding: ActivityProductListBinding

    private val mainViewModel: MainViewModel by viewModel()

    private val productAdapter: ProductAdapter by lazy {
        ProductAdapter {
            ProductDetailActivity.start(this@ProductListActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initProcess()
        initAction()
    }

    private fun initAction() {
        binding.apply {
            btnCheckout.setOnClickListener {
                CheckoutActivity.start(this@ProductListActivity)
            }
        }
    }

    private fun initProcess() {
        mainViewModel.getProductsList()
        mainViewModel.resultProductsList.observe(this) { products ->
            binding.pbLoading.visibility = View.GONE
            if (products.data != null) {
                val items = products.data
                productAdapter.setData(items)
            }
        }
    }

    private fun initRecyclerView() {
        binding.rvProduct.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}