package com.nb.retrofitx.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nb.retrofitx.R
import com.nb.retrofitx.models.Country
import kotlinx.android.synthetic.main.item_country.view.*

class CountryListAdapter(var context: Context) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    var countries: ArrayList<Country> = arrayListOf()
    var onClick: ((pos: Int, view: View) -> Unit)? = null

    inner class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textItemCountry = view.textItemCountry

        fun bind(countries: Country) {
            textItemCountry.text = countries.countryName
        }

        init {
            itemView.setOnClickListener {
                onClick?.invoke(adapterPosition, view)
            }
        }
    }

    fun updateCountries(countries: ArrayList<Country>) {
        this.countries.clear()
        this.countries.addAll(countries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder = CountryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false))

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }
}