package gameapp

import minitest._

import java.io.ByteArrayOutputStream
import java.io.StringReader

object GameTests extends SimpleTestSuite {

  test("enter then quit") {
    val result = execute(input("Luke"), input("quit"))

    val expected =
      s"""|What is your name?
          |Hello, Luke, welcome to the game!
          |Use commands to play
          |Bye bye Luke!
          |""".stripMargin

    assertEquals(result, expected)
  }

  private def input(value: String): String =
    s"""|$value
        |""".stripMargin

  private def execute(inputs: String*): String = {
    val input = new StringReader(inputs.mkString(""))
    val out   = new ByteArrayOutputStream
    Console.withIn(input) {
      Console.withOut(out) {
        new Game().run()
      }
    }
    out.toString
  }
}
