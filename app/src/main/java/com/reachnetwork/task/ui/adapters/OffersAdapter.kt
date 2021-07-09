package com.reachnetwork.task.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reachnetwork.task.R
import com.reachnetwork.task.databinding.OffersItemBinding
import com.reachnetwork.task.models.offers.OffersResponse

class OffersAdapter: ListAdapter<OffersResponse, OffersAdapter.OffersViewHolder>(DiffCallback()) {


    companion object{var listPosition = 0}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersAdapter.OffersViewHolder {
        val binding = OffersItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return OffersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OffersAdapter.OffersViewHolder, position: Int) {
        val currentItem =getItem(position)
        holder.bind(currentItem)
        listPosition = position
    }


    inner class OffersViewHolder(private val binding: OffersItemBinding) : RecyclerView.ViewHolder(binding.root){

        init {
            binding.apply {
                root.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION){
                        val task = getItem(position)
//                        listener.onItemClick(task)
                    }
                }
            }
        }
        fun bind(offersResponse: OffersResponse){
            binding.apply {
                Glide.with(ivArticleImage).load(
                    offersResponse.data.offers.data[listPosition].cover_image
                ).into(ivArticleImage)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<OffersResponse>(){
        override fun areItemsTheSame(oldItem: OffersResponse, newItem: OffersResponse): Boolean =

            oldItem.data.offers.data[listPosition].id == newItem.data.offers.data[listPosition].id

        override fun areContentsTheSame(oldItem: OffersResponse, newItem: OffersResponse): Boolean =
            oldItem == newItem
    }
}