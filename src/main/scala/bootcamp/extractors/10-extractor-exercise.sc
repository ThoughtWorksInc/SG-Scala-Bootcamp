//Refactor the following solution to use extractors
//Hint: what are the different types of frames?

import scala.collection.immutable.::

class Game {
  var rolls:List[Int] = List()
  def roll(roll:Int) { rolls = rolls :+ roll }

  private def compute(total:Int, frame: Int, rolls:List[Int]): Int = (frame, rolls) match {
    // not last frame yet
    case (_, Nil) => total
    // incomplete frame
    case (_, roll1 :: Nil) => total
    case (_, 10 :: roll2 :: Nil) => total
    case (_, roll1 :: roll2 :: Nil) if roll1 + roll2 == 10 => total
    // last frame, spare
    case (10, roll1 :: roll2 :: roll3 :: Nil) if roll1 + roll2 == 10 => total + 10 + roll3
    // last frame, strike (why must end with Nil?)
    case (10, 10 :: roll2 :: roll3 :: Nil) => total + 10 + roll2 + roll3
    // last frame, spare (why must end with Nil?)
    case (_, roll1 :: roll2 :: roll3 :: Nil) if roll1 + roll2 == 10 => total + 10 + roll3
    // normal frame
    case (_, roll1 :: roll2 :: tail) if roll1 + roll2 < 10 => compute(total + roll1 + roll2, frame + 1, tail)
    // spare
    case (_, roll1 :: roll2 :: roll3 :: tail) if roll1 + roll2 == 10 => compute(total + 10 + roll3, frame + 1, roll3 :: tail)
    // strike
    case (_, 10 :: roll2 :: roll3 :: tail) => compute(total + 10 + roll2 + roll3, frame + 1, roll2 :: roll3 :: tail)
  }

  def score() = compute(0, 1, rolls)
}

val g1 = new Game()

g1.roll(10)
g1.roll(10)
g1.roll(10)
g1.roll(10)
g1.roll(10)
g1.roll(10)
g1.roll(10)
g1.roll(10)
g1.roll(10)
g1.roll(10)
g1.roll(10)
g1.roll(10)
assert(g1.score == 300)

val g = new Game()

g.roll(10)
g.roll(10)
g.roll(10)
g.roll(10)
g.roll(10)
g.roll(10)
g.roll(10)
g.roll(10)
g.roll(8)
g.roll(2)
g.roll(1)

g.score

assert(
  g.score == 6*30 + 28 + 20 + 11
)

