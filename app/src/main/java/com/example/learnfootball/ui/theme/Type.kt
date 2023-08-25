package com.example.learnfootball.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.learnfootball.R


val BlackOpsOne = FontFamily(
    Font(R.font.blackopsone_regular)
)

val Poppins = FontFamily(
    Font(R.font.poppins_regular)
)

val PoppinsBold = FontFamily(
    Font(R.font.poppins_bold)
)




val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = BlackOpsOne,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = PoppinsBold,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    )
)