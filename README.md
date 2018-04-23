# everest-migration
Data migration project Built on Spring Batch


to create jar:
    mvn clean package

to run module in dev mode:
    java -jar -Dspring.profiles.active=dev EverestMigration-1.0-SNAPSHOT.jar

to run module in prod mode:
    java -jar -Dspring.profiles.active=prod EverestMigration-1.0-SNAPSHOT.jar
