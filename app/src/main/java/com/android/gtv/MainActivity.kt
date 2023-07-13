package com.android.gtv

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.android.gtv.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nameList = arrayOf("Aswan S. Sunge, S.E, M.Kom", "Donny Maulana, S.Kom., M.M.S.I")
        val nidList = arrayOf("0426018003", "0408107502")
        val matkulList = arrayOf("PEMOGRAMAN WEB 2", "PEMROGRAMAN MOBILE")

        val imageList = intArrayOf(
            R.drawable.a,
            R.drawable.b
        )

        val jadwalList = intArrayOf(
            R.string.jadwaldosen1,
            R.string.jadwaldosen2
        )
        for (i in imageList.indices){
            listData = ListData(nameList[i],nidList[i], matkulList[i], jadwalList[i], imageList[i])
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true

        binding.listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@MainActivity, DetailedActivity::class.java)
            intent.putExtra("name", nameList[i])
            intent.putExtra("nid", nidList[i])
            intent.putExtra("matkul", matkulList[i])
            intent.putExtra("jadwal", jadwalList[i])
            intent.putExtra("image", imageList[i])
            startActivity(intent)

        }


    }
}