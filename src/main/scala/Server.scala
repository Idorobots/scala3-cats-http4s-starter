import cats.effect.*
import org.http4s.*
import org.http4s.dsl.io.*
import org.http4s.headers.`Content-Type`
import org.http4s.implicits.*

object Server:
  val message = "Hello World"

  val routes = HttpRoutes.of[IO] {

    case _ => Ok(message).map(_.withContentType(`Content-Type`(MediaType.text.plain)))

  }
