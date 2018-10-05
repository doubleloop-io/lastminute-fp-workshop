# @color[GoldenRod](Why)
# functional programming?

---
## before to jump on that...

---
## What should we @color[IndianRed](expect)
## from a fp workshop?

---
## It's a bit like 
## @color[GoldenRod](learn) to program @color[IndianRed](again)

---
## try to do not judge what you will see with the eyes of what you know today

---
## try to think how your life would have been different if we had always programmed like that

---
## We need a @color[GoldenRod](place) and @color[GoldenRod](time)
## to @color[IndianRed](experiment) and @color[IndianRed](fail)
## spectacularly

---
## This workshop is that @color[GoldenRod](place)

---
## @color[GoldenRod](free) your @color[IndianRed](mind)

---
## let's get back to the starting point

---
# Why functional programming?

---
## @color[GoldenRod](composition)

---
## Functional Programming
@color[GoldenRod](compose functions) as a central<br />
building block to write software

---
# why is the composition so important?

---
> How do we solve problems? 
> We decompose bigger problems into smaller problems. 
> If the smaller problems are still too big, we decompose them further, and so on.

---
> Finally, we write code that solves all the small problems.

---
> And then comes the essence of programming:
> we compose those pieces of code to create solutions to larger problems.

---
> Decomposition wouldn’t make sense if we weren’t able to put the pieces back together. - Bartosz Milewski

---
## True Story
### In Complex System devs dedicate 
### a significant portion of code 
### and effort to such composition

---
## who is the number one enemy of the composition?

---
## side-effects

---
## can't composition
```scala
val toS : Int => String = n => {
  appendAll("log.txt", "some content")
  n.toString
}
```

---
## Even this
```scala
val list = collection.mutable.ListBuffer[Int]()

val toS : Int => String = n => {
  list += n
  if (list.size < 42) n.toString
  else "Yo!"
}
```

---
## Side-effects are a @color[IndianRed](complexity source)
- hide inputs and outputs
- destroy testability
- destroy composability

---
## In other words
FP is about @color[IndianRed](eliminating) or @color[GoldenRod](controlling) side-effects

---
## Functional Programming
the term “function” refer to the @color[IndianRed](mathematical) one:
- @color[GoldenRod](Total): it must yield a value for every possible input
- @color[GoldenRod](Deterministic): it must yield the same value for the same input
- @color[GoldenRod](Pure): it’s only effect must be the computation of its return value

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
val y = foo(x)
val z = y + y
```

```scala
val z = foo(x) + foo(x)
```

---
## Referential Transparency Benefits
functions get an @color[IndianRed](extraordinary quality) boost:
- easier to @color[GoldenRod](reason)
- easier to @color[GoldenRod](compose)
- easier to @color[GoldenRod](refactor)
- easier to @color[GoldenRod](test)
