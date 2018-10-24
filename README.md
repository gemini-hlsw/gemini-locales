# gemini-locales

Builds a db with timezones and locales for scala.js Gemini project

## How to publish

To publish an updated version you need need to:

1. Fork the maven-repo repository at [maven-repo](https://github.com/gemini-hlsw/maven-repo)
2. Checkout your fork to your local development environment, we'll assume it is at dir `MAVEN_REPO`
3. On the file `build.sbt` change the `publishTo` setting from

```
publishTo := Some(Resolver.file("file", Path.userHome / "Projects" / "maven-repo") )
```

to

```
publishTo := Some(Resolver.file("file", MAVEN_REPO))
```

4. publish your bundles on `sbt` with the `publishLocal` command
5. go to your maven repo dir (`MAVEN_REPO`) and create a commit with the newly published jar and pom files
