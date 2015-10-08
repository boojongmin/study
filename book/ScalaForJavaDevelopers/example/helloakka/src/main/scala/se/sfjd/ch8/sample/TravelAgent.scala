package se.sfjd.ch8.sample

import akka.actor.SupervisorStrategy.{Stop, Restart}
import akka.actor.{OneForOneStrategy, Actor, ActorRef}
import akka.event.{Logging, LoggingReceive}

object TravelAgent {
  case class BookTrip(transport:ActorRef, accomodation: ActorRef, nbOfPersons: Int)
  case object Done
  case object Failed
}

class TravelAgent extends Actor {
  val log = Logging(context.system, this)
  override def preStart() = {
    log.info("Starting TravelAgent")
  }

  import TravelAgent._

  def receive = LoggingReceive {
    case BookTrip(flightAgent, hotelAgent, persons) =>
      flightAgent ! Flight.BookSeat(persons)
      hotelAgent ! Hotel.BookRoom(persons)
      context.become(awaitTransportOrAccomodation(flightAgent, hotelAgent, sender))
  }


  def awaitTransportOrAccomodation(transport:ActorRef, accomodation: ActorRef, customer: ActorRef): Receive = LoggingReceive {
    case Flight.Done =>
      context.become(awaitAccomodation(customer))
    case Hotel.Done =>
      context.become(awaitTransport(customer))
    case Flight.Failed | Hotel.Failed =>
      customer ! Failed
      context.stop(self)
  }

  def awaitTransport(customer: ActorRef): Receive = LoggingReceive {
    case Flight.Done =>
      customer ! Done
      context.stop(self)
    case Flight.Failed =>
      customer ! Failed
      context.stop(self)
  }

  def awaitAccomodation(customer: ActorRef): Receive = LoggingReceive {
    case Hotel.Done =>
      customer ! Done
      context.stop(self)
    case Hotel.Failed =>
      customer ! Failed
      context.stop(self)
  }

  override val supervisorStrategy = OneForOneStrategy(loggingEnabled = false) {
    case _:Flight.FlightBookingException =>
      log.warning("Flight Service Failed. restarting")
      Restart
    case _: Hotel.HotelBookingException =>
      log.warning("Hotel Service Failed. Restarting")
      Restart
    case e =>
      log.error("Unexpected failure", e.getMessage)
      Stop
  }

}
