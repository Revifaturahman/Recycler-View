package com.example.recycle_view

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recycle_view.Model.Hero

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val heroImage = findViewById<ImageView>(R.id.heroImg)
        val txtheroName = findViewById<TextView>(R.id.heroName)
        val txtheroDesc = findViewById<TextView>(R.id.heroDesc)

        val hero = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Hero>("OBJECT_HERO", Hero::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>("OBJECT_HERO")
        }

        if(hero != null){
            heroImage.setImageResource(hero.foto)
            txtheroName.text = hero.nama
            txtheroDesc.text = hero.desk
        }

    }
}