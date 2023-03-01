package com.ibrahim.wingstestcandidate.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.wingstestcandidate.R
import com.ibrahim.wingstestcandidate.data.model.Product
import com.ibrahim.wingstestcandidate.data.model.TransactionDetail
import com.ibrahim.wingstestcandidate.databinding.ItemCheckoutBinding

class CheckoutAdapter : RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder>() {

    private val items = mutableListOf<TransactionDetail>()

    fun setData(items: List<TransactionDetail>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class CheckoutViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemCheckoutBinding.bind(view)
        fun bind(item: TransactionDetail) {
            binding.apply {
                tvProductName.text = item.productName
                tvLabelPcs.text = item.unit
                val subTotal = item.quantity * item.price
                tvSubTotal.text = subTotal.toString()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CheckoutAdapter.CheckoutViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_checkout, parent, false)
        return CheckoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: CheckoutAdapter.CheckoutViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}