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