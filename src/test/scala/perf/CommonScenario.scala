package perf

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import perf.Actions._

object CommonScenario{
  def apply(): ScenarioBuilder = new CommonScenario().mainScenario
}

class CommonScenario {
  val open = group("open"){
  exec(webtours)
  .exec(webtours2)
  .exec(webtours3)
    .pause(1)
  }
  val login = group("login"){
  exec(webtours4)
    .exec(webtours5)
    .exec(webtours6)
    .pause(1)
  }
  val openflights = group("openflights"){
    exec(webtours7)
      .exec(webtours8)
      .exec(webtours9)
      .pause(1)
  }
  val ticketattributes = group ("ticketattributes"){
    exec(webtours10)
      .exec(webtours11)
      .exec(webtours12)
      .pause(1)
  }
  val Itinerary = group("Itinerary") {
    exec(webtours13)
      .exec(webtours14)
      .exec(webtours15)
      .pause(1)
  }
  val signoff = group("signoff") {
    exec(webtours16)
      .exec(webtours17)
      .pause(1)
  }
  val mainScenario = scenario("mainScenario")
    .feed(Feeders.users)
    .feed(Feeders.citystart)
    .feed(Feeders.cityover)
    .exec(open)
    .exec(login)
    .exec(openflights)
    .exec(ticketattributes)
    .exec(Itinerary)
    .exec(signoff)
}
