package com.fudex.project2.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fudex.project2.R
import com.fudex.project2.databinding.ItemLayoutBinding
import com.fudex.project2.domain.models.DataModel

class HomeAdapter(
    private val data: MutableList<DataModel>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<HomeAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val view: ItemLayoutBinding) :
        RecyclerView.ViewHolder(view.root) {

        init {
            view.root.setOnClickListener {
                listener.onClick(data[adapterPosition])
            }
        }

        fun bind(item: DataModel) = with(view) {
            titleTV.text = item.name
            dateTV.text = item.date
            if (item.isPotentiallyHazardousAsteroid) {
                emojiIV.setImageResource(R.drawable.ic_status_potentially_hazardous)
            } else {
                emojiIV.setImageResource(R.drawable.ic_status_normal)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    interface OnItemClickListener {
        fun onClick(item: DataModel)
    }
}