package com.example.bspl

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bspl.databinding.ActivityDetailBinding
import com.example.bspl.models.StringersDataItem

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding


    companion object {

        const val ARGS_STRINGER_DATA = "args_stringer_data"

        @JvmStatic
        fun start(context: Context, stringerData: StringersDataItem) {
            val starter = Intent(context, DetailActivity::class.java)
                .putExtra(ARGS_STRINGER_DATA, stringerData)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}