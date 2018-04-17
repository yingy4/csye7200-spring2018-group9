package models

import models.Temperature2.{stringToDouble, stringToDouble2}
import java.util.Date
import scala.io.Source
import scala.util.Try

case class DateValue(dateValue: Date)

case class Weather(data: String, rain: String, temperature: String,pressure: String)

case class Temperature(date: String, meanTemperature: String, maxTemperature: String, minTemperature: String)

case class Pressure(date: String, meanPressure: String, maxPressure: String, minPressure: String)

case class Humidity(date: String, meanHumidity: String, maxHumidity: String, minHumidity: String)

case class Weather2(data: String, rain: Boolean, temperature: Double,pressure: Double)

case class Temperature2(date: String,id:Int,
                        meanTemperature: Double, maxTemperature: Double, minTemperature: Double,
                        meanTemperature1: Double, maxTemperature1: Double, minTemperature1: Double,
                        meanTemperature2: Double, maxTemperature2: Double, minTemperature2: Double,
                        meanTemperature3: Double, maxTemperature3: Double, minTemperature3: Double)

case class Pressure2(date: String,id:Int,
                     meanPressure: Double, maxPressure: Double, minPressure: Double,
                     meanPressure1: Double, maxPressure1: Double, minPressure1: Double,
                     meanPressure2: Double, maxPressure2: Double, minPressure2: Double,
                     meanPressure3: Double, maxPressure3: Double, minPressure3: Double)

case class Humidity2(date: String,id:Int,
                     meanHumidity: Double, maxHumidity: Double, minHumidity: Double,
                     meanHumidity1: Double, maxHumidity1: Double, minHumidity1: Double,
                     meanHumidity2: Double, maxHumidity2: Double, minHumidity2: Double,
                     meanHumidity3: Double, maxHumidity3: Double, minHumidity3: Double)

object Weather2 {

  implicit def booleanToInt(b:Boolean) = if (b) 1 else 0

  def meanMeanW(weather:Seq[Weather]):Seq[Double]={
    val meanTSum = weather.filter(_.temperature!="").foldLeft[Double](0)((sum,i) => sum + i.temperature.toDouble)
    val meanPSum = weather.filter(_.pressure!="").foldLeft[Double](0)((sum,i) => sum + i.pressure.toDouble)
    return  Seq(meanTSum/weather.length,meanPSum/weather.length)
  }

  def readWeathers(s:String): Seq[Weather] = {
    for {
      line <- Source.fromFile(s).getLines().drop(1).toVector
      values = line.split(",").map(_.trim)
    } yield Weather(values(0),values(10), values(1), values(4))
  }

  def intToBoolean(s:Boolean,ss:String) =s match {
    case true => ss.toInt match {
      case 1 => true
      case _ => false
    }
    case false => false
  }

  def translateToWeather2(weathers:Seq[Weather])= {
    val mean=meanMeanW(weathers)
    for{
    x <- 3 to weathers.length-1
  } yield Weather2(weathers(x).data,
    intToBoolean(Try(weathers(x).rain.toInt).isSuccess,weathers(x).rain),
    stringToDouble(Try(weathers(x).temperature.toDouble).isSuccess,weathers(x).temperature,mean(0)),
    stringToDouble(Try(weathers(x).pressure.toDouble).isSuccess,weathers(x).pressure,mean(1)))
  }
}

object Temperature2  {

  def stringToDouble(s:Boolean,ss:String,mean:Double) =s match {
    case true => ss.toDouble
    case false => mean
  }

  def stringToDouble2(s:Boolean,ss:String) =s match {
    case true => ss.toDouble
    case false => 0.toDouble
  }

  def meanMeanT(temperature:Seq[Temperature]):Seq[Double]={
    val meanSum=temperature.filter(_.meanTemperature!="").foldLeft[Double](0)((sum,i)=> sum + i.meanTemperature.toDouble)
    val maxSum=temperature.filter(_.maxTemperature!="").foldLeft[Double](0)((sum,i)=> sum + i.maxTemperature.toDouble)
    val minSum=temperature.filter(_.minTemperature!="").foldLeft[Double](0)((sum,i)=> sum + i.minTemperature.toDouble)
    return  Seq(meanSum/temperature.length,maxSum/temperature.length,minSum/temperature.length)
  }

  def readTemperatures(s:String): Seq[Temperature] = {
    for {
      line <- Source.fromFile(s).getLines().drop(1).toVector
      values = line.split(",").map(_.trim)
    } yield Temperature(values(0), values(1), values(2), values(3))
  }

