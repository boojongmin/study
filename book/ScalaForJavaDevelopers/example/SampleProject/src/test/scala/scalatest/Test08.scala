package scalatest

import org.openqa.selenium.{WebElement, By, WebDriver}
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FlatSpec, Matchers}

class Test08 extends FlatSpec with Matchers with WebBrowser{
//  implicit val webDriver: WebDriver = new HtmlUnitDriver
//  go to "http://www.amazon.com"
//  click on id("twotabesearchtextbox")
////  textField("twotabsearchtextbox").value = "Scala"
//  submit()
//  pageTitle should be ("Amazon.com: Scala")
//  pageSource should include ("Scala Cookbook: Recipes")
  val webDriver: WebDriver = new HtmlUnitDriver
  webDriver get "http://www.amazon.com"
  val element: WebElement  =webDriver findElement By.id( "twotabsearchtextbox" )
  element sendKeys "Scala"
  element submit()

  webDriver.getTitle() should be ("Amazon.com: Scala")

}
