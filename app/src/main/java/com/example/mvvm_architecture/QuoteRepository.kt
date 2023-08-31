package com.example.mvvm_architecture

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query

class QuoteRepository(private val quoteDao: QuoteDao) {

    @Query("SELECT  * FROM  quote")
    fun getQuotes(): LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }
    @Insert
    suspend fun insert(quote: Quote){
         quoteDao.insertquote(quote)
    }
}