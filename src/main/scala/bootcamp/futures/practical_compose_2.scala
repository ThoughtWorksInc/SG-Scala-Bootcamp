package bootcamp.futures

import java.io.File

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by ravikupin on 11/11/15.
 */

//Get count of all words in a directory

object practical_compose_2 extends App{

  /** WordCount represents number of words in a given file
   *
   */
  type WordCount = (String, Int)

  /** returns all the file names in a given directory
   *
   * @param directory
   * @return
   */
  def files_in_directory(directory: String):Future[Seq[String]] = ???

  /** this method returns one future for each file in files
   *
   * @param files
   * @return
   */
  def total_word_count_for_files_internal(files: Seq[String]):Seq[Future[WordCount]] = ???
  
  
  def total_word_count_for_each_file_in_directory(directory: String): Future[Seq[WordCount]] = ???
  
}
