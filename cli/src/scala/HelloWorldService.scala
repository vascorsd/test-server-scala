import cats.effect._
import cats.syntax.all._

import com.comcast.ip4s._
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.ember.server._
import org.http4s.implicits._
import org.http4s.server._

class HelloWorldService() {
  val routes: HttpRoutes[IO] = HttpRoutes.of[IO] { //
    case GET -> Root / "hello" / name => Ok(s"Hello, $name.")
  }
}
