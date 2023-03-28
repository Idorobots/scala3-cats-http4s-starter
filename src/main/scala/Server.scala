import cats.data.*
import cats.effect.*
import cats.implicits.*
import io.circe.syntax.*
import io.circe.disjunctionCodecs.*
import org.http4s.*
import org.http4s.circe.*
import org.http4s.dsl.io.*
import org.http4s.implicits.*

import ConversionRate.given

object Server:
  val message = "Hello World"

  val routes = HttpRoutes.of[IO] {

    case GET -> Root / "ping" =>
      Ok(message)

    case GET -> Root / "convert" / source / destination =>
      ConversionRate
        .create(source, destination, 23.5)
        .fold(e => BadRequest(e.foldLeft("")(_ ++ _)), c => Ok(c.asJson))

    case unknown =>
      NotFound()
  }
