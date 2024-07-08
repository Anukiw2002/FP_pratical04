object InventoryManagement {
  var itemNames: Array[String] = Array("Apples", "Bananas", "Oranges")
  var itemQuantities: Array[Int] = Array(10, 20, 15)

  // Function to display the inventory
  def displayInventory(): Unit = {
    println("Inventory:")
    for (i <- itemNames.indices) {
      println(s"${itemNames(i)}: ${itemQuantities(i)}")
    }
  }

  // Function to restock an item
  def restockItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      itemQuantities(index) += quantity
      println(s"Restocked $quantity of $itemName. New quantity: ${itemQuantities(index)}")
    } else {
      println(s"Item $itemName does not exist in the inventory.")
    }
  }

  // Function to sell an item
  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
        println(s"Sold $quantity of $itemName. Remaining quantity: ${itemQuantities(index)}")
      } else {
        println(s"Not enough quantity of $itemName to sell. Available quantity: ${itemQuantities(index)}")
      }
    } else {
      println(s"Item $itemName does not exist in the inventory.")
    }
  }

  def main(args: Array[String]): Unit = {
    displayInventory()
    restockItem("Bananas", 10)
    sellItem("Apples", 5)
    sellItem("Oranges", 20)
    displayInventory()
  }
}
