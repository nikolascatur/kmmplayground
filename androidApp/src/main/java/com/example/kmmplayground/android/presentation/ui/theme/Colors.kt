package com.example.kmmplayground.android.presentation.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.kmmplayground.SharedRes


@Composable
fun MokoColorsScheme(
    primary: Color = colorResource(id = SharedRes.colors.primary.resourceId),
    onPrimary: Color = colorResource(id = SharedRes.colors.lightText.resourceId),
    primaryContainer: Color = colorResource(id = SharedRes.colors.primary.resourceId),
    onPrimaryContainer: Color = colorResource(id = SharedRes.colors.lightText.resourceId),
    inversePrimary: Color = Color.Black,
    secondary: Color = Color.Gray,
    onSecondary: Color = colorResource(id = SharedRes.colors.darkText.resourceId),
    secondaryContainer: Color = Color.Magenta,
    onSecondaryContainer: Color = colorResource(id = SharedRes.colors.lightText.resourceId),
    tertiary: Color = Color.Black,
    onTertiary: Color = colorResource(id = SharedRes.colors.lightText.resourceId),
    tertiaryContainer: Color = Color.Black,
    onTertiaryContainer: Color = colorResource(id = SharedRes.colors.lightText.resourceId),
    background: Color = colorResource(id = SharedRes.colors.background.resourceId),
    onBackground: Color = colorResource(id = SharedRes.colors.darkText.resourceId),
    surface: Color = colorResource(id = SharedRes.colors.background.resourceId),
    onSurface: Color = colorResource(id = SharedRes.colors.darkText.resourceId),
    surfaceVariant: Color = colorResource(id = SharedRes.colors.cardSurface.resourceId),
    onSurfaceVariant: Color = colorResource(id = SharedRes.colors.lightText.resourceId),
    surfaceTint: Color = colorResource(id = SharedRes.colors.cardSurface.resourceId),
    inverseSurface: Color = Color.Black,
    inverseOnSurface: Color = Color.White,
    error: Color = Color.Red,
    onError: Color = colorResource(id = SharedRes.colors.lightText.resourceId),
    errorContainer: Color = Color.Red,
    onErrorContainer: Color = colorResource(id = SharedRes.colors.lightText.resourceId),
    outline: Color = Color.DarkGray,
    outlineVariant: Color = Color.Magenta,
    scrim: Color = Color.DarkGray,
):ColorScheme =
    ColorScheme(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
    )