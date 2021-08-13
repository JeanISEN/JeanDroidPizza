package fr.isen.tivollier.jeandroidpizza

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var spinner = findViewById<Spinner>(R.id.spinner)
        var aa = ArrayAdapter.createFromResource(
            this,
            R.array.pizzas,
            android.R.layout.simple_spinner_item
        )
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = aa

        var prenom = findViewById<EditText>(R.id.editTextTextPersonName)
        var nom = findViewById<EditText>(R.id.editTextTextPersonName2)
        var adresse = findViewById<EditText>(R.id.editTextTextPersonName3)
        var tel = findViewById<EditText>(R.id.editTextPhone)
        var heure = findViewById<TimePicker>(R.id.timePicker1)
        var submit = findViewById<Button>(R.id.button)
        submit.setOnClickListener{
            val form_prenom = prenom.text
            val form_nom = nom.text
            val form_adresse = adresse.text
            val form_tel = tel.text
            val form_pizza = spinner.selectedItem.toString()
            if (form_prenom != null && form_nom != null && form_adresse != null && form_tel != null && form_pizza != null){
                val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("nom", form_nom.toString())
                    putString("prenom", form_prenom.toString())
                    commit()
                }
                val intent = Intent(this, confirmation::class.java).apply {
                    putExtra("adresse", form_adresse)
                    putExtra("tel", form_tel)
                    putExtra("pizza", form_pizza)
                }
                startActivity(intent)
            }

        }

    }
}