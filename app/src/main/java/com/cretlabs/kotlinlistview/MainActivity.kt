package com.cretlabs.kotlinlistview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = ListViewAdapter(this)
    }
}
