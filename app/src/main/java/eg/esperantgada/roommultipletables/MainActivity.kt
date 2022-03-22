package eg.esperantgada.roommultipletables

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eg.esperantgada.roommultipletables.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.startButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}