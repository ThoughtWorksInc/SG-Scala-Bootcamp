package bootcamp.futures

import scala.concurrent.Future

/**
 * Created by ravikupin on 11/11/15.
 */

//Get count of all words in a directory

object practical_compose_3 extends App{

  /** WordCount represents number of words in a given file
   *
   */
  type WordCount = (String, Int)

  /**
   * Calculates the word count for a given file
   * @param filename
   * @return
   */
  def word_count_for_file(filename: String): Future[WordCount] = ???

  /** returns all the file names in a given directory
   *
   * @param directory
   * @return
   */
  def files_in_directory(directory: String):Future[Seq[String]] = ???

  /** this method returns one future that contains the number of words for each file in files
   * make use of word_count_for_file
   * @param files
   * @return
   */
  def total_word_count_for_files_internal(files: Seq[String]):Seq[Future[WordCount]] = ???

  /**
   * Given the name the directory, this method calculates total wordcounts for all files
   * make use of methods total_word_count_for_files_internal and files_in_directory
   * @param directory
   * @return
   */
  def total_word_count_for_each_file_in_directory(directory: String): Future[Seq[WordCount]] = ???

}
