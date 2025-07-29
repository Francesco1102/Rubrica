# Rubrica Java con MySQL

Progetto Java per la gestione di una rubrica, con archiviazione dei dati in un database MySQL.

## 📦 Contenuto del progetto

- `src/` - Codice sorgente Java
- `Referenced Libraries/` - Driver JDBC (`mysql-connector-java-9.4.0.jar`)
- `credenziali_database.properties` - File di configurazione del DB
- `schema_database.sql` - Script SQL per creare database e tabelle
- `README.md` - Questo file

## ⚙️ Configurazione

1. Inserire i dati corretti nel file `credenziali_database.properties`:

```properties
db.username=username
db.password=password
db.host=localhost
db.port=3306
```

2. Eseguire schema_database.sql per creare il database e popolarlo
