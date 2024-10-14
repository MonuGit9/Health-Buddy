package com.planetapps.health_buddy.StepCounter

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.planetapps.health_buddy.R
import java.util.Calendar

class StepCounterActivity : AppCompatActivity() {

    private var sensorManager: SensorManager? = null
    private var currentSteps = 0
    private lateinit var tvStepsTaken: TextView
    private lateinit var tv_CALORIES: TextView
    private lateinit var tv_DISTANCE: TextView
//    private val LAST_RESET_TIME = "last_reset_time"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stepcounter)

        tvStepsTaken = findViewById(R.id.tv_steps_taken)
        tv_CALORIES = findViewById(R.id.TV_CALORIES)
        tv_DISTANCE = findViewById(R.id.TV_DISTANCE)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

//        val sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)
//        val lastResetTime = sharedPreferences.getLong(LAST_RESET_TIME, 0)  // 0 if not set yet
//
//        if (isMidnight() || lastResetTime == 0L) { // Reset at midnight or first launch
//            currentSteps = 0
//            tvStepsTaken.text = "0"
//            tv_CALORIES.text = "0"
//            tv_DISTANCE.text = "0"
//            val editor = sharedPreferences.edit()
//            editor.putLong(LAST_RESET_TIME, System.currentTimeMillis())
//            editor.apply()
//        }

    }

    override fun onResume() {
        super.onResume()
        registerStepSensor()
    }

    override fun onPause() {
        super.onPause()
        unregisterStepSensor()
    }

    private fun registerStepSensor() {
        if (sensorManager != null) {
            val stepSensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
            if (stepSensor != null) {
                sensorManager!!.registerListener(stepListener, stepSensor, SensorManager.SENSOR_DELAY_NORMAL)
            }
        }
    }

    private fun unregisterStepSensor() {
        sensorManager?.unregisterListener(stepListener)
    }

    private val stepListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent?) {
            if (event != null) {
                currentSteps = event.values[0].toInt()
                tvStepsTaken.text =  "$currentSteps"
                tv_CALORIES.text = (currentSteps*0.04).toString()
                tv_DISTANCE.text = (currentSteps*0.762).toString()
            }
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            // Handle sensor accuracy changes (optional)
        }
    }


//
//    fun isMidnight(): Boolean {
//        val calendar = Calendar.getInstance()
//        calendar.timeInMillis = System.currentTimeMillis()
//        calendar.set(Calendar.HOUR_OF_DAY, 0)
//        calendar.set(Calendar.MINUTE, 0)
//        calendar.set(Calendar.SECOND, 0)
//        calendar.set(Calendar.MILLISECOND, 0)
//        return System.currentTimeMillis() >= calendar.timeInMillis
//    }

}





