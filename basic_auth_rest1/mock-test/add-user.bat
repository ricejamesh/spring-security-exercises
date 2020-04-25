@echo OFF

set BASE=http://localhost:8080/Gradle___com_example___basic_auth_rest1_0_0_1_SNAPSHOT_war
set URL=%BASE%/users/register


curl -v -H "Origin: http://example.com" -H "Content-Type: application/json" -d "@user.json" %URL%