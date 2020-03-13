package com.pembelajar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pembelajar.databinding.ActivityMainBinding
import com.pembelajar.viewmodel.LocalViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: LocalViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(LocalViewModel::class.java)


        viewModel.sendReq()

        viewModel.getData().observe(this, Observer {
            binding.loadingBar.visibility = View.GONE

            binding.keyOne.text = it.keyOne
            binding.keyTwo.text = it.keyTwo
            binding.keyTwo.visibility = View.VISIBLE
            binding.keyOne.visibility = View.VISIBLE

        })
    }
}
