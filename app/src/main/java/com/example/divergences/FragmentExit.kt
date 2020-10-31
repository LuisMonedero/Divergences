package com.example.divergences

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import android.widget.Button

class FragmentExit: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root =inflater.inflate(R.layout.fragmnt_exit, container, false)

        val cancelar = root.findViewById<View>(R.id.cancelar) as Button
        val confirmar = root.findViewById<View>(R.id.confirmar) as Button

        cancelar.setOnClickListener {
            val fondo: ConstraintLayout =
                (activity as MainActivity).findViewById(R.id.constraintLayout)
            fondo.isEnabled = true
            val myExit: FragmentExit = fragmentManager!!.findFragmentByTag("MyExit") as FragmentExit
            fragmentManager!!.beginTransaction().hide(myExit).commit()
        }
        confirmar.setOnClickListener{
            activity?.finish()
        }
        return root
    }

}