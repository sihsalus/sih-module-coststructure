# SIHSALUS Cost Structure OpenMRS Module

Módulo backend de OpenMRS para registrar y gestionar estructuras de costos de procedimientos sanitarios. Está pensado para integrarse con el microfrontend `@sihsalus/esm-coststructure-app`.

## Descripción

Este módulo OMOD (OpenMRS Module) proporciona la funcionalidad backend para:
- Registro de estructura de costos de procedimientos médicos
- Catálogos de infraestructura, equipamiento, recursos humanos y suministros
- Endpoints MVC JSON para integración con el microfrontend ESM
- Persistencia de datos y lógica de negocio

## Estructura del Proyecto

```
sih-module-coststructure/
├── api/                    # Módulo API (lógica de negocio, DAOs, servicios)
│   ├── pom.xml
│   └── src/
├── omod/                   # Módulo OMOD (controladores web, configuración del módulo)
│   ├── pom.xml
│   └── src/
├── pom.xml                 # POM padre
└── watch.sh               # Script de desarrollo
```

## Requisitos

- Java 8 o superior
- Maven 3.x
- OpenMRS Platform 2.4.x

## Compilación

### Compilación estándar
```bash
mvn -B clean package
```

### Compilación rápida (sin tests)
```bash
mvn -B clean package -DskipTests
```

El archivo `.omod` compilado se generará en `omod/target/coststructure-[version].omod`

## Instalación

### Instalación Manual (OpenMRS Standalone)

1. Compilar el módulo:
   ```bash
   mvn -B -DskipTests clean package
   ```

2. Navegar a la interfaz de administración de OpenMRS:
   ```
   http://localhost:8080/openmrs/admin/modules/module.list
   ```

3. Click en "Add or Update Module"

4. Seleccionar el archivo `.omod` generado:
   ```
   omod/target/coststructure-1.0.1.omod
   ```

5. El módulo se instalará y cargará automáticamente

### Instalación con Docker

Si estás usando OpenMRS en Docker:

```bash
# Compilar el módulo
mvn -B -DskipTests clean package

# Copiar al contenedor de OpenMRS
docker cp omod/target/coststructure-1.0.1.omod <container-name>:/openmrs/data/modules/

# Reiniciar el contenedor
docker restart <container-name>
```

### Verificar Instalación

1. Ir a: `Administration` → `Manage Modules`
2. Buscar "Coststructure" en la lista
3. El estado debe ser "Started"

## Desarrollo

Para desarrollo con hot-reload:

```bash
./watch.sh
```

## Microfrontend ESM

El frontend vive en el monorepo SIHSALUS:

https://github.com/sihsalus/sihsalus-frontend/tree/main/packages/apps/esm-coststructure-app

## CI/CD

El proyecto incluye un workflow de GitHub Actions que:
- Se ejecuta automáticamente en push a `main` o PRs
- Compila el OMOD con Java 8
- Ejecuta tests del módulo API
- Publica releases en Maven Central desde `main` cuando el commit proviene de un PR mergeado

### Descargar Artefactos del CI

1. Ir a: https://github.com/sihsalus/sih-module-coststructure/actions
2. Seleccionar el workflow más reciente exitoso
3. Descargar el artefacto `coststructure-omod`
4. Descomprimir y usar el archivo `.omod`

## Endpoints

Este módulo expone endpoints JSON bajo `/openmrs/module/coststructure`:

- `GET /module/coststructure/list` - Listar estructuras de costos
- `POST /module/coststructure` - Crear estructura de costo
- `GET /module/coststructure/procedure?q=<texto>` - Buscar procedimientos
- `GET /module/coststructure/infrastructure` - Listar infraestructura
- `GET /module/coststructure/equipment` - Listar equipamiento
- `GET /module/coststructure/human-resource` - Listar recursos humanos
- `GET /module/coststructure/supply` - Listar suministros

Nota: estos endpoints no son recursos del módulo Webservices REST (`/ws/rest/v1`). El ESM consume directamente los controladores MVC del OMOD.

## Dependencias

- OpenMRS Platform 2.4.x
- App Framework, UI Framework, UI Commons y App UI, según `omod/src/main/resources/config.xml`

## Licencia

MPL-2.0
