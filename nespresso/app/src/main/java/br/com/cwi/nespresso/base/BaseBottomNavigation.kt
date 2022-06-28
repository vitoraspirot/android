package br.com.cwi.nespresso.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.nespresso.R
import br.com.cwi.nespresso.bag.BagActivity
import br.com.cwi.nespresso.favorites.FavoritesActivity
import br.com.cwi.nespresso.products.ProductsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseBottomNavigation : AppCompatActivity() {

    abstract val currentTab: Int

    abstract fun getBottomNavigation(): BottomNavigationView

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onResume() {
        super.onResume()
        setUpBottomNavigationActions()
        selectCurrentTab()
    }

    private fun setUpBottomNavigationActions() {

        getBottomNavigation().setOnItemSelectedListener {
            if (!isCurrentTab(it.itemId)) when (it.itemId) {
                R.id.products_menu -> {
                    val intent = Intent(this, ProductsActivity::class.java)
                    startActivity(intent)
                }
                R.id.favorites_menu -> {
                    val intent = Intent(this, FavoritesActivity::class.java)
                    startActivity(intent)
                }
                R.id.bag_menu -> {
                    val intent = Intent(this, BagActivity::class.java)
                    startActivity(intent)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun selectCurrentTab() {
        getBottomNavigation().selectedItemId = currentTab
    }

    private fun isCurrentTab(itemId: Int): Boolean {
        return itemId == this.currentTab
    }
}