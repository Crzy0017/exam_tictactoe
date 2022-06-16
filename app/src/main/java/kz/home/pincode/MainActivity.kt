package kz.home.pincode

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private var order:Int = 0
    private lateinit var buttonList: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        editText.setText("Ходит крестик")

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        buttonList = listOf(
            button1, button2, button3, button4, button5, button6, button7, button8, button9
        )
        for(button in buttonList) {
            button.setOnClickListener {
                order++
                setGame(button, order)
                if(order>=5) {
                    gameShot()
                }
            }
        }
    }


    private fun setGame(button: Button, order:Int) {
        if(order%2==1) button.setBackgroundColor(resources.getColor(R.color.stroke))
        else button.setBackgroundColor(resources.getColor(R.color.stroke2))
        buttonText(button, order)
        textOrder(order)
    }

    private fun textOrder(order: Int) {
        if(order%2==0)
            editText.setText("Ходит крестик")
        else
            editText.setText("Ходит нолик")
    }

    private fun buttonText(button: Button, order: Int) {
        if(order%2==1)
            button.text = "X"
        else
            button.text = "O"
    }
    private fun gameShot() {
        if(button1.text.isNotEmpty() && button2.text.isNotEmpty() && button3.text.isNotEmpty()
            && button1.text.toString() == button2.text.toString()
            && button1.text.toString() == button3.text.toString()) {
            check()
        }
        else if(button1.text.isNotEmpty() && button4.text.isNotEmpty() && button7.text.isNotEmpty()
            && button1.text.toString() == button4.text.toString()
            && button1.text.toString() == button7.text.toString()) {
            check()
        }
        else if(button5.text.isNotEmpty() && button1.text.isNotEmpty() && button9.text.isNotEmpty()
            && button5.text.toString() == button1.text.toString()
            && button5.text.toString() == button9.text.toString()) {
            check()
        }
        else if(button5.text.isNotEmpty() && button2.text.isNotEmpty() && button8.text.isNotEmpty()
            && button5.text.toString() == button2.text.toString()
            && button5.text.toString() == button8.text.toString()) {
            check()
        }
        else if(button5.text.isNotEmpty() && button3.text.isNotEmpty() && button7.text.isNotEmpty()
            && button5.text.toString() == button3.text.toString()
            && button5.text.toString() == button7.text.toString()) {
            check()
        }
        else if(button5.text.isNotEmpty() && button4.text.isNotEmpty() && button6.text.isNotEmpty()
            && button5.text.toString() == button4.text.toString()
            && button5.text.toString() == button6.text.toString()) {
            check()
        }
        else if(button9.text.isNotEmpty() && button6.text.isNotEmpty() && button3.text.isNotEmpty()
            && button9.text.toString() == button6.text.toString()
            && button9.text.toString() == button3.text.toString()) {
            check()
        }
        else if(button9.text.isNotEmpty() && button8.text.isNotEmpty() && button7.text.isNotEmpty()
            && button9.text.toString() == button8.text.toString()
            && button9.text.toString() == button7.text.toString()) {
            check()
        }
        else return
    }

    private fun check() {
        val customView: View = layoutInflater.inflate(R.layout.dialog_custom, null)
        val dialog: AlertDialog = AlertDialog.Builder(this).apply {
            setView(customView)
        }.create()

        with(customView) {
            if(editText.text.toString() == "Ходит крестик") {
                findViewById<TextView>(R.id.title).text = "Выиграл НОЛИК"
            }
            else findViewById<TextView>(R.id.title).text = "Выиграл КРЕСТИК"
            findViewById<Button>(R.id.restartButton).setOnClickListener {
                //val intent = intent
                finish()
                startActivity(intent)
            }
        }
        dialog.show()
    }
}