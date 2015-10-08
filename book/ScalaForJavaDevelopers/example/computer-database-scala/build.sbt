name := """computer-database-scala"""

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.7"

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  evolutions,
  specs2 % Test,
  "com.typesafe.play" % "anorm_2.11" % "2.5.0",
  "org.apache.derby" % "derbyclient" % "10.10.2.0"
//  "com.typesafe.play" %% "anorm" % "2.4.0",
//  "org.webjars" % "jquery" % "2.1.4",
//  "org.webjars" % "bootstrap" % "3.3.5"
)     

lazy val root = (project in file(".")).enablePlugins(PlayScala)

routesGenerator := InjectedRoutesGenerator

fork in run := true