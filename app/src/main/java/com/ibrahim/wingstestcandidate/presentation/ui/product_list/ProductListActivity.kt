package com.ibrahim.wingstestcandidate.presentation.ui.product_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahim.wingstestcandidate.App
import com.ibrahim.wingstestcandidate.data.local.TransactionDetailEntity
import com.ibrahim.wingstestcandidate.data.model.Product
import com.ibrahim.wingstestcandidate.databinding.ActivityProductListBinding
import com.ibrahim.wingstestcandidate.presentation.adapter.ProductAdapter
import com.ibrahim.wingstestcandidate.presentation.ui.checkout.CheckoutActivity
import com.ibrahim.wingstestcandidate.presentation.ui.product_detail.ProductDetailActivity
import com.ibrahim.wingstestcandidate.presentation.ui.viewmodel.SellingViewModel
import com.ibrahim.wingstestcandidate.presentation.ui.viewmodel.ViewModelFactory
import kotlin.random.Random

class ProductListActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_USER = "EXTRA_USER"

        fun start(context: Context, user: String) {
            context.startActivity(Intent(context, ProductListActivity::class.java).apply {
                putExtra(EXTRA_USER, user)
            })
        }
    }

    private lateinit var binding: ActivityProductListBinding
    private val sellingViewModel: SellingViewModel by viewModels {
        ViewModelFactory((application as App).repository)
    }

    private val listQuantity = mutableListOf<Int>()
    private val listProduct = mutableListOf<Product>()

    private val productAdapter: ProductAdapter by lazy {
        ProductAdapter(
            onClickedBuyButton = { item ->
                Toast.makeText(this, "Item Ditambahkan!", Toast.LENGTH_SHORT).show()
                if (listProduct.isEmpty()) {
                    listProduct.add(item)
                    listQuantity.add(1)
                } else {
                    listProduct.forEachIndexed { index, product ->
                        if (product.productName == item.productCode) {
                            val qty = listQuantity[index]
                            listQuantity[index] = qty + 1
                        }
                    }
                }
            },
            onClickedToDetailPage = { product ->
                ProductDetailActivity.start(this@ProductListActivity, user, product)
            }
        )
    }

    private val randomDocNumber = Random.nextInt(1, 99999)
    private var user: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initIntent()
        initRecyclerView()
        initObserver()
        initAction()
    }

    private fun initIntent() {
        user = intent.getStringExtra(EXTRA_USER).orEmpty()
    }

    private fun initAction() {
        binding.apply {
            btnCheckout.setOnClickListener {
                insertDataToCheckout()
                CheckoutActivity.start(this@ProductListActivity, user)
            }
        }
    }

    private fun initObserver() {
        sellingViewModel.getAllProducts().observe(this) { items ->
            val products = mutableListOf<Product>()
            for (item in items) {
                products.add(
                    Product(
                        productCode = item.productCode,
                        productName = item.productName,
                        price = item.price,
                        currency = item.currency,
                        discount = item.discount,
                        dimension = item.dimension,
                        unit = item.unit
                    )
                )
            }
            productAdapter.setData(products)
        }
    }

    private fun insertDataToCheckout() {
        listProduct.forEachIndexed { index, data ->
            val transaction = TransactionDetailEntity(
                documentCode = "TRX",
                documentNumber = randomDocNumber.toString(),
                productName = data.productName,
                productCode = data.productCode,
                quantity = listQuantity[index],
                price = data.price,
                unit = data.unit,
                subTotal = 3 * (data.price),
                currency = data.currency
            )
            sellingViewModel.insertTransactionDetail(transaction)
        }
    }

    private fun initRecyclerView() {
        binding.rvProduct.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}