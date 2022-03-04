package com.example.retrofit_ilhamnr_15.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.retrofit_ilhamnr_15.R
import com.example.retrofit_ilhamnr_15.api.RetrofitClient
import com.example.retrofit_ilhamnr_15.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showIndonesia()

        val btnProvince = findViewById<Button>(R.id.btnProvince)
        btnProvince.setOnClickListener{
            Intent(this, ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    private fun showIndonesia() {
        RetrofitClient.instance.getIndonesia().enqueue(object :
            Callback<ArrayList<IndonesiaResponse>> {
            override fun onResponse(
                call: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {
                val indonesia:IndonesiaResponse? = response.body()?.get(0)
                val positive:String? = indonesia?.positif
                val hospitalized:String? = indonesia?.dirawat
                val recover:String? = indonesia?.sembuh
                val death:String? = indonesia?.meninggal

                val tvPositive = findViewById<TextView>(R.id.tvPositiv)
                val tvHospitalized = findViewById<TextView>(R.id.tvHospitalized)
                val tvRecover = findViewById<TextView>(R.id.tvRecover)
                val tvDeath = findViewById<TextView>(R.id.tvDeath)

                tvPositive.text = positive
                tvHospitalized.text = hospitalized
                tvRecover.text = recover
                tvDeath.text = death
            }

            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}