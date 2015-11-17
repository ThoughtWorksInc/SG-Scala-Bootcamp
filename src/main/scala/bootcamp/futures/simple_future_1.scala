package bootcamp.futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
 * Created by ravikupin on 17/11/15.
 */
object simple_future_1 extends App{
  //combine two futures

  def slowFuture(n: Int) = Future {
    Thread.sleep(2 * 1000)
    Math.pow(n, n)
  }

  val two_raise_two = slowFuture(2)
  val three_raise_three = slowFuture(3)

  val sum_of_futures = for {
    x <- two_raise_two
    y <- three_raise_three
  } yield x + y

  println(Await.result(sum_of_futures, 3 seconds))
}
