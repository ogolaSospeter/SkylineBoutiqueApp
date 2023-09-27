package seniordeveloper.peter.skylineboutique.closetModel

data class ClosetData(
    val title: String,
    val price: Float,
    val category: String,
    val description: String,
    val image: String
)

data class UserLoginData(
    val username: String,
    val password: String
)
