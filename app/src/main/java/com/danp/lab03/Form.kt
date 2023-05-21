package com.danp.lab03

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun Form(
    fullname: String,
    funFullname: (String) -> Unit,
    registration_date: String ,
    funRegistration_date: (String) -> Unit,
    blood_type: String,
    funBlood_type: (String) -> Unit,
    phone: String,
    funPhone: (String) -> Unit,
    email: String,
    funEmail: (String) -> Unit,
    mount: String,
    funMount: (String) -> Unit,
    isEditing: Boolean,
    funIsEditing: () -> Unit,
    textButton: String,
    funTextButton: (String) -> Unit,
    listAtendees: MutableList<Attendee>,
    funResetFields: () -> Unit
){
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = fullname,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funFullname(it) },
        label = { Text(text = "Nombre completo") }
    )
    Spacer(modifier = Modifier.padding(vertical = 6.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funEmail(it) },
        label = { Text(text = "Email") }
    )
    Spacer(modifier = Modifier.padding(vertical = 6.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = phone,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funPhone(it) },
        label = { Text(text = "Telefono") }
    )
    Spacer(modifier = Modifier.padding(vertical = 6.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = blood_type,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funBlood_type(it) },
        label = { Text(text = "Tipo de Sangre") }
    )
    Spacer(modifier = Modifier.padding(vertical = 6.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = registration_date,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funRegistration_date(it) },
        label = { Text(text = "Fecha registo") }
    )
    Spacer(modifier = Modifier.padding(vertical = 6.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = mount,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funMount(it) },
        label = { Text(text = "Monto") }
    )
    Spacer(modifier = Modifier.padding(vertical = 6.dp))
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
        onClick = {
            if (isEditing) {
                editAtendee(fullname, email, phone, blood_type, registration_date, mount, listAtendees)
                funTextButton("Agregar asistente")
                funIsEditing()
            } else {
                addAtendee(fullname, email, phone, blood_type, registration_date, mount, listAtendees)
            }
            funResetFields()

        }) {
        Text(
            color = Color.White,
            text = textButton
        )

    }
}