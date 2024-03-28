import cats.data.Kleisli
import cats.effect.*
import cats.syntax.all.*

import com.comcast.ip4s.*
import org.http4s.*
import org.http4s.server.*
import org.http4s.dsl.io.*
import org.http4s.implicits.*
import org.http4s.ember.server.*

object Server {

  val servicesRoutes: HttpRoutes[IO] =
    new HelloWorldService().routes <+>
      new PingService().routes

  val router = Router("/" -> servicesRoutes).orNotFound

  def launch(): IO[Unit] = {
    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"0.0.0.0")
      .withPort(port"8080")
      .withHttpApp(router)
      .build
      .use(_ => IO.never)
      .as(())
  }
}
