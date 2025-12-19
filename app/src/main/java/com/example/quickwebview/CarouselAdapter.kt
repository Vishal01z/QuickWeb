package com.example.quickwebview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickwebview.databinding.ItemCarouselBinding

class CarouselAdapter(
    private val images: List<Int>
) : RecyclerView.Adapter<CarouselAdapter.CarouselVH>() {

    class CarouselVH(val binding: ItemCarouselBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselVH {
        val binding = ItemCarouselBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CarouselVH(binding)
    }

    override fun onBindViewHolder(holder: CarouselVH, position: Int) {
        holder.binding.imageView.setImageResource(images[position])
    }

    override fun getItemCount(): Int = images.size
}
