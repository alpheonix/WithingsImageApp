package com.example.withingstest.data.api

import android.util.Log
import android.widget.Toast
import com.example.withingstest.data.dto.ImageResponseDTO
import com.example.withingstest.data.model.Photo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response





object APIProvider {
    private var service: APIService

    init {
        service = Retrofit.Builder().baseUrl("https://pixabay.com/api/").client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .addInterceptor {
                val request = it.request()
                val url = request.url
                val builder = url.newBuilder()
                val newUrl = builder.build()
                val newRequest = request.newBuilder().url(newUrl).build()
                it.proceed(newRequest)
            }.build()
    }

    fun getImages(search:String ,listner:Listener<List<Photo>>){
        Log.d("tags","tags")
        service.getPhotos(search).enqueue(object :Callback<ImageResponseDTO> {
            override fun onResponse(
                call: Call<ImageResponseDTO>,
                response: Response<ImageResponseDTO>
            ) {
                response.body()?.let { photoResponseDTO ->
                    val photos = PhotosResponseMapper().map(photoResponseDTO)
                    listner.onSuccess(photos)
                }
            }

            override fun onFailure(call: Call<ImageResponseDTO>, t: Throwable) {
                listner.onError(t)

            }

        })
    }

}
interface Listener<T> {
    fun onError(t: Throwable)
    fun onSuccess(track: List<Photo>)
}