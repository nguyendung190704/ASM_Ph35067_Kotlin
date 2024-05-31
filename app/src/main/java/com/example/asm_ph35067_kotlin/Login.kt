package com.example.asm_ph35067_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.asm_ph35067_kotlin.model.ModelUser
import java.util.regex.Pattern

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login") {
                composable("login") { LoginScreen(navController) }
                composable("home") { HomeScreen() }
                composable("signup") { SignupScreen(navController) }
            }
        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var loginError by remember { mutableStateOf<String?>(null) }
    val users = ModelUser.getModelUser()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "",
                    modifier = Modifier
                        .padding(top = 34.dp)
                        .height(1.dp)
                        .width(100.dp)
                        .background(Color(0x94000000))
                        .weight(1f)
                )
                Image(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = null,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = "",
                    modifier = Modifier
                        .padding(top = 34.dp)
                        .height(1.dp)
                        .width(100.dp)
                        .background(Color(0x94000000))
                        .weight(1f)
                )
            }

            Text(
                text = "Hello !",
                fontFamily = FontFamily.Serif,
                fontSize = 25.sp,
                color = Color(0xAE000000),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "WELCOME BACK",
                color = Color(0xFF000000),
                fontFamily = FontFamily.Serif,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(310.dp)
                    .background(Color.White, shape = RoundedCornerShape(20.dp))
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        emailError = if (isValidEmail(it)) null else "Invalid email format"
                    },
                    label = { Text("Email") },
                    isError = emailError != null,
                    modifier = Modifier.fillMaxWidth()
                )
                if (emailError != null) {
                    Text(
                        text = emailError ?: "",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        passwordError = if (it.length > 5) null else "Password must be longer than 5 characters"
                    },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    isError = passwordError != null,
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
                )
                if (passwordError != null) {
                    Text(
                        text = passwordError ?: "",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { /*TODO: Forgot Password logic*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "Forgot Password", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        // Login logic using ModelUser data
                        if (isValidEmail(email) && password.length > 5) {
                            val user = users.find { it.email_user == email && it.password_user == password }
                            if (user != null) {
                                navController.navigate("home")
                            } else {
                                loginError = "Invalid email or password"
                            }
                        } else {
                            emailError = if (isValidEmail(email)) null else "Invalid email format"
                            passwordError = if (password.length > 5) null else "Password must be longer than 5 characters"
                            loginError = null
                        }
                    },
                    modifier = Modifier
                        .background(Color(0xFF000000), shape = RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x00000000),
                        contentColor = Color.White,
                    )
                ) {
                    Text(text = "Login", fontSize = 20.sp)
                }
                if (loginError != null) {
                    Text(
                        text = loginError ?: "",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { navController.navigate("signup") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "SIGN UP", fontSize = 18.sp)
                }
            }
        }
    }
}

fun isValidEmail(email: String): Boolean {
    val emailPattern = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    )
    return emailPattern.matcher(email).matches()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}
