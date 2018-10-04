package gameapp

import scala.io.StdIn._

class Game {
  import Domain._
  import Logic._

  object Domain {

    case class Player(name: String, var x: Int, var y: Int)

    object Player {
      def begin(name: String) = Player(name, 0, 0)
    }

    case class Field(grid: Vector[Vector[String]])

    object Field {
      def mk20x20 =
        Field(Vector.fill(20, 20)("-"))
    }

    case class GameWorld(player: Player, field: Field)
  }

  object Logic {

    val enter = System.getProperty("line.separator")

    var executing        = true
    var world: GameWorld = null

    def initWorld(): Unit = {
      world = GameWorld(Player.begin(askName()), Field.mk20x20)
      println("Use commands to play")
    }

    def askName(): String = {
      println("What is your name?")
      val name = readLine().trim
      println(s"Hello, $name, welcome to the game!")
      name
    }

    def gameLoop(): Unit =
      while (executing) {
        gameStep()
      }

    def gameStep(): Unit = {
      val line = readLine()

      if (line.length > 0) {
        val words = line.trim.toLowerCase.split("\\s+")
        words(0) match {

          case "help" => {
            printHelp()
          }

          case "show" => {
            printWorld()
          }

          case "move" => {
            if (words.length < 2)
              println("Missing direction")
            else {
              try {
                words(1) match {
                  case "up"    => move((-1, 0))
                  case "down"  => move((1, 0))
                  case "right" => move((0, 1))
                  case "left"  => move((0, -1))
                  case _       => println("Unknown direction")
                }
              } catch {
                case e: Exception => println(e.getMessage)
              }
            }
          }

          case "quit" => {
            printQuit()
            executing = false
          }

          case _ => {
            println("Unknown command")
          }

        }
      }
    }

    def move(delta: (Int, Int)): Unit = {
      val newX = world.player.x + delta._1
      val newY = world.player.y + delta._2

      val size = world.field.grid.size - 1
      if (newX < 0
          || newY < 0
          || newX > size
          || newY > size) throw new Exception("Invalid direction")

      world.player.x = newX
      world.player.y = newY
    }

    def printWorld(): Unit =
      println(renderWorld)

    def printQuit(): Unit =
      println(s"Bye bye ${world.player.name}!")

    def printHelp(): Unit = {
      val value =
        s"""|
            |Valid commands:
            |
            | help
            | show
            | move <up|down|left|right>
            | quit
            |""".stripMargin
      println(value)
    }

    def renderWorld: String = {
      val x       = world.player.x
      val y       = world.player.y
      val grid    = world.field.grid
      val updated = grid.updated(x, grid(x).updated(y, "x"))

      enter + updated.map(_.mkString(" ")).mkString(enter) + enter
    }
  }

  def run(): Unit = {
    initWorld()
    gameLoop()
  }
}
