package com.ugurinci.composeunit1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ugurinci.composeunit1.ui.theme.ComposeUnit1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUnit1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*GreetingImage("Happy Birthday Sam!", "From Emma")*/
                    /*Article()*/
                    /*TaskManager()*/
                    QuadrantApp()
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(end = 16.dp)
                .align(alignment = Alignment.End)

        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    Box(modifier) {
        Image(
            painter = painterResource(id = R.drawable.androidparty),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
fun Article() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.title_jetpack_compose_tutorial),
            fontSize = 24.sp,
            modifier = Modifier.padding(all = 16.dp)
        )
        Text(
            text = stringResource(R.string.compose_short_desc),
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.compose_long_desc),
            modifier = Modifier.padding(all = 16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskManager() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = "All tasks completed",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = "Nice work!",
            fontSize = 16.sp,
        )
    }
}

@Composable
fun Quadrant(modifier: Modifier, title: String, description: String, color: Color) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(all = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun QuadrantApp() {
    Column {
        Row(Modifier.weight(1f)) {
            Quadrant(
                Modifier.weight(1f),
                "Text composable",
                "Displays text and follows the recommended Material Design guidelines.",
                Color(0xFFEADDFF)
            )
            Quadrant(
                Modifier.weight(1f),
                "Image composable",
                "Creates a composable that lays out and draws a given Painter class object.\n",
                Color(0xFFD0BCFF)
            )
        }
        Row(Modifier.weight(1f)) {
            Quadrant(
                Modifier.weight(1f),
                "Row composable",
                "A layout composable that places its children in a horizontal sequence.",
                Color(0xFFB69DF8)
            )
            Quadrant(
                Modifier.weight(1f),
                "Column composable",
                "A layout composable that places its children in a vertical sequence.",
                Color(0xFFF6EDFF)
            )
        }
    }
}

@Composable
fun BusinessCard() {
    Box(modifier = Modifier.background(Color(0xFFd2e7d4))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 96.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .height(128.dp)
                    .width(128.dp)
                    .background(Color(0xFF073042))
            )
            Text(
                text = "Jennifer Doe",
                fontSize = 48.sp,
                fontWeight = FontWeight.Light,
            )
            Text(
                text = "Android Developer Extraordinaire",
                color = Color(0xFF0f6439),
                fontWeight = FontWeight.Bold,
            )
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 32.dp)
        ) {
            Contact(Icons.Default.Phone, "+11 (123) 444 555 666")
            Contact(Icons.Default.Share, "@AndroidDev")
            Contact(Icons.Default.Email, "jen.doe@android.com")
        }
    }
}

@Composable
fun Contact(imageVector: ImageVector, info: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 80.dp),
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = Color(0xFF0f6439)
        )
        Text(
            text = info,
            modifier = Modifier.padding(start = 32.dp, bottom = 12.dp)
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    ComposeUnit1Theme {
        GreetingImage(message = "Happy Birthday Sam!", from = "From Emma")
    }
}*/

/*
@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ComposeUnit1Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Article()
        }
    }
}*/

/*
@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    ComposeUnit1Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            TaskManager()
        }
    }
}*/

/*@Preview(showBackground = true)
@Composable
fun QuadrantAppPreview() {
    ComposeUnit1Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            QuadrantApp()
        }
    }
}*/

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    ComposeUnit1Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            BusinessCard()
        }
    }
}