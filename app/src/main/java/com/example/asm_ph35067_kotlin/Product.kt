package com.example.asm_ph35067_kotlin

import android.os.Bundle
import android.telecom.Call.Details
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Product : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductScreen()
        }
    }
}

@Composable
fun ProductScreen() {
    Column {
        TopBarProduct()
        DetailsProduct(0)

    }
}
@Composable
fun TopBarProduct() {
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
                text = "Favorites",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
            )
        }
        IconButton(
            onClick = {  },
            modifier = Modifier.size(30.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.img_2),
                contentDescription = "Search",
                modifier = Modifier.size(35.dp)
            )
        }

    }
}
@Composable
fun DetailsProduct(sl:Int){
    var soluong by remember { mutableStateOf(sl) }

    Column {
        Box (
            modifier = Modifier
                .padding(start = 100.dp)
                .width(812.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_12),
                contentDescription = null,
                modifier = Modifier
                    .width(312.dp)
                    .height(312.dp)
                    .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                ,
                contentScale = ContentScale.FillBounds
            )
        }
        Text(
            text = "Queen size bed",
            fontFamily = FontFamily.Serif,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp,bottom = 5.dp)
            )
        Row (modifier = Modifier.fillMaxWidth().padding(end = 10.dp, bottom = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
            
        ){
            Row(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "$ ",
                    fontFamily = FontFamily.Serif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Text(
                    text = "2000",
                    fontFamily = FontFamily.Serif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End

            ) {
                IconButton(
                    onClick = {  if (soluong > 0) soluong-- },
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .background(Color(0x1A000000),shape = RoundedCornerShape(7.dp)),
                        painter = painterResource(id = R.drawable.baseline_arrow_right_alt_24),
                        contentDescription = null
                    )
                }
                Text(
                    text = "$soluong",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(horizontal = 8.dp)
                    ,

                    )
                IconButton(
                    onClick = { soluong++ },
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .background(Color(0x1A000000),shape = RoundedCornerShape(7.dp)),
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = null
                    )
                }
            }
        }
        Row() {
            Text(
                text = "⭐ ",
                fontFamily = FontFamily.Serif,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp)
            )
            Text(
                text = "4.5",
                fontFamily = FontFamily.Serif,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 10.dp).width(50.dp)
            )
            Text(
                text = "(50 reviews)",
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                color = Color(0xFF8A000000),
                modifier = Modifier.padding(end = 10.dp),
            )
        }
        Text(
            text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
            fontFamily = FontFamily.Serif,
            fontSize = 12.sp,
            color = Color(0xFF8A000000),
            modifier = Modifier.padding(end = 10.dp, start = 10.dp, top = 20.dp).height(80.dp),
        )
        Row(
            modifier = Modifier.padding(start = 20.dp,end = 20.dp, bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,

            ){
            IconButton(
                onClick = {  },
                modifier = Modifier.width(50.dp).height(50.dp)
                    .background(Color(0x1A000000),shape = RoundedCornerShape(10.dp))

            ) {
                Icon(
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp),
                    painter = painterResource(id = R.drawable.img_4),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .background(Color(0xFF000000), shape = RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x00000000),
                    contentColor = Color.White,

                )
            ){
                Text(
                    text = "Add to cart",
                    color = Color.White,
                    fontSize = 20.sp,
                    )
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
        ProductScreen()
}