package daniel.ornelas.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btn_iniciar)
        btn.setOnClickListener {
            var intent: Intent = Intent(this, menu::class.java)
            startActivity(intent)
        }
    }
}

