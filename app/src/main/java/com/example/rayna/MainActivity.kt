package com.example.reviewapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rayna.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReviewAppUI()
            //hello
        }
    }
}

@Composable
fun ReviewAppUI() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF5F5DC))
    ) {
        SearchBar()
        CategoryButtons()
        TopReviews()
    }
}

@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Shops, Products, Services, etc") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search"
            )
        }
    )
}

@Composable
fun CategoryButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(onClick = {}) { Text("Shop") }
        Button(onClick = {}) { Text("Product") }
        Button(onClick = {}) { Text("Service") }
    }
}

@Composable
fun TopReviews() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Top Reviews", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        ReviewItem("Milkshake", "A creamy milkshake drink.", R.drawable.milkshake)
        ReviewItem("Family Restaurant", "A cozy place for family dining.", R.drawable.restaurant)
    }
}

@Composable
fun ReviewItem(title: String, description: String, image: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Fix for elevation
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold)
                Text(description, fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}