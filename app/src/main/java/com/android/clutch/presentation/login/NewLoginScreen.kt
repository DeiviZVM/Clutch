package com.android.clutch.presentation.login

import android.content.Context
import android.graphics.Paint.Align
import android.hardware.biometrics.BiometricManager
import android.hardware.biometrics.BiometricPrompt
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Fingerprint
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.ViewCompat.FocusDirection
import com.android.clutch.R
import com.android.clutch.presentation.components.CustomButtom
import com.android.clutch.presentation.components.CustomTextField
import com.android.clutch.presentation.components.PreferencesManager


@Composable
fun NewLoginScreen(
    onLoginSuccess: () -> Unit
) {

    val context = LocalContext.current

    val preferencesManager = remember { PreferencesManager(context) }
    val mailValue = rememberSaveable { mutableStateOf("david@gmail.com") }
    val passValue = rememberSaveable { mutableStateOf("password") }
    var passVisibility by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF84F4F)),
    ) {
        Image(
            painter = painterResource(id = R.drawable.valorant_icon_logo),
            contentDescription = "Login image",
            contentScale = ContentScale.Inside
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            ConstraintLayout {

                val (surface, fab) = createRefs()

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp)
                        .constrainAs(surface) {
                            bottom.linkTo(parent.bottom)
                        },
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStartPercent = 8,
                        topEndPercent = 8
                    )
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp, 0.dp, 20.dp, 0.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Bienvenido a Clutch",
                            style = MaterialTheme.typography.headlineLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(18.dp)
                        ) {
                            CustomTextField(
                                textFieldValue = mailValue,
                                textLabel = "Correo",
                                keyboardType = KeyboardType.Email,
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Down)
                                    }
                                ),
                                imeAction = ImeAction.Next
                            )

                            CustomTextField(
                                textFieldValue = passValue,
                                textLabel = "Contraseña",
                                keyboardType = KeyboardType.Password,
                                keyboardActions = KeyboardActions(
                                    onDone = {
                                        focusManager.clearFocus()

                                        //TODO Login
                                    }
                                ),
                                imeAction = ImeAction.Done,
                                trailingIcon = {
                                    IconButton(
                                        onClick = {
                                            passVisibility = !passVisibility
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (passVisibility) {
                                                Icons.Filled.RemoveRedEye
                                            } else {
                                                Icons.Outlined.RemoveRedEye
                                            },
                                            contentDescription = "Mostrar contraseña"
                                        )
                                    }
                                },
                                visualTransformation = if (passVisibility) {
                                    VisualTransformation.None
                                } else {
                                    PasswordVisualTransformation()
                                }
                            )

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "He olvidado la contraseña",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.End

                            )

                        }

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            CustomButtom(
                                text = "Iniciar sesión",
                                displayProgressBar = false,
                                onClick = {
                                    if (authenticate(mailValue.value, passValue.value)) {
                                        preferencesManager.saveData("user_name",
                                            mailValue.value.substring(0, mailValue.value.indexOf("@")))
                                        onLoginSuccess()

                                    } else {
                                        Toast.makeText(context,
                                            "Los datos de inicio de sesión no son correctos",
                                            Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }
                            )
                        }
                    }

                }
            }
        }
    }
}

//TODO - Cambiar para que admita correos con @gmail.com y pareceidos no uno solo
fun authenticate(user: String, password: String) =
    (user == "david@gmail.com" && password == "password"
            || user == "miguel@gmail.com" && password == "password")