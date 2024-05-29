package com.example.asm_ph35067_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Congrats : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CongratsScreen()
        }
    }
}

@Composable
fun CongratsScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Text(
            text = "SUCCESS!",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
        )
        Spacer(modifier = Modifier.height(40.dp))
        Image(painter = painterResource(id = R.drawable.img_19), contentDescription = null,
            modifier = Modifier.size(200.dp))
        Image(painter = painterResource(id = R.drawable.img_20), contentDescription = null,
            modifier = Modifier.size(40.dp),
            )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Your order will be delivered soon.",
            fontSize = 17.sp,
            color = Color(0x99000000)
        )
        Text(
            text = "Thank you for choosing our app!",
            fontSize = 17.sp,
            color = Color(0x99000000)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 30.dp)
                .background(Color(0xFF000000), shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x00000000),
                contentColor = Color.White,
            )
        ){
            Text(
                text = "Track your order",
                color = Color.White,
                fontSize = 20.sp,

                )
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .height(50.dp)
                .border(BorderStroke(1.dp, color = Color(0xFF000000)), RoundedCornerShape(10.dp)), // Border với bo góc
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x00000000),
            ),
        ){
            Text(
                text = "BACK TO HOME",
                color = Color.Black,
                fontSize = 20.sp,

                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    CongratsScreen()
}