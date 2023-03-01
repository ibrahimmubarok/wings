package com.ibrahim.wingstestcandidate.presentation.ui.checkout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.ibrahim.wingstestcandidate.App
import com.ibrahim.wingstestcandidate.data.local.TransactionHeaderEntity
import com.ibrahim.wingstestcandidate.data.model.TransactionDetail
import com.ibrahim.wingstestcandidate.databinding.ActivityCheckoutBinding
import com.ibrahim.wingstestcandidate.presentation.adapter.CheckoutAdapter
import com.ibrahim.wingstestcandidate.presentation.ui.viewmodel.SellingViewModel
import com.ibrahim.wingstestcandidate.presentation.ui.viewmodel.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class CheckoutActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_USER = "EXTRA_USER"

        fun start(context: Context, user: String) {
            context.startActivity(Intent(context, CheckoutActivity::class.java).apply {
                putExtra(EXTRA_USER, user)
            })
        }
    }

    private lateinit var binding: ActivityCheckoutBinding
    private val sellingViewModel: SellingViewModel by viewModels {
        ViewModelFactory((application as App).repository)
    }

    private val checkoutAdapter: CheckoutAdapter by lazy {
        CheckoutAdapter()
    }

    private var total: Double = 0.0
    private var user: String = ""
    private var date: String = ""
    private var docNumber: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObserver()
        setupIntent()
        setupAction()
    }

    private fun setupAction() {
        binding.btnConfirm.setOnClickListener {
            sellingViewModel.insertTransactionHeader(
                TransactionHeaderEntity(
                    documentCode = "TRX",
                    documentNumber = docNumber,
                    user = user,
                    total = total,
                    date = date
                )
            )
            Toast.makeText(this, "SUCCESS!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupIntent() {
        user = intent.getStringExtra(EXTRA_USER).orEmpty()

        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        date = formatter.format(time)
    }

    private fun setupObserver() {
        sellingViewModel.getAllTransactionDetail().observe(this) { items ->
            if (items.isNotEmpty()) {
                val transactions = mutableListOf<TransactionDetail>()
                for (item in items) {
                    transactions.add(
                        TransactionDetail(
                            documentCode = item.documentCode,
                            documentNumber = item.documentNumber,
                            productName = item.productName,
                            productCode = item.productCode,
                            price = item.price,
                            quantity = item.quantity,
                            unit = item.unit,
                            subTotal = item.subTotal,
                            currency = item.currency
                        )
                    )
                    total += item.subTotal
                }
                docNumber = transactions[0].documentNumber
                binding.tvTotal.text = "Rp ${total.toString()}"
                checkoutAdapter.setData(transactions)
            }
        }
    }
}