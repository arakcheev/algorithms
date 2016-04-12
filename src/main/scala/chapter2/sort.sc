


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

  println(xs.toList)
}

selection(Array(5, 4, 3, 2, 1, 1, 6, 7, 2, 9))