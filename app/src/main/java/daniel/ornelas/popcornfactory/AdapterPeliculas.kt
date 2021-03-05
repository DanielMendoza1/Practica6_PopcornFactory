package daniel.ornelas.popcornfactory

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.pelicula.view.*

class AdapterPeliculas: BaseAdapter {

    var peliculas = ArrayList<Pelicula>()
    var context: Context? = null

    constructor(context: Context, peliculas: ArrayList<Pelicula>) {
        this.context = context
        this.peliculas = peliculas


    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var pelicula = peliculas[position]
        var inflator = LayoutInflater.from(context)
        var vista = inflator.inflate(R.layout.pelicula, null)

        var image = vista.findViewById(R.id.iv_pelicula) as ImageView
        var nombre = vista.findViewById(R.id.tv_pelicula) as TextView

        image.setImageResource(pelicula.image)
        nombre.setText(pelicula.titulo)

        vista.iv_pelicula.setOnClickListener {
            var intent = Intent(context, DetallePelicula::class.java)
            intent.putExtra("titulo", pelicula.titulo)
            intent.putExtra("image", pelicula.image)
            intent.putExtra("header", pelicula.header)
            intent.putExtra("sinopsis", pelicula.sinopsis)
            context!!.startActivity(intent)
        }
        return vista
    }

    override fun getItem(position: Int): Any {
        return peliculas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return peliculas.size
    }
}