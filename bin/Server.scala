package demo

import cats.effect._
import cats.syntax.all._

import com.comcast.ip4s._
import org.http4s._
import org.http4s.server._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.ember.server._


object Server {
  val helloWorldService = HttpRoutes.of[IO] {
    case GET -> Root / "hello" / name =>
      Ok(s"Hello, $name.")
  }

  val httpApp = Router("/" -> helloWorldService).orNotFound

  def launch(): IO[Unit] = {
    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"0.0.0.0")
      .withPort(port"8080")
      .withHttpApp(httpApp)
      .build
      .use(_ => IO.never)
      .as(())
  }
}
