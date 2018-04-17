package controllers

import java.text.SimpleDateFormat
import java.util.Calendar

import javax.inject._
import models.DateValue
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import regression.{Bayes, Factors}

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc)
    with play.api.i18n.I18nSupport{

  val dateValueForm = Form(
    mapping(
      "dateValue" -> date
    )(DateValue.apply)(DateValue.unapply)
  )

  def index = Action { implicit request =>
    Ok(views.html.index(dateValueForm))
  }

  def result = Action { implicit request => {
    val dateValue = dateValueForm.bindFromRequest().get.dateValue
    val judgeTime = new SimpleDateFormat("M/d/yyyy").parse("12/31/2017")
    val rightNow = Calendar.getInstance()
    val time4 =new SimpleDateFormat("M/d/yyyy").format(dateValue)
    val time2=new SimpleDateFormat("M/d/yyyy").parse(time4)
    rightNow.setTime(time2)
    if (time2.after(judgeTime)) {
      rightNow.add(Calendar.YEAR, -1)
    }
    val time5=rightNow.getTime
    val time3=new SimpleDateFormat("M/d/yyyy").format(time5)
    val time = new SimpleDateFormat("M/d/yyyy").format(dateValue).toString

    val temperature2=Factors.temperatures2.filter(_.date==time3)(0)
    val idT=temperature2.id
    val sevenT=for{i <- 0 to 6} yield Factors.temperatures2(idT+i)
    val meanTemperaturAns=for{s<-sevenT}yield (Factors.meanTemperatureFactors._1 *s.meanTemperature1 +Factors.meanTemperatureFactors._2 *s.meanTemperature2
      +Factors.meanTemperatureFactors._3 *s.meanTemperature3 + Factors.meanTemperatureFactors._4+
      Factors.meanTemperatureFactors._5+Factors.meanTemperatureFactors._6)


    val maxTemperaturAns = for{s<-sevenT}yield(Factors.maxTemperatureFactors._1 *s.maxTemperature1 +Factors.maxTemperatureFactors._2 *s.maxTemperature2
    +Factors.maxTemperatureFactors._3 *s.maxTemperature3 + Factors.maxTemperatureFactors._4+
      Factors.maxTemperatureFactors._5+Factors.maxTemperatureFactors._6)

    val minTemperaturAns = for{s<-sevenT}yield(Factors.minTemperatureFactors._1 *s.minTemperature1 +Factors.minTemperatureFactors._2 *s.minTemperature2
    +Factors.minTemperatureFactors._3 *s.minTemperature3 + Factors.minTemperatureFactors._4+
      Factors.minTemperatureFactors._5+Factors.minTemperatureFactors._6)

    val pressure2=Factors.pressures2.filter(_.date==time3)(0)
    val idP=pressure2.id
    val sevenP=for{i <- 0 to 6} yield Factors.pressures2(idP+i)

    val meanPressureAns = for{s<-sevenP}yield(Factors.meanPressureFactors._1 *s.meanPressure1 +Factors.meanPressureFactors._2 *s.meanPressure2
    +Factors.meanPressureFactors._3 *s.meanPressure3 + Factors.meanPressureFactors._4+
      Factors.meanPressureFactors._5+Factors.meanPressureFactors._6)

    val maxPressureAns = for{s<-sevenP}yield(Factors.maxPressureFactors._1 *s.maxPressure1 +Factors.maxPressureFactors._2 *s.maxPressure2
    +Factors.maxPressureFactors._3 *s.maxPressure3 + Factors.maxPressureFactors._4+
      Factors.maxPressureFactors._5+Factors.maxPressureFactors._6)

    val minPressureAns = for{s<-sevenP}yield(Factors.minPressureFactors._1 *s.minPressure1 +Factors.minPressureFactors._2 *s.minPressure2
    +Factors.minPressureFactors._3 *s.minPressure3 + Factors.minPressureFactors._4+
      Factors.minPressureFactors._5+Factors.minPressureFactors._6)

    val humidity2=Factors.humidities2.filter(_.date==time3)(0)
    val idH=humidity2.id
    val sevenH=for{i <- 0 to 6} yield Factors.humidities2(idH+i)
    val meanhumidityAns = for{s<-sevenH}yield(Factors.meanHumidityFactors._1 *s.meanHumidity1 +Factors.meanHumidityFactors._2 *s.meanHumidity2
      +Factors.meanHumidityFactors._3 *s.meanHumidity3 + Factors.meanHumidityFactors._4+
      Factors.meanHumidityFactors._5+Factors.meanHumidityFactors._6)

    val maxhumidityAns = for{s<-sevenH}yield(Factors.maxHumidityFactors._1 *s.maxHumidity1 +Factors.maxHumidityFactors._2 *s.maxHumidity2
      +Factors.maxHumidityFactors._3 *s.maxHumidity3 + Factors.maxHumidityFactors._4+
      Factors.maxHumidityFactors._5+Factors.maxHumidityFactors._6)

    val minhumidityAns = for{s<-sevenH}yield(Factors.minHumidityFactors._1 *s.minHumidity1 +Factors.minHumidityFactors._2 *s.minHumidity2
      +Factors.minHumidityFactors._3 *s.minHumidity3 + Factors.minHumidityFactors._4+
      Factors.minHumidityFactors._5+Factors.minHumidityFactors._6)
    val weatherF=for{i <- 0 to 6} yield 1+","+meanhumidityAns(i)+","+maxhumidityAns(i)+","+minhumidityAns(i)+","+meanPressureAns(i)+","+maxPressureAns(i)+","+minPressureAns(i)
    //val weatherF=for{i <- 0 to 6} yield 1+","+sevenH(i).meanHumidity+","+sevenH(i).maxHumidity+","+sevenH(i).minHumidity+","+sevenP(i).meanPressure+","+sevenP(i).maxPressure+","+sevenP(i).minPressure
    val weatherResult=Bayes.navieBayes(weatherF)
    val weatherResult2=for{w<-weatherResult}yield if(w.toInt==0) "Sunny" else "Rainy"
    Ok(views.html.result(time,weatherResult2,meanTemperaturAns,maxTemperaturAns,minTemperaturAns,meanPressureAns,maxPressureAns,minPressureAns))
  }
  }
}
