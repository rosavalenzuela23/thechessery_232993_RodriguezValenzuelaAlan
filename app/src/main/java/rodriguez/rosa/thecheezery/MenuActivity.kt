package rodriguez.rosa.thecheezery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val coldDrinksButton: Button = findViewById(R.id.button_cold_drinks)
        val hotDrinksButton: Button = findViewById(R.id.button_hot_drinks)
        val saltiesButton: Button = findViewById(R.id.salties)
        val sweetsButton: Button = findViewById(R.id.button_sweets)

        coldDrinksButton.setOnClickListener {
            val intent: Intent = Intent(this, ProductosActivity::class.java)
            startActivity(intent)
        }

        hotDrinksButton.setOnClickListener {
            val intent: Intent = Intent(this, HotDrinks_Activity::class.java)
            startActivity(intent)
        }

        saltiesButton.setOnClickListener {
            val intent: Intent = Intent(this, Salties_Activity::class.java)
            startActivity(intent)
        }

        sweetsButton.setOnClickListener {
            val intent: Intent = Intent(this, Sweets_Activity::class.java)
            startActivity(intent)
        }

    }
}