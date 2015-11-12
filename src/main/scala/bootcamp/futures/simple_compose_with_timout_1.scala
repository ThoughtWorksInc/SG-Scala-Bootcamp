package bootcamp.futures

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

/**
 * Created by ravikupin on 9/11/15.
 */
object simple_compose_with_timout_1 extends App {
 println("testing of composing futures")

 val timeout = 2 seconds
 val tasks = List(3000, 1200, 1800, 600, 250, 1000, 1100, 8000, 550)
 val taskFutures: List[Future[String]] = tasks map { ms =>

  val search = Future {
   Thread.sleep(ms)
   s"Task with $ms ms"
  }

  Future.firstCompletedOf(Seq(search, fallback(s"timeout $ms", timeout)))

 }

 def fallback[A](default: A, timeout: Duration): Future[A] = {
  Future {
   Thread.sleep(timeout.toMillis)
   default
  }
 }

 val searchFuture = Future sequence taskFutures

 println("Blocking for results")
 val result = Await result (searchFuture, timeout * tasks.length)
 println(s"Found $result")

}
