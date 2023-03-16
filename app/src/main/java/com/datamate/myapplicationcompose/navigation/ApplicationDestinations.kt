package com.datamate.myapplicationcompose.navigation

interface ApplicationDestinations {
    val route: String
}
object Home: ApplicationDestinations {
    override val route: String
        get() = "Home"
}
object Details: ApplicationDestinations {
    override val route: String
        get() = "Details"
}