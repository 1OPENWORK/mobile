package com.stack.open_work_mobile.lay_my_projects

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.stack.open_work_mobile.R

class ProjectProgressCardAdapter(private val projectProcessList: ArrayList<ProjectProgressCard>) :
    RecyclerView.Adapter<ProjectProgressCardAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProjectProgressCardAdapter.MyViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_project_progress, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProjectProgressCardAdapter.MyViewHolder, position: Int) {
        val currentItem = projectProcessList[position]
        holder.title.text = currentItem.title
        holder.subTitle.text = currentItem.subTitle
        holder.describe.text = currentItem.describe

    }

    override fun getItemCount(): Int {
        return projectProcessList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //        val image: ShapeableImageView = itemView.findViewById(R.id.profileImageView)
        val title: TextView = itemView.findViewById(R.id.title_project_process)
        val subTitle: TextView = itemView.findViewById(R.id.sub_title_process)
        val describe: TextView = itemView.findViewById(R.id.describe_porcess)

    }
}