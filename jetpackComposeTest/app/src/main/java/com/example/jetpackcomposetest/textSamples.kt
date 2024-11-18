package com.example.jetpackcomposetest
/*
https://devexpert.io/text-jetpack-compose/
Para una página que lo diga lento

 */


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
//importa las funciones necesarias para que MutableState sea pueda delegar sus propiedades en el by
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
//
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.LocalTextStyle
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp


@Composable
fun textSamplesColumn() {
    Column {
        //Defino por claridad las variables necesarias aquí. Volved cuando veáis la referencia para entenderlo.
        val cicero = stringResource(R.string.cicero)
        val cicero2 = stringResource(R.string.cicero2)
        val aplicacion = stringResource(R.string.app_name)
        val offset = Offset(5.0f, 10.0f)
        val gradientColors = listOf(Color.Cyan, Color.LightGray, Color.Magenta /*...*/)


        //



        //Función más básica de texto
        BasicText("El texto más necio que os vais a encontrar")


        //Estas funciones son preferidas por alinearse con Material Design
        Text("Este texto es normal")
        //Obviamente, value puede aceptar variables.
        Text(aplicacion,textDecoration = TextDecoration.LineThrough)
        //Ahora vamos a jugar con algunos valores de Text
        Text("Hello World", fontStyle = FontStyle.Italic)
        Text("Hello World", fontWeight = FontWeight.Bold)
        Text("Hello World", fontSize = 30.sp)
        Text("Hello World", color = Color.Blue)
        Text(
            "Hello World", textAlign = TextAlign.Center, modifier = Modifier.width(150.dp)
        )


        Text(
            text = "Hello world!",
            style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.Blue, offset = offset, blurRadius = 3f
                )
            )
        )
        Row {
            Text("Hello World", fontFamily = FontFamily.Serif)
            Text("Hello World", fontFamily = FontFamily.SansSerif)
        }
        //Por supuesto, Text maneja variedad de estilos
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("H")
                }
                append("ello ")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                    append("W")
                }
                append("orld")
            }
        )
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("Hello\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold, color = Color.Red
                        )
                    ) {
                        append("World\n")
                    }
                    append("Compose")
                }
            }
        )
        //En los siguientes ejemplos vemos cómo acotar los cuadros de texto
        Text("hello ".repeat(50), maxLines = 2)
        Text("hello ".repeat(20),minLines=3)
        Text("Hello Compose ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
        //Seguir por aquí



        Text(
            text = cicero,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            )
        )


        // [START android_compose_text_annotatedString_brush]
        Text(
            text = cicero2,
            style = LocalTextStyle.current.merge(
                TextStyle(
                    lineHeight = 2.5.em,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    ),
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.None
                    )
                )
            )
        )

        SelectionContainer {
            Column {
                    Text("This text is selectable")
                    Text("This one too")
                    Text("This one as well")
                    DisableSelection {
                        Text("But not this one")
                        Text("Neither this one")
                    }
                    Text("But again, you can select this one")
                    Text("And this one too")
            }
        }



        Spacer(            Modifier.height(10.dp))
        Text(
            text = cicero,
            modifier = Modifier
                .width(220.dp)
                .border(BorderStroke(1.dp, Color.Gray)),
            fontSize = 14.sp,
            style = TextStyle.Default.copy(
                lineBreak = LineBreak.Paragraph
            )
        )


    }
}

@Preview
@Composable
fun PreviewText() {
    textSamplesColumn()

}