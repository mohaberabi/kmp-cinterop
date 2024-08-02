import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.mohaberabi.cinterop.SmsManager
import kotlinx.cinterop.ExperimentalForeignApi

actual class SmsLauncher {
    @OptIn(ExperimentalForeignApi::class)
    actual fun sendSms(
        to: String,
        message: String,
    ) {


        SmsManager.sendSmsTo(to = to, message = message)

    }
}


@Composable
actual fun rememberSmsLauncher(): SmsLauncher {
    return remember { SmsLauncher() }
}