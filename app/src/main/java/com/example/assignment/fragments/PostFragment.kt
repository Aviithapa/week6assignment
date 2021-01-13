package com.example.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.assignment.R
import com.example.assignment.model.student


class PostFragment : Fragment() {

    private lateinit var et_name:EditText
    private lateinit var et_address:EditText
    private lateinit var et_age:EditText
    private lateinit var btn_post:Button
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButton: RadioButton
    var imageAddress:String?=""
    var studentdetails = ArrayList<student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_post, container, false)
        et_name=view.findViewById(R.id.et_name)
        et_address=view.findViewById(R.id.et_address)
        et_age=view.findViewById(R.id.et_age)
        btn_post=view.findViewById(R.id.btn_post)
        radioGroup=view.findViewById(R.id.radio_group)



        btn_post.setOnClickListener{
            var id: Int = radioGroup.checkedRadioButtonId
            if (id!=-1){
                radioButton = view.findViewById(id)

            }else{
                // If no radio button checked in this radio group
                Toast.makeText(context,"On button click : nothing selected",
                        Toast.LENGTH_SHORT).show()
            }
            insert()

        }
        return view
    }

    private fun insert(){
        var name=et_name.text.toString()
        var address=et_address.text.toString()
        var age=et_age.text.toString().toInt()
        var gender=radioButton.text.toString()
        if (gender=="Male"){
            imageAddress="https://png.pngtree.com/png-clipart/20190520/original/pngtree-business-male-icon-vector-png-image_4187852.jpg"
        }else if(gender=="Female"){
            imageAddress="https://lh3.googleusercontent.com/proxy/FLjx8C94T-jWo3ZosVeS-KvJBpF57TdSzJf0densjL3Uo_A73mVQEDMZw9aEda6q9FX82SJkm57aH3jxPfVbGZ5ON2yCz7p22QGrqMMeh4K00VcHZy2HJS8E"
        }else{
            imageAddress="https://www.freeiconspng.com/uploads/social-group--free-other-icons-16.png"
        }

        com.example.assignment.`object`.student.lststudent.add(student(name,age,address,gender, imageAddress!!))

        Toast.makeText(context,"Student Added",Toast.LENGTH_SHORT).show()
//        val bundle=Bundle()
//        bundle.putParcelableArrayList("studentdetails",studentdetails)
           val fragment2: Fragment = HomeFragment()
           val fragmentManager = fragmentManager
           val fragmentTransaction = fragmentManager?.beginTransaction()
//     //   fragment2.arguments=bundle
//     //   Toast.makeText(context,"$bundle",Toast.LENGTH_LONG).show()
        fragmentTransaction?.replace(R.id.frame, fragment2)
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()

    }



}