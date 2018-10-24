enablePlugins(ScalaJSPlugin)
enablePlugins(TzdbPlugin)

name in ThisBuild := "gemini-locales"

version := s"0.1.0-${dbVersion.value.id}"

scalaVersion := "2.12.7"

// Adjust to your local layout
publishTo := Some(Resolver.file("file", Path.userHome / "Projects" / "maven-repo") )

val zonesFilterFn = {(z: String) => z == "America/Santiago" || z == "Pacific/Honolulu"}

zonesFilter := zonesFilterFn

dbVersion := TzdbPlugin.Version("2018f")

libraryDependencies ++= Seq(
  "io.github.cquiroz" %%% "scala-java-time" % "2.0.0-M13"
)

organization := "edu.gemini"

description := "Gemini locales db for Scala.js applications"

homepage := Some(url("https://github.com/gemini-hlsw/gemini-locales"))

licenses := Seq(
  "BSD 3-Clause License" -> url(
    "https://opensource.org/licenses/BSD-3-Clause"))

publishMavenStyle in ThisBuild := true

pomIncludeRepository := { _ => false }
