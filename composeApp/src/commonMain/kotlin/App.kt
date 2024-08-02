import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import cinterop.composeapp.generated.resources.Res
import cinterop.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    var number by remember {
        mutableStateOf("")
    }
    var message by remember {
        mutableStateOf("")
    }

    val sender = rememberSmsLauncher()
    MaterialTheme {


        Column(
            modifier = Modifier.fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Message") })

            Spacer(Modifier.height(20.dp))
            TextField(
                value = number,
                onValueChange = { number = it },
                label = { Text("Number") },
            )
            Spacer(Modifier.height(20.dp))

            if (number.isNotEmpty() && message.isNotEmpty()) {
                Button(
                    onClick = { sender.sendSms(to = number, message = message) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Send")
                }
            }
        }

    }
}