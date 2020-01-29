enablePlugins(ScalaJSPlugin)
enablePlugins(TzdbPlugin)

name in ThisBuild := "gemini-locales"

version := s"0.2.0-${dbVersion.value.id}"

Global / onChangedBuildSource := IgnoreSourceChanges

val zonesFilterFn = {(z: String) => z == "America/Santiago" || z == "Pacific/Honolulu"}

zonesFilter := zonesFilterFn

dbVersion := TzdbPlugin.Version("2019c")

libraryDependencies ++= Seq(
  "io.github.cquiroz" %%% "scala-java-time" % "2.0.0-RC3"
)

inThisBuild(Seq(
  homepage := Some(url("https://github.com/gemini-hlsw/gsp-core")),
  resolvers += "Gemini Repository" at "https://github.com/gemini-hlsw/maven-repo/raw/master/releases", // for gemini-locales
  crossScalaVersions := Seq(scalaVersion.value), // for now, until we get doobie/fs2 upgraded
) ++ gspPublishSettings)

// doesn't work to do this `inThisBuild`
lazy val commonSettings = Seq(
  Compile / doc / scalacOptions --= Seq(
    "-Xfatal-warnings"
  )
)
