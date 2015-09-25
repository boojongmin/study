name := "SampleProject"

organization := "com.samples"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.7"

libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.11.7"

libraryDependencies += "org.scala-lang" % "scala-library" % "2.11.7"

libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115"

libraryDependencies += "org.eclipse.jetty" % "jetty-plus" % "9.1.0.v20131115"

libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.2"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"

//libraryDependencies += "org.scalatest" % "scalatest_2.10" % "3.0.0-M9"

//libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4"

libraryDependencies += "junit" % "junit" % "4.12"

libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "2.47.1"

libraryDependencies += "org.seleniumhq.selenium" % "selenium-htmlunit-driver" % "2.47.1"

libraryDependencies += "org.seleniumhq.selenium" % "selenium-api" % "2.47.1"

libraryDependencies += "org.scalamock" % "scalamock-scalatest-support_2.11" % "3.2.2"

libraryDependencies += "org.scalacheck" % "scalacheck_2.11" % "1.12.5"



//enablePlugins(JettyPlugin)
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



