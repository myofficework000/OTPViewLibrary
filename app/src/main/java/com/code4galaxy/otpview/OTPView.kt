package com.code4galaxy.otpview

import android.util.Log
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.code4galaxy.otpviewlibrary.OTP_VIEW_TYPE_BORDER
import com.code4galaxy.otpviewlibrary.OtpView

@Composable
fun TestingOTPView(modifier: Modifier = Modifier) {
    var otpValue by remember { mutableStateOf("") }

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
}

@Preview
@Composable
private fun PreviewTestingOTPView() {
    TestingOTPView()
}