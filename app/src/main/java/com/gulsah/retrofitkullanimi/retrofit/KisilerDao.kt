package com.gulsah.retrofitkullanimi.retrofit

import com.gulsah.retrofitkullanimi.entity.CRUDCevap
import com.gulsah.retrofitkullanimi.entity.KisilerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDao {
    @GET("kisiler/tum_kisiler.php")
    fun tumKisiler(): Call<KisilerCevap>

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded //eklenenlerde karakter düzenlemesi vs?
    fun kisiEkle(
        @Field("kisi_ad") kisi_ad: String,
        @Field("kisi_tel") kisi_tel: String
    ): Call<CRUDCevap>

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded //eklenenlerde karakter düzenlemesi vs?
    fun kisiSil(
        @Field("kisi_id") kisi_id: Int,
    ): Call<CRUDCevap>

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded //eklenenlerde karakter düzenlemesi vs?
    fun kisiGuncelle(
        @Field("kisi_id") kisi_id: Int,
        @Field("kisi_ad") kisi_ad: String,
        @Field("kisi_tel") kisi_tel: String
    ): Call<CRUDCevap>

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    fun arama(
        @Field("kisi_ad") kisi_ad: String
    ): Call<KisilerCevap>


}