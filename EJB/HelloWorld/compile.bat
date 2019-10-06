@rem *******************************************************
@rem Cleaning things up...
@rem *******************************************************

echo y | rmdir /s classes
echo y | rmdir /s lib
mkdir classes
mkdir lib

@rem *******************************************************
@rem Compiling files...
@rem *******************************************************

javac -d classes src\*.java

@rem *******************************************************
@rem Copying Deployment Descriptor...
@rem *******************************************************

mkdir classes\META-INF
copy deployment\*.xml classes\META-INF

@rem *******************************************************
@rem Creating temporary ejb-jar file...
@rem *******************************************************

cd classes
jar cf ..\lib\tmp.jar *
cd ..

@rem *******************************************************
@rem Generating helper code, and creating new ejb-jar file...
@rem *******************************************************

cd lib
java weblogic.ejbc20 -keepgenerated tmp.jar HelloWorld.jar
del tmp.jar
cd ..

@rem *******************************************************
@rem Depoying the new jar file...
@rem *******************************************************

copy lib\HelloWorld.jar %DEPLOY_HOME%
