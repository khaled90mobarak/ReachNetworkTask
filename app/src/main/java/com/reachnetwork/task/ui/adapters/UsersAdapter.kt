package com.reachnetwork.task.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reachnetwork.task.R
import com.reachnetwork.task.databinding.OffersItemBinding
import com.reachnetwork.task.databinding.UsersItemBinding
import com.reachnetwork.task.models.offers.OffersResponse
import com.reachnetwork.task.models.users.UsersResponse
import java.lang.StringBuilder

class UsersAdapter: ListAdapter<UsersResponse, UsersAdapter.UsersViewHolder>(DiffCallback()) {


    companion object{var listPosition = 0}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.UsersViewHolder {
        val binding = UsersItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersAdapter.UsersViewHolder, position: Int) {
        val currentItem =getItem(position)
        holder.bind(currentItem)
        listPosition = position
    }


    inner class UsersViewHolder(private val binding: UsersItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(usersResponse: UsersResponse){
            binding.apply {
                tvName.text = usersResponse.data[listPosition].name
                var stringUsers = ""
                for (i in usersResponse.data[listPosition].users.data){
                    stringUsers += i.username + "\n"
                }
                tvUsers.text = stringUsers
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<UsersResponse>(){
        override fun areItemsTheSame(oldItem: UsersResponse, newItem: UsersResponse): Boolean =
            oldItem.data[listPosition].id == newItem.data[listPosition].id

        override fun areContentsTheSame(oldItem: UsersResponse, newItem: UsersResponse): Boolean =
            oldItem == newItem
    }
}