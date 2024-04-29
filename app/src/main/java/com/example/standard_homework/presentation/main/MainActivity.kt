package com.example.standard_homework.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_homework.databinding.ActivityMainBinding
import com.example.standard_homework.data.cardList
import com.example.standard_homework.presentation.detail.DetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var cardViewModel : CardViewModel ?= null

    private val cardAdapter : MultiViewAdapter by lazy {
        MultiViewAdapter {
            cardList()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cardViewModel = ViewModelProvider(this, CardViewModelFactory()).get(CardViewModel::class.java)

        cardAdapter.itemClick = object : MultiViewAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val selectedItem = cardList()[position]

                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                val bundle = Bundle().apply {
                    putString("name", selectedItem.name)
                    putString("num", selectedItem.num)
                    putString("date", selectedItem.data)
                    putDouble("price", selectedItem.price)
                }
                intent.putExtra("bundle", bundle)
                startActivity(intent)
            }
        }

        with(binding.recyclerView) {
            adapter = cardAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}