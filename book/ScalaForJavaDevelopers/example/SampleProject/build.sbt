name := "SampleProject"

organization := "com.samples"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115"

libraryDependencies += "org.eclipse.jetty" % "jetty-plus" % "9.1.0.v20131115"

libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.2"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"

enablePlugins(JettyPlugin)

//
//lazy val commonSettings = Seq(
//  version := "0.1-SNAPSHOT",
//    organization := "com.example",
//      scalaVersion := "2.10.1"
//  )
//
//lazy val app = (project in file("app")).
//  settings(commonSettings: _*).
//  settings(
//	// your settings here
//  )



