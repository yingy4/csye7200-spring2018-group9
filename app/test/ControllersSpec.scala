package test

import controllers.ExampleController
import org.scalatestplus.play._
import play.api.mvc._
import play.api.test.Helpers._
import play.api.test._

import scala.concurrent.Future

class ControllersSpec extends PlaySpec with Results{
  "Example Page#index" should {
    "should be valid" in {
      val controller = new ExampleController()
      val result: Future[Result] = controller.index().apply(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText mustBe "ok"
    }
  }
}
