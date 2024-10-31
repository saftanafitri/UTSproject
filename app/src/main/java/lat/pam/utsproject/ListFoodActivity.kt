package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = listOf(
            Food("Batagor", "Batagor adalah camilan gurih khas Bandung yang menggabungkan tahu dan ikan tenggiri yang digoreng renyah, disajikan dengan saus kacang pedas dan sambal.", R.drawable.batagor),
            Food("Black Salad", "Black Salad adalah hidangan sehat yang berisi sayuran segar dengan sentuhan saus hitam eksotis, ditambah keju unik untuk pengalaman rasa yang berbeda.", R.drawable.black_salad),
            Food("Cappucino", "Cappucino klasik yang kaya dan berbuih lembut ini dibuat dari espresso dan susu steamed, menjadikannya favorit sepanjang masa bagi pecinta kopi.", R.drawable.cappuchino),
            Food("Cheese Cake", "Cheese Cake yang lembut dengan lapisan keju krim tebal dan dasar biskuit renyah ini memiliki rasa manis seimbang, ideal untuk penutup makan malam.", R.drawable.cheesecake),
            Food("Cireng", "Cireng adalah jajanan renyah khas Sunda dengan isian pedas yang kenyal, cocok untuk camilan sore hari dengan saus rujak yang manis pedas.", R.drawable.cireng),
            Food("Donut", "Donut klasik dengan tekstur lembut dan topping gula atau cokelat ini cocok untuk camilan di segala suasana, baik untuk pagi atau sore hari.", R.drawable.donut),
            Food("Kopi Hitam", "Kopi Hitam murni dengan rasa pahit khas ini sangat pas untuk dinikmati tanpa tambahan apa pun, ideal bagi para penikmat kopi sejati.", R.drawable.kopi_hitam),
            Food("Mie Goreng", "Mie Goreng yang lezat ini dihidangkan dengan campuran sayuran segar dan bumbu pedas, dengan tambahan topping ayam atau udang yang gurih.", R.drawable.mie_goreng),
            Food("Nasi Goreng", "Nasi Goreng spesial dengan perpaduan kecap manis, sayuran segar, dan telur goreng di atasnya ini menjadi hidangan favorit yang tak pernah salah.", R.drawable.nasigoreng),
            Food("Sparkling Tea", "Sparkling Tea yang unik ini menyegarkan dengan soda dan aroma teh, ditambah pilihan rasa buah untuk momen yang lebih menyegarkan.", R.drawable.sparkling_tea)
        )



        adapter = FoodAdapter(foodList, this) { food ->
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("foodName", food.name)
            startActivity(intent)
        }

        recyclerView.adapter = adapter

        val mainView = findViewById<View>(R.id.main)
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(recyclerView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}
