import api.GitHubAPIClient
import models.Contributor

fun main(args: Array<String>) {
    val api = GitHubAPIClient();

    val contributors: List<Contributor> = api.getTopContributorsForRepo("https://api.github.com/repos/practical-tutorials/project-based-learning/contributors?per_page=25")

}