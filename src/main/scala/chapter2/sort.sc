

def selection(xs: Array[Int]) = {
  for (i <- xs.indices) {
    var min = i
    for (j <- i + 1 until xs.length) {
      if (xs(j) <= xs(min)) {
        min = j
      }
    }
    val tmp = xs(i)
    xs(i) = xs(min)
    xs(min) = tmp
  }
  println(s"Selection: ${xs.toList}")
}

def insertion(xs: Array[Int]) = {
  for (i <- 1 until xs.length) {
    for (j <- i until 0 by -1 if xs(j) < xs(j - 1)) {
      val tmp = xs(j)
      xs(j) = xs(j-1)
      xs(j-1) = tmp
    }
  }
  println(s"Insertion: ${xs.toList}")
}

val xs = Array(5, 4, 3, 2, 1, 1, 1, 3, 4, 2, 4, 6, 8, 9, 7, 4, 1, 2, 3, 4, 5, 56, 7, 8, 9, 4, 6)
println(" ")
selection(xs)
insertion(xs)