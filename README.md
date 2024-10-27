# Coding Assessment

**Agenda**
- [Data Class](#data-class)
- [Extensions](#extensions)
- [Solving Functions](#solving-functions)
- [License](#license)

## Data Class
The `Product` class represents a product with the following properties:

```kotlin
data class Product(
    val name: String = "",
    val price: Double = 0.0,
    val quantity: Int = 0
)
```
**Properties**
- name: The name of the product (default: "").
- price: The price of the product (default: 0.0).
- quantity: The quantity of the product in stock (default: 0).

## Extensions
The `Double Format` extension function formats a `Double` value to a `String` with a currency symbol and `digits` decimal places.

```kotlin
fun Double.format(digits: Int) = "%.${digits}f".format(this)
```

## Solving Functions
**Total Value of Products**
The `totalValue` function calculates the total value of a list of products.

```kotlin
fun totalValue(products: List<Product>): Double {
    val total = products.sumOf { it.price * it.quantity }
    return total
}
```

Parameters:

- products: A list of Product objects.

**Most Expensive Product**
The `mostExpensiveProduct` function returns the most expensive product in a list of products.

```kotlin
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
```

Parameters:
- products: A list of Product objects.


**Check if Product Name Exists**
The `hasProductInStock` function checks if a product with a specific name exists in a list of products.

```kotlin
fun hasProductInStock(products: List<Product>, productName: String): Boolean {
    // Convert list to mutable list
    val mutableProducts = products.toMutableList()
    // Check if the product is in list, ignoring case
    val product = mutableProducts.find { it.name.equals(productName, ignoreCase = true) }
    return product != null
}
```

Parameters:
- products: A list of Product objects.
- productName: The name of the product to check.

**Sort Products by Price**
The `sortProductsByPrice` function sorts a list of products by price in ascending order.

```kotlin
fun sortProductsByPrice(products: List<Product>, ascending: Boolean): List<Product> {
    return if (ascending) {
        products.sortedBy { it.price }
    } else {
        products.sortedByDescending { it.price }
    }
}
```
Parameters:
- products: A list of Product objects.
- ascending: A Boolean flag for sorting order.

**Sort Products by Quantity**
The `sortProductsByQuantity` function sorts a list of products by quantity in ascending order.

```kotlin
fun sortProductsByQuantity(products: List<Product>, ascending: Boolean): List<Product> {
    return if (ascending) {
        products.sortedBy { it.quantity }
    } else {
        products.sortedByDescending { it.quantity }
    }
}
```

Parameters:
- products: A list of Product objects.
- ascending: A Boolean flag for sorting order.

**Find Missing Elements in a List of Integers from 1 to n+1**
The `findMissingElement` function finds the missing element in a list of integers from 1 to n+1.

```kotlin
fun findMissingElement(list: List<Int>): Int {
    val n = list.size + 1
    val totalSum = n * (n + 1) / 2
    val currentSum = list.sum()
    return totalSum - currentSum
}
```

Parameters:
- list: A list of integers from 1 to n+1 with one element missing.

## License
All Rights Reserved © 2024 Nguyen Phuong Tai

Permission is NOT granted to any person or organization to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of this software, unless explicit written permission is provided by the author.

This software is provided "as-is," without any warranty of any kind, express or implied, including but not limited to the warranties of merchantability, fitness for a particular purpose, and non-infringement. In no event shall the authors be liable for any claim, damages, or other liability, whether in an action of contract, tort, or otherwise, arising from, out of, or in connection with the software or the use or other dealings in the software.
