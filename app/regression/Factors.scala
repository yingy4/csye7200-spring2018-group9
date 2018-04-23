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
   def temperature(s:Temperature2,temType:String):Double={
    if(temType=="meanTemperature"){
      return (Factors.meanTemperatureFactors._1 *s.meanTemperature1 +Factors.meanTemperatureFactors._2 *s.meanTemperature2
      +Factors.meanTemperatureFactors._3 *s.meanTemperature3 + Factors.meanTemperatureFactors._4+
        Factors.meanTemperatureFactors._5+Factors.meanTemperatureFactors._6)
    }else if(temType=="maxTemperature"){
      return (Factors.maxTemperatureFactors._1 *s.maxTemperature1 +Factors.maxTemperatureFactors._2 *s.maxTemperature2
        +Factors.maxTemperatureFactors._3 *s.maxTemperature3 + Factors.maxTemperatureFactors._4+
        Factors.maxTemperatureFactors._5+Factors.maxTemperatureFactors._6)
    }else{
      return (Factors.minTemperatureFactors._1 *s.minTemperature1 +Factors.minTemperatureFactors._2 *s.minTemperature2
        +Factors.minTemperatureFactors._3 *s.minTemperature3 + Factors.minTemperatureFactors._4+
        Factors.minTemperatureFactors._5+Factors.minTemperatureFactors._6)
    }
  }

  def sevenTemperature(s:Temperature2):Seq[Temperature2]={
    val t1=new Temperature2("1",1,1,1,1,
      s.meanTemperature,s.maxTemperature,s.minTemperature,
      s.meanTemperature1,s.maxTemperature1,s.minTemperature1,
      s.meanTemperature2,s.maxTemperature2,s.minTemperature2)
    val t2=new Temperature2("1",1,1,1,1,
      temperature(t1,"meanTemperature"),temperature(t1,"maxTemperature"),temperature(t1,"minTemperature"),
      t1.meanTemperature,t1.maxTemperature,t1.minTemperature,
      t1.minTemperature,t1.minTemperature,t1.minTemperature)
    val t3=new Temperature2("1",1,1,1,1,
      temperature(t2,"meanTemperature"),temperature(t2,"maxTemperature"),temperature(t2,"minTemperature"),
      t2.meanTemperature,t2.maxTemperature,t2.minTemperature,
      t2.minTemperature,t2.minTemperature,t2.minTemperature)
    val t4=new Temperature2("1",1,1,1,1,
      temperature(t3,"meanTemperature"),temperature(t3,"maxTemperature"),temperature(t3,"minTemperature"),
      t3.meanTemperature,t3.maxTemperature,t3.minTemperature,
      t3.minTemperature,t3.minTemperature,t3.minTemperature)
    val t5=new Temperature2("1",1,1,1,1,
      temperature(t4,"meanTemperature"),temperature(t4,"maxTemperature"),temperature(t4,"minTemperature"),
      t4.meanTemperature,t4.maxTemperature,t4.minTemperature,
      t4.minTemperature,t4.minTemperature,t4.minTemperature)
    val t6=new Temperature2("1",1,1,1,1,
      temperature(t5,"meanTemperature"),temperature(t5,"maxTemperature"),temperature(t5,"minTemperature"),
      t5.meanTemperature,t5.maxTemperature,t5.minTemperature,
      t5.minTemperature,t5.minTemperature,t5.minTemperature)
    return Seq(s,t1,t2,t3,t4,t5,t6)
  }

  def pressure(s:Pressure2,temType:String):Double={
    if(temType=="meanPressure"){
      return (Factors.meanPressureFactors._1 *s.meanPressure1 +Factors.meanPressureFactors._2 *s.meanPressure2
        +Factors.meanPressureFactors._3 *s.meanPressure3 + Factors.meanPressureFactors._4+
        Factors.meanPressureFactors._5+Factors.meanPressureFactors._6)
    }else if(temType=="maxPressure"){
      return (Factors.maxPressureFactors._1 *s.maxPressure1 +Factors.maxPressureFactors._2 *s.maxPressure2
        +Factors.maxPressureFactors._3 *s.maxPressure3 + Factors.maxPressureFactors._4+
        Factors.maxPressureFactors._5+Factors.maxPressureFactors._6)
    }else{
      return (Factors.minPressureFactors._1 *s.minPressure1 +Factors.minPressureFactors._2 *s.minPressure2
        +Factors.minPressureFactors._3 *s.minPressure3 + Factors.minPressureFactors._4+
        Factors.minPressureFactors._5+Factors.minPressureFactors._6)
    }
  }

