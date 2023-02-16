import api.GitHubAPIClient
import models.Contributor

fun main() {
    val api = GitHubAPIClient()
    val contributors: List<Contributor> = api.getTopContributorsForRepo("https://api.github.com/repos/practical-tutorials/project-based-learning/contributors?per_page=25")
    contributors.forEach {
        println("Username: ${it.login} Number of commits: ${it.contributions} Location: ${api.getUserLocation(it)}")
    }
}