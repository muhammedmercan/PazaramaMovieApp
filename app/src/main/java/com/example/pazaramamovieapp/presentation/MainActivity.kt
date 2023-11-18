package com.example.pazaramamovieapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.pazaramamovieapp.databinding.ActivityMainBinding
import com.example.pazaramamovieapp.domain.repository.MovieRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    @Inject
    lateinit var repository: MovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("MainActivity", "MainActivity: ")
        lifecycleScope.launch {
            Log.e("MainActivity", "onCreate: ")
            val movies = repository.getMovies("Batman")
            Log.d("MainActivity", movies.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}