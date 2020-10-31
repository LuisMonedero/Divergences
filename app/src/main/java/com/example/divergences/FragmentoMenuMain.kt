package com.example.divergences


import android.media.MediaPlayer
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.support.v4.app.Fragment
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class FragmentoMenuMain : Fragment() {
    var back: ConstraintLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val root =inflater.inflate(R.layout.fragmnt_menumain, container, false)

        back = root!!.findViewById(R.id.receptor) as ConstraintLayout

        back!!.setOnClickListener {
            animaciones()
        }
        val salir: Button = root!!.findViewById(R.id.opciones) as Button
        salir.setOnClickListener{
            activity!!.finish()
        }

        return root
    }

    private fun animaciones() {
        val mPlayer = MediaPlayer.create(activity, R.raw.gun_reload)
        mPlayer.start()

        //RECAMARA
        val press:ImageView? = (activity as MainActivity).findViewById(R.id.imageView2)
        val animation = AnimationUtils.loadAnimation(back!!.context, R.anim.backfromdown)
        press!!.startAnimation(animation)

        //TEXTO
        val texto: TextView? = (activity as MainActivity).findViewById(R.id.textView3)
        val animation2 = AnimationUtils.loadAnimation(back!!.context, R.anim.backfromright)
        texto!!.startAnimation(animation2)

        //ARO
        val circle:ImageView? = (activity as MainActivity).findViewById(R.id.imageView)
        val animation3 = AnimationUtils.loadAnimation(back!!.context, R.anim.backantireloj)
        circle!!.startAnimation(animation3)

        //FIN DE VENTANA EMERGENTE
        val menumain: FragmentoMenuMain  = fragmentManager!!.findFragmentByTag("MiMenuMain") as FragmentoMenuMain
        fragmentManager!!.beginTransaction().hide(menumain).commit()
    }
}
