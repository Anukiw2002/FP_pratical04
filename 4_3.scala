object NameFormatter {

  def toUpper(name: String): String = {
    name.toUpperCase()
  }

  def toLower(name: String): String = {
    name.toLowerCase()
  }

  def formatNames(name: String)(formatFunc: String => String): String = {
    formatFunc(name)
  }

  def main(args: Array[String]): Unit = {

    val names = List("Benny", "Niroshan", "Saman", "Kumara")

    println(formatNames(names(0))(toUpper))       
    println(formatNames(names(1))(name => {
      val firstTwo = name.substring(0, 2).toUpperCase
      val rest = name.substring(2).toLowerCase
      firstTwo + rest
    }))                                            
    println(formatNames(names(2))(toLower))       
    println(formatNames(names(3))(name => {
      val init = name.substring(0, name.length - 1).toLowerCase
      val last = name.charAt(name.length - 1).toUpper
      init + last
    }))                                         
  }
}
