package controllers

import javax.inject._

import play.api._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def response200() = Action { implicit request: Request[AnyContent] =>
    Logger.info("200")
    Ok(Json.toJson("Request successful"))
  }

  def response40X() = Action { implicit request: Request[AnyContent] =>
    Logger.info("400")
    BadRequest(Json.toJson("Bad request exception"))
  }

  def response50X() = Action { implicit request: Request[AnyContent] =>
    Logger.info("500")
    InternalServerError(Json.toJson("Some other exception"))
  }
}
