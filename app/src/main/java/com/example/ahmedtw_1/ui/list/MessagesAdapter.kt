package com.example.ahmedtw_1.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ahmedtw_1.databinding.ItemListBinding
import com.example.ahmedtw_1.models.Message

class MessagesAdapter(private val onItemClicked: ((Message) -> Unit)) :
    ListAdapter<Message, MessagesAdapter.UserViewHolder>(MessagesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UserViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class UserViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Message) {
            binding.message = item
            binding.root.setOnClickListener {
                onItemClicked.invoke(item)
            }
        }
    }
}

object MessagesDiffCallback : DiffUtil.ItemCallback<Message>() {
    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem.massageId == newItem.massageId
    }
}