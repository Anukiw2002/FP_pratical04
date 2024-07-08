object patternMatching {
    def intType(input: Int): Unit = {
        if (input <= 0) {
            println("Digit entered is negative or zero")
        } else {
            input % 2 match {
                case 0 => println("Digit entered is an even number")
                case 1 => println("Digit entered is an odd number")
            }
        }
    }

    def main(args: Array[String]): Unit = {
        print("Enter a number: ")
        val input = scala.io.StdIn.readLine().toInt
        intType(input)
    }
}