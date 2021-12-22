package com.example.login

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationScreen() {
    Scaffold {
        Column(
            Modifier
                .verticalScroll(state = ScrollState(initial = 0))
                .fillMaxWidth()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Title(text = stringResource(id = R.string.registration), padding = 50)
            NameField(label = stringResource(id = R.string.fullName))
            NameField(label = stringResource(id = R.string.userName))
            PasswordField(pass = stringResource(id = R.string.password))
            PasswordField(pass = stringResource(id = R.string.confirmPassword))
            RegisterButton(context = LocalContext.current, stringResource(id = R.string.register))
        }
    }
}