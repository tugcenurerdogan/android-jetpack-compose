package com.example.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MessageCard(message = Message("Zela","Hi, how are you?"))
                }
            }
        }
    }
}
data class Message(val author: String, val body : String)

@Composable
fun MessageCard(message: Message){
    Row (modifier = Modifier.padding(all = 10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = "Contact pp",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(5.dp))

        Column {
            Text(
                text = message.author,
                color= MaterialTheme.colors.secondaryVariant,
                style=MaterialTheme.typography.subtitle2,
                )

            Spacer(modifier = Modifier.height(3.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp){
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 6.dp),
                    style = MaterialTheme.typography.body2
                )
            }

        }
    }
}
@Preview(name = "Light Mode")
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
)
@Composable
fun PreviewMessageCard() {
    ComposeTheme {
        MessageCard(
            message = Message("Zela","Hi, how are you?")
        )
    }
}
