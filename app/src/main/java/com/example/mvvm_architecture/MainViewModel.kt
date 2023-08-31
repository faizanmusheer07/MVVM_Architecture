package com.example.mvvm_architecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private var quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes(): LiveData<List<Quote>>{
        return quoteRepository.getQuotes()
    }
     fun insert(quote: Quote){
        viewModelScope.launch(Dispatchers.IO){
         quoteRepository.insert(quote)
        }

    }
}