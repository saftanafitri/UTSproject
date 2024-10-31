package lat.pam.utsproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etUsername: EditText = findViewById(R.id.etRegisterUsername)
        val etPassword: EditText = findViewById(R.id.etRegisterPassword)
        val etConfirmPassword: EditText = findViewById(R.id.etRegisterConfirmPassword)
        val btnRegister: Button = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Konfirmasi password tidak cocok", Toast.LENGTH_SHORT).show()
            } else {
                // Simpan username dan password di SharedPreferences
                val sharedPref = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("registeredUsername", username)
                    putString("registeredPassword", password)
                    apply()
                }

                // Beri tahu pengguna dan arahkan ke halaman login
                Toast.makeText(this, "Registrasi berhasil! Silakan login.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
