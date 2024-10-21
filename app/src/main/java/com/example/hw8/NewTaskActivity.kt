package com.example.hw8

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewTaskActivity : AppCompatActivity() {
    lateinit var taskName: EditText
    lateinit var taskDesc: EditText
    lateinit var addTaskButton : Button
    lateinit var prioritySelect : Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_task)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addTaskButton = findViewById(R.id.submitButton)
        taskName = findViewById(R.id.editTextName)
        taskDesc = findViewById(R.id.editTextDesc)
        prioritySelect = findViewById(R.id.prioritySpinner)

        addTaskButton.setOnClickListener {
            if (taskName.text != null && taskDesc.text != null){
                val priority = prioritySelect.getItemAtPosition(prioritySelect.selectedItemPosition).toString().toInt()
                Model.items.add(Item(taskName.text.toString(),taskDesc.text.toString(),priority))
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }


        }



    }






}