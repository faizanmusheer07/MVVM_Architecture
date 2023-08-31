package com.example.mvvm_architecture

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote")
    fun getQuotes(): LiveData<List<Quote>>

    @Insert
   suspend fun insertquote(quote: Quote)
}