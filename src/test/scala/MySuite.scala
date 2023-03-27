import cats.effect._
import cats.syntax.all._
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.implicits._

class MySuite extends munit.CatsEffectSuite {
  test("Server responds to pings") {
    val request = Request[IO](Method.GET, uri"/")

    Server.routes.orNotFound.run(request).flatMap { response =>
      assertEquals(response.status, Status.Ok)
      response.as[String].assertEquals(Server.message)
    }
  }
}
