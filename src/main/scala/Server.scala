import cats.effect.*
import org.http4s.*
import org.http4s.dsl.io.*
import org.http4s.implicits.*

object Server:

  val routes = HttpRoutes.of[IO] {

    case _ => Ok("Hello World")
  }
