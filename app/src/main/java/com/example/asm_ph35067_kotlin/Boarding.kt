package com.example.asm_ph35067_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Boarding : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoardingScreen { navigateToLogin() }
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}

@Composable
fun BoardingScreen(onGetStartedClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp),
        ) {
            Text(
                text = "MAKE YOUR",
                modifier = Modifier.padding(bottom = 8.dp),
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                color = Color(0xAE000000)
            )
            Text(
                text = "HOME BEAUTIFUL",
                modifier = Modifier.padding(bottom = 16.dp),
                color = Color(0xFF000000),
                fontFamily = FontFamily.Serif,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                lineHeight = 32.sp,
                modifier = Modifier.padding(bottom = 160.dp, start = 60.dp, end = 30.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Button(
                    onClick = onGetStartedClick,
                    modifier = Modifier
                        .background(Color(0xFF000000), shape = RoundedCornerShape(10.dp))
                        .width(200.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x00000000),
                        contentColor = Color.White,
                    )
                ) {
                    Text(
                        text = "Get started",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoardingScreenPreview() {
    BoardingScreen {}
}
