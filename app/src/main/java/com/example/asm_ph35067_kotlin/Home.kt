package com.example.asm_ph35067_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.asm_ph35067_kotlin.model.ModelProduct

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
    var selectedCategory by remember { mutableStateOf("All") }
    var searchText by remember { mutableStateOf("") }
    var isSearchVisible by remember { mutableStateOf(false) }
    val products = ModelProduct.getModelProduct()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        if (isSearchVisible) {
                            isSearchVisible = false
                        }
                    })
                }
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                TopBar(
                    searchText = searchText,
                    onSearchTextChange = { searchText = it },
                    isSearchVisible = isSearchVisible,
                    onSearchIconClick = { isSearchVisible = true }
                )
                Spacer(modifier = Modifier.height(16.dp))
                CategoryRow(selectedCategory = selectedCategory, onCategorySelected = { selectedCategory = it })
                Spacer(modifier = Modifier.height(16.dp))
                ProductList(
                    products = products.filter {
                        (it.type_prod == selectedCategory || selectedCategory == "All") &&
                                it.name_prod.contains(searchText, ignoreCase = true)
                    }
                )
            }
        }
    }
}

@Composable
fun TopBar(searchText: String, onSearchTextChange: (String) -> Unit, isSearchVisible: Boolean, onSearchIconClick: () -> Unit) {

        if (isSearchVisible) {
            OutlinedTextField(
                value = searchText,
                onValueChange = onSearchTextChange,
                label = { Text("Search by product name") },
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = onSearchIconClick,
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        modifier = Modifier
                            .width(23.dp)
                            .height(23.dp)
                    )
                }
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
                    contentDescription = "Profile",
                    modifier = Modifier.size(35.dp)
                )
            }


        }

    }


@Composable
fun CategoryRow(selectedCategory: String, onCategorySelected: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryItem(imageId = R.drawable.img_25, text = "All", isSelected = selectedCategory == "All", onClick = onCategorySelected)
        CategoryItem(imageId = R.drawable.img_7, text = "Popular", isSelected = selectedCategory == "Popular", onClick = onCategorySelected)
        CategoryItem(imageId = R.drawable.img_8, text = "Chair", isSelected = selectedCategory == "Chair", onClick = onCategorySelected)
        CategoryItem(imageId = R.drawable.img_9, text = "Table", isSelected = selectedCategory == "Table", onClick = onCategorySelected)
        CategoryItem(imageId = R.drawable.img_11, text = "Bed", isSelected = selectedCategory == "Bed", onClick = onCategorySelected)
        CategoryItem(imageId = R.drawable.img_10, text = "Armchair", isSelected = selectedCategory == "Armchair", onClick = onCategorySelected)
    }
}

@Composable
fun CategoryItem(imageId: Int, text: String, isSelected: Boolean, onClick: (String) -> Unit) {
    val backgroundColor = if (isSelected) Color.LightGray else Color.Transparent
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(8.dp)
            .clickable { onClick(text) }
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Category",
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = text,
            color = Color.Black,
            fontSize = 9.sp,
            modifier = Modifier.width(37.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ProductList(products: List<ModelProduct>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth().height(470.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products.chunked(2)) { pair ->
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                pair.forEach { product ->
                    ProductItem(product)
                }
            }
        }
    }
}

@Composable
fun ProductItem(modelProduct: ModelProduct) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .height(275.dp)
            .background(Color(0x16000000), shape = RoundedCornerShape(10.dp))
    ) {
        Box(
            modifier = Modifier
                .width(160.dp)
                .height(200.dp)
        ) {
            AsyncImage(
                model = modelProduct.imgUrl_prod,
                contentDescription = null,
                modifier = Modifier
                    .width(160.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                contentScale = ContentScale.FillBounds
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp, end = 21.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .width(27.dp)
                        .height(27.dp)
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
                .height(75.dp)
                .padding(8.dp)
        ) {
            Text(
                text = modelProduct.name_prod,
                color = Color(0x9A000000),
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$ ${modelProduct.price_prod}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
