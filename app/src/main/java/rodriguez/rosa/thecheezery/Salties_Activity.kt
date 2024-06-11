package rodriguez.rosa.thecheezery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Salties_Activity : AppCompatActivity() {

    var salties = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_salties)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addProducts()

        val listView: ListView = findViewById<ListView>(R.id.product_list)

        var adaptador: ProductAdapter = ProductAdapter(salties, this)
        listView.adapter = adaptador

    }

    private fun addProducts(): Unit {

        salties.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.0))
        salties.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.0))
        salties.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4.0))
        salties.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0))
        salties.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7.0))


    }

    private class ProductAdapter: BaseAdapter {

        var productos = ArrayList<Product>()
        var context: Context? = null

        constructor(productos: ArrayList<Product>, context: Context) {
            this.productos = productos
            this.context = context
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var prod = productos[position]
            var inflador = LayoutInflater.from(context)
            var vista = inflador.inflate(R.layout.product_view, null)

            var imagen = vista.findViewById<ImageView>(R.id.img_product)
            var nombre = vista.findViewById<TextView>(R.id.product_name)
            var precio = vista.findViewById<TextView>(R.id.product_price)
            var desc = vista.findViewById<TextView>(R.id.product_description)

            imagen.setImageResource(prod.image)
            nombre.text = prod.name
            precio.text = "$${prod.price.toString()}"
            desc.text = prod.description


            return vista
        }

    }

}