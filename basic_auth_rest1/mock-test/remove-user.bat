@echo OFF

set USERNAME=user3
set BASE=http://localhost:8080/Gradle___com_example___basic_auth_rest1_0_0_1_SNAPSHOT_war
set URL=%BASE%/users/%USERNAME%


curl -v -X DELETE %URL%