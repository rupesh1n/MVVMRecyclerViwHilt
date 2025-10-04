package com.rupesh.mvvmrecyclerviwhilt.data.dto


import com.google.gson.annotations.SerializedName

data class WandDto(
    @SerializedName("core")
    val core: String,
    @SerializedName("length")
    val length: Double,
    @SerializedName("wood")
    val wood: String
)