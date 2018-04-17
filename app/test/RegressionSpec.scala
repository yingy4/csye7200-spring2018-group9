
import org.scalatest.{FlatSpec, Matchers}
import regression.{Factors, NaiveBayesTest}
import math.{pow,sqrt}
class RegressionSpec extends FlatSpec with Matchers {
  it should "The mean error of meanTemperature less than 5" in {
    val sum = Factors.meanTemperature.foldLeft[Double](0)((sum,m)=> sum+ pow((m(1)*Factors.meanTemperatureFactors._1+m(2)*Factors.meanTemperatureFactors._2+m(3)*Factors.meanTemperatureFactors._3+
      Factors.meanTemperatureFactors._4+Factors.meanTemperatureFactors._5+Factors.meanTemperatureFactors._6-m(0)),2))
    val meanerror=sqrt(sum/Factors.meanTemperature.size)
    meanerror min 5
  }
}

