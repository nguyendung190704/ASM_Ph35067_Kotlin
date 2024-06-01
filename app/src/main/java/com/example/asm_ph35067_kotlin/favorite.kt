package com.example.asm_ph35067_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.asm_ph35067_kotlin.model.ModelProduct
import kotlin.math.ceil

class favorite : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FavoriteScreen()
        }
    }
}

@Composable
fun FavoriteScreen() {
    var favoriteProducts by remember { mutableStateOf(ModelProduct.getModelProduct().filter { it.favorite_prod == 1 }) }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            TopBarFavorite()
            Spacer(modifier = Modifier.height(5.dp))
            ProductListFavorite(favoriteProducts) { productId ->
                favoriteProducts = favoriteProducts.map {
                    if (it.id_prod == productId) {
                        it.copy(favorite_prod = 0)
                    } else {
                        it
                    }
                }.filter { it.favorite_prod == 1 }
            }
            ButtonFavorite()
        }
    }
}

@Composable
fun ProductListFavorite(products: List<ModelProduct>, onFavoriteClick: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier.height(490.dp),
    ) {
        items(products.size) { index ->
            GridItemFavorite(products[index], onFavoriteClick)
        }
    }
}


@Composable
fun TopBarFavorite() {
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
fun ButtonFavorite() {
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
            text = "Add all to my cart",
            color = Color.White,
            fontSize = 18.sp,

            )
    }
}






@Composable
fun GridItemFavorite(modelProduct: ModelProduct, onFavoriteClick: (Int) -> Unit) {
        ProductItemFavorite(modelProduct, onFavoriteClick)
}



@Composable
fun ProductItemFavorite(modelProduct: ModelProduct,onFavoriteClick: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(bottom = 10.dp)
            .background(Color(0x05000000), shape = RoundedCornerShape(10.dp))

    ) {
        AsyncImage(
            model = modelProduct.imgUrl_prod,
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
                text = modelProduct.name_prod,
                color = Color.Gray,
                fontSize = 18.sp,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start=10.dp)
            )
            Text(
                text = "$ ${modelProduct.price_prod}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start=10.dp)

            )
        }
        Column {
            IconButton(
                onClick = { onFavoriteClick(modelProduct.id_prod) },
                modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .background(Color(0x00000000),shape = RoundedCornerShape(7.dp)),
                    painter = painterResource(id = R.drawable.outline_cancel_24),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            IconButton(
                onClick = {  },
                modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .background(Color(0x1A000000), shape = RoundedCornerShape(1.dp))
                        .padding(7.dp),
                    painter = painterResource(id = R.drawable.img_16),
                    contentDescription = null
                )
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewFavoriteScreen() {
    FavoriteScreen()
}