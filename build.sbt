enablePlugins(ScalaJSPlugin)
enablePlugins(TzdbPlugin)
enablePlugins(LocalesPlugin)

import locales._

name in ThisBuild := "gemini-locales"

Global / onChangedBuildSource := IgnoreSourceChanges

Global / resolvers += Resolver.sonatypeRepo("public")

val zonesFilterFn = {(z: String) => z == "America/Santiago" || z == "Pacific/Honolulu"}

zonesFilter := zonesFilterFn

dbVersion := TzdbPlugin.Version("2019c")

cldrVersion := CLDRVersion.Version("36")

localesFilter := LocalesFilter.Selection("en-US")

supportNumberFormats := false

libraryDependencies ++= Seq(
  "io.github.cquiroz" %%% "scala-java-time" % "2.2.0",
  "org.portable-scala" %% "portable-scala-reflect" % "1.1.1"
)

inThisBuild(Seq(
  organization := "edu.gemini",
  homepage := Some(url("https://github.com/gemini-hlsw/gemini-locales")),
) ++ lucumaPublishSettings)

// doesn't work to do this `inThisBuild`
lazy val commonSettings = Seq(
  Compile / doc / scalacOptions --= Seq(
    "-Xfatal-warnings"
  )
)

