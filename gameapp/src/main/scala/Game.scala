package gameapp

import scala.io.StdIn._

class Game {
  def run(): Unit = {
    println("What is your name?")
    val name = readLine().trim
    println(s"Hello, $name, welcome to the game!")
    println("Use commands to play")
    println("Bye bye Luke!")
  }
}
