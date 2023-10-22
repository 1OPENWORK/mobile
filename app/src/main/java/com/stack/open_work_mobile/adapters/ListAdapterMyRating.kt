package com.stack.open_work_mobile.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.stack.open_work_mobile.R
import com.stack.open_work_mobile.models.MyRating
import com.stack.open_work_mobile.models.RatingCompanies
import org.w3c.dom.Text

class ListAdapterMyRating(
    private val ratingCompanies: ArrayList<RatingCompanies>
) : RecyclerView.Adapter<ListAdapterMyRating.MyViewHolderListRatingCompany>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolderListRatingCompany {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_my_rating_company, parent, false)
        return MyViewHolderListRatingCompany(itemView)
    }

    override fun getItemCount(): Int {
        return ratingCompanies.size
    }

    override fun onBindViewHolder(holder: MyViewHolderListRatingCompany, position: Int) {
        val currentItem = ratingCompanies[position]

        holder.name.text = currentItem.myAvaliations[position].name
        holder.description.text = currentItem.myAvaliations[position].description
        holder.timeExpected.text = currentItem.myAvaliations[position].timeExpected.toString()
        holder.myGrade.text = currentItem.myAvaliations[position].grade.toString()
        holder.rating.rating = currentItem.myAvaliations[position].grade.toFloat()
        Glide.with(holder.itemView)
            .load(currentItem.myAvaliations[position].image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .override(100, 100)
            .into(holder.logo)
    }

    class MyViewHolderListRatingCompany(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById<TextView>(R.id.tv_nome_company)
        val description: TextView = itemView.findViewById<TextView>(R.id.tv_description)
        val timeExpected: TextView = itemView.findViewById<TextView>(R.id.tv_data)
        val myGrade: TextView = itemView.findViewById<TextView>(R.id.tv_stars)
        val logo: ImageView = itemView.findViewById(R.id.logoempresa)
        val rating: RatingBar = itemView.findViewById<RatingBar>(R.id.rb_starts)
    }
}



