package com.example.sanjeevkumar.tricktest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_menuactivity.*

class Menuactivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View?) {
        var intent = Intent(this,Quizactivity::class.java)

        var value = when(view!!.id){
            science.id-> "science"
            maths.id-> "maths"
            reason.id-> "reason"
            gk.id-> "gk"
            else-> ""
        }
        intent.putExtra("subject", value)
        startActivity(intent)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menuactivity)


        science.setOnClickListener(this)
    maths.setOnClickListener(this)
        reason.setOnClickListener(this)
        gk.setOnClickListener(this)

    }




}
