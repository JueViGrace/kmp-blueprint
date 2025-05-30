package com.jvg.sample2.auth.presentation.ui.signin.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jvg.kmpblueprint.auth.presentation.signin.viewmodel.SignInViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignInScreen() {
    val viewmodel: SignInViewModel = koinViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Sign in")
        Button(
            onClick = {
                viewmodel.navigateToForgotPassword()
            }
        ) {
            Text("Go to forgot password")
        }
        Button(
            onClick = {
                viewmodel.navigateToSignUp()
            }
        ) {
            Text("Go to sign up")
        }
    }
}

