package perf

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class TestSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://webtours.load-test.ru:1090")
    .acceptHeader("text/html,application/xhtml+xml,application/xml")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .disableFollowRedirect
  val scn = CommonScenario()
  val steps = 10
  val stepDuration = 2.minutes
  val rampUpTime = 1.minute
  val targetRps = 10
  val stepUsers = for (i <- 1 to steps) yield {
    val rps = i * targetRps
    constantUsersPerSec(rps) during stepDuration
  }
  val stepLoadScenario = scenario("Step Load Scenario")
    .foreach(stepUsers, "users") {
      exec(scn)
        .pause(rampUpTime)
    }

  setUp(
    stepLoadScenario.inject(
      nothingFor(0),
      rampUsers(1) during 1.second
    )
  ).protocols(httpProtocol)
    .maxDuration(20.minutes)
}
