package com.pembelajar.model

import com.google.gson.annotations.SerializedName

data class Local(
    @SerializedName("intro") var keyOne: String? = null,
    @SerializedName("say one") var keyTwo: String? = null
)