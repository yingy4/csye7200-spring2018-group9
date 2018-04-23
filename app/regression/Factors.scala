package regression

import models.{Humidity2, Pressure2, Temperature2}
import math.{pow,sqrt}


object Factors  {
  // read temperature
  val temperatures = Temperature2.readTemperatures("./weather.csv")
  val temperatures2=Temperature2.translateToTemperature2(temperatures)

  // calculate the mean temperature linear regression factors
  val meanTemperature=Temperature2.translateToMeanTemperature(temperatures2)
  val meanTemperatureFactors=RegressionProcess.linear(meanTemperature)
//  var sum1=0.0
//  for(m<-meanTemperature){
//    sum1+= pow((m(1)*meanTemperatureFactors._1+m(2)*meanTemperatureFactors._2+m(3)*meanTemperatureFactors._3+
//      meanTemperatureFactors._4+meanTemperatureFactors._5+meanTemperatureFactors._6-m(0)),2)
//  }
//  println("The mean error of meanTemperature is :" + sqrt(sum1/meanTemperature.size))

  // calculate the max temperature linear regression factors
  val maxTemperature=Temperature2.translateToMaxTemperature(temperatures2)
  val maxTemperatureFactors=RegressionProcess.linear(maxTemperature)
//  var sum2=0.0
//  for(m<-maxTemperature){
//    sum2+= pow((m(1)*maxTemperatureFactors._1+m(2)*maxTemperatureFactors._2+m(3)*maxTemperatureFactors._3+
//      maxTemperatureFactors._4+maxTemperatureFactors._5+maxTemperatureFactors._6-m(0)),2)
//  }
//  println("The mean error of maxTemperature is :" + sqrt(sum2/meanTemperature.size))

  // calculate the min temperature linear regression factors
  val minTemperature=Temperature2.translateToMinTemperature(temperatures2)
  val minTemperatureFactors=RegressionProcess.linear(minTemperature)
//  var sum3=0.0
//  for(m<-minTemperature){
//    sum3+= pow((m(1)*minTemperatureFactors._1+m(2)*minTemperatureFactors._2+m(3)*minTemperatureFactors._3+
//      minTemperatureFactors._4+minTemperatureFactors._5+minTemperatureFactors._6-m(0)),2)
//  }
//  println("The mean error of minTemperature is :" + sqrt(sum3/meanTemperature.size))

  // read pressure
  val pressures=Pressure2.readPressures("./weather.csv")
  val pressures2=Pressure2.translateToPressure2(pressures)

  // calculate the mean pressure linear regression factors
  val meanPressure=Pressure2.translateToMeanPressure(pressures2)
  val meanPressureFactors=RegressionProcess.linear(meanPressure)
//  var sum4=0.0
//  for(m<-meanPressure){
//    sum4+= pow((m(1)*meanPressureFactors._1+m(2)*meanPressureFactors._2+m(3)*meanPressureFactors._3+
//      meanPressureFactors._4+meanPressureFactors._5+meanPressureFactors._6-m(0)),2)
//  }
//  println("The mean error of meanPressure is :" + sqrt(sum4/meanTemperature.size))

  // calculate the max pressure linear regression factors
  val maxPressure=Pressure2.translateToMaxPressure(pressures2)
  val maxPressureFactors=RegressionProcess.linear(maxPressure)
//  var sum5=0.0
//  for(m<-maxPressure){
//    sum5+= pow((m(1)*maxPressureFactors._1+m(2)*maxPressureFactors._2+m(3)*maxPressureFactors._3+
//      maxPressureFactors._4+maxPressureFactors._5+maxPressureFactors._6-m(0)),2)
//  }
//  println("The mean error of maxPressure is :" + sqrt(sum5/meanTemperature.size))

  // calculate the min pressure linear regression factors
  val minPressure=Pressure2.translateToMinPressure(pressures2)
  val minPressureFactors=RegressionProcess.linear(minPressure)
//  var sum6=0.0
//  for(m<-minPressure){
//    sum6+= pow((m(1)*minPressureFactors._1+m(2)*minPressureFactors._2+m(3)*minPressureFactors._3+
//      minPressureFactors._4+minPressureFactors._5+minPressureFactors._6-m(0)),2)
//  }
//  println("The mean error of minPressure is :" + sqrt(sum6/meanTemperature.size))

  // read humidity
  val humidities=Humidity2.readHumidities("./weather.csv")
  val humidities2=Humidity2.translateToHumidity2(humidities)

  // calculate the mean humidity linear regression factors
  val meanHumidity=Humidity2.translateToMeanHumidity(humidities2)
  val meanHumidityFactors=RegressionProcess.linear(meanHumidity)
//  var sum7=0.0
//  for(m<-meanHumidity){
//    sum7+= pow((m(1)*meanHumidityFactors._1+m(2)*meanHumidityFactors._2+m(3)*meanHumidityFactors._3+
//      meanHumidityFactors._4+meanHumidityFactors._5+meanHumidityFactors._6-m(0)),2)
//  }
//  println("The mean error of meanHumidity is :" + sqrt(sum7/meanTemperature.size))

  // calculate the max humidity linear regression factors
  val maxHumidity=Humidity2.translateToMaxHumidity(humidities2)
  val maxHumidityFactors=RegressionProcess.linear(maxHumidity)
//  var sum8=0.0
//  for(m<-maxHumidity){
//    sum8+= pow((m(1)*maxHumidityFactors._1+m(2)*maxHumidityFactors._2+m(3)*maxHumidityFactors._3+
//      maxHumidityFactors._4+maxHumidityFactors._5+maxHumidityFactors._6-m(0)),2)
//  }
//  println("The mean error of maxHumidity is :" + sqrt(sum8/meanTemperature.size))

  // calculate the min humidity linear regression factors
  val minHumidity=Humidity2.translateToMinHumidity(humidities2)
  val minHumidityFactors=RegressionProcess.linear(minHumidity)
//  var sum9=0.0
//  for(m<-minHumidity){
//    sum9+= pow((m(1)*minHumidityFactors._1+m(2)*minHumidityFactors._2+m(3)*minHumidityFactors._3+
//      minHumidityFactors._4+minHumidityFactors._5+minHumidityFactors._6-m(0)),2)
//  }
//  println("The mean error of minHumidity is :" + sqrt(sum9/meanTemperature.size))

}



