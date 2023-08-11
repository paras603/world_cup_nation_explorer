package com.mastercoding.worldcup

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MyAdapter(private var activity: Activity, private var items: ArrayList<CountryModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): CountryModel {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        if (convertView == null){

            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            view = inflater.inflate(R.layout.list_item_layout, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var countries = items[position]
        viewHolder.txtName?.text = countries.name
        viewHolder.txtCupWin?.text  = countries.cupWins
        viewHolder.flagImg?.setImageResource(countries.flag_img)

        view?.setOnClickListener(){
            Toast.makeText(activity,
                "You Choose: ${countries.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view as View
    }

    private class ViewHolder(row: View?){
        var txtName: TextView? = null
        var txtCupWin: TextView? = null
        var flagImg: ImageView? = null

        init {
            this.txtName = row?.findViewById(R.id.countryName)
            this.txtCupWin = row?.findViewById(R.id.cupWinsTxt)
            this.flagImg = row?.findViewById(R.id.imageview)
        }

    }

}