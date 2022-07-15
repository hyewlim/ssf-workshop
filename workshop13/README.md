## Workshop 13

* Run the spring boot app

Linux/MacOS
```
mvn spring-boot:run -Dspring-boot.run.arguments=--dataDir=/opt/tmp/data
```
mvn spring-boot:run -Dspring-boot.run.arguments=--dataDir=/Users/kennethphang/Projects/workshop13/data
Windows
```
mvn spring-boot:run -Dspring-boot.run.arguments=--dataDir=C:/data
mvn spring-boot:run -Dspring-boot.run.arguments=--dataDir=D:\Workspace\Server\ssf-workshop\workshop13\data
```
* Incoporate test started dependencies

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
            <version>2.7.1</version>
			<scope>test</scope>
		</dependency>
```

* In order to execute test cases

```
mvn test
```
