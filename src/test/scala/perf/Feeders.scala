package perf

import io.gatling.core.Predef._
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Feeders {
 val users = csv("users.csv").circular
 val citystart = csv("citystart.csv").random
 val cityover = csv("cityover.csv").random

 val currentDate: String = LocalDate.now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
 val date = Iterator.continually(Map("currentDate" -> currentDate))
}
