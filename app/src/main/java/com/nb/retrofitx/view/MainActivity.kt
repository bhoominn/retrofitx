package com.nb.retrofitx.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nb.retrofitx.R
import com.nb.retrofitx.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //region Variables
    lateinit var viewModel: ListViewModel
    var countryListAdapter = CountryListAdapter(this)
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        observeData()
    }

    private fun init() {
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recyclerViewCountries.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = countryListAdapter
        }
        countryListAdapter.onClick = { pos, view ->

        }

        swiperefreshlayout.setOnRefreshListener {
            viewModel.refresh()
        }
    }

    private fun observeData() {
        viewModel.countries.observe(this, Observer { countries ->
            countries?.let {
                countryListAdapter.updateCountries(it)
            }
        })

        viewModel.loading.observe(this, Observer { loading ->
            if (loading) {
                if (swiperefreshlayout.isRefreshing) swiperefreshlayout.isRefreshing = false
                recyclerViewCountries.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            } else {
                recyclerViewCountries.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        })
    }
}