package com.example.standard_homework.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_homework.R
import com.example.standard_homework.data.CardInfo
import java.lang.RuntimeException
import java.text.DecimalFormat

class MultiViewAdapter(private val onClick: () -> List<CardInfo>) : RecyclerView.Adapter<MultiViewAdapter.CardViewHolder>() {

    var cardList = listOf<CardInfo>()
        private set

    init {
        cardList = onClick()
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

    inner class CardViewHolder(itemView: View, val onClick: () -> List<CardInfo>) : RecyclerView.ViewHolder(itemView) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View?
        return when (viewType) {
            CardInfo.BLUE_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
                CardViewHolder(view, onClick)
            }
            CardInfo.SKY_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview2, parent, false)
                CardViewHolder(view, onClick)
            }
            CardInfo.ORANGE_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview3, parent, false)
                CardViewHolder(view, onClick)
            }
            else -> throw RuntimeException("알 수 없는 뷰 타입")
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun getItemViewType(position: Int): Int {
        return cardList[position].type
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }

        holder.name.text = cardList[position].name
        holder.number.text = cardList[position].num
        holder.date.text = cardList[position].data

        val decimalFormat = DecimalFormat("$#,###.00")
        holder.price.text = decimalFormat.format(cardList[position].price)
    }
}