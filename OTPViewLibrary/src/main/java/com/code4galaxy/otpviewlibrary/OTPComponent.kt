package com.code4galaxy.otpviewlibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Constants representing OTP view styles.
 */
const val OTP_VIEW_TYPE_NONE = 0
const val OTP_VIEW_TYPE_UNDERLINE = 1
const val OTP_VIEW_TYPE_BORDER = 2

/**
 * A customizable OTP input view.
 *
 * @param otpText The current OTP input value.
 * @param modifier Modifier for styling.
 * @param charColor Color of the OTP characters.
 * @param containerColor Default color of the OTP container.
 * @param selectedContainerColor Highlighted container color when focused.
 * @param charBackground Background color of each character box.
 * @param charSize Font size of each character.
 * @param containerSize Size of each OTP box.
 * @param containerRadius Corner radius of the OTP box.
 * @param containerSpacing Spacing between OTP boxes.
 * @param otpCount Number of OTP digits.
 * @param type OTP box style (None, Underline, or Border).
 * @param enabled Whether the field is enabled.
 * @param password Whether to hide characters (for password-style input).
 * @param passwordChar Masking character for password input.
 * @param keyboardOptions Keyboard options for input type.
 * @param onOtpTextChange Callback invoked when OTP text changes.
 */
@Composable
fun OtpView(
    otpText: String,
    modifier: Modifier = Modifier,
    charColor: Color = Color.Black,
    containerColor: Color = charColor,
    selectedContainerColor: Color = charColor,
    charBackground: Color = Color.Transparent,
    charSize: TextUnit = 16.sp,
    containerSize: Dp = charSize.value.dp * 2,
    containerRadius: Dp = 4.dp,
    containerSpacing: Dp = 4.dp,
    otpCount: Int = 4,
    type: Int = OTP_VIEW_TYPE_UNDERLINE,
    enabled: Boolean = true,
    password: Boolean = false,
    passwordChar: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    onOtpTextChange: (String) -> Unit
) {
    BasicTextField(
        modifier = modifier,
        value = otpText,
        onValueChange = {
            if (it.length <= otpCount) {
                onOtpTextChange.invoke(it)
            }
        },
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        decorationBox = {
            Row(horizontalArrangement = Arrangement.spacedBy(containerSpacing)) {
                repeat(otpCount) { index ->
                    CharView(
                        index = index,
                        otpCount = otpCount,
                        text = otpText,
                        charColor = charColor,
                        containerColor = containerColor,
                        highlightColor = selectedContainerColor,
                        charSize = charSize,
                        containerRadius = containerRadius,
                        containerSize = containerSize,
                        type = type,
                        charBackground = charBackground,
                        password = password,
                        passwordChar = passwordChar,
                    )
                }
            }
        }
    )
}

/**
 * A single character view for the OTP input.
 *
 * @param index Position of the character in the OTP field.
 * @param otpCount Total number of OTP digits.
 * @param text Current OTP input.
 * @param charColor Text color of the character.
 * @param highlightColor Color for highlighted (focused) box.
 * @param containerColor Default box color.
 * @param charSize Font size of the character.
 * @param containerSize Size of the character box.
 * @param containerRadius Corner radius for the box.
 * @param type Style type (None, Underline, or Border).
 * @param charBackground Background color of the character box.
 * @param password Whether to mask characters.
 * @param passwordChar Masking character for password input.
 */
@Composable
private fun CharView(
    index: Int,
    otpCount: Int,
    text: String,
    charColor: Color,
    highlightColor: Color,
    containerColor: Color,
    charSize: TextUnit,
    containerSize: Dp,
    containerRadius: Dp,
    type: Int = OTP_VIEW_TYPE_UNDERLINE,
    charBackground: Color = Color.Transparent,
    password: Boolean = false,
    passwordChar: String = ""
) {
    val containerColor2 =
        if (index == text.length || (index == otpCount - 1 && text.length == otpCount)) highlightColor else containerColor

    val modifier = if (type == OTP_VIEW_TYPE_BORDER) {
        Modifier
            .size(containerSize)
            .border(
                width = 1.dp,
                color = containerColor2,
                shape = RoundedCornerShape(containerRadius)
            )
            .padding(bottom = 4.dp)
            .clip(RoundedCornerShape(containerRadius))
            .background(charBackground)
    } else Modifier
        .width(containerSize)
        .background(charBackground)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val char = when {
            index >= text.length -> ""
            password -> passwordChar
            else -> text[index].toString()
        }
        Text(
            text = char,
            color = charColor,
            modifier = modifier.wrapContentHeight(),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = charSize,
            textAlign = TextAlign.Center,
        )
        if (type == OTP_VIEW_TYPE_UNDERLINE) {
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = Modifier
                    .background(charColor)
                    .height(1.dp)
                    .width(containerSize)
            )
        }
    }
}

/**
 * Preview of the OTP View.
 */
@Composable
@Preview
fun previewOtp() {
    OtpView(otpText = "1234", onOtpTextChange = {})
}
