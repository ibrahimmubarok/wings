package com.ibrahim.wingstestcandidate.presentation.ui.product_detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ibrahim.wingstestcandidate.data.model.Product
import com.ibrahim.wingstestcandidate.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_PRODUCT = "EXTRA_PRODUCT"
        private const val EXTRA_USER = "EXTRA_USER"

        fun start(context: Context, user: String, product: Product) {
            context.startActivity(Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(EXTRA_USER, user)
                putExtra(EXTRA_PRODUCT, product)
            })
        }
    }

    private lateinit var binding: ActivityProductDetailBinding
    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        setupAction()
    }

    private fun setupUI() {
        binding.apply {
            product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT) as Product

            tvProductName.text = product.productName
            tvPrice.text = "Rp ${product.price.toInt()}"
            tvDimension.text = product.dimension
            tvPriceUnit.text = product.unit
        }
    }

    private fun setupAction() {
        binding.btnBuy.setOnClickListener {

        }
    }
}