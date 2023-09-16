package com.stack.open_work_mobile.activities.lay_home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stack.open_work_mobile.R


class ProjectCardHomeAdapter(private val projectCardHomeList: ArrayList<CardProjectHome>) :
    RecyclerView.Adapter<ProjectCardHomeAdapter.MyViewHolderCardProject>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderCardProject {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_project_home_open, parent, false)
        return MyViewHolderCardProject(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolderCardProject, position: Int) {
        val currentItem = projectCardHomeList[position]

        holder.companyName.text = currentItem.companyName
        holder.avaliationCompany.text = currentItem.avaliationCompany.toString()
        holder.describe.text = currentItem.describe
        holder.dateCreated.text = currentItem.dateCreated
        holder.dataEnd.text = currentItem.dateEnd
        holder.qtdDev.text = currentItem.qtdDev.toString()
        holder.value.text = currentItem.value.toString()
    }

    override fun getItemCount(): Int {
        return projectCardHomeList.size
    }

    class MyViewHolderCardProject(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val companyName: TextView = itemView.findViewById<TextView>(R.id.name_company)
        val avaliationCompany: TextView = itemView.findViewById<TextView>(R.id.avaliation_number_id)
        val describe: TextView = itemView.findViewById<TextView>(R.id.description_project)
        val dateCreated: TextView = itemView.findViewById<TextView>(R.id.data_created)
        val dataEnd: TextView = itemView.findViewById<TextView>(R.id.data_end)
        val qtdDev: TextView = itemView.findViewById<TextView>(R.id.dev_number_id)
        val value: TextView = itemView.findViewById<TextView>(R.id.value_id)

    }
}