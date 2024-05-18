package com.example.application.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface WordDAO {
    @Query("SELECT * FROM word_data_table")
    fun getAll(): List<Word>
}