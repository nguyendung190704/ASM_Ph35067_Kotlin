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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.ceil

class RatingReview : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RatingReviewScreen()
        }
    }
}

@Composable
fun RatingReviewScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp)
        ) {
            TopBarRatingReview()
            Spacer(modifier = Modifier.height(10.dp))
            ProductItemRatingReview()
            Spacer(modifier = Modifier.height(20.dp))
            ReviewList()
        }
        WriteReviewButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Composable
fun WriteReviewButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .background(Color(0xFF000000), shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0x00000000),
            contentColor = Color.White,
        )
    ) {
        Text(
            text = "Write a review",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

@Composable
fun TopBarRatingReview() {
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
                text = "Rating & Review",
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
fun ProductItemRatingReview() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 10.dp,)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_12),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp))
            ,
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .height(105.dp)
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Tên sản phẩm ",
                color = Color.Black,
                fontSize = 15.sp,
                modifier = Modifier.padding(start=10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(
                    text = "⭐ ",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start=10.dp)

                )
                Text(
                    text = "4.5",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleSmall,

                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "10 reviews",
                color = Color.Black,
                fontSize = 15.sp,
                modifier = Modifier.padding(start=10.dp)
            )
        }
    }
}
@Composable
fun ReviewList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
    ) {
        items(10) { index ->
            GridItemRating(0)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun GridItemRating(index: Int) {
    if (index < 10) {
        ReviewItem()
    } else {
        Spacer(modifier = Modifier.width(5.dp))
    }
}

@Composable
fun ReviewItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 10.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(top = 20.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(20.dp))
        ){
            Row {
                Text(
                    text = "Nguyễn Dũng",
                    color = Color.Black,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 20.dp, start = 10.dp, end = 10.dp)
                )
                Text(
                    text = "20/12/2024",
                    color = Color(0x81000000),
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 10.dp, end = 10.dp),
                )
            }
            Text(
                text = "⭐⭐⭐⭐⭐",
                color = Color.Black,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(top = 5.dp, start = 10.dp, end = 10.dp)
            )
            Text(
                text = "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(top = 15.dp, start = 10.dp, end = 10.dp, bottom = 20.dp)
            )

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.img_12),
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(50.dp)),
                contentScale = ContentScale.FillBounds
            )
        }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    RatingReviewScreen()
}