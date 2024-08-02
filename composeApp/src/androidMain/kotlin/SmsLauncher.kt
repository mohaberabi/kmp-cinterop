import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext


actual class SmsLauncher(
    private val context: Context,
) {
    actual fun sendSms(to: String, message: String) {


        Intent(Intent.ACTION_SEND).apply {
            data = Uri.parse("smsto:${to}")
            putExtra("sms_body", message)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }.also {
            context.startActivity(it)
        }


    }
}


@Composable
actual fun rememberSmsLauncher(): SmsLauncher {
    val context = LocalContext.current
    return remember { SmsLauncher(context) }
}