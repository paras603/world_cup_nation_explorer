package com.mastercoding.worldcup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. adapter view : List View
        var listView  = findViewById<ListView>(R.id.listview)

        //2. adapter
        var adapter = MyAdapter(
            this,
            generateData()
        )

        listView?.adapter = adapter
        adapter?.notifyDataSetChanged()

    }

    //3. data source
    fun generateData(): ArrayList<CountryModel>{
        var countriesList = ArrayList<CountryModel>()

        var country1 : CountryModel = CountryModel(
            "Brazil",
            "5",
            R.drawable.brazil
        )

        var country2 : CountryModel = CountryModel(
            "France",
            "2",
            R.drawable.france
        )

        var country3 : CountryModel = CountryModel(
            "Germany",
            "3",
            R.drawable.germany
        )

        var country4 : CountryModel = CountryModel(
            "Saudi Arabia",
            "0",
            R.drawable.saudiarabia
        )

        var country5 : CountryModel = CountryModel(
            "Spain",
            "1",
            R.drawable.spain
        )

        var country6 : CountryModel = CountryModel(
            "United Kingdom",
            "0",
            R.drawable.unitedkingdom
        )

        var country7 : CountryModel = CountryModel(
            "United States",
            "0",
            R.drawable.unitedstates
        )

        countriesList.add(country1)
        countriesList.add(country2)
        countriesList.add(country3)
        countriesList.add(country4)
        countriesList.add(country5)
        countriesList.add(country6)
        countriesList.add(country7)

        return countriesList
    }

}