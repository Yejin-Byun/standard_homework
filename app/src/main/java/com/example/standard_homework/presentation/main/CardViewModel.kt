package com.example.standard_homework.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.standard_homework.data.CardInfo
import com.example.standard_homework.data.DataSource
import javax.sql.CommonDataSource

class CardViewModel(val dataSource: DataSource) : ViewModel() {
    val cardsLiveData = dataSource.getCardList()

    fun getCardForId(id: Long) : CardInfo {
        return cardsLiveData.get(id.toInt())
    }
}

class CardViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CardViewModel::class.java)) {
            return CardViewModel(dataSource = DataSource.getDataSource()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}