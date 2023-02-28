package com.ibrahim.wingstestcandidate.presentation.ui.product_detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ibrahim.wingstestcandidate.data.model.ProductsResponse
import com.ibrahim.wingstestcandidate.databinding.ActivityProductDetailBinding
import com.ibrahim.wingstestcandidate.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ProductDetailActivity::class.java))
        }
    }

    private lateinit var binding: ActivityProductDetailBinding

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initProcess()
    }

    private fun initProcess() {

    }

    private fun setupUI(product: ProductsResponse) {
        binding.apply {
            tvProductName.text = product.productName
            tvPrice.text = product.price.toString()
            tvDimension.text = product.dimension
            tvPriceUnit.text = product.unit
        }
    }
}