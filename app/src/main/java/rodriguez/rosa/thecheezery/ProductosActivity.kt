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
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import org.w3c.dom.Text

class ProductosActivity : AppCompatActivity() {

    var coldDrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addProducts()

        val listView: ListView = findViewById<ListView>(R.id.product_list)

        var adaptador: ProductAdapter = ProductAdapter(coldDrinks, this)
        listView.adapter = adaptador

    }

    private fun addProducts(): Unit {

        coldDrinks.add(Product("Caramel Frap", R.drawable.caramel_frap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
        coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolate_frap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
        coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
        coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
        coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
        coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0))


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