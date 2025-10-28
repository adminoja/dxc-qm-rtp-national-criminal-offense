FROM eclipse-temurin:17-jdk as builder

WORKDIR app
 
ARG JAR_FILE=target/*.jar
RUN echo $JAR_FILE 

COPY ${JAR_FILE} /opt/app/app.jar
RUN java -Djarmode=layertools -jar /opt/app/app.jar extract

FROM eclipse-temurin:17-jdk
RUN mkdir -p /opt/app/ssl \
&& mkdir -p /opt/app/static \
&& mkdir -p /opt/app/config \
&& mkdir -p /opt/app/data \
&& mkdir -p /opt/app/cache \
&& mkdir -p /opt/app/logs
WORKDIR /opt/app
COPY --from=builder app/dependencies/ ./
COPY --from=builder app/spring-boot-loader/ ./
COPY --from=builder app/snapshot-dependencies/ ./
COPY --from=builder app/application/ ./

ARG JAVA_OPTS=""
RUN echo $JAVA_OPTS 

# ENTRYPOINT ["java","-cp","/opt/app","-Djava.security.egd=file:/dev/./urandom","-Djava.net.preferIPv4Stack=true", "org.springframework.boot.loader.JarLauncher"]
ENTRYPOINT ["sh", "-c", \
 "java -server --enable-preview -XX:+UseContainerSupport \
 -XX:+UseG1GC -XX:+UseStringDeduplication ${JAVA_OPTS} \
 org.springframework.boot.loader.JarLauncher ${0} ${@}"]
# ENTRYPOINT ปลอดภัยต่อ container
# ENTRYPOINT ["sh", "-c", "java -Xms512m -Xmx2g -XX:+UseContainerSupport -XX:MaxRAMPercentage=75 -XX:+UseG1GC -XX:+UseStringDeduplication -Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true $JAVA_OPTS org.springframework.boot.loader.JarLauncher"]
