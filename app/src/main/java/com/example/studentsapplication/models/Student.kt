package com.example.studentsapplication.models

data class Student(
    val name: String,
    val id: String,
    val avatarUrl: String,
    var isChecked: Boolean
)