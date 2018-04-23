package regression

import models.Temperature2

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
import scala.math.{pow, sqrt}

object RegressionProcess {

  def linear(pairs: Seq[Seq[Double]]) = {
    val n = pairs.size

    val sums = for {

      sumY <- Future {
        val sum = pairs.foldLeft[Double](0)((sum,i)=> sum+ i(0))
        sum
      }

      sumX1 <- Future {
        val sum = pairs.foldLeft[Double](0)((sum,i)=> sum+ i(1))
        sum
      }

      sumX2 <- Future {
        val sum = pairs.foldLeft[Double](0)((sum,i)=> sum+ i(2))
        sum
      }

      sumX3 <- Future {
        val sum = pairs.foldLeft[Double](0)((sum,i)=> sum + i(3))
        sum
      }

      sumX21 <- Future {
        val sum = pairs.foldLeft[Double](0)((sum,i)=> sum+(i(1)*i(1)))
        sum
      }

      sumX22 <- Future {
        val sum = pairs.foldLeft[Double](0)((sum,i)=> sum+(i(2)*i(2)))
        sum
      }

      sumX23 <- Future {
        val sum = pairs.foldLeft[Double](0)((sum,i)=> sum+(i(3)*i(3)))
        sum
      }
      sumY2 <- Future {
        val sum = pairs.foldLeft[Double](0)((sum,i)=> sum+(i(0)*i(0)))
        sum
      }
      sumX1Y <- Future {
        val sum = pairs.foldLeft[Double](0)((sum,i)=> sum+(i(1)*i(0)))
        sum
      }
      sumX2Y <- Future {
        val sum = pairs.foldLeft[Double](0)((sum,i)=> sum+(i(2)*i(0)))
        sum
      }
      sumX3Y <- Future {
        val sum = pairs.foldLeft[Double](0)((sum,i)=> sum+(i(3)*i(0)))
        sum
      }

    } yield (sumY,sumX1,sumX2,sumX3,sumY2,sumX21,sumX22,sumX23,sumX1Y,sumX2Y,sumX3Y)

    val (sumY,sumX1,sumX2,sumX3,sumY2,sumX21,sumX22,sumX23,sumX1Y,sumX2Y,sumX3Y) = Await.result(sums, Duration.Inf)

    val dn = n * sumX21 + n * sumX22 + n * sumX23 - pow(sumX1, 2) - pow(sumX2, 2) - pow(sumX3, 2)
    val poms = for {
      slopei1 <- Future {
        ((n * sumX1Y) - (sumX1 * sumY)) / dn
      }

      slopei2 <- Future {
        ((n * sumX2Y) - (sumX2 * sumY)) / dn
      }

      slopei3 <- Future {
        ((n * sumX3Y) - (sumX3 * sumY)) / dn
      }
      intercepti1 <- Future {
        ((sumY * sumX21) - (sumX1 * sumX1Y)) / dn
      }
      intercepti2 <- Future {
        ((sumY * sumX22) - (sumX2 * sumX2Y)) / dn
      }
      intercepti3 <- Future {
        ((sumY * sumX23) - (sumX3 * sumX3Y)) / dn
      }
      t11 <- Future {
        ((n * sumX1Y) - (sumX1 * sumY)) * ((n * sumX1Y) - (sumX1 * sumY))
      }

      t12 <- Future {
        ((n * sumX2Y) - (sumX2 * sumY)) * ((n * sumX2Y) - (sumX2 * sumY))
      }
      t13 <- Future {
        ((n * sumX3Y) - (sumX3 * sumY)) * ((n * sumX3Y) - (sumX3 * sumY))
      }
      t21 <- Future {
        (n * sumX21) - pow(sumX1, 2)
      }
      t22 <- Future {
        (n * sumX22) - pow(sumX2, 2)
      }
      t23 <- Future {
        (n * sumX23) - pow(sumX3, 2)
      }
      t31 <- Future {
        (n * sumY2) - pow(sumY, 2)
      }
    } yield (slopei1,slopei2,slopei3,intercepti1,intercepti2,intercepti3,
      t11,t12,t13,t21,t22,t23, t31)

    val (slopei1,slopei2,slopei3,intercepti1,intercepti2,intercepti3,
    t11,t12,t13,t21,t22,t23, t31) = Await.result(poms, Duration.Inf)

    if (t21 * t22 * t23 * t31 != 0.0)
      (slopei1,slopei2,slopei3,intercepti1,intercepti2,intercepti3)
    else
      (slopei1,slopei2,slopei3,intercepti1,intercepti2,intercepti3)
  }
}


