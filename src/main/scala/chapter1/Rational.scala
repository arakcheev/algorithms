/*
 * Copyright 2015 Arakcheev Artem (artem.arakcheev@phystech.edu)
 *
 */

package chapter1

class Rational(val a: Long, val b: Long) {

  def +(that: Rational) = Rational(a * that.b + b * that.a, b * that.b)

  def -(that: Rational) = Rational(a * that.b - b * that.a, b * that.b)

  def *(that: Rational) = Rational(a * that.a, b * that.b)

  def /(that: Rational) = Rational(a * that.b, b * that.a)

  def equals(that: Rational) = a * that.b == b * that.a

  override def toString = s"\n $a  \n - \n  $b "
}

object Rational {

  def apply(a: Long, b: Long): Rational = {
    val d = gcd(a, b)
    new Rational(a / d, b / d)
  }

  private def gcd(p: Long, q: Long): Long = {
    if (q == 0) p
    else gcd(q, p % q)
  }
}
