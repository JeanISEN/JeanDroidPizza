package fr.isen.tivollier.jeandroidpizza

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView

class confirmation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val adresse = intent.getStringExtra("adresse")
        val tel = intent.getStringExtra("tel")
        val pizza = intent.getStringExtra("pizza")
        val textViewAdresse = findViewById<TextView>(R.id.textView3).apply {
            text = adresse
        }
        val textViewTel = findViewById<TextView>(R.id.textView5).apply {
            text = tel
        }
        val textViewPizza = findViewById<TextView>(R.id.textView6).apply {
            text = pizza
        }

        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        val nom = sharedPref.getString("nom","")
        val prenom = sharedPref.getString("prenom","")
        val textViewNom = findViewById<TextView>(R.id.textView).apply {
            text = nom
        }
        val textViewPrenom = findViewById<TextView>(R.id.textView2).apply {
            text = prenom
        }

        var submit = findViewById<Button>(R.id.button)
        submit.setOnClickListener{
            //mail
        }
    }
}