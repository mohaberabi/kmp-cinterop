import androidx.compose.runtime.Composable

expect class SmsLauncher {
    fun sendSms(
        to: String,
        message: String,
    )

}


@Composable
expect fun rememberSmsLauncher(): SmsLauncher