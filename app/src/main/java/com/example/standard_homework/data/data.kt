package com.example.standard_homework.data

data class CardInfo(
    val type: Int,
    val name: String,
    val num: String,
    val data: String,
    val price: Double
) {
    companion object {
        const val BLUE_TYPE = 0
        const val SKY_TYPE = 1
        const val ORANGE_TYPE = 2
    }
}
