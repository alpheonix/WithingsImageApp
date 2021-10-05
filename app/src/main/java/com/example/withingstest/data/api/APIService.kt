package com.example.withingstest.data.api

import com.example.withingstest.data.dto.ImageResponseDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    @GET("?key=18021445-326cf5bcd3658777a9d22df6f&image_type=photo")
    fun getPhotos(@Query("q") q:String): Call<ImageResponseDTO>
}