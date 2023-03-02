package de.syntax_institut.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.myapplication.R
import de.syntax_institut.myapplication.adapter.model.Genre
import de.syntax_institut.myapplication.adapter.model.Music

class ListAdapter(private val context: Context, private val dataSet: List<Genre>) :
    RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val tetxView:TextView = itemView.findViewById(R.id.textView_item)
        val recycleView:RecyclerView = itemView.findViewById(R.id.recycler_view_horizontal)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list,parent,false)

        return ItemViewHolder(adapterLayout)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val genre = dataSet[position]
        holder.tetxView.text = genre.name
        holder.recycleView.adapter = ItemAdapter(context,genre.list)
    }


    override fun getItemCount(): Int {
        return dataSet.count()
    }
}
