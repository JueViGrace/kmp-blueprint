package com.jvg.sample1.auth.presentation.ui.forgot.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jvg.sample1.auth.presentation.ui.forgot.viewmodel.ForgotPasswordViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ForgotPasswordScreen() {
    val viewmodel: ForgotPasswordViewModel = koinViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Forgot password")
        Button(
            onClick = {
                viewmodel.navigateBack()
            }
        ) {
            Text("Go back")
        }
    }
}
