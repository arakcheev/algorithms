

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
  println(s"Selection: ${xs.toList} \n")
}

def insertion(xs: Array[Int]) = {
  for (i <- 1 until xs.length) {
    for (j <- i until 0 by -1 if xs(j) < xs(j - 1)) {
      val tmp = xs(j)
      xs(j) = xs(j - 1)
      xs(j - 1) = tmp
    }
  }
  println(s"Insertion: ${xs.toList} \n")
}

def shell(xs: Array[Int]) = {
  var h = 1
  while (h < xs.length / 3.0) h = h * 3 + 1

  while (h >= 1) {
    for (i <- h until xs.length) {
      for (j <- i until h by -h if xs(j) < xs(j - h)) {
        val tmp = xs(j)
        xs(j) = xs(j - h)
        xs(j - h) = tmp
      }
    }
    h /= 3
  }
  println(s"Shell: ${xs.toList} \n")
}


def mergesort(xs: Array[Int]): Unit = {
  val tmp = new Array[Int](xs.length)

  for (k <- xs.indices) {
    tmp(k) = xs(k)
  }

  def merge(lo: Int, mid: Int, hi: Int): Unit = {
    var i = lo
    var j = mid + 1

    for (k <- lo to hi) {
      if (i > mid) {
        xs(k) = tmp(j)
        j += 1
      } else if (j > hi) {
        xs(k) = tmp(i)
        i += 1
      } else if (tmp(j) < tmp(i)) {
        xs(k) = tmp(j)
        j += 1
      } else {
        xs(k) = tmp(i)
        i += 1
      }
    }
  }

  def sort(lo: Int, hi: Int): Unit = {
    if (lo >= hi) {
      return
    }
    val mid = lo + (hi - lo) / 2

    sort(lo, mid)
    sort(mid + 1, hi)
    merge(lo, mid, hi)
  }

  sort(0, xs.length - 1)

  println(s"Merge sort ${xs.toList} \n")
}

def mergeUpper(xs: Array[Int]): Unit = {
  val tmp = new Array[Int](xs.length)

  for (k <- xs.indices) {
    tmp(k) = xs(k)
  }
  def merge(lo: Int, mid: Int, hi: Int): Unit = {
    var i = lo
    var j = mid + 1

    for (k <- lo to hi) {
      if (i > mid) {
        xs(k) = tmp(j)
        j += 1
      } else if (j > hi) {
        xs(k) = tmp(i)
        i += 1
      } else if (tmp(j) < tmp(i)) {
        xs(k) = tmp(j)
        j += 1
      } else {
        xs(k) = tmp(i)
        i += 1
      }
    }
  }

  val gen = for (i <- 1 until xs.length) yield {
    if (i == 1) 1
    else i + i
  }

  for (i <- gen) {
    for (j <- 0 until xs.length - i by i + i) {
      merge(j, j +i -1, Math.min(i +j +i -1, xs.length-1 ))
    }
  }
  println(s"Merge upper: ${xs.toList} \n")
}

val xs = Array(5, 4, 3, 2, 1, 1, 1, 3, 4, 2, 4, 6, 8, 9, 7, 4, 1, 2, 3, 4, 5, 56, 7, 8, 9, 4, 6, 0)
println(" ")
selection(xs)
insertion(xs)
shell(xs)
mergesort(xs)
mergeUpper(xs)