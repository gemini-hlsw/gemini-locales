enablePlugins(ScalaJSPlugin)
enablePlugins(TzdbPlugin)

name in ThisBuild := "gemini-locales"

Global / onChangedBuildSource := IgnoreSourceChanges

val zonesFilterFn = {(z: String) => z == "America/Santiago" || z == "Pacific/Honolulu"}

zonesFilter := zonesFilterFn

dbVersion := TzdbPlugin.Version("2019c")

libraryDependencies ++= Seq(
  "io.github.cquiroz" %%% "scala-java-time" % "2.0.0-RC4"
)

inThisBuild(Seq(
  organization := "edu.gemini",
  homepage := Some(url("https://github.com/gemini-hlsw/gemini-locales")),
) ++ gspPublishSettings)

// doesn't work to do this `inThisBuild`
lazy val commonSettings = Seq(
  Compile / doc / scalacOptions --= Seq(
    "-Xfatal-warnings"
  )
)

scalaVersion := "2.13.1"

crossScalaVersions := Seq("2.13.1", "2.12.10")
