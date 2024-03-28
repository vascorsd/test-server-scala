import cats.effect._
import cats.syntax.all._

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
    IO.println("starting...") *>
      IO.println("goodbye!") *>
      ExitCode.Success.pure
}
