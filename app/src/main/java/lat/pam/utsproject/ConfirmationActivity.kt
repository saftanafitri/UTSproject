package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val foodName = intent.getStringExtra("foodName")
        val servings = intent.getStringExtra("servings")
        val orderingName = intent.getStringExtra("orderingName")
        val additionalNotes = intent.getStringExtra("additionalNotes")

        val foodNameTextView: TextView = findViewById(R.id.tvFoodName)
        val servingsTextView: TextView = findViewById(R.id.tvServings)
        val orderingNameTextView: TextView = findViewById(R.id.tvOrderingName)
        val notesTextView: TextView = findViewById(R.id.tvAdditionalNotes)

        foodNameTextView.text = "Food Name: $foodName"
        servingsTextView.text = "Number of Servings: $servings"
        orderingNameTextView.text = "Ordering Name: $orderingName"
        notesTextView.text = "Additional Notes: $additionalNotes"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backToMenuButton: Button = findViewById(R.id.backtoMenu)
        backToMenuButton.setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}