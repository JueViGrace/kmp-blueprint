package com.jvg.kmpblueprint.shared.presentation.ui.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.jvg.kmpblueprint.resources.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.resources.generated.resources.logo
import com.jvg.kmpblueprint.ui.components.display.ImageComponent
import org.jetbrains.compose.resources.stringResource

@Composable
fun SplashScreen(
    painter: Painter
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ImageComponent(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(4.dp),
            painter = painter,
            contentDescription = stringResource(Res.string.logo)
        )
    }
}
