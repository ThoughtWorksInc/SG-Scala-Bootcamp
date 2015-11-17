package bootcamp.futures

import java.time.LocalDateTime

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
 * Created by ravikupin on 9/11/15.
 */
object simple_future_0 extends App {

  private val current_thread_id: Long = Thread.currentThread().getId

  println(s"current thread id: $current_thread_id")

  val value_at_some_point = Future {

    println(s"time: ${LocalDateTime.now()} threadid: ${Thread.currentThread().getId}")
    Thread.sleep(3000)
    println(s"woke up time: ${LocalDateTime.now()} threadid: ${Thread.currentThread().getId}")

    "some value"

  }
  println("waiting on main thread: time: " + LocalDateTime.now())

  val result = Await.result(value_at_some_point, 5 seconds)
  println(s"value from future '$result'")
}
