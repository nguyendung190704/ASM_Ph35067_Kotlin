package com.example.asm_ph35067_kotlin

import android.os.Bundle
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen(){
    Column {
        TopBarProfile()
        Spacer(modifier = Modifier.height(10.dp))
        itemUser()
        Spacer(modifier = Modifier.height(30.dp))
        noteProfile()
    }
}

@Composable
fun TopBarProfile() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        IconButton(
            onClick = {  },
            modifier = Modifier.size(30.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.img_14),
                contentDescription = "Search",
                modifier = Modifier.size(20.dp)
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)

        ) {

            Text(
                text = "Profile",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
            )
        }
        IconButton(
            onClick = {  },
            modifier = Modifier.size(30.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.img_22),
                contentDescription = "Search",
                modifier = Modifier.size(22.dp)
            )
        }

    }
}
@Composable
fun itemUser(){
    Row(modifier = Modifier.padding(horizontal = 10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.img_12),
            contentDescription = null,
            modifier = Modifier
                .width(70.dp)
                .height(70.dp)
                .clip(RoundedCornerShape(70.dp))
            ,
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.height(70.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Nguyen dung",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFF000000),
                fontSize = 18.sp,
                )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "dungntph35067@fpt.edu.vn",
                color = Color(0x86000000),
                fontSize = 13.sp,
                )
        }
    }
}
@Composable
fun noteProfile(){
    Column {
        Box(modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(20.dp)),
        ){
            Row {
                Column(modifier = Modifier
                    .padding(10.dp)
                    .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "My orders",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(0xFF000000),
                        fontSize = 15.sp,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Already have 10 orders",
                        color = Color(0x86000000),
                        fontSize = 12.sp,
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.height(60.dp)
                ){
                    IconButton(
                        onClick = {  },
                        modifier = Modifier.size(30.dp),
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.img_24),
                            contentDescription = "Search",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(20.dp)),
        ){
            Row {
                Column(modifier = Modifier
                    .padding(10.dp)
                    .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Shipping Addresses",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(0xFF000000),
                        fontSize = 15.sp,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "03 Addresses",
                        color = Color(0x86000000),
                        fontSize = 12.sp,
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.height(60.dp)
                ){
                    IconButton(
                        onClick = {  },
                        modifier = Modifier.size(30.dp),
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.img_24),
                            contentDescription = "Search",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

            }

        }
        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(20.dp)),
        ){
            Row {
                Column(modifier = Modifier
                    .padding(10.dp)
                    .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Payment Method",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(0xFF000000),
                        fontSize = 15.sp,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "You have 02 cards",
                        color = Color(0x86000000),
                        fontSize = 12.sp,
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.height(60.dp)
                ){
                    IconButton(
                        onClick = {  },
                        modifier = Modifier.size(30.dp),
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.img_24),
                            contentDescription = "Search",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

            }

        }
        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(20.dp)),
        ){
            Row {
                Column(modifier = Modifier
                    .padding(10.dp)
                    .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "My reviews",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(0xFF000000),
                        fontSize = 15.sp,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Reviews for 05 items",
                        color = Color(0x86000000),
                        fontSize = 12.sp,
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.height(60.dp)
                ){
                    IconButton(
                        onClick = {  },
                        modifier = Modifier.size(30.dp),
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.img_24),
                            contentDescription = "Search",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

            }

        }
        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(20.dp)),
        ){
            Row {
                Column(modifier = Modifier
                    .padding(10.dp)
                    .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Setting",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(0xFF000000),
                        fontSize = 15.sp,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Notification, Password, FAQ, Contact",
                        color = Color(0x86000000),
                        fontSize = 12.sp,
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.height(60.dp)
                ){
                    IconButton(
                        onClick = {  },
                        modifier = Modifier.size(30.dp),
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.img_24),
                            contentDescription = "Search",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

            }

        }
    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    ProfileScreen()
}