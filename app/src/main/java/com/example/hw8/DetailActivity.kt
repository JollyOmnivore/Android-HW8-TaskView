package com.example.hw8

import android.content.Intent
import android.os.Bundle
import android.view.Display.Mode
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {

    lateinit var detailTextView: TextView
    lateinit var nameTextView: TextView
    lateinit var deleteButton: Button
    lateinit var prioritySpinner: Spinner
    lateinit var backButton: Button
    val priorityLevels = intArrayOf(1, 2, 3, 4, 5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameTextView = findViewById(R.id.enterTextName)
        detailTextView = findViewById(R.id.enterTextDesc)
        prioritySpinner = findViewById(R.id.prioritySpinner)
        deleteButton = findViewById(R.id.deleteButton)
        backButton = findViewById(R.id.backButton)


        val intent = intent
        val position = intent.getIntExtra("DETAIL", 0)
        val item = Model.items[position]

        nameTextView.text = item.name.toString()
        detailTextView.text = item.description.toString()
        prioritySpinner.setSelection(item.priority - 1)//


        // outside resources used
        //https://stackoverflow.com/questions/46447296/android-kotlin-onitemselectedlistener-for-spinner-not-working
        //https://www.digitalocean.com/community/tutorials/android-spinner-using-kotlin
        //===============================================================================================
        prioritySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                priorityPosition: Int,// overrode my other position
                id: Long
            ) {
                val selectedItem = priorityLevels[priorityPosition]
                Toast.makeText(this@DetailActivity, "Task Priority Changed to: $selectedItem", Toast.LENGTH_SHORT).show()//adds an indicator of change
                Model.items[position] = Item(item.name,item.description,selectedItem)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // I have to implement this
            }


        }
        //===============================================================================================

        backButton.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.putExtra("DETAIL",position)
            startActivity(intent)
        }
        deleteButton.setOnClickListener {
            Model.items.removeAt(position)
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.putExtra("DETAIL",position)
            startActivity(intent)
        }


    }
}