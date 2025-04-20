package com.prototype.compose_figma_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prototype.compose_figma_app.R // Import your R class
import com.prototype.compose_figma_app.ui.theme.* // Import your theme elements

@Composable
fun LeaveReservationScreen(
    onStayClicked: () -> Unit,
    onLeaveClicked: () -> Unit,
    onCloseClicked: () -> Unit
) {
    // Using Box to potentially allow easier absolute positioning if needed,
    // but Column with alignment modifiers works well here.
    Column(
        modifier = Modifier
            .fillMaxSize() // Fill the whole screen
            .background(BackgroundMain) // Set background color
            // Apply padding consistent with the edge-to-edge setup
            // Use systemBarsPadding() to avoid drawing under hidden bars if needed,
            // but manual padding often gives more control for specific designs.
            .padding(horizontal = 16.dp, vertical = 24.dp) // Main content padding
    ) {
        // Close Button
        IconButton(
            onClick = onCloseClicked,
            modifier = Modifier.align(Alignment.End) // Align to the top-right of the Column
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = stringResource(R.string.content_description_close),
                tint = TextPrimary
            )
        }

        Spacer(modifier = Modifier.height(12.dp)) // Space below close button

        // Title
        Text(
            text = stringResource(R.string.leave_reservation_title),
            style = TextStyle(lineHeight = 40.sp),
            fontSize = 32.sp, // Use sp for text sizes
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth() // Take full width for potential centering
                .padding(horizontal = 8.dp) // Smaller horizontal padding for text block
        )

        Spacer(modifier = Modifier.height(16.dp)) // Space below title

        // Accent Line
        Divider( // Or use Box(modifier = Modifier.height(4.dp).width(60.dp).background(PgaGreen))
            color = PgaGreen,
            thickness = 8.dp,
            modifier = Modifier
                .width(102.dp) // Specific width for the accent
                .padding(start = 8.dp) // Align with text block start
        )

        Spacer(modifier = Modifier.height(24.dp)) // Space below accent line

        // Body Text 1
        Text(
            text = stringResource(R.string.leave_info_1),
            color = TextSecondary,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(4.dp)) // Small space between text lines

        // Body Text 2
        Text(
            text = stringResource(R.string.leave_info_2),
            color = TextSecondary,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        // Spacer to push buttons to the bottom
        Spacer(modifier = Modifier.weight(1f))

        // Stay Button (Solid)
        Button(
            onClick = onStayClicked,
            shape = RoundedCornerShape(80.dp), // Button corner radius
            colors = ButtonDefaults.buttonColors(
                containerColor = PgaBlue, // Background color
                contentColor = Color.White // Text color
            ),
            modifier = Modifier
                .fillMaxWidth() // Make button span width
                .height(50.dp) // Specific button height
                .padding(horizontal = 8.dp) // Padding around button
        ) {
            Text(
                text = stringResource(R.string.button_stay),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp)) // Space between buttons

        // Leave Button (Outlined)
        OutlinedButton(
            onClick = onLeaveClicked,
            shape = RoundedCornerShape(80.dp),
            border = ButtonDefaults.outlinedButtonBorder.copy( // Use default as base
                width = 1.dp, // Adjust border width if needed
                // brush = SolidColor(PgaBlue) // Use brush for color
            ),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = PgaBlue // Text color
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = stringResource(R.string.button_leave),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Space below last button if needed
    }
}

// --- Preview Function ---
@Preview(showBackground = true, device = "id:pixel_6") // Example device
@Composable
fun LeaveReservationScreenPreview() {
    ComposeFigmaAppTheme {
        LeaveReservationScreen(
            onStayClicked = {},
            onLeaveClicked = {},
            onCloseClicked = {}
        )
    }
}