
# OTP View Library for Jetpack Compose

A modern, highly customizable OTP (One-Time Password) input view built for Jetpack Compose. This library provides a clean and flexible way to implement OTP input in your Android applications.

## Features

- Built with Jetpack Compose
- Automatic cursor movement
- Password mode support
- Customizable styles (Border, Underline, or None)
- Configurable attributes:
  - Colors (container, text, background)
  - Size and spacing
  - Character count
  - Border radius
  - Text size
- Keyboard type options
- Real-time input validation

## Installation

Add the dependency to your app's build.gradle:

```gradle
dependencies {
    implementation 'com.code4galaxy:otpview:1.0.0'
}
```

## Basic Usage

```kotlin
var otpValue by remember { mutableStateOf("") }

OtpView(
    otpText = otpValue,
    onOtpTextChange = { otpValue = it }
)
```

## Advanced Usage

```kotlin
OtpView(
    otpText = otpValue,
    onOtpTextChange = { otpValue = it },
    type = OTP_VIEW_TYPE_BORDER,
    password = true,
    containerSize = 48.dp,
    passwordChar = "•",
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    charColor = Color.White
)
```

## Customization Options

### View Types
```kotlin
OTP_VIEW_TYPE_NONE      // No border or underline
OTP_VIEW_TYPE_UNDERLINE // With underline
OTP_VIEW_TYPE_BORDER    // With border
```

### Available Properties
| Property | Description | Default |
|----------|-------------|---------|
| otpText | Current OTP value | Required |
| charColor | Text color | Black |
| containerColor | Border/underline color | Same as charColor |
| selectedContainerColor | Active input color | Same as charColor |
| charBackground | Background color | Transparent |
| charSize | Text size | 16.sp |
| containerSize | Size of each character box | charSize * 2 |
| containerRadius | Border radius for border type | 4.dp |
| containerSpacing | Space between characters | 4.dp |
| otpCount | Number of characters | 4 |
| type | View type (none/underline/border) | OTP_VIEW_TYPE_UNDERLINE |
| enabled | Enable/disable input | true |
| password | Enable password mode | false |
| passwordChar | Character for password mode | "" |
| keyboardOptions | Input keyboard options | KeyboardType.Number |

## Example Implementation

```kotlin
@Composable
fun OtpVerificationScreen() {
    var otpValue by remember { mutableStateOf("") }
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Enter Verification Code")
        
        OtpView(
            otpText = otpValue,
            onOtpTextChange = { otpValue = it },
            type = OTP_VIEW_TYPE_BORDER,
            containerSize = 48.dp,
            otpCount = 6,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        
        Button(onClick = { validateOtp(otpValue) }) {
            Text("Verify")
        }
    }
}
```

## Styling Examples

### Border Style
```kotlin
OtpView(
    otpText = otpValue,
    onOtpTextChange = { otpValue = it },
    type = OTP_VIEW_TYPE_BORDER,
    containerColor = Color.Blue,
    charColor = Color.Black
)
```

### Underline Style
```kotlin
OtpView(
    otpText = otpValue,
    onOtpTextChange = { otpValue = it },
    type = OTP_VIEW_TYPE_UNDERLINE,
    containerColor = Color.Gray,
    selectedContainerColor = Color.Blue
)
```

### Password Mode
```kotlin
OtpView(
    otpText = otpValue,
    onOtpTextChange = { otpValue = it },
    password = true,
    passwordChar = "•"
)
```

## License

```
MIT License

Copyright (c) 2024 Code4Galaxy

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files.
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Support

For issues, feature requests, or questions, please file an issue on the GitHub repository.

---
Made with ❤️ by Code4Galaxy


<img src="https://github.com/user-attachments/assets/88ece3cf-285c-4e13-94a2-0a44da5b23fd" alt="image" width="250" height="500">



