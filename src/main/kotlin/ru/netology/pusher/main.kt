package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val token = "eKN8r1gSSAG8EQgcGk5nYn:APA91bH05Ph8qwQEWL_jO-LqIugWkcsrZFtkR0fXmvQmlcNxhpotVh53Ktb77Fuy8O960RmtdNsLoEUCmDhtiiwc6YPnyBBo1AeU0PCcsI88IU8FytTrWV5zCsM_pOUFu2x7ptTMa-Bi"
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postContentId": 2,
          "postContent": "Какой-то текст, какой-то текст, какой-то текст, какой-то текст,
           какой-то текст, какой-то текст, какой-то текст, какой-то текст, какой-то текст,
           какой-то текст, какой-то текст, какой-то текст, какой-то текст, какой-то текст,
           какой-то текст, какой-то текст, какой-то текст, какой-то текст, какой-то текст,
           какой-то текст, какой-то текст, какой-то текст, какой-то текст, какой-то текст,
           какой-то текст, какой-то текст, какой-то текст, какой-то текст, какой-то текст,
           какой-то текст, какой-то текст, какой-то текст, какой-то текст, какой-то текст,
           какой-то текст, какой-то текст, какой-то текст, какой-то текст, какой-то текст,
           какой-то текст, какой-то текст, какой-то текст, какой-то текст, какой-то текст,
           какой-то текст, какой-то текст, какой-то текст, какой-то текст, какой-то текст,
           какой-то текст, какой-то текст, какой-то текст, какой-то текст, какой-то текст,
           какой-то текст, какой-то текст, какой-то текст, какой-то текст, какой-то текст,"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}
