package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.DraggableState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.ComposeTheme
import kotlinx.coroutines.launch
import kotlin.random.Random
import androidx.compose.material3.Text as Text

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fantail = FontFamily(
            Font(R.font.bungee_spice_regular, FontWeight.Bold)
        )
        setContent {
//            Row(modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.5f)
//                .background(Color.Green)
//                .border(3.dp, Color.Blue)
//                .padding(3.dp)
//                .border(3.dp, Color.Cyan)
//                .padding(3.dp)
//                .border(3.dp, Color.White),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround) {
//                Column(modifier = Modifier.fillMaxWidth(0.5f),verticalArrangement = Arrangement.SpaceAround) {
//                    Greeting(name = "Harpreet")
//                    Spacer(modifier = Modifier.height(50.dp))
//                    Greeting(name = "Partik")
//                }
//                Column(modifier = Modifier
//                    .fillMaxWidth(0.5f)
//                    .draggable(
//                        enabled = true,
//                        orientation = Orientation.Horizontal,
//                        state = DraggableState { }), verticalArrangement = Arrangement.SpaceAround) {
//                    Greeting(name = "Harpreet")
//                    Spacer(modifier = Modifier.height(50.dp))
//                    Greeting(name = "Partik")
//                }
//            }
//            val p = painterResource(id = R.drawable.logo)
//            ImageCard(painter = p, content = "ABC",title="DEF", modifier = Modifier.fillMaxSize(0.5f))
//            Box(modifier = Modifier
//                .fillMaxHeight(0.5f)
//                .background(color = Color.Gray)) {
//                Text(
//                    text = buildAnnotatedString {
//                                withStyle(
//                                    style = SpanStyle(
//                                        color = Color.Cyan
//                                    )) {
//                                        append("A")
//                                    }
//                        append("BCD")
//                    },
//                    color = Color.White,
//                    fontSize = 20.sp,
//                    fontFamily = fantail,
//                    fontStyle = FontStyle.Italic,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.fillMaxWidth(),
//                    textDecoration = TextDecoration.Underline
//                )
//            }
//            ColorBox(modifier = Modifier.fillMaxSize())
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            var textFieldState = remember {
                mutableStateOf("")
            }

//            val textFieldState = remember{ mutableStateOf("")}
            Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(
                        value = textFieldState,
                        label = {
                            Text("Enter Your Name")
                        },
                        onValueChange = {
                            textFieldState = it
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(onClick = {
                        scope.launch { scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState") }
                    }) {
                        Text("Greet Me")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name : String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        Greeting("Harpreet")
    }
}

@Composable
fun ImageCard(painter : Painter, content : String= "",title  : String= "",modifier:Modifier=Modifier){

        Box(
            modifier = modifier
        ) {
            Image(painter = painter, contentDescription = content, contentScale = ContentScale.Crop)
        }
}

@Composable
fun ColorBox(modifier : Modifier = Modifier){
    val color = remember {
        mutableStateOf(Color.Yellow) }
    Box(modifier = modifier
        .background(color = color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        })
}

