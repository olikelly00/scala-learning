

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

    result.slice(0, result.length-2)
  }
}
