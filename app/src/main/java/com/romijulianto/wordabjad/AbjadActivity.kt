package com.romijulianto.wordabjad

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AbjadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abjad)

        /* create list data */
        /*  val abjads = listOf<String>(
            "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "O", "P", "Q", "R", "S",
            "T", "U", "V", "W", "X", "Y", "Z",
        )*/

    }

    /* method outsite onCreate to switch Linear to Grid */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    var default = true
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        default=!default
        if (default)
        {
            item.setIcon(R.drawable.ic_list_view)
            val abjads = arrayListOf<String>()

            for (item in 'A'..'Z'){
                abjads.add(item.toString())
            }

            /* if your application error, show Log.e */
            Log.e("AbjadActivity", "size ${abjads.size}")
            Log.e("AbjadActivity", abjads[1])

            abjads.forEach { abjad ->
                Log.e("AbjadActivity", abjad)
            }

            val abjadAdapter = AbjadAdapter( abjads )
            findViewById<RecyclerView?>(R.id.recyclerview_abjad).apply {
                layoutManager = LinearLayoutManager( applicationContext )
                adapter = abjadAdapter
            }
        } else {
            item.setIcon(R.drawable.ic_grid_view)
            val abjads = arrayListOf<String>()

            for (item in 'A'..'Z'){
                abjads.add(item.toString())
            }

            /* if your application error, show Log.e */
            Log.e("AbjadActivity", "size ${abjads.size}")
            Log.e("AbjadActivity", abjads[1])

            abjads.forEach { abjad ->
                Log.e("AbjadActivity", abjad)
            }

            val abjadAdapter = AbjadAdapter( abjads )
            findViewById<RecyclerView?>(R.id.recyclerview_abjad).apply {
                layoutManager = GridLayoutManager( applicationContext, 3 )
                adapter = abjadAdapter
            }
        }
        return super.onOptionsItemSelected(item)
    }
}