package com.example.mvvm_architecture

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("quote")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var text: String,
    var author: String
)