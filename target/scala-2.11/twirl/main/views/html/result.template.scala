
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object result extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template10[String,Array[String],IndexedSeq[Double],IndexedSeq[Double],IndexedSeq[Double],IndexedSeq[Double],IndexedSeq[Double],IndexedSeq[Double],RequestHeader,MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/( time:String,weatherResult:Array[String],meanTemperature: IndexedSeq[Double],maxTemperature: IndexedSeq[Double],minTemperature: IndexedSeq[Double], meanPressure: IndexedSeq[Double],maxPressure: IndexedSeq[Double],minPressure: IndexedSeq[Double])(implicit request: RequestHeader, messagesProvider: MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.317*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*6.62*/("""
        """),format.raw/*7.9*/("""<title>weather Prediction</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*8.54*/routes/*8.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*8.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.59*/routes/*9.65*/.Assets.versioned("images/favicon.png")),format.raw/*9.104*/("""">
        <script src=""""),_display_(/*10.23*/routes/*10.29*/.Assets.versioned("javascripts/hello.js")),format.raw/*10.70*/("""" type="text/javascript"></script>
    </head>
    <body>
        <section id="top">
            <div class="wrapper">
                <h1>Welcome to Weather Prediction Application</h1>
            </div>
        </section>
        <div id="content" class="wrapper doc">
            <article>

                <h1>"""),_display_(/*21.22*/time),format.raw/*21.26*/("""</h1>
                <table border="8" cellpadding="10">
                    <tr>
                        <th>weather </th>
                        <th>meanTemperature </th>
                        <th>maxTemperature </th>
                        <th>minTemperature </th>
                        <th>meanPressure </th>
                        <th>maxPressure </th>
                        <th>minPressure </th>
                    </tr>
                    """),_display_(/*32.22*/for(i<- 0 to 6) yield /*32.37*/ {_display_(Seq[Any](format.raw/*32.39*/("""
                        """),format.raw/*33.25*/("""<tr>
                            <th>"""),_display_(/*34.34*/weatherResult(i)),format.raw/*34.50*/("""</th>
                            <th>"""),_display_(/*35.34*/meanTemperature(i)/*35.52*/.toInt),format.raw/*35.58*/("""</th>
                            <th>"""),_display_(/*36.34*/maxTemperature(i)/*36.51*/.toInt),format.raw/*36.57*/("""</th>
                            <th>"""),_display_(/*37.34*/minTemperature(i)/*37.51*/.toInt),format.raw/*37.57*/("""</th>
                            <th>"""),_display_(/*38.34*/meanPressure(i)/*38.49*/.toInt),format.raw/*38.55*/("""</th>
                            <th>"""),_display_(/*39.34*/maxPressure(i)/*39.48*/.toInt),format.raw/*39.54*/("""</th>
                            <th>"""),_display_(/*40.34*/minPressure(i)/*40.48*/.toInt),format.raw/*40.54*/("""</th>
                        </tr>
                    """)))}),format.raw/*42.22*/("""
                """),format.raw/*43.17*/("""</table>

            </article>
        </div>
    </body>
</html>

"""))
      }
    }
  }

  def render(time:String,weatherResult:Array[String],meanTemperature:IndexedSeq[Double],maxTemperature:IndexedSeq[Double],minTemperature:IndexedSeq[Double],meanPressure:IndexedSeq[Double],maxPressure:IndexedSeq[Double],minPressure:IndexedSeq[Double],request:RequestHeader,messagesProvider:MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(time,weatherResult,meanTemperature,maxTemperature,minTemperature,meanPressure,maxPressure,minPressure)(request,messagesProvider)

  def f:((String,Array[String],IndexedSeq[Double],IndexedSeq[Double],IndexedSeq[Double],IndexedSeq[Double],IndexedSeq[Double],IndexedSeq[Double]) => (RequestHeader,MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (time,weatherResult,meanTemperature,maxTemperature,minTemperature,meanPressure,maxPressure,minPressure) => (request,messagesProvider) => apply(time,weatherResult,meanTemperature,maxTemperature,minTemperature,meanPressure,maxPressure,minPressure)(request,messagesProvider)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Apr 17 14:00:33 EDT 2018
                  SOURCE: D:/Study/BigData/Assignment/csye7200-spring2018-group9/app/views/result.scala.html
                  HASH: 0fee00140126558398eb5929f7171355156acf73
                  MATRIX: 890->1|1301->316|1331->320|1413->428|1449->438|1563->526|1577->532|1639->573|1727->635|1741->641|1801->680|1854->706|1869->712|1931->753|2284->1079|2309->1083|2806->1553|2837->1568|2877->1570|2931->1596|2997->1635|3034->1651|3101->1691|3128->1709|3155->1715|3222->1755|3248->1772|3275->1778|3342->1818|3368->1835|3395->1841|3462->1881|3486->1896|3513->1902|3580->1942|3603->1956|3630->1962|3697->2002|3720->2016|3747->2022|3837->2081|3883->2099
                  LINES: 21->1|26->1|28->3|31->6|32->7|33->8|33->8|33->8|34->9|34->9|34->9|35->10|35->10|35->10|46->21|46->21|57->32|57->32|57->32|58->33|59->34|59->34|60->35|60->35|60->35|61->36|61->36|61->36|62->37|62->37|62->37|63->38|63->38|63->38|64->39|64->39|64->39|65->40|65->40|65->40|67->42|68->43
                  -- GENERATED --
              */
          