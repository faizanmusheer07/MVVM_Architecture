package com.example.mvvm_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_architecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository = QuoteRepository(dao)


        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(repository)
        ).get((MainViewModel::class.java))
         mainViewModel.getQuotes().observe(this, {
             binding.quotes = it.toString()
         })
        binding.btnAddQuote.setOnClickListener {
val quote= Quote(0, "this is testing","Testing")
            mainViewModel.insert(quote)
        }
    }
}