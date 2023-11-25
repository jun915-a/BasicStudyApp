package com.example.basicstudyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.basicstudyapp.R

class MenuButtonAdapter(
    private val items: List<ButtonPattern>,
    private val context: Context,
    private val onItemClick: (ButtonPattern) -> Unit
) :
    RecyclerView.Adapter<MenuButtonAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_button, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.button.setOnClickListener {
            onItemClick(items[position])
        }
        when (items[position]) {
            ButtonPattern.BACK -> {
                holder.button.text = context.getText(R.string.back_button_text)
            }

            ButtonPattern.WEB -> {
                holder.button.text = context.getText(R.string.web_view_button)
            }

            ButtonPattern.BROWSE -> {
                holder.button.text = context.getText(R.string.browse_button)
            }

            ButtonPattern.PHOTO -> {
                holder.button.text = context.getText(R.string.photo_button)
            }

            ButtonPattern.MAP -> {
                holder.button.text = context.getText(R.string.map_button)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

enum class ButtonPattern {
    BACK, WEB, BROWSE, PHOTO, MAP
}
