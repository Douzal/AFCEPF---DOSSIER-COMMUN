@REM Bat file to launch Promo32 application.
@REM By default, needs to be in the same folder that Promo_32 war file. If not, change PROMO-32_HOME value.

@echo off

IF "%PROMO-32_HOME%" == "" set PROMO-32_HOME=.

REM Default variables
set JAR_NAME=%PROMO-32_HOME%/portailPromo_web-0.0.1-SNAPSHOT.war
set HTTP_PORT=8081
REM DataBase parameters
REM DB_TYPE can be one of mysql or mariadb
REM DDL_AUTO can have value create, database tables will be drop and recreate with some data, or update, no dropping 
set DDL_AUTO=create
set DB_URL=jdbc:mysql://localhost:3306/portail_promotion
set DB_USERNAME=root
REM Uncomment if database has a password
set DB_PASSWORD=root
REM Add to _JAVA_OPTIONS if database has a password
REM -Dspring.datasource.password=%DB_PASSWORD%
REM Extra Java args
REM Uncomment below for server mode. It requires a JDK instead of a JRE
REM set SERVER_MODE=-server
set JAVA_ARGS=-Xms128m -Xmx1024m %SERVER_MODE%

REM Java arguments
set _JAVA_OPTIONS=-Dspring.datasource.url=%DB_URL% -Dspring.datasource.username=%DB_USERNAME% -Dspring.datasource.password=%DB_PASSWORD% -Dspring.jpa.hibernate.ddl-auto=%DDL_AUTO% -Dspring.jpa.show-sql=false -Duser.language=en -Dfile.encoding=UTF8

set DAEMON_ARGS=%JAVA_ARGS% %_JAVA_OPTIONS% -jar %JAR_NAME% --server.port=%HTTP_PORT%

REM set REMOTE_DEBUG=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005 -Ddebug

echo Starting Squash TM...
java %DAEMON_ARGS%