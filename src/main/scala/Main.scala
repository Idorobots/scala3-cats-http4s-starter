import cats.effect._
import org.http4s.implicits._
import org.http4s.blaze.server.BlazeServerBuilder

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = BlazeServerBuilder[IO]
    .bindHttp(8080, "localhost")
    .withHttpApp(Server.routes.orNotFound)
    .serve
    .compile
    .drain
    .as(ExitCode.Success)

}
