package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Actions {

  //------------open

  val webtours = http("/webtours/")
    .get("/webtours/")
    .check(status is 200)

  val webtours2 = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("signOff", "true")
    .check(status is 200)
  val webtours3 = http("/cgi-bin/nav.pll")
    .get("/cgi-bin/nav.pl")
    .queryParam("in", "home")
    .check(regex(pattern = """name="userSession" value="(.*)\"""").saveAs("Session"))
    .check(status is 200)

  //------------login

  val webtours4 = http("/cgi-bin/login.pl")
    .post("/cgi-bin/login.pl")
    .formParam("userSession", "${Session}")
    .formParam("username", "${login}")
    .formParam("password", "${password}")
    .formParam("login.x", "29")
    .formParam("login.y", "19")
    .formParam("JSFormSubmit", "off")
    .check(status is 200)
  val webtours5 = http("/cgi-bin/login.pl")
    .get("/cgi-bin/login.pl")
    .queryParam("intro", "true")
    .check(status is 200)
  val webtours6 = http("/cgi-bin/nav.pll")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in","home")
    .check(status is 200)

  //------------open flights

  val webtours7 = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("page", "search")
    .check(status is 200)

  val webtours8 = http("/cgi-bin/reservations.pl")
    .get("/cgi-bin/reservations.pl")
    .queryParam("page", "welcome")
    .check(status is 200)

  val webtours9 = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "flights")
    .check(status is 200)

  //------------ticket

  val webtours10 = http("/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("depart", "${citystart}")
    .formParam("departDate", "08/22/2023")
    .formParam("arrive", "${cityover}")
    .formParam("returnDate", "08/23/2023")
    .formParam("numPassengers", "1")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("findFlights.x", "43")
    .formParam("findFlights.y", "9")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam(".cgifields", "seatPref")
    .check(regex(pattern = """name="outboundFlight" value="(.*)\"""").saveAs("outbound"))
    .check(status is 200)

  val webtours11 = http("/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("outboundFlight", "${outbound}")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("findFlights.x", "43")
    .formParam("findFlights.y", "9")
    .check(status is 200)

  val webtours12 = http("/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("firstName", "A")
    .formParam("lastName", "B")
    .formParam("address1", "36")
    .formParam("address2", "V")
    .formParam("pass1.x", "AB")
    .formParam("creditCard.y", "ASA")
    .formParam("expDate", "12221")
    .formParam("oldCCOption", "")
    .formParam("numPassengers", "1")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("outboundFlight", "${outbound}")
    .formParam("advanceDiscount", "0")
    .formParam("returnFlight", "")
    .formParam("JSFormSubmit", "off")
    .formParam("buyFlights.x", "37")
    .formParam("buyFlights.y", "9")
    .formParam(".cgifields", "saveCC")
    .check(status is 200)

  ///------------Itinerary

  val webtours13 = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("page", "itinerary")
    .check(status is 200)

  val webtours14 = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "itinerary")
    .check(status is 200)

  val webtours15 = http("/cgi-bin/itinerary.pl")
    .get("/cgi-bin/itinerary.pl")
    .check(status is 200)

  ///------------signoff

  val webtours16 = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("signOff", "1")
    .check(status is 200)

  val webtours17 = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("in", "home")
    .check(status is 200)

}

