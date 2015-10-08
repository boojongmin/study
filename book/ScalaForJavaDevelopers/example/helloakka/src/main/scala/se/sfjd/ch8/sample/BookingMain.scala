package se.sfjd.ch8.sample

import akka.actor.{Actor, Props}
import akka.event.LoggingReceive

class BookingMain extends Actor {
  val flight = context.actorOf(Props[Flight], "Stockholm-Nassau" )
  val hotel = context.actorOf(Props[Hotel], "Atlantis")
  val travelAgent = context.actorOf(Props[TravelAgent], "ClubMed")
  travelAgent ! TravelAgent.BookTrip(flight, hotel, 20)

  def receive = LoggingReceive {
    case TravelAgent.Done =>
      println("Booking Successful")
      context.stop(self)
    case TravelAgent.Failed =>
      println("Booking Failed")
      context.stop(self)
  }
}
