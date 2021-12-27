package com.example.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun LoginScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Title(text = stringResource(id = R.string.signIn), padding = 90)
        NameField(stringResource(id = R.string.userName))
        PasswordField(pass = stringResource(id = R.string.password))
        RegisterButton( text = stringResource(id = R.string.submit)) {
            val todoItem = User(
                userId = 1,
                userFullName = "Dummy Item",
                userName = "item",
                password = "1234"
            )
            userDatabaseDAO.insert(todoItem)
        }


    }
}

@Composable
fun RegisterButton(text: String, callBack:()-> Unit) {
    Button(
        onClick = {
            callBack()
        },
        Modifier
            .fillMaxWidth()
            .size(55.dp), shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.White,
        )
    ) {
        Text(text = text)

    }

}

@Composable
fun PasswordField(pass:String) {
    var password by remember {
        mutableStateOf(TextFieldValue())
    }

    var visible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        value = password,
        onValueChange = {
            password = it
        },
        label = {
            Text(
                pass,
                fontSize = 16.sp,
                color = Color.Black
            )
        },
        trailingIcon = {
            if (visible) {
                IconButton(onClick = { visible = !visible }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = stringResource(
                            id = R.string.hidePassword
                        )
                    )
                }
            } else {
                IconButton(onClick = { visible = !visible }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = stringResource(
                            id = R.string.hidePassword
                        )
                    )
                }
            }
        },
        visualTransformation = if (!visible) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = Color.Black,
            disabledLabelColor = Color.Black,
            cursorColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black
        )
    )

}

@Composable
fun NameField(label: String) {
    var name by remember {
        mutableStateOf(TextFieldValue())
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        value = name, onValueChange = {
            name = it
        },
        label = {
            Text(
                text = label,
                fontSize = 16.sp,
                color = Color.Black
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = Color.Black,
            disabledLabelColor = Color.Black,
            cursorColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black
        )
    )

}

@Composable
fun Title(text: String,padding:Int) {
    Text(
        text = text,
        fontSize = 30.sp,
        modifier = Modifier.padding(vertical = padding.dp)
    )
}
