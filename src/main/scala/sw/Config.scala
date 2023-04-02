package sw

import com.typesafe.config.ConfigFactory
import io.circe.generic.auto.*
import io.circe.config.syntax.*

case class Rest(host: String, port: Int)

object Config:

  private val config = ConfigFactory.load()

  val Rest = config.as[Rest]("sw.rest")

