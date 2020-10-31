package com.example.divergences


import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    var mPlayer: MediaPlayer? = null
    var mPlayer2: MediaPlayer? = null
    var mPlayer3: MediaPlayer? = null
    var mPlayer4: MediaPlayer? = null
    var start: ImageView? = null
    var circle: ImageView? = null
    var press: TextView? = null

    var animation: Animation? = null
    var animation2: Animation? = null
    var animation3: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPlayer2 = MediaPlayer.create(this, R.raw.gun)
        mPlayer3 = MediaPlayer.create(this, R.raw.select)
        mPlayer4 = MediaPlayer.create(this, R.raw.gun_reload)

        start = findViewById(R.id.imageView2)
        circle= findViewById(R.id.imageView)
        press= findViewById(R.id.textView3)

        animation = AnimationUtils.loadAnimation(this, R.anim.backfromdown)
        animation2 = AnimationUtils.loadAnimation(this, R.anim.backantireloj)
        animation3 = AnimationUtils.loadAnimation(this, R.anim.backfromright)

    }

    override fun onStart() {
        super.onStart()
        val flags = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        window.decorView.setSystemUiVisibility(flags)


        //MUSICA RESETEADA CADA VEZ QUE SE INICIA LA APP
        mPlayer = MediaPlayer.create(this, R.raw.ost)
        mPlayer!!.isLooping = true
        mPlayer!!.start()


        //ANIMACION DE LA ROTACION DE LA RECAMARA Y ARO

        start!!.startAnimation(animation)
        circle!!.startAnimation(animation2)
        press!!.startAnimation(animation3)
    }

    override fun onPause() {
        mPlayer!!.stop()
        super.onPause()
    }

    fun menu(w: View?) {
        var menumain: FragmentoMenuMain? = supportFragmentManager.findFragmentByTag("MiMenuMain") as FragmentoMenuMain?
        mPlayer2!!.seekTo(0)
        mPlayer2!!.start()
        val animation4 = AnimationUtils.loadAnimation(this, R.anim.godown)
        circle!!.startAnimation(animation4)
        val animation5 = AnimationUtils.loadAnimation(this, R.anim.godown)
        start!!.startAnimation(animation5)
        val animation6 = AnimationUtils.loadAnimation(this, R.anim.goright)
        press!!.startAnimation(animation6)

        if (menumain == null) {
            menumain = FragmentoMenuMain()
            supportFragmentManager.beginTransaction().add(R.id.miMenuMain, menumain, "MiMenuMain").commit()
        } else {
            if (menumain.isHidden || menumain.isDetached) supportFragmentManager.beginTransaction()
                .attach(menumain).show(menumain).commit()
        }
    }

    fun nuevaPartida(w: View?) {
        val fondo: ConstraintLayout? = findViewById(R.id.constraintLayout)
        fondo!!.isEnabled = false
        val menumain =
            supportFragmentManager.findFragmentByTag("MiMenuMain") as FragmentoMenuMain
        supportFragmentManager.beginTransaction().hide(menumain).commit()
        mPlayer3!!.start()
        var advertencia: FragmentoNuevaPartida? =
            supportFragmentManager.findFragmentByTag("miAdvertencia") as FragmentoNuevaPartida?
        if (advertencia == null) {
            advertencia = FragmentoNuevaPartida()
            supportFragmentManager.beginTransaction()
                .add(R.id.miMenuMain, advertencia, "miAdvertencia").commit()
        } else {
            if (advertencia.isHidden() || advertencia.isDetached()) getSupportFragmentManager().beginTransaction()
                .attach(advertencia).show(advertencia).commit()
        }
    }

    fun cargarPartida(w: View?) {
        val mybd = BD(this)
        val a = mybd.partida
        if (a.cap1_Opcion1 != "0") {
            mybd.close()
            val menumain =
                supportFragmentManager.findFragmentByTag("MiMenuMain") as FragmentoMenuMain
            supportFragmentManager.beginTransaction().hide(menumain).commit()
            finish()
            mPlayer3!!.start()
            val i = Intent(this, Teatro::class.java)
            startActivity(i)
        }
    }

    private fun salir(w: View?) {
        finish()
    }
    private fun animaciones(){
        //RECAMARA
        val press:ImageView? = findViewById(R.id.imageView2)
        val animation = AnimationUtils.loadAnimation(this, R.anim.backfromdown)
        press!!.startAnimation(animation)

        //TEXTO
        val texto: TextView? = findViewById(R.id.textView3)
        val animation2 = AnimationUtils.loadAnimation(this, R.anim.backfromright)
        texto!!.startAnimation(animation2)

        //ARO
        val circle:ImageView? = findViewById(R.id.imageView)
        val animation3 = AnimationUtils.loadAnimation(this, R.anim.backantireloj)
        circle!!.startAnimation(animation3)
    }

    override fun onBackPressed() {
        var menumain: FragmentoMenuMain? = supportFragmentManager.findFragmentByTag("MiMenuMain") as FragmentoMenuMain?
        var advertencia: FragmentoNuevaPartida? = supportFragmentManager.findFragmentByTag("miAdvertencia") as FragmentoNuevaPartida?
        var fragmentExit: FragmentExit? = supportFragmentManager.findFragmentByTag("MyExit") as FragmentExit?

        val fondo:ConstraintLayout = findViewById(R.id.constraintLayout)
        if(menumain != null && !menumain.isHidden){
            supportFragmentManager.beginTransaction().hide(menumain).commit()
            animaciones()
        }
        else if(advertencia != null && !advertencia.isHidden ){
            supportFragmentManager.beginTransaction().hide(advertencia).commit()
            animaciones()

            fondo.isEnabled = true
        }
        else{
            if (fragmentExit == null) {
                fragmentExit = FragmentExit()
                supportFragmentManager.beginTransaction().add(R.id.miExit, fragmentExit, "MyExit").commit()
                fondo.isEnabled = false
            } else {
                if (fragmentExit.isHidden || fragmentExit.isDetached) {
                    supportFragmentManager.beginTransaction().attach(fragmentExit)
                        .show(fragmentExit).commit()
                    fondo.isEnabled = false
                }
                else{
                    supportFragmentManager.beginTransaction().hide(fragmentExit).commit()
                    fondo.isEnabled = true
                }
            }
        }
    }
}
