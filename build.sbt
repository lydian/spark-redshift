net.virtualvoid.sbt.graph.Plugin.graphSettings

organization := "com.databricks.examples.redshift"

name := "redshift-input-format"

version := "0.1"

scalaVersion := "2.10.4"

sparkVersion := "1.3.0"

spName := "databricks/spark-redshift"

sparkComponents += "sql"

libraryDependencies := libraryDependencies.value.map { module =>
  if (module.name.indexOf("spark-sql") >= 0) {
    module.exclude("org.apache.hadoop", "hadoop-client")
  } else {
    module
  }
}

libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "1.0.4"

libraryDependencies += "com.google.guava" % "guava" % "14.0.1" % Test

libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.5" % Test