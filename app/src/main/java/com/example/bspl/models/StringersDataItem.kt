package com.example.bspl.models


data class StringersDataItem(
    val Address: String?= "",
    val Age: Int?= null,
    val CloseTiming: String ?= null,
    val EmailAddress: String ?= "",
    val Lname: String?= "",
    val Name: String ?= "",
    val Password: String ?= null,
    val PhoneNumber: String?= null,
    val StartTiming: String?= "",
    val StringerID: Int ?= null
): java.io.Serializable{
    fun fullName() = "$Name $Lname"
}