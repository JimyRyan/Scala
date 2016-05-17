name := "Guillaume Mocquet's Teads test"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % "2.11.8",
    "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4",
    "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"
)