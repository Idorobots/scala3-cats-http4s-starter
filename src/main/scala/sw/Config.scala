package sw

import cats.effect.*
import com.typesafe.config.ConfigFactory
import io.circe.generic.auto.*
import io.circe.config.syntax.*

case class Rest(host: String, port: Int)

case class FreeCurrencyApi(apiKey: String)

case class Config(rest: Rest, freeCurrencyApi: FreeCurrencyApi)

object Config:

  def load(): Resource[IO, Config] =
    val config = IO.fromEither(ConfigFactory.load().as[Config]("sw"))
    Resource.eval(config)
