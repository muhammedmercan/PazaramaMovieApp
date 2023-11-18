package com.example.pazaramamovieapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.pazaramamovieapp.R
import com.example.pazaramamovieapp.domain.repository.MovieRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: MovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity", "MainActivity: ")
        lifecycleScope.launch {
            Log.e("MainActivity", "onCreate: ")
            val movies = repository.getMovies("Batman")
            Log.d("MainActivity", movies.toString())
        }
    }
}