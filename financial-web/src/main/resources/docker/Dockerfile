# Base images 基础镜像
FROM java:8u111

#MAINTAINER 维护者信息
MAINTAINER luochen<luochenex@gmail.com>

#VOLUME：挂载目录
VOLUME /home

#ADD  将app.jar文件将拷贝到容器中，默认拷贝到根路径下
# 因为目录不允许超过当前目录，所以将jar复制到同级
ADD app.jar app.jar

#修改app.jar这个文件的访问时间和修改时间为当前时间，而不会修改文件的内容。
RUN bash -c "touch /app.jar"

#EXPOSE 容器暴露端口
EXPOSE 8080

#ENTRYPOINT 应用启动命令 参数设定
#由于tomcat的session id的生成主要通过java.security.SecureRandom生成随机数来实现，导致启动过程很慢
#通过-Djava.security.egd=file:/dev/./urandom参数可以加快随机数产生过程
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]

