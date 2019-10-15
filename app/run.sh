
mvn clean package -Pnative -Dnative-image.docker-build=true -DskipTests=true
target/homebanking-1.0-SNAPSHOT-runner