package perf

import io.gatling.core.Predef._

object Feeders {
 val users = csv("users.csv").circular
 val citystart = csv("citystart.csv").random
 val cityover = csv("cityover.csv").random
}
