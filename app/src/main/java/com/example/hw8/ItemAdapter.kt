package com.example.hw8

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
// Recycler view requires a custom adapter
class ItemAdapter(private val itemAdapterListener: ItemAdapterListener) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    interface  ItemAdapterListener{
        fun click(position: Int)
    }



    class ViewHolder(itemView:View,private val itemAdapterListener: ItemAdapterListener) : RecyclerView.ViewHolder(itemView){//View holder takes the item layout
    init {
        itemView.setOnClickListener {
            val position = adapterPosition
            itemAdapterListener.click(position)
        }
    }
        private val textViewTaskName:TextView = itemView.findViewById(R.id.taskName)
        private val textViewDescription:TextView = itemView.findViewById(R.id.taskDec)
        private val textViewPriority:TextView = itemView.findViewById(R.id.taskPriority)

        fun update(item:Item){
            textViewTaskName.text = item.name.toString()
            textViewDescription.text = item.description.toString()
            textViewPriority.text = item.priority.toString()

            if (item.priority == 1){
                textViewTaskName.setBackgroundColor(Color.RED)
                textViewDescription.setBackgroundColor(Color.RED)
                textViewPriority.setBackgroundColor(Color.RED)
            }
            if (item.priority == 2){
                textViewTaskName.setBackgroundColor(Color.rgb(255, 165, 0))
                textViewDescription.setBackgroundColor(Color.rgb(255, 165, 0))
                textViewPriority.setBackgroundColor(Color.rgb(255, 165, 0))
            }
            if (item.priority == 3){
                textViewTaskName.setBackgroundColor(Color.YELLOW)
                textViewDescription.setBackgroundColor(Color.YELLOW)
                textViewPriority.setBackgroundColor(Color.YELLOW)
            }
            if (item.priority == 4){
                textViewTaskName.setBackgroundColor(Color.GREEN)
                textViewDescription.setBackgroundColor(Color.GREEN)
                textViewPriority.setBackgroundColor(Color.GREEN)
            }
            if (item.priority == 5){
                textViewTaskName.setBackgroundColor(Color.BLUE)
                textViewDescription.setBackgroundColor(Color.BLUE)
                textViewPriority.setBackgroundColor(Color.BLUE)
            }


            /*
            textViewRed.setBackgroundColor(Color.rgb(item.red?: 0,0,0))
            textViewGreen.setBackgroundColor(Color.rgb(0,item.green?: 0,0))
            textViewBlue.setBackgroundColor(Color.rgb( 0,0,item.blue?: 0))

             */
        }
    }



    // you need to implement these 3 functions

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view,itemAdapterListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = Model.items[position]
        holder.update(item)
    }
    override fun getItemCount(): Int {
        return Model.items.size
    }

}
