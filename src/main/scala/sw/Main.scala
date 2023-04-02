package sw

import cats.effect.*
import org.http4s.implicits.*
import org.http4s.blaze.server.BlazeServerBuilder

object Main extends IOApp:

  override def run(args: List[String]): IO[ExitCode] =
    for {
      config <- IO.fromEither(Config.Rest)
      code <- BlazeServerBuilder[IO]
        .bindHttp(config.port, config.host)
        .withHttpApp(Server.routes.orNotFound)
        .serve
        .compile
        .drain
        .as(ExitCode.Success)
    } yield code
