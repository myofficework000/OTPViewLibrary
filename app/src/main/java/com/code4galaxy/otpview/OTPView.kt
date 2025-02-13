package com.code4galaxy.otpview

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.code4galaxy.otpviewlibrary.OTP_VIEW_TYPE_BORDER
import com.code4galaxy.otpviewlibrary.OtpView


@Composable
fun TestingOTPView(
    modifier: Modifier = Modifier
) {

    var otpValue by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(Color(0xFF3F51B5))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Verification Code",
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Text(
            modifier = Modifier.padding(32.dp),
            textAlign = TextAlign.Center,
            text = "Please type the verification code sent to +xxxxxxxxxxxx",
            color = Color.White,
        )
        OtpView(
            otpText = otpValue,
            onOtpTextChange = {
                otpValue = it
                Log.d("Actual Value", otpValue)
            },
            type = OTP_VIEW_TYPE_BORDER,
            password = true,
            containerSize = 48.dp,
            passwordChar = "•",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            charColor = Color.White
        )


        TextButton(modifier = Modifier.padding(32.dp), onClick = {
            if (otpValue == "1234") {
                Toast.makeText(context, "OTP is correct", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(context, "OTP is wrong", Toast.LENGTH_SHORT)
                    .show()
            }
        }) {
            Text(text = "Validate", color = Color.White)
        }
        Button(onClick = {
//            startActivity(Intent(context, ViewSystemExampleActivity::class.java))
        }) {
            Text(text = "View System Example")
        }
    }
}

//@Preview
//@Composable
//private fun PreviewTestingOTPView() {
//    TestingOTPView()
//}