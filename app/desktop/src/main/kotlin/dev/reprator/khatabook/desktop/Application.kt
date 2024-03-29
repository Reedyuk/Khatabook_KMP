package dev.reprator.khatabook.desktop

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import dev.reprator.khatabook.expect.DesktopContext
import dev.reprator.khatabook.screens.home.HomeScreen
import io.github.xxfast.decompose.LocalComponentContext

@OptIn(ExperimentalDecomposeApi::class)
fun main() {
  val lifecycle = LifecycleRegistry()
  val rootComponentContext = DefaultComponentContext(lifecycle = lifecycle)

  application {
    val windowState: WindowState = rememberWindowState()
    LifecycleController(lifecycle, windowState)


    Window(
      title = "Khatabook",
      state = windowState,
      onCloseRequest = { exitApplication() }
    ) {
      CompositionLocalProvider(LocalComponentContext provides rootComponentContext) {
        MaterialTheme {
          HomeScreen(DesktopContext)
        }
      }
    }
  }
}
