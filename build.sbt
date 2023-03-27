val scala3Version = "3.2.2"
val http4sVersion = "0.23.14"
val circeVersion = "0.15.0-M1"
val ironVersion = "2.0.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Scala3 Cats http4s starter",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      // HTTP server
      "org.http4s" %% "http4s-core" % http4sVersion,
      "org.http4s" %% "http4s-dsl" % http4sVersion,
      "org.http4s" %% "http4s-blaze-server" % http4sVersion,
      "org.http4s" %% "http4s-circe" % http4sVersion,

      // JSON
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,

      // Type constraints
      "io.github.iltotore" %% "iron" % ironVersion,
      "io.github.iltotore" %% "iron-cats" % ironVersion,
      "io.github.iltotore" %% "iron-circe" % ironVersion,
    ),

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test,
    ),

    semanticdbEnabled := true,

    coverageEnabled := true,

    scalacOptions ++= Seq(
      "-feature", "-unchecked", "-deprecation", "-encoding", "utf8",
      "-Xfatal-warnings"
    ),

  )
