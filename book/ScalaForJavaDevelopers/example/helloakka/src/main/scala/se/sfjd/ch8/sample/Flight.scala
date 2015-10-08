package se.sfjd.ch8.sample

import java.util.concurrent.ThreadLocalRandom

import akka.actor.Actor
import akka.event.LoggingReceive

object Flight {
  case class BookSeat(number:Int) {
    require(number >0)
  }
  case object Done
  case object Failed

  class FlightBookingException extends Exception("Unavailable Flight Booking Service")

}

class Flight extends Actor {
  import Flight._
  var seatsLeft = 50


  //  override def receive: Receive = ???
  def receive = LoggingReceive {
    case BookSeat(nb) if nb <= seatsLeft =>
      unreliable()
      seatsLeft -= nb
      sender ! Done
    case _ => sender ! Failed
  }


  def unreliable(): Unit = if(ThreadLocalRandom.current().nextDouble() < 0.25) throw new FlightBookingException

}
