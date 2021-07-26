package com.coronaapp.model.Bed_Kosong.Hospital_Detail

data class HospitalDetails_Corona_BedKosong (

    val id :String,
    val name:String,
    val address:String,
    val phone:String,
    val bedDetail : ArrayList<BedDetail_Datamodel>
        )