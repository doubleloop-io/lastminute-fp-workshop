package inventory.answers

import cats._
import cats.implicits._

import ItemService._
import RandomId._
import Models._

object Examples {

  def demoOk[F[_]: Monad: ItemService]: F[Item] =
    for {
      item0 <- create("books", 5)
      uuid  = item0.id.value
      _ <- checkin(uuid, 10)
      _ <- rename(uuid, "pens")
      _ <- checkout(uuid, 3)
      item4 <- deactivate(uuid)
    } yield item4

  def demoBad[F[_]: Monad: ItemService]: F[Item] =
    for {
      item0 <- create("@books!", -5)
      uuid  = item0.id.value
      item1 <- checkin(uuid, 10)
    } yield item1

  def demoNotFound[F[_]: Monad: RandomId: ItemService]: F[Item] =
    for {
      uuid  <- nextId()
      item0 <- checkin(uuid, 10)
    } yield item0

}
