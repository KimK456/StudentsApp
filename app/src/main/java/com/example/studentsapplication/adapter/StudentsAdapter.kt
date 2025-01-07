package com.example.studentsapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.example.studentsapplication.R
import com.example.studentsapplication.models.Student

class StudentsAdapter(private val students: List<Student>?): BaseAdapter() {

    override fun getCount(): Int = students?.size ?: 0

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long  = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflator = LayoutInflater.from(parent?.context)
//            val view = convertView ?: inflator.inflate(R.layout.student_list_row, parent, false)

        val view = convertView ?: inflator.inflate(R.layout.student_list_row, parent, false).apply {
            findViewById<CheckBox>(R.id.students_row_checkbox).apply {
                setOnClickListener {
                    (tag as? Int)?.let { tag ->
                        val student = students?.get(tag)
                        student?.isChecked = (it as? CheckBox)?.isChecked ?: false
                    }
                }
            }
        }

//            var view = convertView
//            if (convertView == null) {
//                view = inflator.inflate(R.layout.student_list_row, parent, false)
//                val studentCheckBox: CheckBox? = view?.findViewById(R.id.student_row_check_box)
//
//                studentCheckBox?.apply {
//                    setOnClickListener {
//                        (tag as? Int)?.let { tag ->
//                            val student = students?.get(tag)
//                            student?.isChecked = (it as? CheckBox)?.isChecked ?: false
//                        }
//                    }
//                }
//            }


        val student = students?.get(position)

        val nameTextView: TextView? = view?.findViewById(R.id.students_row_name_text_view)
        val idTextView: TextView? = view?.findViewById(R.id.students_row_id_text_view)
        val studentCheckBox: CheckBox? = view?.findViewById(R.id.student_row_check_box)

        nameTextView?.text = student?.name
        idTextView?.text = student?.id

        studentCheckBox?.apply {
            isChecked = student?.isChecked ?: false
            tag = position
        }

        return view!!
    }
}