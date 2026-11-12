package com.example.habit_tracker.presentation.naviagtion

import kotlinx.serialization.Serializable
@Serializable
 sealed class Routes {
        @Serializable
        object Login : Routes()


        @Serializable
        object Signup : Routes()


        @Serializable
        object Task : Routes()

        @Serializable
        object Group : Routes()

        @Serializable
         object Calendar : Routes()

        @Serializable
        object Profile : Routes()


    }