name := "FatJarClassClashExample"

version := "0.1"

scalaVersion := "2.12.6"

//Projects

lazy val global = project
  .in(file("."))
  .aggregate(
    common,
    libAproj,
    libBproj
  )

lazy val common = project
  .settings(
    name := "common",
    libraryDependencies ++= commonDependencies
  )

lazy val libAproj = project
    .settings(
      name := "libA"
    )

lazy val libBproj = project
    .settings(
      name := "libB"
    )

lazy val dependencies = new {
  val libAVersion = "1.0"
  val libBVersion = "2.0"

  val libA = "com.progrexor.sandbox" % "lib" % libAVersion
  val libB = "com.progrexor.sandbox" % "lib" % libBVersion
}

lazy val commonDependencies = Seq(
  //dependencies.libA,
  //dependencies.libB
)
