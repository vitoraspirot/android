package br.com.cwi.nespresso.favorites

import android.os.Bundle
import br.com.cwi.nespresso.R
import br.com.cwi.nespresso.base.BaseBottomNavigation
import br.com.cwi.nespresso.databinding.ActivityFavoritesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoritesActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityFavoritesBinding
    override val currentTab: Int = R.id.favorites_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

}