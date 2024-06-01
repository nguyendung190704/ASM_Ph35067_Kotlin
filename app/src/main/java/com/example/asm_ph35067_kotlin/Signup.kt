package com.example.asm_ph35067_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import com.example.asm_ph35067_kotlin.model.UserRepository

class Signup : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UserRepository.init(this)

        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "signup") {
                composable("signup") { SignupScreen(navController) }
                composable("login") { LoginScreen(navController) }
                composable("home") { HomeScreen() }
            }
        }
    }
}

@Composable
fun SignupScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var imgUrlUser by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorText by remember { mutableStateOf("") }
    val users = remember { mutableStateListOf(*ModelUser.getModelUser().toTypedArray()) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var nameError by remember { mutableStateOf<String?>(null) }
    var linkanhError by remember { mutableStateOf<String?>(null) }
    var ConfirmPasswordError by remember { mutableStateOf<String?>(null) }
    Box(
        modifier = Modifier.fillMaxSize(),
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
            text = "WELCOME",
            modifier = Modifier.padding(bottom = 16.dp, top = 50.dp, start = 16.dp),
            color = Color(0xFF000000),
            fontFamily = FontFamily.Serif,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )

        Column(
            modifier = Modifier
                .padding(top = 100.dp)
                .width(310.dp)
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .padding(horizontal = 16.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                value = name,
                onValueChange = { name = it
                                nameError = if (validateName(it)) null else "Name must be longer than 5 characters and contain no digits."},
                label = { Text("Name") },
                isError = nameError != null,

                )
            if (nameError != null) {
                Text(
                    text = nameError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            OutlinedTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                value = email,
                onValueChange = {
                    email = it
                    emailError = if (validateEmail(it)) null else "Invalid email format"
                },
                label = { Text("Email") },
                isError = emailError != null,

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
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                value = imgUrlUser,
                onValueChange = { imgUrlUser = it
                                linkanhError = if (validateImageUrl(it)) null else "Image URL cannot be blank."},
                label = { Text("Link image") },
                isError = linkanhError != null,

                )
            if (linkanhError != null) {
                Text(
                    text = linkanhError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            OutlinedTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                value = password,
                onValueChange = { password = it
                                passwordError = if (validatePassword(it)) null else "Password must be longer than 5 characters."},
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                isError = passwordError != null,

                )
            if (passwordError != null) {
                Text(
                    text = passwordError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            OutlinedTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                value = confirmpassword,
                onValueChange = { confirmpassword = it },
                label = { Text("Confirm Password") },
                visualTransformation = PasswordVisualTransformation(),
                isError = ConfirmPasswordError != null,

                )
            if (ConfirmPasswordError != null) {
                Text(
                    text = ConfirmPasswordError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp)
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        if (!validateConfirmPassword(password, confirmpassword)) {
                            ConfirmPasswordError = "Passwords do not match."
                            return@Button
                        } else {
                            ConfirmPasswordError = null
                        }
                        val newUser = ModelUser(
                            id_user = UserRepository.getUsers().size + 1,
                            name_user = name,
                            email_user = email,
                            img_user = imgUrlUser,
                            password_user = password
                        )
                        UserRepository.addUser(newUser)
                        navController.navigate("login")
                    },
                    modifier = Modifier
                        .background(Color(0xFF000000), shape = RoundedCornerShape(10.dp))
                        .width(200.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x00000000),
                        contentColor = Color.White,
                    )
                ) {
                    Text(
                        text = "Sign Up",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                }

                // Hiển thị thông báo lỗi nếu có
                if (errorText.isNotEmpty()) {
                    Text(
                        text = errorText,
                        color = Color.Red,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                // Điều hướng đến màn hình đăng nhập nếu đã có tài khoản
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 70.dp)
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Already have an account?",
                        modifier = Modifier.wrapContentSize()
                    )

                    Text(
                        text = "SIGN IN",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { navController.navigate("login") }
                            .padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

fun validateName(name: String): Boolean {
    return name.length > 5 && !name.any { it.isDigit() }
}

fun validateEmail(email: String): Boolean {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
    return email.matches(emailRegex.toRegex())
}

fun validateImageUrl(url: String): Boolean {
    return url.isNotBlank()
}

fun validatePassword(password: String): Boolean {
    return password.length > 5
}

fun validateConfirmPassword(password: String, confirmPassword: String): Boolean {
    return password == confirmPassword
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    val navController = rememberNavController()
    SignupScreen(navController)
}

