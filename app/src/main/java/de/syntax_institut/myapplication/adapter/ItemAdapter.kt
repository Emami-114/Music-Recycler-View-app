package de.syntax_institut.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.myapplication.R
import de.syntax_institut.myapplication.adapter.model.Music

class ItemAdapter(private val context: Context, private val dataSet: List<Music>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imageView:ImageView = itemView.findViewById(R.id.image_view_item)
        val textViewTitle:TextView = itemView.findViewById(R.id.tv_text_view_title)
        val subTextView:TextView = itemView.findViewById(R.id.tv_text_view_subtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_horizontal,parent,false)

        return ItemViewHolder(adapterLayout)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        holder.imageView.setImageResource(item.image)
        holder.textViewTitle.text = context.resources.getText(item.title)
        holder.subTextView.text = context.resources.getText(item.subTitle)

    }


    override fun getItemCount(): Int {
        return dataSet.count()
    }
}
