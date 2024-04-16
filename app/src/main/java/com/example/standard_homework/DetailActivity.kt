package com.example.standard_homework

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle = intent.getBundleExtra("bundle")
        val name = bundle?.getString("name")
        val num = bundle?.getString("num")
        val date = bundle?.getString("date")
        val price = bundle?.getDouble("price")

        findViewById<TextView>(R.id.detail_name).text = name
        findViewById<TextView>(R.id.detail_num).text = num
        findViewById<TextView>(R.id.detail_date).text = date

        val decimalFormat = DecimalFormat("$#,###.00").format(price ?: 0.0)
        findViewById<TextView>(R.id.detail_price).text = decimalFormat

        }
    }
