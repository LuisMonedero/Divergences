package com.example.divergences

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class FragmentoNuevaPartida : Fragment() {
    private var vistaMenu: View? = null
    private var back: Button? = null
    private var ahead: Button? = null
    private var press: ImageView? = null
    private var circle: ImageView? = null
    private var texto: TextView? = null
    private var mPlayer3: MediaPlayer? = null

    //1//3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vistaMenu = LayoutInflater.from(context).inflate(R.layout.fragmnt_nuevapartida, null)
        ahead = vistaMenu!!.findViewById(R.id.button)
        back = vistaMenu!!.findViewById(R.id.button2)
        mPlayer3 = MediaPlayer.create(activity, R.raw.select)
        back!!.setOnClickListener { //FIN DE VENTANA EMERGENTE
            animaciones()
        }
        ahead!!.setOnClickListener{ //FIN DE VENTANA EMERGENTE
            animaciones()
            mPlayer3!!.start()
            val mybd = BD(context)
            mybd.nuevaPartida()
            mybd.close()
            val miadver =
                fragmentManager!!.findFragmentByTag("miAdvertencia") as FragmentoNuevaPartida
                fragmentManager!!.beginTransaction().hide(miadver).commit()
            val i = Intent(activity, Teatro::class.java)
            startActivity(i)
        }
        return vistaMenu
    }

    private fun animaciones() {
        mPlayer3!!.start()
        val miadver =
            fragmentManager!!.findFragmentByTag("miAdvertencia") as FragmentoNuevaPartida
            fragmentManager!!.beginTransaction().hide(miadver).commit()

        val fondo: ConstraintLayout =
            (activity as MainActivity).findViewById(R.id.constraintLayout)
        fondo.isEnabled = true

        //RECAMARA
        press = (activity as MainActivity).findViewById(R.id.imageView2)
        val animation = AnimationUtils.loadAnimation(back!!.context, R.anim.backfromdown)
        press!!.startAnimation(animation)

        //TEXTO
        texto = (activity as MainActivity).findViewById(R.id.textView3)
        val animation2 = AnimationUtils.loadAnimation(back!!.context, R.anim.backfromright)
        texto!!.startAnimation(animation2)

        //ARO
        circle = (activity as MainActivity).findViewById(R.id.imageView)
        val animation3 = AnimationUtils.loadAnimation(back!!.context, R.anim.backantireloj)
        circle!!.startAnimation(animation3)

        //FIN DE VENTANA EMERGENTE
        val menumain = fragmentManager!!.findFragmentByTag("MiMenuMain") as FragmentoMenuMain
        fragmentManager!!.beginTransaction().hide(menumain).commit()
    }


}