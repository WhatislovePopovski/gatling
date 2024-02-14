package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Actions {

  //------------open

  val webtoursmain = http("/webtours/")
    .get("/webtours/")
    .check(status is 200)

  val welcome = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("signOff", "true")
    .check(status is 200)

  val navpllhome = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("in", "home")
    .check(regex(pattern = """name="userSession" value="(.*)\"""").saveAs("Session"))
    .check(status is 200)

  //------------login

  val auth = http("/cgi-bin/login.pl")
    .post("/cgi-bin/login.pl")
    .formParam("userSession", "${Session}")
    .formParam("username", "${login}")
    .formParam("password", "${password}")
    .formParam("login.x", "29")
    .formParam("login.y", "19")
    .formParam("JSFormSubmit", "off")
    .check(status is 200)

  val auth2 = http("/cgi-bin/login.pl")
    .get("/cgi-bin/login.pl")
    .queryParam("intro", "true")
    .check(status is 200)

  val navplmenu = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in","home")
    .check(status is 200)

  //------------open flights

  val webtourssearch = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("page", "search")
    .check(status is 200)

  val reservationswelcome = http("/cgi-bin/reservations.pl")
    .get("/cgi-bin/reservations.pl")
    .queryParam("page", "welcome")
    .check(regex(pattern = """name="departDate" value="([^"]+)"""").saveAs("departDate"))
    .check(regex(pattern = """name="returnDate" value="([^"]+)"""").saveAs("returnDate"))
    .check(status is 200)

  val navplmenu2 = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "flights")
    .check(status is 200)

  //------------ticket
  val reservationsticket = http("/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("advanceDiscount", "0")
    .formParam("depart", "${citystart}")
    .formParam("departDate", "${departDate}")
    .formParam("arrive", "${cityover}")
    .formParam("returnDate", "${returnDate}")
    .formParam("numPassengers", "1")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("findFlights.x", "43")
    .formParam("findFlights.y", "9")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam(".cgifields", "seatPref")
    .check(regex(pattern = """name="outboundFlight" value="([^"]+)"""").saveAs("outbound"))
    .check(status is 200)

  val reservationsticket2 = http("/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("outboundFlight", "${outbound}")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("findFlights.x", "43")
    .formParam("findFlights.y", "9")
    .check(status is 200)

  val reservationsticket3 = http("/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("firstName", "Test")
    .formParam("lastName", "Testovski")
    .formParam("address1", "Chellus")
    .formParam("address2", "d 52")
    .formParam("pass1", "Test Testovski")
    .formParam("creditCard.y", "4857 4756 4767 1427")
    .formParam("expDate", "02/24")
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

  val welcomeitinerary = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("page", "itinerary")
    .check(status is 200)

  val navplitinerary = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "itinerary")
    .check(status is 200)

  val itinerarypl = http("/cgi-bin/itinerary.pl")
    .get("/cgi-bin/itinerary.pl")
    .check(status is 200)

  ///------------signoff

  val welcomeplsignOff = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("signOff", "1")
    .check(status is 200)

  val navplhome2 = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("in", "home")
    .check(status is 200)

}

