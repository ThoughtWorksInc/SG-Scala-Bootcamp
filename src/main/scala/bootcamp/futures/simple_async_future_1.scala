package bootcamp.futures

import scala.async.Async._
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

/**
 * Created by ravikupin on 17/11/15.
 */
object simple_async_future_1 extends App {
  //combine two futures

  def slowFuture(n: Int) = async {
    Thread.sleep(2 * 1000)
    Math.pow(n, n)
  }

  val two_raise_two = slowFuture(2)
  val three_raise_three = slowFuture(4)

  val resultantFuture = async {
    await(two_raise_two) + await(three_raise_three)
  }

  println(Await.result(resultantFuture, 3 seconds))

}
