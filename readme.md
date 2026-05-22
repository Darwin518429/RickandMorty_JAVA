#  RickandMorty JAVA

Aplicació Java que consumeix la [Rick and Morty API](https://rickandmortyapi.com/) i gestiona les dades en una base de dades MySQL.

---

##  Descripció

Aquest projecte permet obtenir dades de personatges i localitzacions de la sèrie Rick and Morty, tant via API REST com via fitxers JSON locals, i emmagatzemar-les en una base de dades relacional.

---

##  Estructura del projecte

```
RickandMorty_JAVA/
├── BD_SCHEMA/          # Esquema de la base de dades
├── BD_SCRIPT/          # Scripts SQL d'inicialització
└── ProjecteApi/        # Codi font Java
    └── src/
        ├── Api/
        │   ├── ApiTemplate/        # Classe abstracta ApiClientGeneric i ApiFactory
        │   ├── ConnectionEndpoint/ # Connexió HTTP (ApiConnection)
        │   └── RickMorty/          # Client Rick and Morty + Parsers
        ├── Controllers/            # Menús i lògica de presentació
        ├── DAO/                    # Accés a dades (personatges, localitzacions...)
        ├── Model/                  # Classes de domini (Personatge, Localitzacio...)
        ├── Services/               # Capa de servei
        └── resources/
            ├── api.properties      # URLs de la API
            ├── db.properties       # Configuració de la BD
            └── Json/               # Fitxers JSON locals
```

---

##  Requisits
- JDBC
- Jackson
- Java 23 LTS
- MySQL 8+
-   IntelliJ IDEA
- Connexió a internet (per accedir a la API)

---

##  Configuració

### 1. Base de dades

Executa els scripts de la carpeta `BD_SCRIPT/` per crear la base de dades i les taules:

```sql
-- Taules principals:
-- personatges, localitzacions
```

### 2. Fitxer `db.properties`

Configura la connexió a la base de dades:

```properties
db.url=jdbc:mysql://localhost:3306/rickandmorty
db.user=el_teu_usuari
db.password=la_teva_contrasenya
```

### 3. Fitxer `api.properties`

Configura les URLs de la API:

```properties
api.rickmorty.nom=rickmorty
api.rickmorty.url.character=https://rickandmortyapi.com/api/character
api.rickmorty.url.location=https://rickandmortyapi.com/api/location
api.rickmorty.url.episode=https://rickandmortyapi.com/api/episode
```

>  Si alguna URL és incorrecta, l'aplicació mostrarà un error i es tancarà automàticament.

---

## Funcionalitats

### Menú principal

```
=== MENU PRINCIPAL ===
1. Llistar personatges
2. Mostrar contingut
3. Còpia
4. Actualitzar personatge
0. Sortir
```

### Mostrar contingut
- Des de l'endpoint de la API
- Des de fitxers JSON locals

### Còpia
- **Còpia total**: importa tots els personatges a la BD
- **Còpia parcial**: importa un personatge per ID

### Actualitzar
- Cerca un personatge a la API per ID i actualitza el registre a la BD

---

##  Base de dades

### Taules principals

| Taula | Descripció |
|-------|------------|
| `personatges` | Personatges de Rick and Morty |
| `localitzacions` | Localitzacions (planeta, dimensió...) |

### Relacions

```
localitzacions ←── personatges 
```

> Les localitzacions s'han d'inserir **abans** que els personatges per respectar les claus forànies.

---

##  API utilitzada

[Rick and Morty API](https://rickandmortyapi.com/) — API pública i gratuïta.

Endpoints utilitzats:
- `GET /api/character` — Llista paginada de personatges
- `GET /api/character/{id}` — Personatge per ID
- `GET /api/location` — Llista de localitzacions

---

##  Autor

**Darwin** — [GitHub](https://github.com/Darwin518429)
