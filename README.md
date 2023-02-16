# Redbite Coding Test

A simple command line application for fetching the top 25 contributors for a GitHub repository ordered by the number of
commits, and displaying the username, number of commits and location, if it is known.

## Setup

### Authorisation
You will need to edit the `local.properties` file and add a GitHub personal access token in place of `YOUR_TOKEN_HERE`
to use this application. This is because the GitHub API is rate-limited, and non-authenticated users are limited to
60 requests per hour.
