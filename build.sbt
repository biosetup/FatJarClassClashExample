name := "FatJarClassClashExample"

version := "0.1"

scalaVersion := "2.12.6"

lazy val libADependency = "com.progrexor.sandbox.sbt" %% "libs" % "1.0"
lazy val libBDependency = "com.progrexor.sandbox.sbt" %% "libs" % "2.0"

lazy val LibA = project
  .settings(
    name := "libs",
    organization := "com.progrexor.sandbox.sbt",
    version := "1.0",
  )

lazy val LibB = project
  .settings(
    name := "libs",
    organization := "com.progrexor.sandbox.sbt",
    version := "2.0",
  )

commands += Command.command("libPub") { state =>
  "LibA/publishLocal" ::
  "LibB/publishLocal" ::
  state
}

lazy val LADep = Seq(
  libADependency
)

lazy val LBDep = Seq(
  libBDependency
)

lazy val projMain = project
  .settings(
    assemblySettings,
  )
  .dependsOn(projUsesLibA, projUsesLibB)

lazy val projUsesLibA = project
  .settings(
    libraryDependencies ++= LADep,
  )

lazy val projUsesLibB = project
  .settings(
    libraryDependencies ++= LBDep
  )

lazy val assemblySettings = Seq(
//  assemblyMergeStrategy in assembly := {
//    case PathList("com", "progrexor", "sandbox", "sbt", sq @ _*) => MergeStrategy.concat
//  },
  assemblyShadeRules in assembly := Seq(
    ShadeRule
      .rename("com.progrexor.sandbox.**" -> "shadedLibB.@0")
      .inLibrary(libBDependency)
      .inProject
  )
)
