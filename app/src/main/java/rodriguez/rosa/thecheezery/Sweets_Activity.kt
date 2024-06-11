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
import android.widget.ListAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Sweets_Activity : AppCompatActivity() {

    var sweets = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sweets)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addProducts()

        val listView: ListView = findViewById<ListView>(R.id.product_list)

        val adaptador: ProductAdapter = ProductAdapter(sweets, this)
        listView.adapter = adaptador

    }

    private fun addProducts(): Unit {

        sweets.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.0))
        sweets.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.0))
        sweets.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4.0))
        sweets.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.0))
        sweets.add(Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.0))
        sweets.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.0))


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