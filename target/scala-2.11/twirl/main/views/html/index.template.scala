
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[DateValue],RequestHeader,MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(dateValueForm:Form[DateValue])(implicit request: RequestHeader, messagesProvider: MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*24.22*/import helper._


Seq[Any](format.raw/*3.1*/("""


"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*9.62*/("""
        """),format.raw/*10.9*/("""<title>weather Prediction</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*11.54*/routes/*11.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*11.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*12.59*/routes/*12.65*/.Assets.versioned("images/favicon.png")),format.raw/*12.104*/("""">
        <script src=""""),_display_(/*13.23*/routes/*13.29*/.Assets.versioned("javascripts/hello.js")),format.raw/*13.70*/("""" type="text/javascript"></script>
    </head>
    <body>
        <section id="top">
            <div class="wrapper">
                <h1><a>Welcome to Weather Prediction Application</a></h1>
            </div>
        </section>
        <div id="content" class="wrapper doc">
            <article>
                <p>
                    """),format.raw/*25.1*/("""
                    """),_display_(/*26.22*/helper/*26.28*/.form(action = routes.HomeController.result())/*26.74*/{_display_(Seq[Any](format.raw/*26.75*/("""
                        """),_display_(/*27.26*/CSRF/*27.30*/.formField),format.raw/*27.40*/("""
                        """),_display_(/*28.26*/helper/*28.32*/.inputDate(dateValueForm("dateValue"))),format.raw/*28.70*/("""
                        """),format.raw/*29.25*/("""<img scr=""""),_display_(/*29.36*/routes/*29.42*/.Assets.versioned("images/favicon.png")),format.raw/*29.81*/("""">
                        <input type="submit"  value="Prediction">
                        """)))}),format.raw/*31.26*/("""
                """),format.raw/*32.17*/("""</p>
            </article>
        </div>
    </body>
</html>


"""))
      }
    }
  }

  def render(dateValueForm:Form[DateValue],request:RequestHeader,messagesProvider:MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(dateValueForm)(request,messagesProvider)

  def f:((Form[DateValue]) => (RequestHeader,MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (dateValueForm) => (request,messagesProvider) => apply(dateValueForm)(request,messagesProvider)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Apr 17 14:00:33 EDT 2018
                  SOURCE: D:/Study/BigData/Assignment/csye7200-spring2018-group9/app/views/index.scala.html
                  HASH: efec3bc0620d400e979c747078a3a12cc2493f60
                  MATRIX: 769->2|944->873|988->103|1017->106|1096->211|1132->220|1246->307|1261->313|1324->354|1412->415|1427->421|1488->460|1540->485|1555->491|1617->532|1984->889|2033->911|2048->917|2103->963|2142->964|2195->990|2208->994|2239->1004|2292->1030|2307->1036|2366->1074|2419->1099|2457->1110|2472->1116|2532->1155|2657->1249|2702->1266
                  LINES: 21->2|24->24|27->3|30->6|33->9|34->10|35->11|35->11|35->11|36->12|36->12|36->12|37->13|37->13|37->13|48->25|49->26|49->26|49->26|49->26|50->27|50->27|50->27|51->28|51->28|51->28|52->29|52->29|52->29|52->29|54->31|55->32
                  -- GENERATED --
              */
          