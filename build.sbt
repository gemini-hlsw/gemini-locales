ThisBuild / tlBaseVersion       := "0.12"
ThisBuild / tlCiReleaseBranches := Seq("master")

enablePlugins(ScalaJSPlugin)
enablePlugins(TzdbPlugin)
enablePlugins(LocalesPlugin)

import locales._

Global / onChangedBuildSource := IgnoreSourceChanges

val zonesFilterFn = { (z: String) => z == "America/Santiago" || z == "Pacific/Honolulu" }

zonesFilter := zonesFilterFn

dbVersion := TzdbPlugin.Version("2022a")

cldrVersion := CLDRVersion.Version("38.1")

localesFilter := LocalesFilter.Selection("en-US")

supportNumberFormats := false

scalaVersion := "3.7.2"

libraryDependencies ++= Seq(
  "io.github.cquiroz" %%% "scala-java-time" % "2.6.0"
)

libraryDependencies ++= {
  Seq(
    ("org.portable-scala" %%% "portable-scala-reflect" % "1.1.3").cross(CrossVersion.for3Use2_13)
  )
}

libraryDependencies += "org.scala-lang" %% "scala3-library" % scalaVersion.value
