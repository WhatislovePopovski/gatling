package perf

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import perf.Actions._


object CommonScenario{
  def apply(): ScenarioBuilder = new CommonScenario().mainScenario
}

class CommonScenario {
  val open = group("open"){
  exec(webtoursmain)
  .exec(welcome)
  .exec(navpllhome)
    .pause(1)
  }
  val login = group("login"){
  exec(auth)
    .exec(auth2)
    .exec(navplmenu)
    .pause(1)
  }
  val openflights = group("openflights"){
    exec(webtourssearch)
      .exec(reservationswelcome)
      .exec(navplmenu2)
      .pause(1)
  }
  val ticketattributes = group ("ticketattributes"){
    exec(reservationsticket)
      .exec(reservationsticket2)
      .exec(reservationsticket3)
      .pause(1)
  }
  val Itinerary = group("Itinerary") {
    exec(welcomeitinerary)
      .exec(navplitinerary)
      .exec(itinerarypl)
      .pause(1)
  }
  val signoff = group("signoff") {
    exec(welcomeplsignOff)
      .exec(navplhome2)
      .pause(1)
  }
  val mainScenario = scenario("mainScenario")
    .feed(Feeders.users)
    .feed(Feeders.citystart)
    .feed(Feeders.cityover)
    .feed(Feeders.date)
    .exec(open)
    .exec(login)
    .exec(openflights)
    .exec(ticketattributes)
    .exec(Itinerary)
    .exec(signoff)
}
