@echo off
java -jar %cd%\mybatis-generator-core-1.3.2.jar -configfile generator.xml -overwrite

pause