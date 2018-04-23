package models

import play.api.libs.json._

object dataFromApi extends App{
  val url = "http://api.wunderground.com/api/791897507797ea42/history_1011/q/UK/London.json"

  val result = scala.io.Source.fromURL(url).mkString
  val json: JsValue = Json.parse(result)
  val h=json("history")("dailysummary")(0)
  val meantempm=h("meantempm")
  val maxtempm=h("maxtempm")
  val mintempm=h("mintempm")
  val meanpressurem=h("meanpressurem")
  val maxpressurem=h("maxpressurem")
  val minpressurem=h("minpressurem")
  val meanhumidity=h("humidity")
  val maxhumidity=h("maxhumidity")
  val minhumidity=h("minhumidity")
  val rain=h("rain")
  println(meanhumidity)
}
