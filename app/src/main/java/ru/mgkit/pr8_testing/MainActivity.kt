package ru.mgkit.pr8_testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Convert private constructor(){

    companion object {
        fun format (str: String, type: Int): String {
            return if (str.toIntOrNull() != null) {
                Integer.parseInt(str).toString(type)
            } else {
                "ОШИБКА!"
            }
        }

    }


}

class MainActivity : AppCompatActivity() {
    private var hexButton: Button? = null
    private var octButton: Button? = null
    private var binButton: Button? = null
    private var inputField: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hexButton = findViewById(R.id.hex_Button)
        octButton = findViewById(R.id.oct_Button)
        binButton = findViewById(R.id.bin_Button)
        inputField = findViewById(R.id.inputField)
        findViewById<Button>(R.id.sendButton).setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, findViewById<TextView>(R.id.inputField).text.toString())
            intent.type = "text/plain"
            //Окно выбор
            val intentCreateChooser = Intent.createChooser(intent, null)
            startActivity(intentCreateChooser)
        }

        hexButton?.setOnClickListener {
            inputField?.setText(Convert.format(inputField?.text.toString(),16))
        }

        octButton?.setOnClickListener {
            inputField?.setText(Convert.format(inputField?.text.toString(),8))
        }

        binButton?.setOnClickListener {
            inputField?.setText(Convert.format(inputField?.text.toString(),2))
        }

    }
}