package com.lab3ex3.labexercise3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MessageListScreen()
        }
    }
}

data class Message(
    val author: String,
    val body: String
)

val sampleMessages = listOf(
    Message("Wojtek1515", "ez"),
    Message("Wojtek1515", "ez"),
    Message("Wojtek1515", "ez"),
    Message("Wojtek1515", "ez"),
    Message("Mynamejeff127", "ez"),
    Message("Wojtek1515", "toxic"),
    Message("Joe", "noob"),
    Message("Indiasuperpower934", "y u smoke"),
    Message("JimboStansUncle", "yes"),
    Message("Elisio.Egpalina1998", "push mid"),
    Message("MidOrFeed", "push what?"),
    Message("Joe", "I hate autosniper"),
    Message("JimboStansUncle", "Joe Mama lmao")
)

@Composable
fun ComposableMessageItem(
    message: Message,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        verticalAlignment = Alignment.Top
    ) {

        //pfp
        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = Color.Red,
                    shape = CircleShape
                )
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "●",
                fontSize = 24.sp,
                color = Color.LightGray
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        //name & message
        Column {

            Text(
                text = message.author,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF4A4A4A),
                modifier = Modifier.padding(
                    start = 4.dp,
                    bottom = 4.dp
                )
            )

            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                shadowElevation = 0.5.dp,
                modifier = Modifier.border(
                    width = 0.5.dp,
                    color = Color.LightGray.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(16.dp)
                )
            ) {
                Text(
                    text = message.body,
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(
                        horizontal = 14.dp,
                        vertical = 8.dp
                    )
                )
            }
        }
    }
}

@Composable
fun MessageListScreen(
    messages: List<Message> = sampleMessages
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF7FA))
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                vertical = 12.dp
            )
        ) {
            items(messages) { message ->
                ComposableMessageItem(
                    message = message
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageListScreen() {
    MaterialTheme {
        MessageListScreen()
    }
}