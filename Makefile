run-dist:	# запуск исполняемого файла
	./build/install/app/bin/app
install:
	./gradlew clean build
	./gradlew check
	./gradlew test
check-updates:
	./gradlew dependencyUpdates
lint:
	./gradlew check
test:
	./gradlew test

.PHONY: build
