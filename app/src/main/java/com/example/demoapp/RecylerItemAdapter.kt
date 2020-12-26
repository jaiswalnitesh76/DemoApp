package com.example.demoapp

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class RecylerItemAdapter(val useList:ArrayList<User>): RecyclerView.Adapter<RecylerItemAdapter.ViewHolder>() {
    var lastCheckedPosition: Int = 0

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {


        val  user : User = useList[p1]
        p0?.item_check?.text= user.name
        p0.item_checkbox.isChecked = user.is_checked

        p0.item_checkbox.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked){
                useList!![lastCheckedPosition].is_checked = false
                lastCheckedPosition = p1
            }
            useList!![p1].is_checked = isChecked
           // notifyDataSetChanged()
        }
    }

    class  ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


        val item_check : TextView = itemView.findViewById(R.id.itemDate)
        val item_checkbox :CheckBox= itemView.findViewById(R.id.checkBox)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return useList.size
    }


}