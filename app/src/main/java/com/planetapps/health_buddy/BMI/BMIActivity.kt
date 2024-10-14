package com.planetapps.health_buddy.BMI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.planetapps.health_buddy.R
import com.planetapps.health_buddy.databinding.ActivityBmiBinding

class BMIActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calculateButton = binding.calculateButton
        val resultTextView = binding.resultTextView

        calculateButton.setOnClickListener {
            val height = binding.heightEditText.text.toString().toDoubleOrNull()
            val weight = binding.weightEditText.text.toString().toDoubleOrNull()

            if (height != null && weight != null) {
                val bmi = calculateBmi(height, weight)
                val bmiText = getBmiInterpretation(bmi)
                resultTextView.text = getString(R.string.bmi_result, bmi, bmiText)
            } else {
                resultTextView.text = getString(R.string.invalid_input)
            }
        }
    }

    private fun calculateBmi(heightInCm: Double, weightInKg: Double): Double {
        val heightInMeters = heightInCm / 100
        return weightInKg / (heightInMeters * heightInMeters)
    }

    private fun getBmiInterpretation(bmi: Double): String {
        return when (bmi) {
            in Double.MIN_VALUE..18.5 -> getString(R.string.underweight)
            in 18.6..24.9 -> getString(R.string.normal_weight)
            in 25.0..29.9 -> getString(R.string.overweight)
            else -> getString(R.string.obese)
        }
    }
}

