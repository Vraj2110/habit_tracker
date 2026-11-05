package com.example.habit_tracker.presentation.naviagtion

import kotlinx.serialization.Serializable

class Routes {

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
        data class Calendar(val productId: Int) : Routes()

        @Serializable
        object Profile : Routes()


    }
}