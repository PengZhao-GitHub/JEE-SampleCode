rem 
rem Set JAVA_HOME and J2EE_HOME before running this script.
rem

rem first include user-specified definitions.
call %J2EE_HOME%\bin\userconfig.bat

if "%JMS_HOME%" == "" set JMS_HOME=%J2EE_HOME%

set LIBDIR=%J2EE_HOME%\lib
set LOCALEDIR=%J2EE_HOME%\lib\locale
set CLOUDSCAPE_INSTALL=%LIBDIR%\cloudscape

set CLASSESDIR=%LIBDIR%\classes
set JMS_CLASSESDIR=%JMS_HOME%\classes

set J2EEJARS=%LIBDIR%\j2ee.jar
set JAVATOOLS=%JAVA_HOME%\lib\tools.jar

set JAVAHELPJARS=%LIBDIR%\jhall.jar

rem JMS DB PATH must end in slash to specify a directory
set JMS_DB_PATH=%J2EE_HOME%\repository\%COMPUTERNAME%\db\

set SYSTEM_LIB_DIR=%LIBDIR%\system
set JMS_RI_JDBC=%SYSTEM_LIB_DIR%\cloudscape.jar;%SYSTEM_LIB_DIR%\tools.jar
set CLOUDJARS=%JMS_RI_JDBC%;%CLOUDSCAPE_INSTALL%\RmiJdbc.jar;%CLOUDSCAPE_INSTALL%\cloudclient.jar

set CPATH=%CLOUDJARS%;%CLASSESDIR%;%JMS_CLASSESDIR%;%J2EEJARS%;%LOCALEDIR%;%J2EE_CLASSPATH%;%JAVATOOLS%;%JAVAHELPJARS%

set JAAS_OPTIONS=-Djava.security.auth.policy=%J2EE_HOME%\lib\security\jaas.policy
set SSL_OPTIONS=-Djavax.net.ssl.trustStore=%J2EE_HOME%\lib\security\cacerts.jks
set LISTEN_OPTIONS=-Dcom.sun.CORBA.connection.ORBListenSocket=SSL:0,SSL_MUTUALAUTH:0,PERSISTENT_SSL:1060

set JAVACMD=%JAVA_HOME%\bin\java -Xmx128m %SSL_OPTIONS% %JAAS_OPTIONS%

