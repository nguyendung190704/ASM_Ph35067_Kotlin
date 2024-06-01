package com.example.asm_ph35067_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    var selectedItem by remember { mutableStateOf("Home") }
    hienthi(selectedItem) { selectedItem = it }
}

@Composable
fun hienthi(selectedItem: String, onMenuItemClick: (String) -> Unit) {
    Column {
        Box(modifier = Modifier.weight(1f)){
            when (selectedItem) {
                "Home" -> HomeScreen()
                "Favorite" -> FavoriteScreen()
                "Notification" -> NotificationScreen()
                "Profile" -> ProfileScreen()
            }
        }
        Box(modifier = Modifier.padding(horizontal = 20.dp)){
            menuRow(selectedItem, onMenuItemClick)

        }

    }
}

@Composable
fun menuRow(selectedItem: String, onMenuItemClick: (String) -> Unit) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MenuItem(imageId = R.drawable.img_26, text = "Home", isSelected = selectedItem == "Home") { onMenuItemClick("Home") }
        MenuItem(imageId = R.drawable.img_4, text = "Favorite", isSelected = selectedItem == "Favorite") { onMenuItemClick("Favorite") }
        MenuItem(imageId = R.drawable.img_5, text = "Notification", isSelected = selectedItem == "Notification") { onMenuItemClick("Notification") }
        MenuItem(imageId = R.drawable.img_6, text = "Profile", isSelected = selectedItem == "Profile") { onMenuItemClick("Profile") }
    }
}

@Composable
fun MenuItem(imageId: Int, text: String, isSelected: Boolean, onClick: () -> Unit) {
    var modifiedImageId = imageId
    if (isSelected && text == "Favorite") {
        modifiedImageId = R.drawable.img_28
    }
    if (isSelected && text == "Home") {
        modifiedImageId = R.drawable.img_27
    }
    if (isSelected && text == "Notification") {
        modifiedImageId = R.drawable.img_29
    }
    if (isSelected && text == "Profile") {
        modifiedImageId = R.drawable.img_30
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = modifiedImageId),
            contentDescription = "Category",
            modifier = Modifier.size(20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MainScreen()
}