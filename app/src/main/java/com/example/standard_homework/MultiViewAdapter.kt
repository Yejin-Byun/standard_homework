package com.example.standard_homework

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_homework.databinding.ItemRecyclerviewBinding
import java.lang.RuntimeException
import java.text.DecimalFormat

class MultiViewAdapter(private val list: List<CardInfo>) : RecyclerView.Adapter<MultiViewAdapter.CardViewHolder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiViewAdapter.CardViewHolder {
        val view: View?
        return when (viewType) {
            CardInfo.BLUE_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
                CardViewHolder(view)
            }
            CardInfo.SKY_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview2, parent, false)
                CardViewHolder(view)
            }
            CardInfo.ORANGE_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview3, parent, false)
                CardViewHolder(view)
            }
            else -> throw RuntimeException("알 수 없는 뷰 타입")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    override fun onBindViewHolder(holder: MultiViewAdapter.CardViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }

        holder.name.text = list[position].name
        holder.number.text = list[position].num
        holder.date.text = list[position].data

        val decimalFormat = DecimalFormat("$#,###.00")
        holder.price.text = decimalFormat.format(list[position].price)
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tv_name)
        val number: TextView = itemView.findViewById(R.id.tv_cardnum)
        val date: TextView = itemView.findViewById(R.id.tv_date)
        val price: TextView = itemView.findViewById(R.id.tv_balance)

        init {
            itemView.setOnClickListener {
                itemClick?.onClick(it, adapterPosition)
            }
        }
    }

}