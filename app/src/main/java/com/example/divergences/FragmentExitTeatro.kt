package com.example.divergences

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import android.widget.Button
import android.widget.FrameLayout

class FragmentExitTeatro: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root =inflater.inflate(R.layout.fragmnt_exit_teatro, container, false)

        val cancelar = root.findViewById<View>(R.id.cancelar) as Button
        val confirmar = root.findViewById<View>(R.id.confirmar) as Button


        cancelar.setOnClickListener {
            val fondo: ConstraintLayout = (activity as Teatro).findViewById(R.id.clicks)
            fondo.isEnabled = true
            val boton1: Button? = (activity as Teatro).findViewById(R.id.btn1)
            val boton2: Button? = (activity as Teatro).findViewById(R.id.btn2)
            val boton3: Button? = (activity as Teatro).findViewById(R.id.btn3)

            boton1?.isEnabled=true
            boton2?.isEnabled=true
            boton3?.isEnabled=true

            val myExit: FragmentExitTeatro = fragmentManager!!.findFragmentByTag("MyExitTeatro") as FragmentExitTeatro
            fragmentManager!!.beginTransaction().hide(myExit).commit()
        }
        confirmar.setOnClickListener{
            activity?.finish()
        }
        return root
    }

}