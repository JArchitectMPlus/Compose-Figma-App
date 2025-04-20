package com.prototype.compose_figma_app

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.prototype.compose_figma_app.ui.theme.ComposeFigmaAppTheme

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivityCompose"
    
    override fun onResume() {
        super.onResume()
        // Hide the action bar when the activity resumes
        actionBar?.hide()
        // For AppCompatActivity, you would use: supportActionBar?.hide()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        // --- Full Screen Setup ---
        // 1. Enable edge-to-edge display BEFORE calling super.onCreate or setContent
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.Transparent.toArgb()), // Or .light depending on background
            navigationBarStyle = SystemBarStyle.dark(Color.Transparent.toArgb()) // Or .light
        )

        super.onCreate(savedInstanceState)

        // Hide the action bar using WindowCompat
        WindowCompat.setDecorFitsSystemWindows(window, false) // Optional: Handle insets

        setContent {
            ComposeFigmaAppTheme { // Apply your app's theme
                // --- System UI Visibility Control ---
                DisposableEffect(Unit) {
                    // Hide the system bars specific to this screen
                    hideSystemBars()
                    // Return block to run when the effect leaves the composition
                    onDispose {
                        // Optionally show system bars again if navigating away
                        // showSystemBars()


                    }
                }
                // --- End System UI Visibility Control ---


                // --- Set the main Composable ---
                LeaveReservationScreen(
                    onStayClicked = { handleStayAction("Stay button clicked") },
                    onLeaveClicked = { handleLeaveAction("Leave button clicked") },
                    onCloseClicked = { handleLeaveAction("Close button clicked") }
                )
            }
        }
    }

    // --- Helper Functions for System Bars ---
    private fun hideSystemBars() {
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.hide(androidx.core.view.WindowInsetsCompat.Type.systemBars())
        windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }

    private fun showSystemBars() {
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.show(androidx.core.view.WindowInsetsCompat.Type.systemBars())
        // Optionally reset behavior if needed
    }


    // --- Action Handlers ---
    private fun handleStayAction(logMessage: String) {
        Log.d(TAG, logMessage)
        Toast.makeText(this, "Staying...", Toast.LENGTH_SHORT).show()
        // Add logic: dismiss, navigate back, etc.
        finish() // Example action
    }

    private fun handleLeaveAction(logMessage: String) {
        Log.d(TAG, logMessage)
        Toast.makeText(this, "Leaving...", Toast.LENGTH_SHORT).show()
        // Add logic: navigate away, confirm leave action, etc.
        finish() // Example action
    }
}

@Preview(showBackground = true, showSystemUi = true)
@androidx.compose.runtime.Composable
fun PreviewLeaveReservationScreen() {
    ComposeFigmaAppTheme {
        Surface {
            LeaveReservationScreen(
                onStayClicked = { /* Handle preview stay action */ },
                onLeaveClicked = { /* Handle preview leave action */ },
                onCloseClicked = { /* Handle preview close action */ })
        }
    }
}

