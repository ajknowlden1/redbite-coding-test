import api.GitHubAPIClient
import models.Contributor

fun main() {
    val api = GitHubAPIClient()
    val contributors: List<Contributor>? = api.getTopContributorsForRepo()
    contributors?.forEach {
        println("Username: ${it.login} Number of commits: ${it.contributions} Location: ${api.getUserLocation(it)}")
    }
}