#!/bin/bash


MODULE_ServiceRegistry="ServiceRegistry"

echo "🔨 Собираем $MODULE_ServiceRegistry..."
(cd "$MODULE_ServiceRegistry" && ./gradlew clean bootJar) || { echo "❌ Ошибка сборки"; exit 1; }


MODULE_ApiGateway="ApiGateway"

echo "🔨 Собираем $MODULE_ApiGateway..."
(cd "$MODULE_ApiGateway" && ./gradlew clean bootJar) || { echo "❌ Ошибка сборки"; exit 1; }


MODULE_UserService="UserService"

echo "🔨 Собираем $MODULE_UserService..."
(cd "$MODULE_UserService" && ./gradlew clean bootJar) || { echo "❌ Ошибка сборки"; exit 1; }


MODULE_PaymentService="PaymentService"

echo "🔨 Собираем $MODULE_PaymentService..."
(cd "$MODULE_PaymentService" && ./gradlew clean bootJar) || { echo "❌ Ошибка сборки"; exit 1; }


echo "🐳 Запускаем Docker Compose..."
docker-compose up --build