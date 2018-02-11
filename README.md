# KotlinListview
http://thoughtnerds.com/listview-using-kotlin-android-tutorial/

Listview using Kotlin Android Example.
Listview is very needy for all  when developing android apps. This tutorial shows How to create Listview using Kotlin android with Example. First need to create a android application including kotlin support.

 

1) Create layout_item.xml contains AppCompatTextView widget with id li_list_textview.

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
    android:layout_height="match_parent">
<android.support.v7.widget.AppCompatTextView
    android:layout_width="match_parent"
    android:id="@+id/li_list_textview"
    style="@style/Base.TextAppearance.AppCompat.Subhead"
    android:layout_height="wrap_content" />
</android.support.constraint.ConstraintLayout>
2)Create a ListviewAdapter.kt as follows, This adapter inflate views from layout_item.xml

package com.cretlabs.kotlinlistview

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * Created by Gokul on 2/11/2018.
 */
class ListViewAdapter(context: Context) : BaseAdapter() {
    internal var sList = arrayOf("Apple", "Orange", "Grape", "Pine Apple", "Jack fruit", "Strawberry", "Guava"
    )
    private val mInflator: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return sList.size
    }

    override fun getItem(position: Int): Any {
        return sList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ViewHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.layout_item, parent, false)
            vh = ViewHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }

        vh.label.text = sList[position]
        return view
    }
}

/**
 * View holder
 */
private class ViewHolder(row: View?) {
    public val label: AppCompatTextView
    init {
        this.label = row?.findViewById<AppCompatTextView>(R.id.li_list_textview)!!
    }
}
3)Create actuvuty_main.xml as follows, Layout contains android Listview widget with id  list

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.cretlabs.kotlinlistview.MainActivity">

    <ListView
        android:id="@+id/list"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
</android.support.constraint.ConstraintLayout>
4)Create MainActivity.kt  to initialize Listview widget and setting adapter to listview

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
Its all done like this you can create simple list view using kotlin in android.


