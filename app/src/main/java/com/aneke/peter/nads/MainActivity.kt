package com.aneke.peter.nads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aneke.peter.nads.databinding.ActivityMainBinding
import com.aneke.peter.nigerianadministrativedivisionspinner.getAllStates
import com.aneke.peter.nigerianadministrativedivisionspinner.models.State
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel : MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

//        viewModel.state.observe(this, Observer {
//            it?.let {
//                lga.setCurrentState(it)
//            }
//        })


        state.setOnItemClickListener { _, _, _, id ->
            lga.setCurrentState(getAllStates()[id.toInt()].name)
        }







    }
}
