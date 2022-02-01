package com.kevinhao426.cryptocurrencylist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kevinhao426.cryptocurrencylist.databinding.ItemCurrencyBinding
import com.kevinhao426.cryptocurrencylist.model.CurrencyData
import javax.inject.Inject

class CurrencyListAdapter @Inject constructor() :
    RecyclerView.Adapter<CurrencyListAdapter.CurrencyItemViewHolder>() {

    private val dataList: MutableList<CurrencyData> = mutableListOf()

    fun updateNewsList(list: List<CurrencyData>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }

    class CurrencyItemViewHolder(val binding: ItemCurrencyBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyItemViewHolder {
        return CurrencyItemViewHolder(
            ItemCurrencyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CurrencyItemViewHolder, position: Int) {
        val data = dataList[position]
        holder.binding.currencyName.text = data.name
        holder.binding.currencySymbol.text = data.symbol
        holder.binding.nameInitials.text = data.name?.first().toString()
    }

    override fun getItemCount(): Int = dataList.size
}