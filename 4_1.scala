object InventoryManagement {
    def displayInventory(itemName: Array[String], quantity: Array[Int]): Unit = {
        for (i <- itemName.indices) {
            println(s"${itemName(i)} - ${quantity(i)}")
        }
    }

    def restockItem(itemName: Array[String], quantity: Array[Int]): Unit = {
        print("Enter the item Name: ")
        val itemAdded = scala.io.StdIn.readLine()
        print("Enter the quantity added: ")
        val quantityAdded = scala.io.StdIn.readLine().toInt

        itemAdded match {
            case "Pens" => quantity(0) += quantityAdded
            case "Pencils" => quantity(1) += quantityAdded
            case "Books" => quantity(2) += quantityAdded
            case "Erasers" => quantity(3) += quantityAdded
            case "Sharpeners" => quantity(4) += quantityAdded
            case _ => println("Error: This item is not in the system")
        }
    }

    def sellItem(itemName: Array[String], quantity: Array[Int]): Unit = {
        print("Enter the item Name: ")
        val itemSold = scala.io.StdIn.readLine()
        print("Enter the quantity sold: ")
        val quantitySold = scala.io.StdIn.readLine().toInt

        itemSold match {
            case "Pens" => quantity(0) -= quantitySold
            case "Pencils" => quantity(1) -= quantitySold
            case "Books" => quantity(2) -= quantitySold
            case "Erasers" => quantity(3) -= quantitySold
            case "Sharpeners" => quantity(4) -= quantitySold
            case _ => println("Error: This item is not in the system")
        }

        for (j <- quantity.indices) {
            if (quantity(j) < 0) {
                println(s"Error: Not enough ${itemName(j)} to be sold")
                quantity(j) += quantitySold // Reverting the sold quantity
            }
        }
    }

    def options(optNumber: Int, itemName: Array[String], quantity: Array[Int]): Unit = {
        optNumber match {
            case 1 => displayInventory(itemName, quantity)
            case 2 => restockItem(itemName, quantity)
            case 3 => sellItem(itemName, quantity)
            case 4 => println("Exiting...")
            case _ => println("Invalid option")
        }
    }

    def main(args: Array[String]): Unit = {
        val itemName = Array("Pens", "Pencils", "Books", "Erasers", "Sharpeners")
        val quantity = Array(45, 85, 17, 21, 29)

        var optNumber = 0
        while (optNumber != 4) {
            println("Inventory Management System.")
            println("Option 1: Display Inventory")
            println("Option 2: Restock Inventory")
            println("Option 3: Sell Inventory")
            println("Option 4: Exit")
            print("Enter the option number: ")
            optNumber = scala.io.StdIn.readLine().toInt

            options(optNumber, itemName, quantity)
        }
    }
}
