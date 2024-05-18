package com.example.application.ui.test

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.example.application.MainActivity
import com.example.application.R
import com.example.application.data.Word
import com.example.application.data.WordDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TestFragment : Fragment() {
    private lateinit var database: WordDatabase

    private lateinit var questionField: TextView
    private lateinit var variant1: Button
    private lateinit var variant2: Button
    private lateinit var variant3: Button
    private lateinit var variant4: Button
    private lateinit var nextBtn: Button

    private lateinit var currentWord: Word
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionField = view.findViewById(R.id.question)
        variant1 = view.findViewById(R.id.variant1)
        variant2 = view.findViewById(R.id.variant2)
        variant3 = view.findViewById(R.id.variant3)
        variant4 = view.findViewById(R.id.variant4)
        nextBtn = view.findViewById(R.id.next)

        GlobalScope.launch(Dispatchers.IO) {
            database = Room.databaseBuilder(requireActivity().applicationContext, WordDatabase::class.java, "english_words")
                .createFromAsset("database/english_words.db")
                .build()

            val wordDAO = database.wordDAO()
            val words = wordDAO.getRandomWords()

            Log.d("RRR", words.toString())

            requireActivity().runOnUiThread {
                updateUI(words)
            }
        }
    }

    private fun updateUI(words: List<Word>) {
        currentWord = words[0]
        questionField.text = currentWord.wordEnglish

        variant1.text = words[0].wordRussian
        variant2.text = words[1].wordRussian
        variant3.text = words[2].wordRussian
        variant4.text = words[3].wordRussian
    }
}