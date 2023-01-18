import org.http4s.server.Server
@main
def test(): Unit = {
  println("test")
}

@main
def server(): Unit = {
  import cats.effect._, org.http4s._, org.http4s.dsl.io._
  import cats.effect.unsafe.IORuntime
  implicit val runtime: IORuntime = cats.effect.unsafe.IORuntime.global

import cats.syntax.all._
import com.comcast.ip4s._
import org.http4s.ember.server._
import org.http4s.implicits._
import org.http4s.server.Router
import scala.concurrent.duration._
    
  val helloWorldService = HttpRoutes.of[IO] {
    case GET -> Root / "hello" / name =>
      Ok(s"Hello, $name.")
  }

  val httpApp = Router("/" -> helloWorldService).orNotFound

  val server: Resource[cats.effect.IO, Server] = EmberServerBuilder
    .default[IO]
    .withHost(ipv4"0.0.0.0")
    .withPort(port"8080")
    .withHttpApp(httpApp)
    .build

  val shutdown = server.allocated.unsafeRunSync()._2

      while (true) {}
}