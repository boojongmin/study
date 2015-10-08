import scala.async.Async._
import scala.concurrent.ExecutionContext.Implicits._

val computation = async { 3 * 2 }
await(computation)

val longComputation = async { Thread.sleep(3000); 3 * 2 }
await(longComputation)

val longComputation2 = async { Thread.sleep(3000); 3 * 2 }
longComputation2.onComplete(println)

