package com.example.checkingtriangleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.checkingtriangleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun setOnClick(view: View) {
        if (!isEmpty()) {
            if (checkInputSize()) {
                val result = getString(R.string.result) + getString(R.string.positiveResult)
                binding.textResult.text = result
                binding.imageView.setImageResource(R.drawable.correct)
            } else {
                val negativeResult = getString(R.string.result) + getString(R.string.negativeResult)
                binding.textResult.text = negativeResult
                binding.imageView.setImageResource(R.drawable.error)
            }
        }
    }

    private fun isEmpty(): Boolean {
        binding.apply {
            if (inputA.text.isNullOrEmpty()) inputA.error = getString(R.string.errorA)
            if (inputB.text.isNullOrEmpty()) inputB.error = getString(R.string.errorB)
            if (inputC.text.isNullOrEmpty()) inputC.error = getString(R.string.errorC)

            return inputA.text.isNullOrEmpty() || inputB.text.isNullOrEmpty() || inputC.text.isNullOrEmpty()
        }
    }


    private fun checkInputSize(): Boolean {
        var sizeA: Double
        var sizeB: Double
        var sizeC: Double

        binding.apply {
            sizeA = inputA.text.toString().toDouble()
            sizeB = inputB.text.toString().toDouble()
            sizeC = inputC.text.toString().toDouble()

            return ((sizeA < sizeB + sizeC) && (sizeB < sizeA + sizeC) && (sizeC < sizeB + sizeA))
        }
    }
}