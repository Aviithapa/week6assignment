package com.example.assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment.R
import com.example.assignment.model.student
import de.hdodenhof.circleimageview.CircleImageView

class adapter(
        private val data: List<student>
) :RecyclerView.Adapter<adapter.HomeViewholder>(){

    private var listUser: MutableList<student> = data as MutableList<student>

    inner class HomeViewholder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(student: student, index: Int) {
            val image = view.findViewById<ImageView>(R.id.logo)
            val name = view.findViewById<TextView>(R.id.brand_name)
            val age = view.findViewById<TextView>(R.id.age)
            val address = view.findViewById<TextView>(R.id.address)
            val gender = view.findViewById<TextView>(R.id.Gender)
            val imageView = view.findViewById<ImageButton>(R.id.delete_img)
            name.text = student.name
            age.text = student.age.toString()
            address.text = student.address
            Glide.with(view.context)
                    .load(student.logo)
                    .into(image)
            gender.text= student.gender
            imageView.setOnClickListener {deleteItem(index)}
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewholder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_student_post,parent,false)
        return HomeViewholder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: HomeViewholder, position: Int) {
        holder.bind(listUser[position], position)
    }


    fun deleteItem(index: Int){
        listUser.removeAt(index)
        notifyDataSetChanged()
    }
}