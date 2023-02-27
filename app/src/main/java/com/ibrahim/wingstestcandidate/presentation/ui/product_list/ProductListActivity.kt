package com.ibrahim.wingstestcandidate.presentation.ui.product_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahim.wingstestcandidate.data.model.Product
import com.ibrahim.wingstestcandidate.databinding.ActivityProductListBinding
import com.ibrahim.wingstestcandidate.presentation.adapter.ProductAdapter
import com.ibrahim.wingstestcandidate.presentation.ui.product_detail.ProductDetailActivity

class ProductListActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ProductListActivity::class.java))
        }
    }

    private lateinit var binding: ActivityProductListBinding

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
        initObserver()
    }

    private fun dataDummy(): List<Product> {
        val data = mutableListOf<Product>()
        for (i in 0..30) {
            data.add(Product(
                productCode = "2000",
                productName = "Sabun Colek Nih Bos",
                price = 2.000,
                currency = "Rp",
                discount = 9.0,
                dimension = "90 x 900",
                unit = "900"
            ))
        }
        return data
    }

    private fun initData() {
        productAdapter.setData(dataDummy())
    }

    private fun initObserver() {
        initData()
    }

    private fun initRecyclerView() {
        binding.rvProduct.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}