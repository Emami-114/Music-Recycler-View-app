package de.syntax_institut.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.myapplication.adapter.ItemAdapter
import de.syntax_institut.myapplication.adapter.ListAdapter
import de.syntax_institut.myapplication.adapter.model.MusicLoader
import de.syntax_institut.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val recycleView = binding.recycleViewVertical
        val recycleView2 = findViewById<RecyclerView>(R.id.recycler_view_horizontal)

        val musics = MusicLoader(this).loadMusic()
        val genres = MusicLoader(this).loadGenres()
        recycleView.adapter = ListAdapter(this,genres)
        recycleView.setHasFixedSize(true)
    }


}