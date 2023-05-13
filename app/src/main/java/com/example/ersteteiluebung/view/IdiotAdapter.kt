package com.example.ersteteiluebung.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ersteteiluebung.R
import com.example.ersteteiluebung.model.IdiotNames

class IdiotAdapter(val mList: ArrayList<IdiotNames>) :
    RecyclerView.Adapter<IdiotAdapter.ViewHolder>() {

    fun updateRec(newIdiotsList: List<IdiotNames>) {
        mList.clear()
        mList.addAll(newIdiotsList)
        notifyDataSetChanged()

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemViewx = view.findViewById<TextView>(R.id.name_item_row)
        fun binding(idiotNameObj: IdiotNames) {
            itemViewx.text = idiotNameObj.fullname


        }

    }

    override fun onCreateViewHolder(view: ViewGroup, viewType: Int):
            ViewHolder = ViewHolder(
        LayoutInflater.from(view.context)
            .inflate(R.layout.item_row, view, false)
    )

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(mList.get(position))
    }
}