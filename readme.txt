-springboot 4.0.3
-jsp
-@WebServlet

===ตัวอย่างการ Dockerfile mvn แบบ offline==
==ติดตั้ง  lib ที่ไม่มีใน maven repo
mvn install:install-file "-Dmaven.repo.local=repo" ^
 -Dfile=mylib-1.jar  ^
 -DgroupId=org.example  ^
 -DartifactId=mylib ^
 -Dversion=1  ^
 -Dpackaging=jar ^
 -DgeneratePom=true

==รันเพื่อเอา  lib  มาเก็บที่เดียวกับ code  ต้องรันที่ project folder ที่เครื่อง dev
mvn "-Dmaven.repo.local=repo" clean package -DskipTests 

==สำหรับรันตอนอยู่ใน  Dockerfile
mvn  -o "-Dmaven.repo.local=repo" clean package -DskipTests  

==ตัวอย่างการเขียน Dockerfile mvn แบบ offline 
WORKDIR /home/myapp
ENV JAVA_HOME=/usr/lib/jvm/java-21-temurin-jdk
ENV M2_HOME=/opt/maven/apache-maven-3.9.11
ENV PATH=$M2_HOME/bin:$JAVA_HOME/bin:$PATH
 
COPY pom.xml .
COPY src .
COPY repo ./repo

RUN mvn -o "-Dmaven.repo.local=repo" clean package -DskipTests
...
==