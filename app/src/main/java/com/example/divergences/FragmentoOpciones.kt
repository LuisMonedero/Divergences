package com.example.divergences


import android.media.MediaPlayer
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class FragmentoOpciones : Fragment() {
    var miView: View? = null
    var opcion1: Button? = null
    var opcion2: Button? = null
    var opcion3: Button? = null
    var mplayer: MediaPlayer? = null
    var texto1: String? = null
    var texto2: String? = null
    var texto3: String? = null

    //1//3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        miView = LayoutInflater.from(getContext()).inflate(R.layout.fragmnt_opciones, null)
        opcion1 = miView!!.findViewById(R.id.btn1)
        opcion2 = miView!!.findViewById(R.id.btn2)
        opcion3 = miView!!.findViewById(R.id.btn3)
        texto1 = arguments!!.getString("opcion1")
        texto2 = arguments!!.getString("opcion2")
        texto3 = arguments!!.getString("opcion3")
        println(texto1 + texto2 + texto3)
        if (texto3 == "") {
            opcion3!!.setVisibility(View.INVISIBLE)
            opcion3!!.setEnabled(false)
        }
        opcion1!!.text = texto1
        opcion2!!.text = texto2
        opcion3!!.text = texto3
        mplayer = MediaPlayer.create(activity, R.raw.opcion_select)
        opcion1!!.setOnClickListener(View.OnClickListener {
            mplayer!!.start()
            val misOpciones =
                fragmentManager!!.findFragmentByTag("misOpciones") as FragmentoOpciones
            val disabled: ConstraintLayout = (activity as Teatro).findViewById(R.id.clicks)
            disabled.isEnabled = true
            (activity as Teatro).tomaDato(1)
            (activity as Teatro).interaccion()
            fragmentManager!!.beginTransaction().remove(misOpciones).commit()
        })
        opcion2!!.setOnClickListener(View.OnClickListener {
            mplayer!!.start()
            val misOpciones =
                fragmentManager!!.findFragmentByTag("misOpciones") as FragmentoOpciones
            val disabled: ConstraintLayout = (activity as Teatro).findViewById(R.id.clicks)
            disabled.isEnabled = true
            (activity as Teatro).tomaDato(2)
            (activity as Teatro).interaccion()
            fragmentManager!!.beginTransaction().remove(misOpciones).commit()
        })
        opcion3!!.setOnClickListener(View.OnClickListener {
            mplayer!!.start()
            val misOpciones =
                fragmentManager!!.findFragmentByTag("misOpciones") as FragmentoOpciones
            val disabled: ConstraintLayout = (activity as Teatro).findViewById(R.id.clicks)
            disabled.isEnabled = true
            (activity as Teatro).tomaDato(3)
            (activity as Teatro).interaccion()
            fragmentManager!!.beginTransaction().remove(misOpciones).commit()
        })
        return miView
    }
}