package sw

import cats.effect.*
import cats.syntax.all.*
import org.http4s.*
import org.http4s.dsl.io.*
import org.http4s.implicits.*

import sw.service.FreeCurrencyApi

class ServerSuite extends munit.CatsEffectSuite:
  test("Server responds to pings") {
    val request = Request[IO](Method.GET, uri"/ping")

    val mockService = new FreeCurrencyApi:
      def latest(base: String, targets: List[String]): IO[Map[String, Double]] =
        IO(Map("USD" -> 23.5))

    Server.routes(mockService).orNotFound.run(request).flatMap { response =>
      assertEquals(response.status, Status.Ok)
      response.as[String].assertEquals(Server.message)
    }
  }
