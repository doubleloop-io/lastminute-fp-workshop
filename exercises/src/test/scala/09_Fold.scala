package exercises

import minitest._

/*
 *
 */

object FoldTests extends SimpleTestSuite {

  import scala.util.{Failure, Success, Try}

  case class NotAnIntException(s: String) extends RuntimeException(s"not an int: $s")
  case class DivByZeroException()         extends RuntimeException("div by zero")

  val toi: String => Try[Int] =
    s =>
      if (s.matches("^[0-9]+$")) Success(s.toInt)
      else Failure(NotAnIntException(s))

  val dec: Int => Int =
    n => n - 1

  val div: Int => Try[Int] =
    n =>
      if (n != 0) Success(n / n)
      else Failure(DivByZeroException())

  val tos: Int => String =
    n => n.toString

  test("remove effect - happy") {
    val program: String => Try[String] =
      s => toi(s).map(dec).flatMap(div).map(tos)

    ignore("use getOrElse to remove the Try effect")
    val result = program("10")
    assertEquals(result, "1")
  }

  test("remove effect - fail") {
    val program: String => Try[String] =
      s => toi(s).map(dec).flatMap(div).map(tos)

    ignore("use getOrElse to remove the Try effect")
    val result = program("1")
    assertEquals(result, "zero")
  }

  test("remove effect") {
    val program: String => Try[String] =
      s => toi(s).map(dec).flatMap(div).map(tos)

    ignore("use fold to remove the Try effect")
    val result = program("1")
    assertEquals(result, DivByZeroException().getMessage)
  }
}
