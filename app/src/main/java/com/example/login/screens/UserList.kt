package com.example.login.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login.RegisterButton
import com.example.login.UserViewModel
import com.example.login.state.UserState
import com.example.login.utils.Screen

@Composable
fun UserList(userViewModel:UserViewModel,navController: NavController) {
    val userList = userViewModel.fetchUsers().observeAsState(arrayListOf())
    Box() {
        LazyColumn {
            userList.value.size.let {
                items(it){
                    Card(modifier = Modifier.padding(15.dp),
                        elevation = 10.dp,
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = MaterialTheme.colors.surface,
                    ) {
                        Box(modifier = Modifier
                            .height(200.dp)
                            .padding(20.dp)
                            .fillMaxWidth()) {
                            Column {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                ){
                                    Text("Full Name:-")

                                    Row(){
                                        Icon(
                                            imageVector = Icons.Filled.Person,
                                            contentDescription = ""
                                        )
                                        Text("${userList.value[it].firstName} ${userList.value[it].lastName}")
                                    }
                                }
                                Text(userList.value[it].lastName)
                                Text(userList.value[it].contactNumber)
                                Text(userList.value[it].emailAddress)

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