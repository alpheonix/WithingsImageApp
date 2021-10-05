package com.axt.esgi.esgi4a2020.recycler

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.withingstest.R
import com.example.withingstest.data.model.Photo

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    lateinit var slectedItems: ArrayList<Photo>


    var data: ArrayList<Photo> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var listener: ((Photo) -> Unit)? = null

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }


    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = data[position]


        with(holder) {
            Glide.with(itemView)
                .load(photo.previewURL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(thumbnailImv)

            itemView.setOnClickListener {listener?.invoke(photo)}



        }
    }


    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var thumbnailImv: ImageView = itemView.findViewById(R.id.item_photo_imv)

    }
}