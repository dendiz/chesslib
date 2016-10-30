```
mvn install:install-file -Dfile=<path-to-file>
```

mvn install:install-file -Dfile=target/chesslib-0.0.1-SNAPSHOT.jar -DgroupId=com.dendiz -DartifactId=chesslib -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar
# chesslib
chess game processing lib maven repo.

# usage


```
resolvers += "dendiz.com" at "http://mvn.dendiz.com/repository/internal"
libraryDependencies ++= Seq("com.dendiz" % "chesslib" % "1.2")

```
