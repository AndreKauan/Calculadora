package com.akantonelli.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import org.mariuszgromada.math.mxparser.Expression


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Click Event
        val btn0 =  findViewById<TextView>(R.id.Btn0);
        btn0.setOnClickListener {addCalc("0", true)}
        val btn1 =  findViewById<TextView>(R.id.Btn1);
        btn1.setOnClickListener {addCalc("1", true)}
        val btn2 =  findViewById<TextView>(R.id.Btn2);
        btn2.setOnClickListener {addCalc("2", true)}
        val btn3 =  findViewById<TextView>(R.id.Btn3);
        btn3.setOnClickListener {addCalc("3", true)}
        val btn4 =  findViewById<TextView>(R.id.Btn4);
        btn4.setOnClickListener {addCalc("4", true)}
        val btn5 =  findViewById<TextView>(R.id.Btn5);
        btn5.setOnClickListener {addCalc("5",true)}
        val btn6 =  findViewById<TextView>(R.id.Btn6);
        btn6.setOnClickListener {addCalc("6", true)}
        val btn7 =  findViewById<TextView>(R.id.Btn7);
        btn7.setOnClickListener {addCalc("7", true)}
        val btn8 =  findViewById<TextView>(R.id.Btn8);
        btn8.setOnClickListener {addCalc("8", true)}
        val btn9 =  findViewById<TextView>(R.id.Btn9);
        btn9.setOnClickListener {addCalc("9", true)}
        val btnPoint = findViewById<TextView>(R.id.BtnPoint)
        btnPoint.setOnClickListener {addCalc(".", true)}
        val btnOpenParent = findViewById<TextView>(R.id.BtnOpenParent)
        btnOpenParent.setOnClickListener {addCalc("(",true)}
        val btnCloseParent = findViewById<TextView>(R.id.BtnCloseParent)
        btnCloseParent.setOnClickListener {addCalc(")",true)}

        //Operator Event
        val btnPlus = findViewById<TextView>(R.id.BtnPlus)
        btnPlus.setOnClickListener{addCalc("+", true)}
        val btnMinus = findViewById<TextView>(R.id.BtnMinus)
        btnMinus.setOnClickListener{addCalc("-", true)}
        val btnMultiply = findViewById<TextView>(R.id.BtnMultiply)
        btnMultiply.setOnClickListener{addCalc("*", true)}
        val btnDivision = findViewById<TextView>(R.id.BtnDivision)
        btnDivision.setOnClickListener{addCalc("/",true)}

        //Clear Event
        val  btnClear = findViewById<TextView>(R.id.BtnClear)
        btnClear.setOnClickListener{addCalc("", false)}

        //Equal Event
        val txtResult = findViewById<TextView>(R.id.result)
        var txtForm = findViewById<TextView>(R.id.form)

        val btnEqual = findViewById<TextView>(R.id.BtnEquals)
        btnEqual.setOnClickListener{
            val resultado = Expression(txtResult.text.toString()).calculate()

            txtForm.text = txtResult.text
            txtResult.text = resultado.toString()

        }

    }

    fun addCalc (string: String, clear: Boolean){

        val txtResult = findViewById<TextView>(R.id.result)
        val txtForm = findViewById<TextView>(R.id.form)

        if (txtResult.text.isNotEmpty()){
            txtForm.text=""
        }

        if (clear){
            txtResult.append(string)
        }else{
            txtResult.text=""
            txtForm.text=""
        }

    }
}
