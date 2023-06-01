package com.example.hugoworumi_20411099_uts_mc

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class Home : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENTS"
    }

    private var gridLayoutManager : GridLayoutManager? = null
    private var wisatalist = mutableListOf<itemimg>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.home_activity)

        wisatalist = ArrayList()

        val keluar = findViewById<TextView>(R.id.logout)

        keluar.setOnClickListener {
            logout()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.v_recyclerhome)
        gridLayoutManager = GridLayoutManager(applicationContext, 2,
            LinearLayoutManager.VERTICAL,false)

        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView.adapter = MyAdapter(this, wisatalist){
            val intent = Intent(this, Content::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

        prepareWisataListData()

    }

    private fun prepareWisataListData(){
        var wisata = itemimg(
            R.drawable.komodo,
            "Pantai pink komodo",
            "Pulau komodo",
            "Pulau Komodo masuk dalam kawasan Taman Nasional Komodo bersama pulau-pulau lain di sekitar Kepulauan Nusa Tenggara. Pada tahun 1986, UNESCO menetapkan tempat wisata di Indonesia ini sebagai salah satu situs warisan dunia. Pulau ini dianggap sebagai habitat binatang komodo yang wajib dilindungi. Salah satu penghargaan tertinggi yang berhasil diraih adalah berhasil masuk dalam jajaran tujuh kejaiban alam di dunia atau yang lebih dikenal dengan New Seven Wonders of Nature pada tahun 2011",
        )
        wisatalist.add(wisata)

        wisata = itemimg(
            R.drawable.lombok,
            "Gili lombok",
            "Lombok",
            "Trio Gili merupakan tiga pulau cantik yang ada di Lombok. Ketiga pulau tersebut antara lain Gili Trawangan, Gili Meno dan Gili Air. Ketiganya tak hanya dikenal oleh wisatawan domestik, tapi juga telah berhasil mengundang banyak wisatawan mancanegara untuk datang",
        )
        wisatalist.add(wisata)

        wisata = itemimg(
            R.drawable.sentani,
            "Danau sentani",
            "Sentani, Papua",
            "Danau Sentani disebut sebagai danau terbesar dengan di Papua. Tak mengherankan memang, karena danau ini memiliki luas sekitar 9.360 hektar dan berada di ketinggian 75 meter di atas permukaan laut. Tempat wisata terindah di Indonesia ini dihiasi dengan 21 pulau di sekitarnya yang menjadi perkampungan warga.",
        )
        wisatalist.add(wisata)

        wisata = itemimg(
            R.drawable.bali,
            "bali",
            "Bali",
            "Siapa tak mengenal Bali? Sulit untuk memilih tempat wisata apa yang paling menarik di Bali, karena hampir seluruh penjuru Bali adalah tempat wisata yang luar biasa. Bali memiliki banyak keindahan alam yang sangat indah mulai dari deretan pantainya, suasana pegunungannya sampai pura-pura sakralnya. ",
        )
        wisatalist.add(wisata)

        wisata = itemimg(
            R.drawable.bunaken,
            "Taman Laut Bunaken",
            "Bunaken",
            "Taman Laut Bunaken menjadi salah satu tempat wisata terindah di Indonesia yang lagi-lagi ditetapkan UNESCO sebagai situs warisan dunia, tepatnya pada tahun 2005. Hal ini dikarenakan kekayaan dan keragaman biota lautnya yang luar biasa mulai dari terumbu karang, rumput laut sampai spesies ikan yang ada.",
        )
        wisatalist.add(wisata)

        wisata = itemimg(
            R.drawable.toraja,
            "Tanah toraja",
            "Toraja",
            "Tanah Toraja memiliki keindahan alam yang luar biasa mulai dari deretan pegunungan dan hijau perbukitannya. Selain kaya akan alamnya, tempat wisata d Indonesia ini juga kaya akan budaya leluhur yang masih dijaga sampai saat ini. Di sini, ada banyak tradisi kuno yang masih dipertahankan, salah satunya adalah Rambu Solo’.",
        )
        wisatalist.add(wisata)
    }

    private fun logout() {
        FirebaseAuth.getInstance().signOut()
        navigateToLoginPage()
    }

    private fun navigateToLoginPage() {
        val intent = Intent(this, Masuk::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }


    }