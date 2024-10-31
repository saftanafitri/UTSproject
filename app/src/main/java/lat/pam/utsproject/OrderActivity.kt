package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.Toast

class OrderActivity : AppCompatActivity() {

    private lateinit var servingsEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var notesEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val foodName = intent.getStringExtra("foodName")

        val foodNameTextView: TextView = findViewById(R.id.etFoodName)
        foodNameTextView.text = foodName

        servingsEditText = findViewById(R.id.etServings)
        nameEditText = findViewById(R.id.etName)
        notesEditText = findViewById(R.id.etNotes)

        val orderButton: Button = findViewById(R.id.btnOrder)
        orderButton.setOnClickListener {
            val servings = servingsEditText.text.toString()
            val orderingName = nameEditText.text.toString()
            val additionalNotes = notesEditText.text.toString()

            if (servings.isNotBlank() && orderingName.isNotBlank() && additionalNotes.isNotBlank()) {
                val intent = Intent(this, ConfirmationActivity::class.java).apply {
                    putExtra("foodName", foodName)
                    putExtra("servings", servings)
                    putExtra("orderingName", orderingName)
                    putExtra("additionalNotes", additionalNotes)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
