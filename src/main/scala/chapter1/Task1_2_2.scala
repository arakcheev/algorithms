/*
 * Copyright 2015 Arakcheev Artem (artem.arakcheev@phystech.edu)
 *
 */

package chapter1

import java.awt.Color

import edu.princeton.cs.algorithms.{Interval1D, Point2D}
import edu.princeton.cs.introcs.{StdDraw, StdRandom}

object Task1_2_2 extends App {

  val N = StdRandom.uniform(1000)

  StdDraw.setCanvasSize(800, 700)
  StdDraw.setXscale(0, 1)
  StdDraw.setYscale(0, 1)
  StdDraw.setPenRadius(.004)

  Range(0, N).toList.map { i =>
    val x1 = StdRandom.uniform()
    val y1 = StdRandom.uniform()

    val interval = new Interval1D(x1, y1)
  }
}
