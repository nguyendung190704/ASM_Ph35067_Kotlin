package com.example.asm_ph35067_kotlin

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = "",
                modifier = Modifier
                    .wrapContentSize()
                    .background(Color(0x66000000))
                    .width(120.dp)
                    .height(1.dp),

            )
            Spacer(modifier = Modifier.width(1.dp)) // Khoảng trống
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(1.dp)) // Khoảng trống
            Text(
                text = "",
                modifier = Modifier
                    .wrapContentSize()
                    .background(Color(0x66000000))
                    .width(120.dp)
                    .height(1.dp),

                )
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp),
        ){
            Text(
                text = "Hello !",
                modifier = Modifier.padding(bottom = 8.dp, top = 100.dp),
                fontFamily = FontFamily.Serif,
                fontSize = 25.sp,
                color = Color(0xAE000000)
            )
            Text(
                text = "WELCOME BACK",
                modifier = Modifier.padding(bottom = 16.dp),
                color = Color(0xFF000000),
                fontFamily = FontFamily.Serif,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 200.dp)
                .width(310.dp)
            .background(Color.White,shape = RoundedCornerShape(20.dp))
        ){
            OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp,),
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp,),
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation()
            )
            Column(
                modifier = Modifier
                    .padding(top = 20.dp,bottom = 20.dp, start = 55.dp)
                    .fillMaxWidth()

            ){
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color(0x00000000), shape = RoundedCornerShape(10.dp))
                        .width(200.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x00000000),
                        contentColor = Color.White,
                    )
                ) {
                    Text(
                        text = "Forgot Password",
                        color = Color(0xFF000000),
                        fontSize = 18.sp,

                        )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color(0xFF000000), shape = RoundedCornerShape(10.dp))
                        .width(200.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x00000000),
                        contentColor = Color.White,
                        )
                    ){
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontSize = 20.sp,

                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color(0x00000000), shape = RoundedCornerShape(10.dp))
                        .width(200.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x00000000),
                        contentColor = Color.White,
                    )
                ) {
                    Text(
                        text = "SIGN UP",
                        color = Color(0xFF000000),
                        fontSize = 18.sp,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        LoginScreen()

}