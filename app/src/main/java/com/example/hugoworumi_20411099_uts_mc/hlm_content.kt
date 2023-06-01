package com.example.hugoworumi_20411099_uts_mc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class hlm_content : AppCompatActivity() {

    private lateinit var laguRecyclerView: RecyclerView
    private lateinit var laguAdapter: MyAdapter
    private lateinit var listimg : ArrayList<itemimg>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content)

        //Lagu R&B
        laguRecyclerView = findViewById(R.id.fotoRV)
        listimg = ArrayList()

        listimg.add(itemimg(R.drawable.foto1))
        listimg.add(itemimg(R.drawable.foto2))
        listimg.add(itemimg(R.drawable.foto3))

        laguRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        laguRecyclerView.setHasFixedSize(true)
        laguAdapter = MyAdapter(listimg)
        laguRecyclerView.adapter = laguAdapter
    }
}