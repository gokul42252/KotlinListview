# KotlinListview
http://thoughtnerds.com/listview-using-kotlin-android-tutorial/

<h1><span style="color: #000000;"><a href="http://thoughtnerds.com/listview-using-kotlin-android-tutorial/" style="color: #000000;">Listview using Kotlin Android Example</a></span>.</h1>
Listview is very needy for all  when developing android apps. This Shows how to Create Listview using Kotlin Android Tutorial. First need to create a android application including kotlin support.

1) Create layout_item.xml contains AppCompatTextView widget with id li_list_textview.
<pre><span style="color: #ff6600;">&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
    android:layout_height="match_parent"&gt;
&lt;android.support.v7.widget.AppCompatTextView
    android:layout_width="match_parent"
    android:id="@+id/li_list_textview"
    style="@style/Base.TextAppearance.AppCompat.Subhead"
    android:layout_height="wrap_content" /&gt;
&lt;/android.support.constraint.ConstraintLayout&gt;</span></pre>
2)Create a ListviewAdapter.kt as follows, This adapter inflate views from layout_item.xml
<pre><span style="color: #ff6600;">package com.cretlabs.kotlinlistview

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
        this.label = row?.findViewById&lt;AppCompatTextView&gt;(R.id.li_list_textview)!!
    }
}</span></pre>
3)Create actuvuty_main.xml as follows, Layout contains android Listview widget with id  list
<pre><span style="color: #ff6600;">&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.cretlabs.kotlinlistview.MainActivity"&gt;

    &lt;ListView
        android:id="@+id/list"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" /&gt;
&lt;/android.support.constraint.ConstraintLayout&gt;
</span></pre>
4)Create MainActivity.kt  to initialize Listview widget and setting adapter to listview
<pre><span style="color: #ff6600;">package com.cretlabs.kotlinlistview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        setContentView(R.layout.activity_main)
        val listView = findViewById&lt;ListView&gt;(R.id.list)
        listView.adapter = ListViewAdapter(this)
    }
}</span></pre>
Its all done like this you can create simple list view using kotlin in android.

<img src="http://thoughtnerds.com/wp-content/uploads/2018/02/Screenshot-54-169x300.png" alt="" width="235" height="417" class="alignnone wp-image-466" />

Download full source code From<a href="https://github.com/gokul42252/KotlinListview"> Github</a>


