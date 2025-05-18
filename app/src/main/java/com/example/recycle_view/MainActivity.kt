package com.example.recycle_view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.recycle_view.Adapter.ListHeroAdapter
import com.example.recycle_view.Model.Hero

class MainActivity : AppCompatActivity() {
    private lateinit var rv_heroes: RecyclerView
    private var list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_heroes = findViewById(R.id.rv_hero)
        rv_heroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecycleList()
    }

    private fun getListHeroes(): ArrayList<Hero>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listHero = ArrayList<Hero>()
        for(i in dataDesc.indices){
            val hero = Hero(dataName[i], dataDesc[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }

        return listHero
    }

    private fun showRecycleList(){
        val listHeroAdapter = ListHeroAdapter(list){data ->
            showSelectedHero(data)
        }

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })

        rv_heroes.layoutManager = LinearLayoutManager(this)
        rv_heroes.adapter = listHeroAdapter
        rv_heroes.setHasFixedSize(true)
    }

    private fun showSelectedHero(hero: Hero){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("OBJECT_HERO", hero)
        startActivity(intent)
    }
}