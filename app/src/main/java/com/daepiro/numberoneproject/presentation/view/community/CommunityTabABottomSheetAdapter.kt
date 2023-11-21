package com.daepiro.numberoneproject.presentation.view.community

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daepiro.numberoneproject.R
import com.daepiro.numberoneproject.data.model.ConversationModel

class CommunityTabABottomSheetAdapter(
    private var items:List<ConversationModel>,
    private val listener:onItemClickListener
):RecyclerView.Adapter<CommunityTabABottomSheetAdapter.ViewHolder>() {
    interface onItemClickListener{
        fun onItemClickListener()
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val info : TextView = itemView.findViewById(R.id.user_info)
        val content:TextView = itemView.findViewById(R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_community_commentlist,parent,false)
        return CommunityTabABottomSheetAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(position < items.size){
            val item = items[position]
            holder.info.text = item.info
            holder.content.text = item.content
        }
    }

    fun updateList(newData:List<ConversationModel>){
        items = newData
        notifyDataSetChanged()
    }
}