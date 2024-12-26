package com.example.studentsapplication.models

class Model private constructor() {

    val students: MutableList<Student> = ArrayList()
    companion object {
        val shared = Model()
    }

    init {
        for (i in 0..20) {
            val student = Student(
                name = "Kim Kurikan $i",
                id = i.toString(),
                avatarUrl = "",
                isChecked = false
            )

            students.add(student)
        }
    }
}