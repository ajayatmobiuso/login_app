package com.example.login.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login.R
import com.example.login.RegisterButton
import com.example.login.database.UserViewModel
import com.example.login.utils.Screen

@Composable
fun UserList(userViewModel: UserViewModel, navController: NavController) {
    val userList = userViewModel.fetchUsers().observeAsState(arrayListOf())
    Box() {
        LazyColumn {
            userList.value.size.let {
                items(it) {
                    Card(
                        modifier = Modifier.padding(15.dp),
                        elevation = 10.dp,
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = MaterialTheme.colors.surface,
                    ) {
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .padding(20.dp)
                                .fillMaxWidth()
                        ) {

                            Row() {
                                Column(Modifier.weight(1f)) {
                                    Text("${stringResource(id = R.string.fullName)}:-")
                                    Text("${stringResource(id = R.string.contactNumber)}:-")
                                    Text("${stringResource(id = R.string.emailAddress)}:-")
                                }
                                Column(Modifier.weight(1f)) {

                                    Row(
                                        horizontalArrangement = Arrangement.Start,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Person,
                                            contentDescription = ""
                                        )
                                        Box(Modifier.width(5.dp))
                                        Text("${userList.value[it].firstName} ${userList.value[it].lastName}")
                                    }
                                    Row(
                                        horizontalArrangement = Arrangement.Start,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.MobileFriendly,
                                            contentDescription = ""
                                        )
                                        Box(Modifier.width(5.dp))
                                        Text(userList.value[it].contactNumber)
                                    }

                                    Row(
                                        horizontalArrangement = Arrangement.Start,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Email,
                                            contentDescription = ""
                                        )
                                        Box(Modifier.width(5.dp))
                                        Text(userList.value[it].emailAddress)
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
        Box(
            Modifier.height(20.dp)
        )
        RegisterButton(text = "Add Users") {
            navController.navigate(Screen.RegisterScreen.route)
        }
    }


}