/*
 * Copyright 2015 Arakcheev Artem (artem.arakcheev@phystech.edu)
 *
 */

package chapter1

import java.awt.Color

import edu.princeton.cs.algorithms.{Interval1D, Interval2D, Point2D}
import edu.princeton.cs.introcs.{StdDraw, StdRandom}

object Task1_2_1 extends App {

  val N = StdRandom.uniform(1000)

  StdDraw.setCanvasSize(800, 700)
  StdDraw.setXscale(0, 1)
  StdDraw.setYscale(0, 1)
  StdDraw.setPenRadius(.004)

  val points = Range(0, N).toList.map { i =>
    val x = StdRandom.uniform()
    val y = StdRandom.uniform()
    val p = new Point2D(x, y)
    p.draw()
    p
  }

  def calcMinDistance(point2D: Point2D, points: List[Point2D]) = {
    points.map(_.distanceTo(point2D)).min
  }

  def loop(xs: List[Point2D], min: Double, points: (Point2D, Point2D)): (Double, (Point2D, Point2D)) = {
    xs match {
      case Nil => (min, points)
      case point :: tail =>
        val (newMin, newPoints) = {
          if (tail.isEmpty) (min, points)
          else {
            var minD: Double = min
            var minPoint: (Point2D, Point2D) = points
            tail.foreach { p =>
              val d = p.distanceTo(point)
              if (d < minD) {
                minD = d
                minPoint = (point, p)
              }
            }
            (minD, minPoint)
          }
        }
        loop(tail, newMin, newPoints)
    }
  }

  val min = loop(points, math.sqrt(2), null)

  StdDraw.setPenRadius(.005)
  StdDraw.setPenColor(Color.RED)
  min._2._1.drawTo(min._2._2)

  println(min._1)
}
