package com.example.bspl

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.bspl.api.Apis
import com.example.bspl.databinding.ActivityMainBinding
import com.example.bspl.databinding.LayoutItemBinding
import com.example.bspl.models.StringersData
import com.example.bspl.models.StringersDataItem
import com.example.bspl.viewmodel.MainViewModel
import com.yogeshpaliyal.universalAdapter.adapter.UniversalAdapterViewType
import com.yogeshpaliyal.universalAdapter.adapter.UniversalRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mViewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            // hold splash screen
            setKeepOnScreenCondition {
                mViewModel.isLoading.value
            }
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        getStringersList()
    }

    private fun getStringersList() {
        mViewModel.getStringer()
    }

    private fun initView() {
        binding.rvItems.adapter = mAdapter.getAdapter()
    }


    private val mAdapter by lazy {
        UniversalRecyclerAdapter.Builder<StringersDataItem>(
            content = UniversalAdapterViewType.Content(
                resource = R.layout.layout_item,
                customBindingMapping = {itemBinding, item, bindingAdapterPosition ->
                    (itemBinding as? LayoutItemBinding)?.let {binding ->
                        binding.root.setOnClickListener {
                            DetailActivity.start(this, item)
                        }
                    }
                }
            )
        ).build()
    }
}