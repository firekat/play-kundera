import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "play-kundera"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
        "com.impetus.client" % "kundera-cassandra" % "2.3"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
        ebeanEnabled := false, 
        resolvers += "Kundera" at "https://oss.sonatype.org/content/repositories/releases",
        resolvers += "Riptano" at "http://mvn.riptano.com/content/repositories/public",
        resolvers += "Kundera missing" at "http://kundera.googlecode.com/svn/maven2/maven-missing-resources",
        resolvers += "Scale 7" at "https://github.com/s7/mvnrepo/raw/master"    
   )
}
