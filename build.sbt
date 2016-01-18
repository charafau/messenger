import Keys._

import android.Keys._

//android.Plugin.androidBuild

name := "Messenger"
organization := "com.nullpointerbay.messenger"
version := "0.0.1"
versionCode := Some(1)

scalaVersion := "2.11.7"

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")
scalacOptions ++= Seq("-feature", "-language:implicitConversions", "-language:postfixOps", "-target:jvm-1.7")
platformTarget in Android := "android-23"
minSdkVersion in Android := "21"


resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("releases")
)

fork in Test := true
publishArtifact in (Compile, packageDoc) := false
publishArtifact in Test := false
publishArtifact in Compile := false

proguardOptions in Android ++= io.Source.fromFile("proguard-sbt.txt").getLines.toSeq

// don't include jni libs in apk file
collectJni in Android := { List() }

// don't include assets - we don't use them
collectResources in Android := {
  val (assets, res) = (collectResources in Android).value
  (assets ** "*").get.foreach(_.delete())
  (assets, res)
}

libraryProject in Android := false

transitiveAndroidLibs in Android := true

useProguard in Android := true
useProguardInDebug in Android := (useProguard in Android).value
typedResources in Android := true
dexMulti in Android := false
dexMaxHeap in Android := "2048M"

val supportLibVersion = "23.1.1"

libraryDependencies ++= Seq (
  "com.koushikdutta.async" % "androidasync" % "2.1.6",
  "com.softwaremill.macwire" %% "macros" % "2.2.2" % "provided",
  aar("com.android.support" % "appcompat-v7" % "23.1.1"),
  aar("com.android.support" % "recyclerview-v7" % "23.1.1"),
  aar("com.android.support" % "cardview-v7" % "23.1.1")
)

protifySettings
