import scala.async.Async._
import scala.concurrent.ExecutionContext.Implicits._

object TetstMain extends App {
  val computation = async { 3 * 2 }
  await {
    tln(computation.value)
  }

  val longComputation = async { Thread.sleep(3000); 3 * 2 }
  println(longComputation.value)

  val longComputation2 = async { Thread.sleep(3000); 3 * 2 }
  longComputation2.onComplete(println)

  println("hello")
}