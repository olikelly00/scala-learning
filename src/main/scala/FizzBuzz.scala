import scala.annotation.tailrec

/* This implementation of FizzBuzz if very object oriented, rather than conforming to these
functional paradigms:
1) Make use of simple functions composed together
2) Avoid using for or while loops (try map, reduce or recursion instead)
3) Has 'pure' functions
4) Avoids mutating variables?

*/
object FizzBuzz {

  def generate(number: Int): String = {
    var result = ""
    for (i <- 1 to number) {
      if (i % 5 == 0 && i % 3 == 0) {
        result += "FizzBuzz, "
      } else if (i % 3 == 0) {
        result += "Fizz, "
      } else if (i % 5 == 0) {
        result += "Buzz, "
      } else {
        val NumAsString = (i).toString
        result += (s"$NumAsString, ")
      }
    }

    result.slice(0, result.length - 2)
  }
}


  /*
Below is my 'functional' implementation of FizzBuzz

1) Make use of simple functions composed together - ✅ Yes, this implementation
splits the task into two smaller functions: fizzBuzzHelper() which returns a list,
and generate(), which makes a string from that list. This makes the code more modular
and easier to understand.

2) Avoid using for or while loops (try map, reduce or recursion instead)  ✅  Uses
recursion instead of for loop

3) Has 'pure' functions ✅  The functions don't rely on any external variables.
 This means it will always return the same result for the same input (generate(n)
 will always produce the same output for the same n), making it more reliable
 overall. However, since this implementation creates a new list each time, this
 could be considered a 'side effect' (something that is produced that wasn't
 specified in the function signature).

4) Avoids mutating variables? ✅  - This function creates a new list each time the function runs. However, there is a trade
off made here between computational efficiency and reliability. Making a new list
each time is less computationally efficient (because of the memory required for
this operation), but building the function like this avoids mutating variables which
is a more 'reliable' approach to programming.
 */

object FunctionalFizzBuzz {

    def generate(n: Int): String = {
      def fizzBuzzHelper(current: Int, max: Int, acc: List[String]): List[String] = {
        if (current > max) acc
        else {
          val currentValue = (current % 3, current % 5) match {
            case (0, 0) => "FizzBuzz"
            case (0, _) => "Fizz"
            case (_, 0) => "Buzz"
            case _ => current.toString
          }
          fizzBuzzHelper(current + 1, max, acc :+ currentValue)
        }
      }
      fizzBuzzHelper(1, n, List()).mkString(", ")
    }
  }
