package com.example.hw8


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),ItemAdapter.ItemAdapterListener {
    lateinit var newTaskButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //code
        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerView)
        val itemAdapter= ItemAdapter(this)
        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)


    }

    override fun click(position: Int) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra("DETAIL",position)
        startActivity(intent)
    }
    fun createTaskIntent(view: View){
        val intent = Intent(applicationContext, NewTaskActivity::class.java)
        startActivity(intent)

    }

}