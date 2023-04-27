package com.example.shoppingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import com.example.shoppingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        val navController=navHostFragment!!.findNavController()
        val popupMenu=PopupMenu(this,null)
        popupMenu.inflate(R.menu.menu)
        supportActionBar?.hide()
        actionBar?.hide()
        binding.bottomBar.setupWithNavController(popupMenu.menu,navController)
      navController.addOnDestinationChangedListener(object:NavController.OnDestinationChangedListener{
          override fun onDestinationChanged(
              controller: NavController,
              destination: NavDestination,
              arguments: Bundle?
          ) {
              title=when(destination.id){
                  R.id.cartFragment->"Cart"
                  R.id.homeFragment->"Home"
                  R.id.moreFragment->"Setting"
                  R.id.moreFragment->"Setting2"
                  else -> "pkart"
              }


          }

      })



    }


}


