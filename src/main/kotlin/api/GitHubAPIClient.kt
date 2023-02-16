package api

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import models.Contributor
import models.ContributorInfo
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.File
import java.io.FileInputStream
import java.util.Properties

class GitHubAPIClient {

    private val client: OkHttpClient = OkHttpClient()
    private val json = Json {
        ignoreUnknownKeys = true
    }
    private val token: String = Properties().apply {
        load(FileInputStream(File("local.properties")))
    }.getProperty("TOKEN")
    fun getTopContributorsForRepo(url: String): List<Contributor>?
    {
        val request: Request = Request.Builder()
            .url(url)
            .header("Authorization", "Bearer $token")
            .build()

        val response: Response = client.newCall(request).execute()

        return response.body?.string()?.let { json.decodeFromString(it) }
    }
    fun getUserLocation(user: Contributor): String {

        val request: Request = Request.Builder()
            .url("https://api.github.com/users/${user.login}")
            .header("Authorization", "Bearer $token")
            .build()

        val response: Response = client.newCall(request).execute()

        val contributorInfo: ContributorInfo = json.decodeFromString(response.body!!.string())

        return contributorInfo.location ?: "Unknown"
    }
}