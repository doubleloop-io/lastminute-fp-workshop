package marsroverkata

import minitest._

import java.io.ByteArrayOutputStream
import java.io.StringReader

object GameTests extends SimpleTestSuite {

  test("example") {
    ignore("remove me")
    val result = execute(inputs("5x5", noObstacles, "0,0", "rrffflbb"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "E:3,3"
    )

    assertEquals(result, expected)
  }

  test("discard invalid commnds and keep going") {
    ignore("remove me")
    val result = execute(inputs("5x5", noObstacles, "2,3", "frzffxrbbylbll"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "W:4,4"
    )

    assertEquals(result, expected)
  }

  test("hit an obstacle") {
    ignore("remove me")
    val result = execute(inputs("5x5", "0,0/2,2", "0,2", "lfff"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "W:0,1"
    )

    assertEquals(result, expected)
  }

  test("move forward") {
    ignore("remove me")
    val result = execute(inputs("10x10", noObstacles, "5,5", "ff"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "N:3,5"
    )

    assertEquals(result, expected)
  }

  test("move backward") {
    ignore("remove me")
    val result = execute(inputs("10x10", noObstacles, "5,5", "bb"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "N:7,5"
    )

    assertEquals(result, expected)
  }

  test("turn 90 to the right") {
    ignore("remove me")
    val result = execute(inputs("2x2", noObstacles, "0,0", "r"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "E:0,0"
    )

    assertEquals(result, expected)
  }

  test("turn 180 to the right") {
    ignore("remove me")
    val result = execute(inputs("2x2", noObstacles, "0,0", "rr"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "S:0,0"
    )

    assertEquals(result, expected)
  }

  test("turn 270 to the right") {
    ignore("remove me")
    val result = execute(inputs("2x2", noObstacles, "0,0", "rrr"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "W:0,0"
    )

    assertEquals(result, expected)
  }

  test("turn 360 to the right") {
    ignore("remove me")
    val result = execute(inputs("2x2", noObstacles, "0,0", "rrrr"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "N:0,0"
    )

    assertEquals(result, expected)
  }

  test("turn 90 to the left") {
    ignore("remove me")
    val result = execute(inputs("2x2", noObstacles, "0,0", "l"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "W:0,0"
    )

    assertEquals(result, expected)
  }

  test("turn 180 to the left") {
    ignore("remove me")
    val result = execute(inputs("2x2", noObstacles, "0,0", "ll"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "S:0,0"
    )

    assertEquals(result, expected)
  }

  test("turn 270 to the left") {
    ignore("remove me")
    val result = execute(inputs("2x2", noObstacles, "0,0", "lll"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "E:0,0"
    )

    assertEquals(result, expected)
  }

  test("turn 360 to the left") {
    ignore("remove me")
    val result = execute(inputs("2x2", noObstacles, "0,0", "llll"))

    val expected = outputs(
      "Welcome to the Mars Rover Kata!",
      "What is the size of the planet?",
      "Where are obstacles?",
      "What is the position of the rover?",
      "Waiting commands...",
      "N:0,0"
    )

    assertEquals(result, expected)
  }

  private def inputs(value: String*): String =
    value.toList.mkString(enter)

  private def outputs(value: String*): String =
    value.toList.mkString(enter)

  private def execute(value: String): String = {
    val input = new StringReader(value)
    val out   = new ByteArrayOutputStream
    Console.withIn(input) {
      Console.withOut(out) {
        new Game().run()
      }
    }
    out.toString.split("\\r?\\n").toList.mkString(enter)
  }

  private val enter = System.getProperty("line.separator")

  private val noObstacles = ""
}
