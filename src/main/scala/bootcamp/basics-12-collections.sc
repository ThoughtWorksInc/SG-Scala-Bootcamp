
import java.util

import scala.collection.immutable

val imap = immutable.Map("John" -> 18)
val imap2 = imap.updated("John", 19)
imap("John")
imap2("John")

import scala.collection.mutable

val mmap = mutable.Map("Dave" -> 21)
mmap.update("Dave", 22)
mmap("Dave")


import scala.collection.convert._

val javaList: util.ArrayList[String] = {"a", "b", "c"}


javaList.get(1)