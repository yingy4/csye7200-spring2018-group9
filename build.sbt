name := "gropu9Project"
 
version := "1.0" 
      
lazy val `gropu9project` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

scalaVersion := "2.11.8"

val scalaTestVersion = "2.2.4"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )

libraryDependencies += "org.scalatest" %% "scalatest" % scalaTestVersion % "test"

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.2.0"

libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.2.0"

libraryDependencies += "org.apache.spark" % "spark-mllib_2.11" % "2.2.0"

libraryDependencies ++= Seq("org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2", "org.apache.spark" % "spark-mllib_2.11" % "2.2.0")

dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.8.11"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.11"
dependencyOverrides += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.8.11"

libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.7.2"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

parallelExecution in Test := false

      