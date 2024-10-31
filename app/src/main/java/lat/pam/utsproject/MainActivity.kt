package lat.pam.utsproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtUsername: EditText = findViewById(R.id.etUsername)
        val edtPassword: EditText = findViewById(R.id.etPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val tvRegister: TextView = findViewById(R.id.tvRegister)

        val sharedPref = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            val registeredUsername = sharedPref.getString("registeredUsername", null)
            val registeredPassword = sharedPref.getString("registeredPassword", null)


            if (username == registeredUsername && password == registeredPassword) {
                with(sharedPref.edit()) {
                    putBoolean("isLoggedIn", true)
                    apply()
                }
                startActivity(Intent(this, ListFoodActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Username atau password salah.", Toast.LENGTH_SHORT).show()
            }
        }

        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}
