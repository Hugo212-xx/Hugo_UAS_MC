package com.example.hugoworumi_20411099_uts_mc

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class itemimg (
    var img : Int,
    var name: String,
    var loc : String,
    var dec : String
):Parcelable