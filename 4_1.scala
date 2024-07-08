object InventoryManagement {
    def displayInventory(itemName: Array[String], quantity: Array[Int]): Unit = {
        for (i <- itemName.indices) {
            println(s"${itemName(i)} - ${quantity(i)}")
        }
    }

    def restockItem(itemName: Array[String], quantity: Array[Int]): Unit = {
        println("Enter the name of the item being restocked: ")
        val item = scala.io.StdIn.readLine()
        println("Enter the quantity to restock: ")
        val num = scala.io.StdIn.readInt()

        item match {
            case "Pens" => quantity(0) += num
            case "Pencils" => quantity(1) += num
            case "Notebooks" => quantity(2) += num
            case "Erasers" => quantity(3) += num
            case "Sharpeners" => quantity(4) += num
            case _ => println("The item entered is not in the system.")
        }
    }

    def sellItem(itemName: Array[String], quantity: Array[Int]): Unit = {
        println("Enter the name of the item sold: ")
        val item = scala.io.StdIn.readLine()
        println("Enter the quantity sold: ")
        val num = scala.io.StdIn.readInt()

        item match {
            case "Pens" if quantity(0) >= num => quantity(0) -= num
            case "Pencils" if quantity(1) >= num => quantity(1) -= num
            case "Notebooks" if quantity(2) >= num => quantity(2) -= num
            case "Erasers" if quantity(3) >= num => quantity(3) -= num
            case "Sharpeners" if quantity(4) >= num => quantity(4) -= num
            case _ => println("The item entered is not in the system or not enough stock.")
        }
    }

    def selectOption(optNumber: Int, itemName: Array[String], quantity: Array[Int]): Unit = {
        optNumber match {
            case 1 => displayInventory(itemName, quantity)
            case 2 => restockItem(itemName, quantity)
            case 3 => sellItem(itemName, quantity)
            case 4 => println("Exiting the system...")
            case _ => println("Invalid option selected.")
        }
    }

    def main(args: Array[String]): Unit = {
    val itemName = Array("Pens", "Pencils", "Notebooks", "Erasers", "Sharpeners")
    val quantity = Array(10, 50, 16, 45, 98)
    
    var optNumber = 0
    var continue = true // Flag to control loop

    do {
        println("Select the number of the operation that you want to perform:")
        println("Option 1: Display Inventory")
        println("Option 2: Restock Items")
        println("Option 3: Sell Items")
        println("Option 4: Exit the system")
        optNumber = scala.io.StdIn.readInt()
        
        optNumber match {
            case 1 | 2 | 3 => selectOption(optNumber, itemName, quantity)
            case 4 => continue = false // Exit loop
            case _ => println("Invalid option selected.")
        }
    } while (continue)
}

}
