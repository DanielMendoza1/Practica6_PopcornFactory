package daniel.ornelas.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras
        var ns = 0
        var id = -1
        var tittle = ""
        var asientos_ocupados: ArrayList<Cliente>? = null

        if (bundle != null){

            ns =  bundle.getInt("numberOfSeats")

            tittle = bundle.getString("titulo")!!
            iv_pelicula_imagen.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("titulo"))
            tv_descripcion_pelicula.setText(bundle.getString("sinopsis"))
            seats_left.setText("$ns seats Available")
            id = bundle.getInt("pos")
            asientos_ocupados = bundle.getParcelableArrayList("asientos_ocupados")

        }

        if (ns == 0){
            buy_tickets.isEnabled = false
        } else{
            buy_tickets.setOnClickListener {
                val intent: Intent = Intent(this, SeatsSelection::class.java)
                intent.putExtra("asientos_ocupados", asientos_ocupados)
                intent.putExtra("pos", id)
                intent.putExtra("titulo", tittle)
                this.startActivity(intent)
            }
        }
    }
}