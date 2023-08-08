package com.android.clutch.presentation.login

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.platform.LocalFocusManager
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

@Composable
fun NewLoginScreen() {

    val mailValue = rememberSaveable { mutableStateOf("") }
    val passValue = rememberSaveable { mutableStateOf("") }
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
                        .height(480.dp)
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
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Bienvenido a Clutch",
                            style = MaterialTheme.typography.headlineLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                        )

                        Text(
                            text = "Inicie sesión",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Medium
                            )
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
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
                                            imageVector = if(passVisibility) {
                                                Icons.Default.Star
                                            }else{
                                                Icons.Default.ArrowForward
                                            },
                                            contentDescription = "Mostrar contraseña"
                                        )
                                    }
                                },
                                visualTransformation = if(passVisibility){
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
                                    //TODO LOGIN
                                }
                            )

                            ClickableText(
                                text = buildAnnotatedString {
                                       append("¿No tienes cuenta?")

                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold
                                        )
                                    ){
                                        append("Registrarse")
                                    }
                                }
                            ){
                                //TODO REGISTER
                            }
                        }
                    }

                }

                FloatingActionButton(
                    modifier = Modifier
                        .size(72.dp)
                        .constrainAs(fab) {
                            top.linkTo(surface.top, margin = (-36).dp)
                            end.linkTo(surface.end, margin = 36.dp)
                        },
                    contentColor = Color.White,
                    containerColor = Color(0xFFF84F4F),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        modifier = Modifier.size(42.dp),
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Forward Icon",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun NewLoginScreenPreview() {
    NewLoginScreen()
}