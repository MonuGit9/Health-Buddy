package com.planetapps.health_buddy


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.planetapps.health_buddy.BMI.BMIActivity
import com.planetapps.health_buddy.Meditation.MeditationActivity
import com.planetapps.health_buddy.StepCounter.StepCounterActivity
import com.planetapps.health_buddy.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvStep.setOnClickListener {
            val intent = Intent(activity, StepCounterActivity::class.java)
            startActivity(intent)
        }

        binding.cvBMI.setOnClickListener {
            val intent = Intent(activity, BMIActivity::class.java)
            startActivity(intent)
        }

        binding.cvMedit.setOnClickListener {
            val intent = Intent(activity, MeditationActivity::class.java)
            startActivity(intent)
        }


    }

        companion object {
        }

}