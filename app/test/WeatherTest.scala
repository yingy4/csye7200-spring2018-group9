package test

import models._
import org.scalatest.{FlatSpec, Matchers}
import regression.Factors

class WeatherTest extends FlatSpec with Matchers {

  it should "equal the first weather" in {
    val weather = Weather2.readWeathers("./weather.csv")(0)
    val weatherTest = new models.Weather("1/1/2010","0","1","1005.76")
    weather shouldBe  weatherTest
  }

  it should "equal the first temperature" in {
    val temperature = Temperature2.readTemperatures("./weather.csv")(0)
    val temperatureTest = new Temperature("1/1/2010","1","3","-1")
    temperature shouldBe  temperatureTest
  }

  it should "equal the first pressure" in {
    val pressure =  Pressure2.readPressures("./weather.csv")(0)
    val pressureTest = new Pressure("1/1/2010","1005.76","1010","1002")
    pressure shouldBe  pressureTest
  }

  it should "equal the first weather2" in {
    val weather = Weather2.readWeathers("./weather.csv")
    val weather2 = Weather2.translateToWeather2(weather)(0)
    val weather2Test = new models.Weather2("1/4/2010",false,-1,1018.05)
    weather2 shouldBe  weather2Test
  }

  it should "equal the first temperature2" in {
    val temperature = Temperature2.readTemperatures("./weather.csv")
    val temperature2 = Temperature2.translateToTemperature2(temperature)(0)
    val temperature2Test = new Temperature2("1/4/2010",0,-1.0,2.0,-4.0,0.0,2.0,-2.0,2.0,5.0,-1.0,1.0,3.0,-1.0)
    temperature2 shouldBe  temperature2Test
  }

  it should "equal the first pressure2" in {
    val pressure =  Pressure2.readPressures("./weather.csv")
    val pressure2 = Pressure2.translateToPressure2(pressure)(0)
    val pressure2Test = new Pressure2("1/4/2010",0,1018.05,1023.0,1012.0,1022.69,1024.0,1019.0,1014.83,1019.0,1010.0,1005.76,1010.0,1002.0)
    pressure2 shouldBe  pressure2Test
  }
  it should "equal the 1" in {
    val temperature2 = Factors.temperatures2.filter(_.date == "1/1/2016")
    val size = temperature2.size
    size shouldBe 1
  }

}
