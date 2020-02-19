package com.example.submissionfootballleagueliga.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Liga(val logo: String, val nameLeague : String, val description:String) : Parcelable