name := "calendar-holidays"

version in Global := "1.0"

scalaVersion in Global := "2.11.8"

val `com.typesafe.scala-logging_scala-logging` = "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"

lazy val restapi = Project("restapi", file("restapi"))
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin).settings(
  libraryDependencies ++= Seq(
    `com.typesafe.scala-logging_scala-logging`
  )
)

libraryDependencies ++= Seq("org.specs2" %% "specs2-mock" % "3.8" % "test")
