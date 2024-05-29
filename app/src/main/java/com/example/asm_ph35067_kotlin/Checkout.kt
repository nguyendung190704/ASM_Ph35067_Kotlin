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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Checkout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckoutScreen()
            BottomBarCheckout()
        }
    }
}

@Composable
fun CheckoutScreen() {
    Column {
        TopBarCheckout()
        Spacer(modifier = Modifier.height(10.dp))
        ShippingAddress()
        Spacer(modifier = Modifier.height(20.dp))
        Payment()
        Spacer(modifier = Modifier.height(20.dp))
        Deliverymethod()
        Spacer(modifier = Modifier.height(20.dp))
        BottomBarCheckout()
        SubmitOrder()
    }
}

@Composable
fun TopBarCheckout() {
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
                text = "Check out",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
            )
        }
        IconButton(
            onClick = {  },
            modifier = Modifier.size(30.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.img_21),
                contentDescription = "Search",
                modifier = Modifier.size(35.dp)
            )
        }

    }
}

@Composable
fun ShippingAddress(){
    Column (modifier = Modifier.padding(horizontal = 10.dp)){
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Shipping Address",
                color = Color(0x79000000),
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = { },
                modifier = Modifier.size(25.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .background(Color(0x00000000),shape = RoundedCornerShape(7.dp)),
                    painter = painterResource(id = R.drawable.outline_border_color_24),
                    contentDescription = null
                )
            }
        }
        Column (modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .height(80.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Center,
            ) {
            Text(text = "Nguyen Dung",
                fontSize = 16.sp,
                color = Color(0xFF000000),
                fontWeight = FontWeight.Bold,

            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                fontSize = 13.sp,
                color = Color(0x8A000000),
                )
        }
    }
}
@Composable
fun Payment(){
    Column (modifier = Modifier.padding(horizontal = 10.dp)){
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Payment",
                color = Color(0x79000000),
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = { },
                modifier = Modifier.size(25.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .background(Color(0x00000000)),
                    painter = painterResource(id = R.drawable.outline_border_color_24),
                    contentDescription = null
                )
            }
        }
        Row (modifier = Modifier
            .padding(start = 10.dp)
            .background(Color(0xFFFFFFFF))
        ){

            Image(painter = painterResource(id = R.drawable.img_17), contentDescription = null,
                modifier = Modifier.size(50.dp))
            Column( verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(50.dp)){
                Text(text = "**** **** **** 2004", fontWeight = FontWeight.Bold)
            }
        }

    }
}
@Composable
fun Deliverymethod(){
    Column (modifier = Modifier.padding(horizontal = 10.dp)){
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Delivery method",
                color = Color(0x79000000),
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = { },
                modifier = Modifier.size(25.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .background(Color(0x00000000)),
                    painter = painterResource(id = R.drawable.outline_border_color_24),
                    contentDescription = null
                )
            }
        }
        Row (modifier = Modifier
            .padding(start = 10.dp)
            .background(Color(0xFFFFFFFF))
        ){
            Image(painter = painterResource(id = R.drawable.img_18), contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .width(70.dp))
            Column( verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(50.dp)){
                Text(text = "Fast (2-3days)", fontWeight = FontWeight.Bold)
            }
        }

    }
}
@Composable
fun BottomBarCheckout(){
    Box(modifier = Modifier.padding(horizontal = 20.dp)){
        Column (modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .height(120.dp)
            ,
            verticalArrangement = Arrangement.Center,

            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 35.dp,)
            ) {
                Text(
                    text = "Order :",
                    fontSize = 18.sp,
                    color = Color(0xFF8A000000),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "$ ",
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "95.00",
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 35.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "Delivery :",
                    fontSize = 18.sp,
                    color = Color(0xFF8A000000),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "$ ",
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "5.00",
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 35.dp,)
            ) {
                Text(
                    text = "Total :",
                    fontSize = 18.sp,
                    color = Color(0xFF8A000000),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "$ ",
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "100.00",
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }

}
@Composable
fun SubmitOrder() {
    Box(modifier = Modifier.padding(horizontal = 30.dp)){
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .background(Color(0xFF000000), shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(50.dp)
            ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x00000000),
                contentColor = Color.White,
            )
        ){
            Text(
                text = "Submit Order",
                color = Color.White,
                fontSize = 20.sp,

                )
        }
    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    CheckoutScreen()

}