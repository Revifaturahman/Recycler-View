package com.example.recycle_view.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val nama: String,
    val desk: String,
    val foto: Int
): Parcelable
