package controllers

import play.api.mvc.{Action, Controller}

class ExampleController extends Controller {
  def index() = Action {
    Ok("ok")
  }
}
