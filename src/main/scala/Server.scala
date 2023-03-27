import cats.effect._
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.implicits._

object Server {

  val routes = HttpRoutes.of[IO] {

    case _ => Ok("Hello World")
  }
}
