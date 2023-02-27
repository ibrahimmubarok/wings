package com.ibrahim.wingstestcandidate.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.wingstestcandidate.R
import com.ibrahim.wingstestcandidate.data.model.Product
import com.ibrahim.wingstestcandidate.databinding.ItemProductBinding

class ProductAdapter(val onClicked: (Product) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder>() {

    private val items = mutableListOf<Product>()

    fun setData(items: List<Product>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class ProductAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemProductBinding.bind(view)
        fun bind(item: Product) {
            binding.apply {
                tvProductName.text = item.productName
                tvPrice.text = item.price.toString()
                btnBuy.setOnClickListener {
                    onClicked.invoke(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductAdapterViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProductAdapterViewHolder, position: Int) {
        holder.bind(items[position])
    }
}