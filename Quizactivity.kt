package com.example.sanjeevkumar.tricktest

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_menuactivity.*
import kotlinx.android.synthetic.main.activity_quizactivity.*

class Quizactivity : AppCompatActivity() {

    lateinit var questions : Array<String>
    lateinit var options : Array<String>
    lateinit var answers : Array<String>
    var counter=0
    var score=0
    var num=0
    var miss=0
    var incorrect=0
    var rigth=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizactivity)


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

        }


        var intent=intent

         var subject= intent.getStringExtra("subject")

        when(subject)
        {
           "science"->{
                questions=resources.getStringArray(R.array.scienceques)
                options=resources.getStringArray(R.array.scienceoptions)
                answers=resources.getStringArray(R.array.scienceans)
            }
           "maths"->{
                questions=resources.getStringArray(R.array.mathsques)
                options=resources.getStringArray(R.array.mathsoptions)
                answers=resources.getStringArray(R.array.mathsans)
            }
            "reason"->{
                questions=resources.getStringArray(R.array.reasonques)
                options=resources.getStringArray(R.array.reasonoptions)
                answers=resources.getStringArray(R.array.reasonans)
            }
            "gk"->{
                questions=resources.getStringArray(R.array.gkques)
                options=resources.getStringArray(R.array.gkoptions)
                answers=resources.getStringArray(R.array.gkans)
            }

        }
        LoadData()
    }

    private  fun LoadData()
    {
        if (counter<=questions.size-1)
        {
            QuestionTextview.text=questions[counter]
            RadioButton1.text=options[4*counter]
            RadioButton2.text=options[4*counter+1]
            RadioButton3.text=options[4*counter+2]
            RadioButton4.text=options[4*counter+3]

        }
        else
        {
            var intent = Intent(this, Scoreactivity :: class.java)
            intent.putExtra("Score" , score)
            intent.putExtra("marked",num)
            intent.putExtra("miss",miss)
            intent.putExtra("wrong",incorrect)
            intent.putExtra("correct",rigth)
            startActivity(intent)
            finish()
        }

    }
    fun nextbutton(view: View)
    {
        checkscore()
        counter++
        radiogroup.clearCheck()
        LoadData()
    }

    private fun checkscore() {

        if(radiogroup.checkedRadioButtonId != -1)
        {
            num++


            var radioButton = findViewById<RadioButton>(radiogroup.checkedRadioButtonId)

            if (radioButton.text == answers[counter])
            {
                rigth++;
                score+=10
            }
            else
            {
                incorrect++
            }

        }
        else
        {
            miss++

        }



    }
}

