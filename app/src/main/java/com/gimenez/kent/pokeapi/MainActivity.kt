package com.gimenez.kent.pokeapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.apache.commons.lang3.StringUtils
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL


class MainActivity : AppCompatActivity() {

    private val url = "https://pokeapi.co/api/v2/pokemon/"
    private var Pokemons: ArrayList<Pokedata>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvHeader.text= "Your pokemon is coming."
        Pokemons = ArrayList()
        recyclerview.layoutManager = LinearLayoutManager(this)


        doAsync {
            progressbar.visibility = View.VISIBLE

            for (i in 1..20){
           val resultJson = URL (url+i).readText();
                val jsonObject = JSONObject (resultJson)
                val name = StringUtils.capitalize(jsonObject.getString("name"))
                val imageUrl =jsonObject.getJSONObject("sprites").getString("front_default")

            
            uiThread {
              recyclerview.adapter = Adapter(Pokemons)
                Pokemons?.add(Pokedata(name,imageUrl))
                tvHeader.text= "Okay Nice! You have $i Pokemon(s)"

            }



            }
            progressbar.visibility = View.INVISIBLE
            }
        }

    }