//  def sevenPressure(s:Pressure2):Seq[Pressure2]={
//    val t1=new Pressure2("1",1,1,1,1,
//      s.meanPressure,s.maxPressure,s.minPressure,
//      s.meanPressure1,s.maxTemperature1,s.minTemperature1,
//      s.meanTemperature2,s.maxTemperature2,s.minTemperature2)
//    val t2=new Pressure2("1",1,1,1,1,
//      pressure(t1,"meanPressure"),pressure(t1,"maxPressure"),pressure(t1,"minPressure"),
//      t1.meanPressure1,t1.maxPressure1,t1.minPressure1,
//      t1.meanPressure2,t1.maxPressure2,t1.minPressure2)
//    val t3=new Pressure2("1",1,1,1,1,
//      pressure(t2,"meanPressure"),pressure(t2,"maxPressure"),pressure(t2,"minPressure"),
//      t2.meanPressure1,t2.maxPressure1,t2.minPressure,
//      t2.meanPressure1,t2.minTemperature,t2.minTemperature)
//    val t4=new Pressure2("1",1,1,1,1,
//      pressure(t3,"meanPressure"),pressure(t3,"maxPressure"),pressure(t3,"minPressure"),
//      t3.meanPressure1,t3.maxPressure1,t3.minPressure,
//      t3.meanPressure1,t3.minTemperature,t3.minTemperature)
//    val t5=new Pressure2("1",1,1,1,1,
//      pressure(t4,"meanPressure"),pressure(t4,"maxPressure"),pressure(t4,"minPressure"),
//      t4.meanPressure1,t4.maxPressure1,t4.minPressure,
//      t4.minTemperature,t4.minTemperature,t4.minTemperature)
//    val t6=new Pressure2("1",1,1,1,1,
//      pressure(t5,"meanPressure"),pressure(t5,"maxPressure"),pressure(t5,"minPressure"),
//      t5.meanPressure1,t5.maxPressure1,t5.minPressure,
//      t5.minTemperature,t5.minTemperature,t5.minTemperature)
//    return Seq(s,t1,t2,t3,t4,t5,t6)
//  }

  def humidity(s:Humidity2,temType:String):Double={
    if(temType=="meanhumidity"){
      return (Factors.meanHumidityFactors._1 *s.meanHumidity1 +Factors.meanHumidityFactors._2 *s.meanHumidity2
        +Factors.meanHumidityFactors._3 *s.meanHumidity3 + Factors.meanHumidityFactors._4+
        Factors.meanHumidityFactors._5+Factors.meanHumidityFactors._6)
    }else if(temType=="maxhumidity"){
      return (Factors.maxHumidityFactors._1 *s.maxHumidity1 +Factors.maxHumidityFactors._2 *s.maxHumidity2
        +Factors.maxHumidityFactors._3 *s.maxHumidity3 + Factors.maxHumidityFactors._4+
        Factors.maxHumidityFactors._5+Factors.maxHumidityFactors._6)
    }else{
      return (Factors.minHumidityFactors._1 *s.minHumidity1 +Factors.minHumidityFactors._2 *s.minHumidity2
        +Factors.minHumidityFactors._3 *s.minHumidity3 + Factors.minHumidityFactors._4+
        Factors.minHumidityFactors._5+Factors.minHumidityFactors._6)
    }
  }
}



