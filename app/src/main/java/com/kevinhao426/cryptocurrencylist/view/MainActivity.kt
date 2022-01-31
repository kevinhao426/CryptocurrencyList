package com.kevinhao426.cryptocurrencylist.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kevinhao426.cryptocurrencylist.dao.AppDatabase
import com.kevinhao426.cryptocurrencylist.databinding.ActivityMainBinding
import com.kevinhao426.cryptocurrencylist.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var appDatabase: AppDatabase

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindUIEvent()
    }

    private fun bindUIEvent() {
        binding.fetchDataBtn.setOnClickListener {
            viewModel.fetchCurrencyList(this, appDatabase)
        }

        binding.clearDBBtn.setOnClickListener {
            viewModel.clearDB(appDatabase)
        }

        binding.sortListBtn.setOnClickListener {
            viewModel.sortCurrencyList()
        }
    }


}