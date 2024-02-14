package perf

import io.gatling.http.Predef._
import io.gatling.core.Predef._

class TestSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://webtours.load-test.ru:1090")
    .acceptHeader("text/html,application/xhtml+xml,application/xml")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .disableFollowRedirect

  setUp(
    CommonScenario().inject(
      incrementUsersPerSec(0.059)
        .times(10)
        .eachLevelLasting(120)
        .separatedByRampsLasting(0)
        .startingFrom(0)
    )
  ).protocols(httpProtocol)
    .maxDuration(1200)
}

