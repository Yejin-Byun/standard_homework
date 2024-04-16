package com.example.standard_homework

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = listOf(
            CardInfo(
                CardInfo.BLUE_TYPE,
                "Anderson",
                "2423  3581  9503  2412",
                "21 / 24", 3100.30
            ),
            CardInfo(
                CardInfo.SKY_TYPE,
                "Anderson",
                "2423  3581  9503  2412",
                "12 / 25",
                3100.30
            ),
            CardInfo(
                CardInfo.ORANGE_TYPE,
                "Anderson",
                "2423  3581  9503  2412",
                "21 / 24",
                3100.30
            )
        )

        val adapter = MultiViewAdapter(dataList)
        adapter.itemClick = object : MultiViewAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val selectedItem = dataList[position]

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

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }
}