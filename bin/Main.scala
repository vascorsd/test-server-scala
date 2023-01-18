package demo

import cats.effect._
import io.chrisdavenport.crossplatformioapp.CrossPlatformIOApp

object Main extends CrossPlatformIOApp.Simple {
  def run =
    IO.println("starting...") *>
      Server.launch() *>
      IO.println("goodbye!") // this does not appear
}
