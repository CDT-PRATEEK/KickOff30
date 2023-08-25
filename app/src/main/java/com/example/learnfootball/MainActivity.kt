package com.example.learnfootball

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnfootball.model.Day
import com.example.learnfootball.model.days
import com.example.learnfootball.ui.theme.LearnFootballTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnFootballTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FootballGuideApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FootballGuideApp() {

    Scaffold ( topBar = {AppTopBar()}){ it


        LazyColumn {

            items(days) {

                DayItem(
                    day = it,
                    modifier = Modifier.padding(10.dp)
                )


            }

        }

    }
}

@Composable
fun DayItem(day: Day,
    modifier: Modifier = Modifier
){
    var expanded by remember { mutableStateOf(false) }
    Card (modifier = Modifier.padding(8.dp)){

        Column(modifier = Modifier.animateContentSize (animationSpec =
        spring(dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMedium)
        )) {
            
            DayImage(img = day.imageResourceId)

            Spacer(modifier = Modifier
                .height(20.dp)
                .padding(end = 8.dp))

            Row( verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    ) {

                DayInfo(count = day.day, activity = day.activity )

                Spacer(modifier = Modifier.weight(1f))


                DayItemButton(expanded = expanded,
                    onClick = {expanded = !expanded},
                    modifier = Modifier.padding(top = 10.dp  ))



            }
            if(expanded){

                DayDescription(description = day.description)
            }
        }
    }
}

@Composable
fun DayImage(
    @DrawableRes img : Int ,
    modifier: Modifier = Modifier
){
    Image(painter = painterResource(id = img), contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 300.dp)
            .widthIn(max = 300.dp),
        contentScale = ContentScale.Crop)

}

@Composable
fun DayInfo(
    @StringRes count : Int ,
    @StringRes activity : Int,
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier.width(300.dp)){

        Text(
            text = stringResource(R.string.day_number , count),
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(id = activity) ,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 10.dp , bottom = 10.dp ,end = 8.dp),
            overflow = TextOverflow.Ellipsis
        )
    }


}

@Composable
fun DayDescription(
    @StringRes description : Int,
    modifier: Modifier = Modifier
){

    Text(
        text = stringResource(id = description),
        style = MaterialTheme.typography.displayMedium,
        modifier = Modifier.padding(start = 10.dp),
    )


}

@Composable
private fun DayItemButton(
    expanded : Boolean,
    onClick :() -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(onClick = onClick , modifier = modifier) {

        Icon(imageVector = if(expanded)Icons.Filled.ExpandLess else Icons.Filled.ExpandMore ,
            contentDescription = stringResource(id = R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary)

    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(modifier :Modifier = Modifier){

    CenterAlignedTopAppBar(title = {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Image(painter = painterResource(id = R.drawable.goal), contentDescription = null
            , modifier = Modifier
                    .size(64.dp)
                    .padding(8.dp))


            Text(text = stringResource(R.string.Top_bar_headline),
                style = MaterialTheme.typography.displayLarge)

        }
    },
        modifier = modifier,
        )



}



@Preview(showBackground = true)
@Composable
fun LearnFootballPreview() {
    LearnFootballTheme {
        FootballGuideApp()
    }
}