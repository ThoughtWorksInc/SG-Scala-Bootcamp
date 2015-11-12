package bootcamp.futures

import scala.concurrent.Future

/**
 * Created by ravikupin on 12/11/15.
 */
object practical_compose_2 extends App{

  /**
   * double_value function sleeps randomly between 0-5 seconds before returning double
   * the value
   * @param x
   * @return
   */
  def double_value(x: Int):Future[Int] = ???

  /**
   * converts the list of futures to one future, reason being so that user can wait on only
   * one future irrespective of many futures
   *
   * @param listOfFutures
   * @return
   */
  def convert(listOfFutures: List[Future[Int]]): Future[List[(Int, Int)]] = ???

  /**
   * seed needs to converted to
   */
  val seed = (1 to 10)

  /**
   * fill in the ouput after doubling, make use of double_value method
   */

  val actual: List[Int] = Nil

  val expected = (1 to 10) map (_ * 2)
  assert(expected == actual, "not matching")
}
