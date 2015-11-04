import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

val future = Future {
  Thread.sleep(200)
  1 + 1
}

// i can wait indefinitely for computation to complete.
// val output = Await.result(future, Duration.Inf)

// i have stringent timelines about how much time my compuation actually takes.
//val output = Await.result(future, 100 millis)

//println(output)
