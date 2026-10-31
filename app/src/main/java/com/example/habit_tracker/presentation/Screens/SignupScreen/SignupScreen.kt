package com.example.habit_tracker.presentation.Screens.SignupScreen

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.presentation.UiComponent.TopBar
import com.example.habit_tracker.ui.theme.Appdefault

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignupScreen() {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }

    Column() {

        Spacer(modifier = Modifier.height(20.dp))

        TopBar()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 12.dp)
        ) {

            Text(
                text = "Make room for progress",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Create your account find your focus",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color.DarkGray.copy(alpha = 0.5f),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Full Name",
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = name, onValueChange = { name = it },
                placeholder = { Text("Your full name",
                    color = Color.Gray,
                    fontSize = 13.sp) },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Appdefault
                )
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Email",
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = email, onValueChange = { email = it },
                placeholder = { Text("you@example.com",color = Color.Gray,
                    fontSize = 13.sp) },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Appdefault
                )
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Password",
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = password, onValueChange = { password = it },
                placeholder = { Text("Create a password",
                    color = Color.Gray,
                    fontSize = 13.sp) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                // 3. Add the trailing icon button
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password"
                    )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Appdefault
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "use 8+ character,with a letter and number",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color.DarkGray.copy(alpha = 0.5f),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Confirm Password",
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = password, onValueChange = { password = it },
                placeholder = { Text("Re-enter your password",
                    color = Color.Gray,
                    fontSize = 13.sp) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                // 3. Add the trailing icon button
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Appdefault
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.offset(x = (-12.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Checkbox(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(50.dp)),
                        checked = rememberMe,
                        onCheckedChange = { rememberMe = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFF6B66FF),
                            uncheckedColor = Color.LightGray
                        )
                    )

                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Gray)) {
                                append("I agree to the")
                            }
                            withStyle(style = SpanStyle(color = Appdefault)) {
                                append(" Terms of Service ")
                            }
                            withStyle(style = SpanStyle(color = Color.Gray)) {
                                append("and")
                            }
                            withStyle(style = SpanStyle(color = Appdefault)) {
                                append(" Privacy Policy")
                            }
                        },
                        fontSize = 12.sp,
                        maxLines = 1
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(end = 10.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonColors(
                    containerColor = Appdefault,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.Black
                )
            ) {
                Text(
                    "Sign up",
                    fontSize = 15.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Sign Up Link
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Alredy have an account? ", color = Color.Gray, fontSize = 14.sp)
                Text(
                    text = "Login",
                    color = Color(0xFF6B66FF),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.clickable { /* Navigate to Sign Up */ }
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Bottom Footer Text
            Text(
                text = "Less noise. More momentum.",
                color = Color.LightGray,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 24.dp)
            )
        }
    }
}