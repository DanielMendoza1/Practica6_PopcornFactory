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


class AdapterSeries: BaseAdapter {

    var series = ArrayList<Serie>()
    var context: Context? = null

    constructor(context: Context, series: ArrayList<Serie>) {
        this.context = context
        this.series = series


    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var serie = series[position]
        var inflator = LayoutInflater.from(context)
        var vista = inflator.inflate(R.layout.pelicula, null)

        var image = vista.findViewById(R.id.iv_pelicula) as ImageView
        var nombre = vista.findViewById(R.id.tv_pelicula) as TextView

        image.setImageResource(serie.image)
        nombre.setText(serie.titulo)

        vista.iv_pelicula.setOnClickListener {
            var intent = Intent(context, DetallePelicula::class.java)
            intent.putExtra("titulo", serie.titulo)
            intent.putExtra("image", serie.image)
            intent.putExtra("header", serie.header)
            intent.putExtra("sinopsis", serie.sinopsis)
            context!!.startActivity(intent)
        }
        return vista
    }

    override fun getItem(position: Int): Any {
        return series[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return series.size
    }


}