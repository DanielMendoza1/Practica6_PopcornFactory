package daniel.ornelas.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detalle_compra.*

class DetalleCompra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_compra)

        val bundle = intent.extras
        var seat = ""
        var pos_movie = -1

        if (bundle != null){

            pos_movie = bundle.getInt("pos")
            seat = bundle.getString("seat").toString()
            num_seat.setText(seat)
        }

        buy.setOnClickListener {
            val nombre = nombre_comprador.text.toString()
            val id = radioGruop.checkedRadioButtonId
            val tipo_pago = radioGruop.findViewById<RadioButton>(id).text.toString()

            var cliente: Cliente = Cliente(nombre, tipo_pago, seat.toInt())

           Toast.makeText(this, "Enjoy the movie", Toast.LENGTH_LONG).show()
            var intent: Intent = Intent(this, menu::class.java)
            intent.putExtra("cliente", cliente)
            intent.putExtra("id_pelicula", pos_movie)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP
            this.startActivity(intent)

        }
    }
}