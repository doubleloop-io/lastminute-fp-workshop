# What is functional programming?

---
## before to jump on that...

---
## What should we expect from a functional programming workshop?

---
## It's a bit like learning to program again

---
## to do that we nead a place to experiment and fail spectacularly

---
## This workshop **is** that place

---
## try to do not judge what you will see with the eyes of what you know today

---
## try to think how your life would have been different if we had always programmed like that

---
## let's get back to the starting point

---
# What is functional programming?
---
# @color[GoldenRod](Pure)
# Functional
# @color[IndianRed](Programming)

---
## Functional Programming
@color[GoldenRod](compose functions) as a central<br />
building block to write software
<br /><br />
```scala
val toS: Int => String = 
  n => n.toString

val fromS: String => Int = 
  s => s.length

val toAndFrom: Int => Int = 
  fromS compose toS
```
@[1-2](from Int to String)
@[4-5](from String to Int)
@[7-8](compose them)

---
## Pure Functional Programming
in this context “function” refer to the @color[IndianRed](mathematical) one
- @color[GoldenRod](Total): it must yield a value for every possible input
- @color[GoldenRod](Deterministic): it must yield the same value for the same input
- @color[GoldenRod](Pure): it’s only effect must be the computation of its return value

---
## This is not valid
```scala
val toS : Int => String = n => {
  appendAll("log.txt", "some content")
  n.toString
}
```

---
## Nor even this
```scala
val list = collection.mutable.ListBuffer[Int]()

val toS : Int => String = n => {
  list += n
  if (list.size < 42) n.toString
  else "Yo!"
}
```

---
## In other words
pure FP is about @color[IndianRed](eliminating) or @color[GoldenRod](controlling) side-effects
```scala
// pure (function w/out side-effect)
val f: A => B = ...

// effectful (function w/ controlled side-effect)
val g: A => F[B] = ...
```

---
## It's a @color[IndianRed](huge) constraint
## why @color[GoldenRod](embrace) it?

---
## Side-effects are a @color[IndianRed](complexity source)
- hide inputs and outputs
- destroy testability
- destroy composability

---
## We earn back
that all functions become @color[GoldenRod](referentially transparent)

---
## Referential Transparency
An @color[GoldenRod](expression can be replaced) with<br />
its corresponding value @color[IndianRed](without changing)<br >
the program's behavior

---
## Referential Transparency
it means these two programs yield the @color[GoldenRod](same result)
```scala
val x = foo(42)
val y = x + x
```

```scala
val y = foo(42) + foo(42)
```

---
## Referential Transparency Benefits
functions get an @color[IndianRed](extraordinary quality) boost:
- easier to @color[GoldenRod](reason)
- easier to @color[GoldenRod](compose)
- easier to @color[GoldenRod](refactor)
- easier to @color[GoldenRod](test)
