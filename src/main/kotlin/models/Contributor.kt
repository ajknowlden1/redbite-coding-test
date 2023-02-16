package models

import kotlinx.serialization.Serializable
@Serializable
data class Contributor(val login: String, val contributions: Int, val location: String?)
