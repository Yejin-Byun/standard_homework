package com.example.standard_homework.data

import com.example.standard_homework.data.CardInfo.Companion.BLUE_TYPE
import com.example.standard_homework.data.CardInfo.Companion.ORANGE_TYPE
import com.example.standard_homework.data.CardInfo.Companion.SKY_TYPE

fun cardList(): List<CardInfo> {
    return listOf(
        CardInfo(
            BLUE_TYPE,
            "Anderson",
            "2423  3581  9503  2412",
            "21 / 24", 3100.30
        ),
        CardInfo(
            ORANGE_TYPE,
            "Anderson",
            "2423  3581  9503  2412",
            "12 / 25",
            3100.30
        ),
        CardInfo(
            SKY_TYPE,
            "Anderson",
            "2423  3581  9503  2412",
            "21 / 24",
            3100.30
        )
    )
}