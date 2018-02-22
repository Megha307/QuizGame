package com.example.sanjeevkumar.tricktest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_scoreactivity.*

class Scoreactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreactivity)
        var intent = intent
        scoreviewText.text = intent.getIntExtra("Score", 0).toString()
        missviewtext.text=intent.getIntExtra("miss",0).toString()
        markedview.text=intent.getIntExtra("marked",0).toString()
        textView3.text=intent.getIntExtra("wrong",0).toString()
        textView5.text=intent.getIntExtra("correct",0).toString()
    }
}
