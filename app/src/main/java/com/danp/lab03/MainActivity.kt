package com.danp.lab03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val listAtendees = remember { mutableStateListOf<Attendee>() }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()){
                    ScreenCRUD(listAtendees)
                    }
                }
        }
    }
}


@Composable
fun ScreenCRUD(listAtendees: MutableList<Attendee>){
    var fullname by remember { mutableStateOf("") }
    var registration_date by remember { mutableStateOf("") }
    var blood_type by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mount by remember { mutableStateOf( "" ) }
    var isEditing by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar asistente") }

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(12.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {
            Form(
                fullname = fullname,
                funFullname = { fullname = it },
                registration_date = registration_date,
                funRegistration_date = { registration_date = it },
                blood_type = blood_type,
                funBlood_type = { blood_type = it },
                phone = phone,
                funPhone = { phone = it },
                email = email,
                funEmail = { email = it },
                mount = mount,
                funMount = { mount = it },
                isEditing = isEditing,
                funIsEditing = { isEditing = false },
                textButton = textButton,
                funTextButton = { textButton = it },
                listAtendees = listAtendees,
                funResetFields = {
                    fullname = ""
                    registration_date = ""
                    blood_type = ""
                    phone = ""
                    email = ""
                    mount = ""
                }
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(listAtendees) { atendee ->

                        CardAtendee(
                            funFullname = { fullname = it },
                            funEmail = { email = it },
                            funPhone = { phone = it },
                            funBlood_type = { blood_type = it },
                            funRegistration_date = { registration_date = it },
                            funMount = { mount = it },
                            atendee = atendee,
                            funTextButton = { textButton = it },
                            funIsEditing = { isEditing = it },
                            funDeleteAtendee = { deleteAtendee(it, listAtendees) }
                        )
                    }
                }
            }
        }
    }
}
fun addAtendee(fullname: String, email: String, phone: String, blood_type: String, registration_date: String, mount: String, listAtendees: MutableList<Attendee>) {
    listAtendees.add(Attendee(fullname, email, phone, blood_type, registration_date, mount))
}

fun editAtendee(fullname: String, email: String, phone: String, blood_type: String, registration_date: String, mount: String, listAtendees: MutableList<Attendee>) {
    listAtendees.forEach { atendee ->
        if (atendee.email == email) {
            atendee.email = email
            atendee.fullname = fullname
            atendee.phone = phone
            atendee.blood_type = blood_type
            atendee.registration_date = registration_date
            atendee.mount = mount
        }
    }
}

fun deleteAtendee(email: String, listAtendees: MutableList<Attendee>) {
    listAtendees.forEach { atendee ->
        if (atendee.email == email) {
            listAtendees.remove(atendee)
        }
    }
}