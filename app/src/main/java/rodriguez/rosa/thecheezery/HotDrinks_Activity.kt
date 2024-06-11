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

class HotDrinks_Activity : AppCompatActivity() {

    var hotDrinks = ArrayList<Product>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hot_drinks)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addProducts()

        val listView: ListView = findViewById<ListView>(R.id.product_list)

        val adaptador: ProductAdapter = ProductAdapter(hotDrinks, this)
        listView.adapter = adaptador

    }

    private fun addProducts(): Unit {

        hotDrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.0))
        hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.0))
        hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.0))
        hotDrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.0))
        hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.0))
        hotDrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.0))


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