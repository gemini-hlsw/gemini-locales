ThisBuild / tlBaseVersion       := "0.9"
ThisBuild / tlCiReleaseBranches := Seq("master")

enablePlugins(ScalaJSPlugin)
enablePlugins(TzdbPlugin)
enablePlugins(LocalesPlugin)

import locales._

Global / onChangedBuildSource := IgnoreSourceChanges

Global / resolvers ++= Resolver.sonatypeOssRepos("public")

val zonesFilterFn = { (z: String) => z == "America/Santiago" || z == "Pacific/Honolulu" }

zonesFilter := zonesFilterFn

dbVersion := TzdbPlugin.Version("2022a")

cldrVersion := CLDRVersion.Version("38.1")

localesFilter := LocalesFilter.Selection("en-US")

supportNumberFormats := false

crossScalaVersions := Seq("2.13.11", "3.2.1")

libraryDependencies ++= Seq(
  "io.github.cquiroz" %%% "scala-java-time" % "2.5.0"
)

libraryDependencies ++= {
  val sv = scalaBinaryVersion.value
  if (sv.startsWith("3"))
    // https://github.com/portable-scala/portable-scala-reflect/issues/23
    Seq(
      "org.portable-scala"   % "portable-scala-reflect_sjs1_2.13" % "1.1.2"
    )
  else
    Seq(
      "org.portable-scala" %%% "portable-scala-reflect"           % "1.1.2"
    )
}

inThisBuild(
  Seq(
    organization := "edu.gemini",
    homepage     := Some(url("https://github.com/gemini-hlsw/gemini-locales"))
  ) ++ lucumaPublishSettings
)

// doesn't work to do this `inThisBuild`
lazy val commonSettings = Seq(
  Compile / doc / scalacOptions --= Seq(
    "-Xfatal-warnings"
  )
)
