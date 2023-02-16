package api

import models.Contributor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GitHubAPIClientTest {

    private val api = GitHubAPIClient()

    @Test
    fun shouldReturnTheTop25Contributors() {
        val result: List<Contributor>? = api.getTopContributorsForRepo("https://api.github.com/repos/practical-tutorials/project-based-learning/contributors?per_page=25")
        assertTrue(result?.size == 25)
    }

    @Test
    fun shouldReturnContributorsSortedByNumberOfCommits() {
        val result: List<Contributor>? = api.getTopContributorsForRepo("https://api.github.com/repos/practical-tutorials/project-based-learning/contributors?per_page=25")
        val sorted: List<Contributor>? = result?.sortedByDescending { it.contributions }
        assertEquals(result, sorted)
    }

    @Test
    fun shouldReturnUserLocationIfItIsKnown() {
        val user = Contributor("ajknowlden1", 0)
        val result: String = api.getUserLocation(user)
        assertEquals(result, "United Kingdom")
    }
}