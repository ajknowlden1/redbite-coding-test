package api

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import models.Contributor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class GitHubAPIClient {

    private val client: OkHttpClient = OkHttpClient();
    fun getTopContributorsForRepo(url: String): List<Contributor>
    {
        val request: Request = Request.Builder()
            .url("https://api.github.com/repos/practical-tutorials/project-based-learning/contributors?per_page=25")
            .build();
        var response: Response = client.newCall(request).execute()

        val contributors: List<Contributor> = Json {
            ignoreUnknownKeys = true
        }.decodeFromString(response.body!!.string());

        return contributors
    }

}