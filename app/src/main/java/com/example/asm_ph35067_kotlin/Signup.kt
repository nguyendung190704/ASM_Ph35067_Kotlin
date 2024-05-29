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

class Signup : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupScreen()
        }
    }
}


@Composable
fun SignupScreen() {
    var name by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }
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

        Text(
            text = "WELCOME",
            modifier = Modifier.padding(bottom = 16.dp, top = 100.dp, start = 16.dp),
            color = Color(0xFF000000),
            fontFamily = FontFamily.Serif,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )

        Column(
            modifier = Modifier
                .padding(top = 150.dp)
                .width(310.dp)
                .background(Color.White,shape = RoundedCornerShape(20.dp))
        ){
            OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp,),
                value = name,
                onValueChange = { name = it },
                label = { Text("name") },
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp,),
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
            OutlinedTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp,),
                value = confirmpassword,
                onValueChange = { confirmpassword = it },
                label = { Text("Confirm Password") },
                visualTransformation = PasswordVisualTransformation()
            )
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .padding(top = 20.dp,bottom = 20.dp)
                    .fillMaxWidth()
            ){
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
                        text = "Sign Up",
                        color = Color.White,
                        fontSize = 20.sp,

                        )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 70.dp)
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = "Already have account ?",
                        modifier = Modifier
                            .wrapContentSize()
                        )

                    Text(
                        text = "SIGN IN",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .wrapContentSize()
                        )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
        SignupScreen()

}