package com.example.login

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.database.User
import com.example.login.database.UserDatabaseDAO
import com.example.login.utils.Screen

lateinit var userDatabaseDAO: UserDatabaseDAO

@Composable
fun RegistrationScreen(context: Context, navController: NavController) {

    val userViewModel: UserViewModel = UserViewModel(application = Application())
    var firstName by remember {
        mutableStateOf(TextFieldValue())
    }
    var lastName by remember {
        mutableStateOf(TextFieldValue())
    }
    var contactNumber by remember {
        mutableStateOf(TextFieldValue())
    }
    var emailAddress by remember {
        mutableStateOf(TextFieldValue())
    }
//    var visible by remember {
//        mutableStateOf(false)
//    }
//    var confirmPasswordVisibility by remember {
//        mutableStateOf(false)
//    }


//    val userDb: UserDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java)
//        .allowMainThreadQueries()
//        .build()
    Scaffold {
        Column(
            Modifier
                .verticalScroll(state = rememberScrollState())
                .fillMaxWidth()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Title(text = stringResource(id = R.string.registration), padding = 50)
            //First Name
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                value = firstName, onValueChange = {

                    firstName = it

                },
                label = {
                    Text(
                        text = stringResource(id = R.string.firstName),
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

            //user name
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                value = lastName, onValueChange = {
                    lastName = it

                },
                label = {
                    Text(
                        text = stringResource(id = R.string.lastName),
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

            //Contact Number
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                value = contactNumber,
                onValueChange = {
                    contactNumber = it
                },

                label = {
                    Text(
                        stringResource(id = R.string.contactNumber),
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                },
//                trailingIcon = {
//                    if (visible) {
//                        IconButton(onClick = { visible = !visible }) {
//                            Icon(
//                                imageVector = Icons.Filled.Visibility,
//                                contentDescription = stringResource(
//                                    id = R.string.hidePassword
//                                )
//                            )
//                        }
//                    } else {
//                        IconButton(onClick = { visible = !visible }) {
//                            Icon(
//                                imageVector = Icons.Filled.VisibilityOff,
//                                contentDescription = stringResource(
//                                    id = R.string.hidePassword
//                                )
//                            )
//                        }
//                    }
//                },
//                visualTransformation = if (!visible) {
//                    PasswordVisualTransformation()
//                } else {
//                    VisualTransformation.None
//                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = Color.Black,
                    disabledLabelColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )

            //Email Address
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                value = emailAddress,
                onValueChange = {
                    emailAddress = it
                },
                label = {
                    Text(
                        stringResource(id = R.string.emailAddress),
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                },
//                trailingIcon = {
//                    if (confirmPasswordVisibility) {
//                        IconButton(onClick = {
//                            confirmPasswordVisibility = !confirmPasswordVisibility
//                        }) {
//                            Icon(
//                                imageVector = Icons.Filled.Visibility,
//                                contentDescription = stringResource(
//                                    id = R.string.hidePassword
//                                )
//                            )
//                        }
//                    } else {
//                        IconButton(onClick = {
//                            confirmPasswordVisibility = !confirmPasswordVisibility
//                        }) {
//                            Icon(
//                                imageVector = Icons.Filled.VisibilityOff,
//                                contentDescription = stringResource(
//                                    id = R.string.hidePassword
//                                )
//                            )
//                        }
//                    }
//                },
//                visualTransformation = if (!confirmPasswordVisibility) {
//                    PasswordVisualTransformation()
//                } else {
//                    VisualTransformation.None
//                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = Color.Black,
                    disabledLabelColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )
            RegisterButton(stringResource(id = R.string.register)) {

                userViewModel.insertCustomer(

                    User(
                        firstName = firstName.text,
                        lastName = lastName.text,
                        contactNumber = contactNumber.text,
                        emailAddress = emailAddress.text
                    )
                )

                navController.navigate(Screen.UserScreen.route) {
                    popUpTo(Screen.RegisterScreen.route)
                }
            }
            Text("Login", modifier = Modifier.clickable {
                println("Clicked")
                navController.navigate("loginScreen")
            })
        }
    }

}