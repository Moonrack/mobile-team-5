package com.android.gtv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.android.gtv.databinding.ActivityDetailedBinding

class DetailedActivity : FragmentActivity() {

    private lateinit var binding: ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val intent = this.intent
        if (intent != null){
            val name = intent.getStringExtra("name")
            val nid = intent.getStringExtra("nid")
            val matkul = intent.getStringExtra("matkul")
            val jadwal = intent.getIntExtra("jadwal", R.string.jadwaldosen1)
            val image = intent.getIntExtra("image", R.drawable.a)

            binding.detailName.text = name
            binding.detailNid.text = nid
            binding.detailMk.text = matkul
            binding.detailJdwl.setText(jadwal)
            binding.detailImage.setImageResource(image)

        }
    }
}