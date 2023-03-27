val scala3Version = "3.2.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Scala3 Cats http4s starter",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test
    ),

    semanticdbEnabled := true,

    coverageEnabled := true,

    scalacOptions ++= Seq(
      "-feature", "-unchecked", "-deprecation", "-encoding", "utf8",
      "-Xfatal-warnings"
    ),

  )
