@ECHO OFF

set CONTEXT=Gradle___com_example___basic_auth_rest1_0_0_1_SNAPSHOT_war

set BASE=http://localhost:8080
set URL=%BASE%/users/

curl -s -v -H "Origin: http://example.com" %URL%