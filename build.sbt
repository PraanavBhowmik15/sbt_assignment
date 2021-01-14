name := "Assignment"
version := "1.4.4"
scalaVersion := "2.12.12"
sbtPlugin := true

lazy val common = project.in(file("common"))
	.settings(
		libraryDependencies ++= Seq("org.json4s" %% "json4s-native" % "3.7.0-M7",
		"org.slf4j" % "slf4j-api" % "1.7.30",
		"com.typesafe" % "config" % "1.4.1",
		"org.scalatest" %% "scalatest" % "3.2.3" % Test,
		"org.mockito" %% "mockito-scala" % "1.16.15"  ))
	
lazy val persistance = project.in(file("persistance")).settings(
		libraryDependencies ++= Seq("com.typesafe.slick" %% "slick" % "3.3.3",
		"org.postgresql" % "postgresql" % "42.2.18",
		"com.h2database" % "h2" % "1.4.200" % Test   )).dependsOn(common)
		
lazy val root = project.in(file(".")).aggregate(common,persistance)
	
		
