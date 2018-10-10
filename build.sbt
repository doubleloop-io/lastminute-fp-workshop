addCommandAlias("fm", "all compile:scalafmt test:scalafmt")
addCommandAlias("t", "test")
addCommandAlias("to", "testOnly")
addCommandAlias("ps", "projects")
addCommandAlias("p", "project")

lazy val global = project
  .in(file("."))
  .settings(settings)
  .aggregate(exercises, marsroverkata, random)

lazy val exercises = project
  .settings(
    name := "exercises",
    settings
  )

lazy val marsroverkata = project
  .settings(
    name := "marsroverkata",
    settings
  )

lazy val random = project
  .settings(
    name := "random",
    settings
  )

lazy val settings = Seq(
  organization := "io.doubleloop",
  scalaVersion := "2.12.7",
  version := "0.1.0-SNAPSHOT",
  scalacOptions ++= scalacSettings,
  resolvers ++= resolversSettings,
  libraryDependencies ++= libsSettings,
  testFrameworks += new TestFramework("minitest.runner.Framework"),
  addCompilerPlugin("com.olegpy"     %% "better-monadic-for" % "0.2.4"),
  addCompilerPlugin("org.spire-math" %% "kind-projector"     % "0.9.8"),
  addCompilerPlugin(("org.scalamacros" % "paradise" % "2.1.0").cross(CrossVersion.full)),
)

lazy val scalacSettings = Seq(
  "-encoding",
  "UTF-8",
  "-deprecation",
  "-unchecked",
  "-feature",
  "-explaintypes",
  "-opt-warnings",
  "-language:existentials",
  "-language:higherKinds",
  "-opt:l:inline",
  "-opt-inline-from:<source>",
  "-Ypartial-unification",
  "-Yrangepos",
  "-Yno-adapted-args",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Ywarn-extra-implicit",
  "-Ywarn-inaccessible",
  "-Ywarn-infer-any",
  "-Ywarn-nullary-override",
  "-Ywarn-nullary-unit",
  "-Ywarn-unused:_,-imports",
  "-Xsource:2.13",
  "-Xlint:_,-type-parameter-shadow",
  "-Xfuture"
)

lazy val resolversSettings = Seq(
  Resolver.sonatypeRepo("public"),
  Resolver.sonatypeRepo("snapshots"),
  Resolver.sonatypeRepo("releases")
)

lazy val monocleVersion = "1.5.1-cats"

lazy val libsSettings = Seq(
  "org.typelevel"              %% "cats-core"     % "1.4.0",
  "org.typelevel"              %% "cats-effect"   % "1.0.0",
  "org.typelevel"              %% "cats-mtl-core" % "0.2.3",
  "com.github.julien-truffaut" %% "monocle-core"  % monocleVersion,
  "com.github.julien-truffaut" %% "monocle-macro" % monocleVersion,
  "net.debasishg"              %% "redisclient"   % "3.7",
  "com.github.mpilquist"       %% "simulacrum"    % "0.13.0",
  "io.monix"                   %% "minitest"      % "2.1.1" % Test
)