  def translateToTemperature2(temperature:Seq[Temperature])= {
    val mean=meanMeanT(temperature)
    for{
      x <- 3 to temperature.length-1
    } yield Temperature2(temperature(x).date,
      x-3,
      stringToDouble(Try(temperature(x).meanTemperature.toDouble).isSuccess,temperature(x).meanTemperature,mean(0)),
      stringToDouble(Try(temperature(x).maxTemperature.toDouble).isSuccess,temperature(x).maxTemperature,mean(1)),
      stringToDouble(Try(temperature(x).minTemperature.toDouble).isSuccess,temperature(x).minTemperature,mean(2)),
      stringToDouble(Try(temperature(x-1).meanTemperature.toDouble).isSuccess,temperature(x-1).meanTemperature,mean(0)),
      stringToDouble(Try(temperature(x-1).maxTemperature.toDouble).isSuccess,temperature(x-1).maxTemperature,mean(1)),
      stringToDouble(Try(temperature(x-1).minTemperature.toDouble).isSuccess,temperature(x-1).minTemperature,mean(2)),
      stringToDouble(Try(temperature(x-2).meanTemperature.toDouble).isSuccess,temperature(x-2).meanTemperature,mean(0)),
      stringToDouble(Try(temperature(x-2).maxTemperature.toDouble).isSuccess,temperature(x-2).maxTemperature,mean(1)),
      stringToDouble(Try(temperature(x-2).minTemperature.toDouble).isSuccess,temperature(x-2).minTemperature,mean(2)),
      stringToDouble(Try(temperature(x-3).meanTemperature.toDouble).isSuccess,temperature(x-3).meanTemperature,mean(0)),
      stringToDouble(Try(temperature(x-3).maxTemperature.toDouble).isSuccess,temperature(x-3).maxTemperature,mean(1)),
      stringToDouble(Try(temperature(x-3).minTemperature.toDouble).isSuccess,temperature(x-3).minTemperature,mean(2)))
  }

  def translateToMeanTemperature(temperature:Seq[Temperature2]):Seq[Seq[Double]]= {
    for{
      x <- 0 to temperature.length-1
    } yield Seq(temperature(x).meanTemperature,
      temperature(x).meanTemperature1,
      temperature(x).meanTemperature2,
      temperature(x).meanTemperature3)
  }
  def translateToMaxTemperature(temperature:Seq[Temperature2]):Seq[Seq[Double]]= {
    for{
      x <- 0 to temperature.length-1
    } yield Seq(temperature(x).maxTemperature,
      temperature(x).maxTemperature1,
      temperature(x).maxTemperature2,
      temperature(x).maxTemperature3)
  }
  def translateToMinTemperature(temperature:Seq[Temperature2]):Seq[Seq[Double]]= {
    for{
      x <- 0 to temperature.length-1
    } yield Seq(temperature(x).minTemperature,
      temperature(x).minTemperature1,
      temperature(x).minTemperature2,
      temperature(x).minTemperature3)
  }
}

object Pressure2  {

  def meanMeanP(pressure:Seq[Pressure]):Seq[Double]={
    val meanSum=pressure.filter(_.meanPressure!="").foldLeft[Double](0)((sum,i)=> sum + i.meanPressure.toDouble)
    val maxSum=pressure.filter(_.maxPressure!="").foldLeft[Double](0)((sum,i)=> sum + i.maxPressure.toDouble)
    val minSum=pressure.filter(_.minPressure!="").foldLeft[Double](0)((sum,i)=> sum + i.minPressure.toDouble)
    return  Seq(meanSum/pressure.length,maxSum/pressure.length,minSum/pressure.length)
  }

  def readPressures(s:String): Seq[Pressure] = {
    for {
      line <- Source.fromFile(s).getLines().drop(1).toVector
      values = line.split(",").map(_.trim)
    } yield Pressure(values(0), values(4), values(5), values(6))
  }

  def translateToPressure2(pressures:Seq[Pressure])= {
    val mean=meanMeanP(pressures)
    for{
      x <- 3 to pressures.length-1
    } yield Pressure2(pressures(x).date,
      x-3,
      stringToDouble(Try(pressures(x).meanPressure.toDouble).isSuccess,pressures(x).meanPressure,mean(0)),
      stringToDouble(Try(pressures(x).maxPressure.toDouble).isSuccess,pressures(x).maxPressure,mean(1)),
      stringToDouble(Try(pressures(x).minPressure.toDouble).isSuccess,pressures(x).minPressure,mean(2)),
      stringToDouble(Try(pressures(x-1).meanPressure.toDouble).isSuccess,pressures(x-1).meanPressure,mean(0)),
      stringToDouble(Try(pressures(x-1).maxPressure.toDouble).isSuccess,pressures(x-1).maxPressure,mean(1)),
      stringToDouble(Try(pressures(x-1).minPressure.toDouble).isSuccess,pressures(x-1).minPressure,mean(2)),
      stringToDouble(Try(pressures(x-2).meanPressure.toDouble).isSuccess,pressures(x-2).meanPressure,mean(0)),
      stringToDouble(Try(pressures(x-2).maxPressure.toDouble).isSuccess,pressures(x-2).maxPressure,mean(1)),
      stringToDouble(Try(pressures(x-2).minPressure.toDouble).isSuccess,pressures(x-2).minPressure,mean(2)),
      stringToDouble(Try(pressures(x-3).meanPressure.toDouble).isSuccess,pressures(x-3).meanPressure,mean(0)),
      stringToDouble(Try(pressures(x-3).maxPressure.toDouble).isSuccess,pressures(x-3).maxPressure,mean(1)),
      stringToDouble(Try(pressures(x-3).minPressure.toDouble).isSuccess,pressures(x-3).minPressure,mean(2)))
  }

