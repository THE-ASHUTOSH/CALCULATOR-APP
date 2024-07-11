package com.example.calculatorapp2

import android.os.Bundle
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorapp2.databinding.ActivityMainBinding//for viewBinding
import com.udojava.evalex.Expression

// binding is a method to call the button, textView etc using their ids and not use the
// findViewById to use the items.
// To implement the following first make changes in the build.gradle.kts file and then add some
// of the things in the main file (tags with viewBinding)


// in the tutorial a plugin was used which had been expired and we could not use it now so
// found a new method of binding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding  // for viewBinding
    lateinit var resultString: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //for viewBinding
        setContentView(R.layout.activity_main)
        setContentView(binding.root)//for viewBinding

        pressNumBtn()
        clearBtn()
        operationBtn()
        resultOp()
        BackBtn()

    }
    fun pressNumBtn(){
            binding.point.setOnClickListener {
                if(binding.inputView.text.length<=12) {
                    binding.inputView.text = "${binding.inputView.text}."
                    binding.finalView.text = ""
                }
                else{
                   inputFullError()
                }
             }
            binding.zero.setOnClickListener {
                if(binding.inputView.text.length<=12) {
                    binding.inputView.text = "${binding.inputView.text}0"
                    binding.finalView.text = ""
                }
                else{
                    inputFullError()
                }
            }
            binding.one.setOnClickListener {
                if(binding.inputView.text.length<=12) {
                    binding.inputView.text = "${binding.inputView.text}1"
                    binding.finalView.text = ""
                }
                else{
                    inputFullError()
                }
            }
            binding.two.setOnClickListener {
                if(binding.inputView.text.length<=12) {
                    binding.inputView.text = "${binding.inputView.text}2"
                    binding.finalView.text = ""
                }
                else{
                    inputFullError()
                }
            }
            binding.three.setOnClickListener {
                if(binding.inputView.text.length<=12) {
                    binding.inputView.text = "${binding.inputView.text}3"
                    binding.finalView.text = ""
                }
                else{
                    inputFullError()
                }
            }
            binding.four.setOnClickListener {
                if(binding.inputView.text.length<=12) {
                    binding.inputView.text = "${binding.inputView.text}4"
                    binding.finalView.text = ""
                }
                else{
                    inputFullError()
                }
            }
            binding.five.setOnClickListener {
                if(binding.inputView.text.length<=12) {
                    binding.inputView.text = "${binding.inputView.text}5"
                    binding.finalView.text = ""
                }
                else{
                    inputFullError()
                }
            }
            binding.six.setOnClickListener {
                if(binding.inputView.text.length<=12) {
                    binding.inputView.text = "${binding.inputView.text}6"
                    binding.finalView.text = ""
                }
                else{
                    inputFullError()
                }
            }
            binding.seven.setOnClickListener {
                if(binding.inputView.text.length<=12) {
                    binding.inputView.text = "${binding.inputView.text}7"
                    binding.finalView.text = ""
                }
                else{
                    inputFullError()
                }
            }
            binding.eight.setOnClickListener {
                if(binding.inputView.text.length<=12) {
                    binding.inputView.text = "${binding.inputView.text}8"
                    binding.finalView.text = ""
                }
                else{
                    inputFullError()
                }
            }
            binding.nine.setOnClickListener {
                if(binding.inputView.text.length<=12) {
                    binding.inputView.text = "${binding.inputView.text}9"
                    binding.finalView.text = ""
                }
                else{
                    inputFullError()
                }
            }

    }
    fun clearBtn(){
        binding.clear.setOnClickListener {
            try {
                if (binding.inputView.text == "") {
                    // Toast is used to show pop up at the bottom of the screen for a few second
                    Toast.makeText(this, "NO NUMBER TO DELETE", Toast.LENGTH_SHORT).show()
                }else {
                    binding.inputView.text = ""
                    resultString = ""
                    binding.finalView.text = ""
                }

            }catch (e:Exception){
                println("error clearBtn")
            }
        }
    }
    fun BackBtn(){
        binding.backSpace.setOnClickListener {
            try {
                if (binding.inputView.text == "") {
                    Toast.makeText(this, "NO NUMBER TO DELETE", Toast.LENGTH_SHORT).show()
                } else {
                    var text = binding.inputView.text
                    // substring is used to select a part of the string. First Parameter is the
                    // starting point and the second id the ending point. The end point is not included
                    var Newtext = text.substring(0, text.length - 1)
                    binding.inputView.text = Newtext
                    binding.finalView.text=""
                }
            }catch (e:Exception){
                println("error BackBtn")
            }
        }
    }
    fun operationBtn(){
        binding.plus.setOnClickListener {
            if(binding.inputView.text.length<=12) {
                binding.inputView.text = "${binding.inputView.text}+"
                binding.finalView.text = ""
            }
            else{
                inputFullError()
            }
        }
        binding.minus.setOnClickListener {
            if(binding.inputView.text.length<=12) {
                binding.inputView.text = "${binding.inputView.text}-"
                binding.finalView.text = ""
            }
            else{
                inputFullError()
            }
        }
        binding.multiply.setOnClickListener {
            if(binding.inputView.text.length<=12) {
                binding.inputView.text = "${binding.inputView.text}*"
                binding.finalView.text = ""
            }
            else{
                inputFullError()
            }
        }
        binding.divide.setOnClickListener {
            if(binding.inputView.text.length<=12) {
                binding.inputView.text = "${binding.inputView.text}/"
                binding.finalView.text = ""
            }
            else{
                inputFullError()
            }
        }
    }
    fun resultOp(){
        binding.equal.setOnClickListener {
            val inputString = binding.inputView.text.toString()
            try {
                val result = evaluateExpression(inputString)
                binding.finalView.text = inputString
                binding.inputView.text = result
            } catch (e: Exception) {
                Toast.makeText(this, "Can not evaluate this expression", Toast.LENGTH_SHORT).show()
                println("Error: ${e.message}")
            }
        }
    }
    //use of external dependency. Concept in google note
    fun evaluateExpression(expression: String): String {
        val expr = Expression(expression)
        return expr.eval().toPlainString()
    }
    fun inputFullError(){
        Toast.makeText(this, "No more inputs accepted", Toast.LENGTH_SHORT).show()
    }
}


// problems encountered
//    1)  to convert the string in the textview (inputView) to integer to calculate the expression
// solution: used a dependency to solve this. documentation available in google notes
//    2)  to remove a single character for the text view to make the backspace button functional
// solution: used the inbuilt method "substring" to solve it.It only selects some amount of the
// string