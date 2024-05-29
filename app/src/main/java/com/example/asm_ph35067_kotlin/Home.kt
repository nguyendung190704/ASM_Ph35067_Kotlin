package com.example.asm_ph35067_kotlin

import android.os.Bundle
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import kotlin.math.ceil

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            TopBar()
            Spacer(modifier = Modifier.height(16.dp))
            CategoryRow()
            Spacer(modifier = Modifier.height(16.dp))
            ProductList()
        }
    }
}

@Composable
fun TopBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)

        ) {
            Text(
                text = "Make home",
                fontFamily = FontFamily.Serif,
            )
            Text(
                text = "BEAUTIFUL",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,

                )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = R.drawable.img_2),
            contentDescription = "Search",
            modifier = Modifier.size(35.dp)
        )
    }
}

@Composable
fun CategoryRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryItem(imageId = R.drawable.img_7, text = "Popular")
        CategoryItem(imageId = R.drawable.img_8, text = "Chair")
        CategoryItem(imageId = R.drawable.img_9, text = "Table")
        CategoryItem(imageId = R.drawable.img_11, text = "Bed")
        CategoryItem(imageId = R.drawable.img_10, text = "Armchair")

    }
}

@Composable
fun CategoryItem(imageId: Int, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Category",
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = text,
            color = Color.Black
        )
    }
}

@Composable
fun ProductList() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(ceil(10 / 2.0).toInt()) { index ->
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                GridItem(index * 2)
                Spacer(modifier = Modifier.width(16.dp))
                GridItem(index * 2 + 1)
            }
        }
    }
}

@Composable
fun GridItem(index: Int) {
    if (index < 10) {
        ProductItem()
    } else {
        Spacer(modifier = Modifier.width(5.dp))
    }
}

@Composable
fun ProductItem() {
    Column(
        modifier = Modifier
            .height(275.dp)
    ) {
        Box(modifier = Modifier.width(150.dp).height(200.dp)){
            Image(
                painter = painterResource(id = R.drawable.img_12),
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                ,
                contentScale = ContentScale.FillBounds
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 14.dp, end = 15.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                        .background(Color(0x20000000), shape = RoundedCornerShape(10.dp))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.img_16),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .height(105.dp)
        ) {
            Text(
                text = "Tên sản phẩm ",
                color = Color.Gray,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$ 500.00",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
