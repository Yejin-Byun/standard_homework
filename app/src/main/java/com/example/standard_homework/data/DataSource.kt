package com.example.standard_homework.data

class DataSource {
    companion object {
        private var INSTANCE : DataSource ?= null
        fun getDataSource() : DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    fun getCardList(): List<CardInfo> {
        return cardList()
    }
}