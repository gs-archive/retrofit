package com.gulsah.retrofitkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gulsah.retrofitkullanimi.entity.CRUDCevap
import com.gulsah.retrofitkullanimi.entity.KisilerCevap
import com.gulsah.retrofitkullanimi.retrofit.ApiUtils
import com.gulsah.retrofitkullanimi.retrofit.KisilerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var kdaoi: KisilerDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kdaoi = ApiUtils.getKisilerDaoInterface()
        arama()
    }

    fun tumKisileriGoster() {
        kdaoi.tumKisiler().enqueue(object : Callback<KisilerCevap> {
            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
                val kisilerListesi = response.body()!!.kisiler
                for (k in kisilerListesi) {
                    Log.e("***********", "***********")
                    Log.e("kişi id", k.kisi_id.toString())
                    Log.e("kişi adi", k.kisi_adi)
                    Log.e("kişi tel", k.kisi_tel)
                }
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun kayit() {
        kdaoi.kisiEkle("gulsah", "424242").enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                Log.e("response", response.body()!!.success.toString())
                Log.e("mesaj", response.body()!!.message)
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })
    }

    fun sil() {
        kdaoi.kisiSil(1328).enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                Log.e("response", response.body()!!.success.toString())
                Log.e("mesaj", response.body()!!.message)
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })
    }

    fun guncelle() {
        kdaoi.kisiGuncelle(1329, "gulsah", "3245698").enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                Log.e("response", response.body()!!.success.toString())
                Log.e("mesaj", response.body()!!.message)
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })
    }

    fun arama() {
        kdaoi.arama("es").enqueue(object : Callback<KisilerCevap> {
            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
                val kisilerListesi = response.body()!!.kisiler
                for (k in kisilerListesi) {
                    Log.e("***********", "***********")
                    Log.e("kişi id", k.kisi_id.toString())
                    Log.e("kişi adi", k.kisi_adi)
                    Log.e("kişi tel", k.kisi_tel)
                }
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}