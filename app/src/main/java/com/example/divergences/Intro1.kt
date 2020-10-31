package com.example.divergences

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.intro_activity1.*

class Intro1: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity1)
        cambiarOpcionesUI()
        mostrarVista()
    }
    private fun mostrarVista(){

        Handler(Looper.getMainLooper()).postDelayed({
            val aparecer = AnimationUtils.loadAnimation(this, R.anim.aparecer)
            textView1.animation = aparecer
            textView2.animation = aparecer
        }, 0)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Intro2::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.aparecer,R.anim.desaparecer)
            finish()
        }, 7000)
    }

    override fun onBackPressed() {
        //super.onBackPressed()
    }

    private fun cambiarOpcionesUI(){
        //DEPRECATED??
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        //window.setDecorFitsSystemWindows(false)
        //This last line is suppossed to do the same job as this methood in lvl 30 APIS or higher, but running this in lvl 30 apis does nothing, so just keep old methods
    }

}