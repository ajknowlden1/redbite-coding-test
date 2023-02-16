package models

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(val login: String, val location: String?)