package com.android.clutch.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.TextField
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.clutch.R

const val LOGIN_TEXT_FIELD_USER = "LOGIN_TEXT_FIELD_USER"
const val LOGIN_TEXT_FIELD_PASSWORD = "LOGIN_TEXT_FIELD_PASSWORD"

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    // Prueba de paso de parámetros
    onForgotClicked: (Int) -> Unit
) {

    var email by remember {
        // mutableStateOf("")
        mutableStateOf("david@gmail.com")
    }

    var password by remember {
        mutableStateOf("pass")
        //mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = R.drawable.agent_killjoy),
            contentDescription = "SuperHero Application"
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
        )

        TextField(
            modifier = Modifier.testTag(LOGIN_TEXT_FIELD_USER),
            value = email,
            placeholder = {
                  Text("Email")
            },
            onValueChange = { newValue ->
                email = newValue
            },
            leadingIcon = {
                Image(
                    imageVector = Icons.Default.Email,
                    contentDescription = ""
                )
            }
        )

        TextField(
            modifier = Modifier.testTag(LOGIN_TEXT_FIELD_PASSWORD),
            value = password,
            placeholder = {
                  Text("Password")
            },
            onValueChange = {
                password = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = ""
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Outlined.AccountBox,
                        contentDescription = ""
                    )
                }
            }
        )

        Spacer(
            modifier = Modifier
                .size(20.dp)
        )

        Button(
            onClick = {
                if (authenticate(email, password)) {
                    onLoginSuccess()
                }
            }
        ) {
            Text(
               text = stringResource(R.string.login)
            )
        }
        Spacer(
            modifier = Modifier
                .size(20.dp)
        )

        Button(
            onClick = {
                onForgotClicked.invoke(0)
            }
        ) {
            Text(
                text = "Forgot"
            )
        }

        /*
        onClick = {
        onLoginSuccess.invoke()
        onLoginSuccess()
        }
        */


    }
}

fun authenticateOld(user: String, password: String) =
    user == "david@gmail.com" && password == "pass"


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginSuccess = {

        },
        onForgotClicked = { test ->

        }
    )
}
