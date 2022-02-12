addSbtPlugin("io.github.cquiroz" % "sbt-tzdb" % "2.0.0")

addSbtPlugin("io.github.cquiroz" % "sbt-locales" % "3.1.0")

resolvers += Resolver.sonatypeRepo("snapshots")
resolvers += "sonatype-s01-snapshots".at(
  "https://s01.oss.sonatype.org/content/repositories/snapshots"
)
addSbtPlugin("edu.gemini" % "sbt-lucuma-lib" % "0.6.0")

evictionErrorLevel := Level.Info
