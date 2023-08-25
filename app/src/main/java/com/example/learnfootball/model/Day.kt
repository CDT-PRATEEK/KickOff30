package com.example.learnfootball.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.learnfootball.R

data class Day(
    @DrawableRes val imageResourceId: Int,
    @StringRes val activity : Int ,
    @StringRes val description : Int,
    val day : Int
)





