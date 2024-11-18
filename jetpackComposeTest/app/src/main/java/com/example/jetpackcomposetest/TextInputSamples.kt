package com.example.jetpackcomposetest

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text

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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp


@Composable
fun TextInputColumn() {
    val uriHandler = LocalUriHandler.current
    var email by rememberSaveable { mutableStateOf("Email") }
    var nombre by rememberSaveable { mutableStateOf("Nombre") }
    var apellido by remember { mutableStateOf("Apellido") }
    var CP by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    val numericRegex = Regex("[^0-9]")
    Column {
//Función más básica de introducir texto. He definido valor para que almacene lo escrito.
        BasicTextField(value = email, onValueChange = { email = it })
        if (email.isEmpty()) {
            Text(text = "Placeholder")
        }

//Con Text* tenemos más variedad de letra con menos código, lo que permite leerlo mejor. Juega con los parámetros en tu aplicación.
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            textStyle = TextStyle(
                color = Color.Blue, fontSize = 35.sp, fontWeight = FontWeight.Bold
            )
        )


        TextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text("Dos apellidos") }
        )


        OutlinedTextField(
            value = CP,
            onValueChange = { CP = it },
            label = { Text("Código Postal") }
        )

        TextField(
            value = contraseña,
            onValueChange = { contraseña = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        TextField(
            value = phoneNumber,
            onValueChange = {
                // Remove non-numeric characters.
                val stripped = numericRegex.replace(it, "")
                phoneNumber = if (stripped.length >= 10) {
                    stripped.substring(0..9)
                } else {
                    stripped
                }
            },
            label = { Text("Número de teléfono") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }

}


@Preview
@Composable
fun PreviewInput() {
    TextInputColumn()

}