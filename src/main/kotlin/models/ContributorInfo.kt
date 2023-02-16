package models

import kotlinx.serialization.Serializable

@Serializable
data class ContributorInfo(val login: String, val location: String?)