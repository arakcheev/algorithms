case class Counter(var value: Int) {

  def inc() = {
    value += 1
  }

  override def toString = s"Total($value)"
}

val counter = Counter(0)

def loop(s: String): String = {

  val N = s.length
  counter.inc()
  if (N <= 1) s
  else {
    val a = s.substring(0, N / 2)
    val b = s.substring(N / 2, N)
    loop(b) + loop(a)
  }
}