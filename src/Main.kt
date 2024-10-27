// Total value of products in stock
fun totalValue(products: List<Product>): Double {
    var total = 0.0
    for (product in products) {
        total += product.price * product.quantity
    }
    return total
}

// Most expensive product
fun mostExpensiveProduct(products: List<Product>): Product? {
    if (products.isEmpty()) return null
    var mostExpensive = products[0]
    for (product in products) {
        if (product.price > mostExpensive.price) {
            mostExpensive = product
        }
    }
    return mostExpensive
}

// Check if product in list by name
fun hasProductInStock(products: List<Product>, productName: String): Boolean {
    // Convert list to mutable list
    val mutableProducts = products.toMutableList()
    // Check if the product is in list, ignoring case
    val product = mutableProducts.find { it.name.equals(productName, ignoreCase = true) }
    return product != null
}

// Sort products by price
fun sortProductsByPrice(products: List<Product>, ascending: Boolean): List<Product> {
    return if (ascending) {
        products.sortedBy { it.price }
    } else {
        products.sortedByDescending { it.price }
    }
}

// Sort products by quantity
fun sortProductsByQuantity(products: List<Product>, ascending: Boolean): List<Product> {
    return if (ascending) {
        products.sortedBy { it.quantity }
    } else {
        products.sortedByDescending { it.quantity }
    }
}

// Find missing element in a list of integers
fun findMissingElement(list: List<Int>): Int {
    val n = list.size + 1
    val totalSum = n * (n + 1) / 2
    val currentSum = list.sum()
    return totalSum - currentSum
}


fun main() {
    // Question 2.1
    // List of products
    val productsList : MutableList<Product> = mutableListOf(
        Product("Laptop", 999.99, 5),
        Product("Smartphone", 499.99, 10),
        Product("Tablet", 299.99, 0),
        Product("Smartwatch", 199.99, 3)
    )

    println("Total value: ${totalValue(productsList).format(2)}\n")

    println("Most expensive product: ${ mostExpensiveProduct(productsList)?.name ?: "No products" }\n")

    println("Product Headphones is in stock: ${ hasProductInStock(productsList, "Headphones") }\n")


    val sortedProductsByPrice = sortProductsByPrice(productsList, true)
    println("Products sorted ascending by price:")
    println(sortedProductsByPrice.joinToString { it.name } + "\n")

    val sortedProductsByPriceDescending = sortProductsByPrice(productsList, false)
    println("Products sorted descending by price:")
    println(sortedProductsByPriceDescending.joinToString { it.name } + "\n")

    val sortedProductsByQuantityDescending = sortProductsByQuantity(productsList, true)
    println("Products sorted ascending by quantity:")
    println(sortedProductsByQuantityDescending.joinToString { it.name } + "\n")

    val sortedProductsByQuantity = sortProductsByQuantity(productsList, false)
    println("Products sorted descending by quantity:")
    println(sortedProductsByQuantity.joinToString { it.name } + "\n")

    // Question 2.2
    // Generate a list of non duplicated integers from 1 to n, with n being the size of the list
    val n = 10
    val list = (1..n).shuffled()
    // Randomly remove 1 element from the list
    val removedElement = list.random()
    val newList = list.filter { it != removedElement }
    println("Original list: $list")
    println("New list: $newList")
    println("Removed element: $removedElement")

    // Finding the missing element
    println("Missing element: ${findMissingElement(newList)}")
}

