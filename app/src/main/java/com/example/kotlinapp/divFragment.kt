package com.example.kotlinapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.div_layout.*
import kotlinx.android.synthetic.main.div_layout.view.*
import java.lang.StringBuilder
import android.widget.Toast.makeText as makeText1

class divFragment : Fragment() {

    var flag = 0
    var primonumero = 0
    var secondonumero = 0
    var  string : String = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =  inflater!!.inflate(R.layout.div_layout, container, false)
        view.editTextNumberDecimal.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if(flag==0) {
                    view.risultato.text = view.editTextNumberDecimal.text.toString()
                } else  {
                    view.risultato.text=primonumero.toString() + " / " + view.editTextNumberDecimal.text.toString()
                }
            }
        })
        view.divbtn.setOnClickListener(View.OnClickListener {
            if(!view.editTextNumberDecimal.text.toString().isEmpty()) {
                if(flag==0) {
                    primonumero = Integer.parseInt(view.editTextNumberDecimal.text.toString())
                    string = view.risultato.text.toString()
                    view.risultato.text = "$string /"
                    flag = 1
                    view.editTextNumberDecimal.setText("")
                    view.divbtn.setText("=")
                    Log.e("numero", primonumero.toString())
                } else {
                    secondonumero = Integer.parseInt(view.editTextNumberDecimal.text.toString())
                    view.editTextNumberDecimal.setText("")
                    risultato.text=(primonumero / secondonumero).toString()
                    flag=0
                    view.divbtn.setText("/")
                }
            }
            else {
                Toast.makeText(context, "Inserisci il numero da dividere", Toast.LENGTH_LONG).show()
            }
        })
        return view
    }
}