  def translateToMeanPressure(pressure:Seq[Pressure2]):Seq[Seq[Double]]= {
    for{
      x <- 0 to pressure.length-1
    } yield Seq(pressure(x).meanPressure,
      pressure(x).meanPressure1,
      pressure(x).meanPressure2,
      pressure(x).meanPressure3)
  }
  def translateToMaxPressure(pressure:Seq[Pressure2]):Seq[Seq[Double]]= {
    for{
      x <- 0 to pressure.length-1
    } yield Seq(pressure(x).maxPressure,
      pressure(x).maxPressure1,
      pressure(x).maxPressure2,
      pressure(x).maxPressure3)
  }
  def translateToMinPressure(pressure:Seq[Pressure2]):Seq[Seq[Double]]= {
    for{
      x <- 0 to pressure.length-1
    } yield Seq(pressure(x).minPressure,
      pressure(x).minPressure1,
      pressure(x).minPressure2,
      pressure(x).minPressure3)
  }
}

object Humidity2  {

  def meanMeanH(humidity:Seq[Humidity]):Seq[Double]={
    val meanSum=humidity.filter(_.meanHumidity!="").foldLeft[Double](0)((sum,i)=> sum + i.meanHumidity.toDouble)
    val maxSum=humidity.filter(_.maxHumidity!="").foldLeft[Double](0)((sum,i)=> sum + i.maxHumidity.toDouble)
    val minSum=humidity.filter(_.minHumidity!="").foldLeft[Double](0)((sum,i)=> sum + i.minHumidity.toDouble)
    return  Seq(meanSum/humidity.length,maxSum/humidity.length,minSum/humidity.length)
  }

  def readHumidities(s:String): Seq[Humidity] = {
    for {
      line <- Source.fromFile(s).getLines().drop(1).toVector
      values = line.split(",").map(_.trim)
    } yield Humidity(values(0), values(7), values(8), values(9))
  }

  def translateToHumidity2(humidities:Seq[Humidity])= {
    val mean=meanMeanH(humidities)
    for{
      x <- 3 to humidities.length-1
    } yield Humidity2(humidities(x).date,
      x-3,
      stringToDouble(Try(humidities(x).meanHumidity.toDouble).isSuccess,humidities(x).meanHumidity,mean(0)),
      stringToDouble(Try(humidities(x).maxHumidity.toDouble).isSuccess,humidities(x).maxHumidity,mean(1)),
      stringToDouble(Try(humidities(x).minHumidity.toDouble).isSuccess,humidities(x).minHumidity,mean(2)),
      stringToDouble(Try(humidities(x-1).meanHumidity.toDouble).isSuccess,humidities(x-1).meanHumidity,mean(0)),
      stringToDouble(Try(humidities(x-1).maxHumidity.toDouble).isSuccess,humidities(x-1).maxHumidity,mean(1)),
      stringToDouble(Try(humidities(x-1).minHumidity.toDouble).isSuccess,humidities(x-1).minHumidity,mean(2)),
      stringToDouble(Try(humidities(x-2).meanHumidity.toDouble).isSuccess,humidities(x-2).meanHumidity,mean(0)),
      stringToDouble(Try(humidities(x-2).maxHumidity.toDouble).isSuccess,humidities(x-2).maxHumidity,mean(1)),
      stringToDouble(Try(humidities(x-2).minHumidity.toDouble).isSuccess,humidities(x-2).minHumidity,mean(2)),
      stringToDouble(Try(humidities(x-3).meanHumidity.toDouble).isSuccess,humidities(x-3).meanHumidity,mean(0)),
      stringToDouble(Try(humidities(x-3).maxHumidity.toDouble).isSuccess,humidities(x-3).maxHumidity,mean(1)),
      stringToDouble(Try(humidities(x-3).minHumidity.toDouble).isSuccess,humidities(x-3).minHumidity,mean(2)))
  }

  def translateToMeanHumidity(humidities:Seq[Humidity2]):Seq[Seq[Double]]= {
    for{
      x <- 0 to humidities.length-1
    } yield Seq(humidities(x).meanHumidity,
      humidities(x).meanHumidity1,
      humidities(x).meanHumidity2,
      humidities(x).meanHumidity3)
  }
  def translateToMaxHumidity(humidities:Seq[Humidity2]):Seq[Seq[Double]]= {
    for{
      x <- 0 to humidities.length-1
    } yield Seq(humidities(x).maxHumidity,
      humidities(x).maxHumidity1,
      humidities(x).maxHumidity2,
      humidities(x).maxHumidity3)
  }
  def translateToMinHumidity(humidities:Seq[Humidity2]):Seq[Seq[Double]]= {
    for{
      x <- 0 to humidities.length-1
    } yield Seq(humidities(x).minHumidity,
      humidities(x).minHumidity1,
      humidities(x).minHumidity2,
      humidities(x).minHumidity3)
  }
}