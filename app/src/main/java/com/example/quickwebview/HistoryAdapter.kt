package com.example.quickwebview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quickwebview.databinding.ItemHistoryBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HistoryAdapter(
    private val onItemClick: (String) -> Unit
) : ListAdapter<UrlHistoryEntity, HistoryAdapter.VH>(DiffCallback()) {

    class VH(val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemHistoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = getItem(position)

        holder.binding.tvUrl.text = item.url
        holder.binding.tvTime.text = formatTimestamp(item.timestamp)

        holder.binding.root.setOnClickListener {
            onItemClick(item.url)
        }
    }

    private fun formatTimestamp(timestamp: Long): String {
        val sdf = SimpleDateFormat(
            "dd MMM yyyy, hh:mm a",
            Locale.getDefault()
        )
        return sdf.format(Date(timestamp))
    }

    class DiffCallback : DiffUtil.ItemCallback<UrlHistoryEntity>() {
        override fun areItemsTheSame(
            oldItem: UrlHistoryEntity,
            newItem: UrlHistoryEntity
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: UrlHistoryEntity,
            newItem: UrlHistoryEntity
        ): Boolean {
            return oldItem == newItem
        }
    }
}
