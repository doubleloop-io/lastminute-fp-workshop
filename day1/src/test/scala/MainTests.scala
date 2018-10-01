package day1

import minitest._

import java.io.ByteArrayOutputStream

object MainTests extends SimpleTestSuite {

  test("it works!") {
    val out = new ByteArrayOutputStream
    Console.withOut(out) {
      Main.main(Array())
    }
    val expected = """Hi,
                     |to everybody!""".stripMargin
    assertEquals(out.toString, expected)
  }
}
