package br.com.cwi.nespresso.products

import android.content.Intent
import android.os.Bundle
import br.com.cwi.nespresso.R
import br.com.cwi.nespresso.base.BaseBottomNavigation
import br.com.cwi.nespresso.products.accessorie.AccessorieActivity
import br.com.cwi.nespresso.products.coffee.CoffeeActivity
import br.com.cwi.nespresso.databinding.ActivityProductsBinding
import br.com.cwi.nespresso.products.machine.MachineActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProductsActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityProductsBinding
    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpProductsActions()
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    private fun setUpProductsActions() {

        binding.contentCoffees.root.setOnClickListener {
            val intent = Intent(this, CoffeeActivity::class.java)
            startActivity(intent)
        }

        binding.contentMachines.root.setOnClickListener {
            val intent = Intent(this, MachineActivity::class.java)
            startActivity(intent)
        }

        binding.contentAccessories.root.setOnClickListener {
            val intent = Intent(this, AccessorieActivity::class.java)
            startActivity(intent)
        }

    }

}