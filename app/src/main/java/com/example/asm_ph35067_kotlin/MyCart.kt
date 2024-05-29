package com.example.asm_ph35067_kotlin

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle
import kotlin.math.ceil

class MyCart : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCartScreen()
        }
    }
}

@Composable
fun MyCartScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            TopBarMyCart()
            Spacer(modifier = Modifier.height(5.dp))
            ProductListMyCart()
            BottomMyCart()
        }
    }
}

@Composable
fun TopBarMyCart() {
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
                text = "My cart",
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
fun PromoCode() {
    var promocode by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 0.dp),
    ) {
        OutlinedTextField(
            modifier = Modifier
                .padding(0.dp,),
            value = promocode,
            onValueChange = { promocode = it },
            label = { Text("Enter your promo code") },
        )
        IconButton(
            onClick = {  },
            modifier = Modifier.width(60.dp).height(65.dp).padding(top = 7.dp)
                .background(Color(0x19000000),shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp))

        ) {
            Icon(
                modifier = Modifier
                    .width(50.dp)
                    .height(60.dp),
                painter = painterResource(id = R.drawable.baseline_chevron_right_24),
                contentDescription = null
            )
        }
    }
}

@Composable
fun Total() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp, vertical = 10.dp)
    ) {
        Text(
            text = "Total :",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
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
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "95.00",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Composable
fun CheckOutButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .background(Color(0xFF000000), shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0x00000000),
            contentColor = Color.White,
        )
    ){
        Text(
            text = "Check out",
            color = Color.White,
            fontSize = 20.sp,

            )
    }
}

@Composable
fun BottomMyCart() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        PromoCode()
        Total()
        CheckOutButton()
    }
}


@Composable
fun ProductListMyCart() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
    ) {
        items(10) { index ->
            GridItemMyCart(0)
        }
    }
}

@Composable
fun GridItemMyCart(index: Int) {
    if (index < 10) {
        ProductItemMyCart(0)
    } else {
        Spacer(modifier = Modifier.width(5.dp))
    }
}

@Composable
fun ProductItemMyCart(sl:Int) {
    var soluong by remember { mutableStateOf(sl) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(bottom = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_12),
            contentDescription = null,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .clip(RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp))
            ,
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .height(105.dp)
        ) {
            Text(
                text = "Tên sản phẩm ",
                color = Color.Gray,
                fontSize = 18.sp,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start=10.dp)
            )
            Text(
                text = "$ 500.00",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start=10.dp)

            )
            Row(    verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { soluong-- },
                    modifier = Modifier.size(40.dp)
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
                    modifier = Modifier.size(40.dp)
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
        Image(
            painter = painterResource(id = R.drawable.outline_cancel_24),
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .padding(top = 10.dp)
            ,
            contentScale = ContentScale.FillBounds
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMyCartScreen() {
    MyCartScreen()
}