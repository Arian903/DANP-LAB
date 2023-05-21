package com.danp.lab03

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardAtendee(
    funFullname: (String) -> Unit,
    funEmail: (String) -> Unit,
    funPhone: (String) -> Unit,
    funBlood_type: (String) -> Unit,
    funRegistration_date: (String) -> Unit,
    funMount: (String) -> Unit,
    funTextButton: (String) -> Unit,
    funIsEditing: (Boolean) -> Unit,
    funDeleteAtendee: (String) -> Unit,
    atendee: Attendee
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)) {
            Text(text = atendee.fullname)
            Text(text = atendee.email)
            Text(text = atendee.registration_date)
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = {
                        funFullname(atendee.fullname)
                        funEmail(atendee.email)
                        funPhone(atendee.phone)
                        funBlood_type(atendee.blood_type)
                        funRegistration_date(atendee.registration_date)
                        funMount(atendee.mount)
                        funTextButton("Editar")
                        funIsEditing(true)
                    }
                ) {
                    Text(text = "Editar", color = Color.White)
                }

                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = {
                        funDeleteAtendee(atendee.email)
                    }
                ) {
                    Text(text = "Eliminar", color = Color.White)
                }
            }
        }
    }
}