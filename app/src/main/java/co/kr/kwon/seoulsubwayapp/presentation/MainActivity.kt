package co.kr.kwon.seoulsubwayapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import co.kr.kwon.seoulsubwayapp.R
import co.kr.kwon.seoulsubwayapp.databinding.ActivityMainBinding
import co.kr.kwon.seoulsubwayapp.extension.toGone
import co.kr.kwon.seoulsubwayapp.extension.toVisible

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val navigationController by lazy {
        (supportFragmentManager.findFragmentById(R.id.mainNavigationHostContainer)
                as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
        bindViews()

    }

    override fun onSupportNavigateUp(): Boolean {
        return navigationController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun initViews() {
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navigationController)
    }

    private fun bindViews() {
        navigationController.addOnDestinationChangedListener { _, destination, argument ->
            if (destination.id == R.id.station_arrivals_dest) {
                binding.toolbar.toVisible()
            } else {
                binding.toolbar.toGone()
            }
        }
    }


}