package com.example.myapplication

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplication.screens.backdrop.OnBottomSheetCallbacks
import com.google.android.material.bottomsheet.BottomSheetBehavior
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private var listener: OnBottomSheetCallbacks? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.elevation = 0F
        supportActionBar?.title = "Home"
        supportActionBar?.setLogo(R.drawable.ic_search_icon)
        //supportActionBar?.setIcon()

        configureBackdrop()

        val bottomSheet = findViewById<View>(R.id.navigation_sheet)
        bottomSheet?.setOnClickListener {
            if (mainBottomSheetBehavior?.state == BottomSheetBehavior.STATE_COLLAPSED){
                openBottomSheet()
            }
        }
    }

    private var mainBottomSheetBehavior: BottomSheetBehavior<View?>? = null

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_application_top_menu, menu)

        menu?.findItem(R.id.hamburger_top_menu_button)?.setOnMenuItemClickListener {
            if (mainBottomSheetBehavior?.state == BottomSheetBehavior.STATE_EXPANDED){
                closeBottomSheet()
            }else{
                openBottomSheet()
            }
        }
        return true
    }

    private fun openBottomSheet(): Boolean {
        mainBottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED

        return true
    }

    private fun closeBottomSheet(): Boolean {
        mainBottomSheetBehavior?.state = BottomSheetBehavior.STATE_COLLAPSED

        return true
    }


    private fun configureBackdrop() {
        val fragment = supportFragmentManager.findFragmentById(R.id.navigation_sheet)

        fragment?.view?.let {
            BottomSheetBehavior.from(it).let { bottomSheet ->
                bottomSheet.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {}

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        listener?.onStateChanged(bottomSheet,newState)
                    }
                })
                bottomSheet.state = BottomSheetBehavior.STATE_EXPANDED

                mainBottomSheetBehavior = bottomSheet
            }
        }
    }



}