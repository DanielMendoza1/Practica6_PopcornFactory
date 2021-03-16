package daniel.ornelas.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_seats_selection.*


class SeatsSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seats_selection)

        val title: TextView = tittleSeats
        var posMovie = -1
        var seat = ""
        var asientos_ocupados: ArrayList<Cliente>? = null

        val bundle = intent.extras

        if (bundle != null){
            title.setText(bundle.getString("titulo"))
            posMovie = bundle.getInt("pos")
            asientos_ocupados = bundle.getParcelableArrayList("asientos_ocupados")
        }

        val confirm: Button = confirm
        confirm.setOnClickListener {

            val intent: Intent = Intent(this, DetalleCompra::class.java)
            intent.putExtra("pos", posMovie)
            intent.putExtra("seat", seat)
            this.startActivity(intent)
        }

        val row1: RadioGroup = row1
        val row2: RadioGroup = row2
        val row3: RadioGroup = row3
        val row4: RadioGroup = row4

        row1.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedId)
                val radioButton: RadioButton = row1.findViewById(checkedId)
                seat = radioButton.text.toString()
            }
        }

        row2.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
                val radioButton: RadioButton = row2.findViewById(checkedId)
                seat = radioButton.text.toString()

            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)
                val radioButton: RadioButton = row3.findViewById(checkedId)
                seat = radioButton.text.toString()

            }
        }

        row4.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()

                row4.check(checkedId)
                val radioButton: RadioButton = row4.findViewById(checkedId)
                seat = radioButton.text.toString()

            }
        }

        if (asientos_ocupados != null) {
            if (asientos_ocupados.size > 0 ){
                for (asiento in asientos_ocupados){

                    if (asiento.asiento in 1..5){
                        row1[asiento.asiento-1].setBackgroundResource(R.drawable.radio_disable)
                    } else if (asiento.asiento in 6..10){
                        row2[asiento.asiento-6].setBackgroundResource(R.drawable.radio_disable)
                    } else if (asiento.asiento in 11..15){
                        row3[asiento.asiento-11].setBackgroundResource(R.drawable.radio_disable)
                    }  else if (asiento.asiento in 16..20){
                        row4[asiento.asiento-16].setBackgroundResource(R.drawable.radio_disable)

                    }
                }
            }
        }

    }
}