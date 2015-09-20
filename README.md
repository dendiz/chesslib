```
mvn install:install-file -Dfile=<path-to-file>
```

mvn install:install-file -Dfile=target/chesslib-0.0.1-SNAPSHOT.jar -DgroupId=com.dendiz -DartifactId=chesslib -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar
# chesslib
chess game processing lib maven repo.

# usage
```
<repositories>
    <repository>
        <id>chesslib-mvn-repo</id>
        <url>https://raw.github.com/dendiz/chesslib/mvn-repo/</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
</repositories>
```
