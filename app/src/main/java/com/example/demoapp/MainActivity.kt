package com.example.demoapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.movieDetailsRV)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.layoutManager=LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        val users = ArrayList<User>()

        //adding some dummy data to the list
      users.add(User("welcome" ,false))
        users.add(User("Thank you",false))

        //creating our adapter
        val adapter = RecylerItemAdapter(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }
}