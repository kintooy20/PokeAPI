package com.gimenez.kent.pokeapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_row.view.*

/**
 * Created by Kent on 3/7/2018.
 */


class Adapter (val pokemons: ArrayList<Pokedata>?) : RecyclerView.Adapter<Adapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder =
           CustomViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.pokemon_row, parent, false))


    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {



        val pokemon = pokemons!![position]
        holder?.tvName?.text = pokemon.name
        Picasso.with(holder?.itemView?.context).load(pokemon.imageUrl).into(holder?.ivImage)

    }

    override fun getItemCount(): Int = pokemons!!.size


    class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val ivImage = v.imageView
        val tvName = v.tvPokemonName
    }

}