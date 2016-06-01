package pl.warsawscala.rest

import com.typesafe.scalalogging.StrictLogging
import play.api.http.HttpErrorHandler
import play.api.mvc.{RequestHeader, Result}
import play.api.mvc.{Call, Results}
import scala.concurrent.Future
import com.google.inject.Singleton

@Singleton
class ErrorHandler extends HttpErrorHandler with StrictLogging {

  def onClientError(request: RequestHeader, statusCode: Int, message: String): Future[Result] =
    Future.successful(
      Results.Status(statusCode)(s"A client error occurred: $message")
    )

  def onServerError(request: RequestHeader, exception: Throwable): Future[Result] =
    Future.successful {
      logger.error("", exception)
      Option(request.path) match {
        case Some(path) =>
          if (path.endsWith("/")) {
            val p = path.substring(0, path.length - 1)
            Results.Redirect(new Call(request.method, p))
          } else {
            val cutSlash = request.uri.substring(1)
            Results.NotFound(cutSlash)
          }
        case _ =>
          Results.NotFound("")
      }
    }

}
