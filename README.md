# OpenMRS Module - Cost Structure (OMOD)

Módulo backend de OpenMRS para el registro y gestión de estructura de costos hospitalarios basado en el documento técnico de cálculo de costo estándar del Ministerio de Salud (MINSA).

## Descripción

Este módulo OMOD (OpenMRS Module) proporciona la funcionalidad backend para:
- Registro de estructura de costos de procedimientos médicos
- Gestión de recursos (infraestructura, equipamiento, recursos humanos, suministros)
- APIs REST para integración con el microfrontend ESM
- Persistencia de datos y lógica de negocio

## Estructura del Proyecto

```
openmrs-module-coststructure/
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
- OpenMRS Platform 1.11.6 o superior

## Compilación

### Compilación estándar
```bash
mvn clean install
```

### Compilación rápida (sin tests)
```bash
mvn -B -DskipTests clean package
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
   omod/target/coststructure-1.0.0-SNAPSHOT.omod
   ```

5. El módulo se instalará y cargará automáticamente

### Instalación con Docker

Si estás usando OpenMRS en Docker:

```bash
# Compilar el módulo
mvn -B -DskipTests clean package

# Copiar al contenedor de OpenMRS
docker cp omod/target/coststructure-1.0.0-SNAPSHOT.omod <container-name>:/openmrs/data/modules/

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

El frontend de este módulo está en un repositorio separado:
https://github.com/PROYECTO-SANTACLOTILDE/sihsalus-esm-coststructure-app

## CI/CD

El proyecto incluye un workflow de GitHub Actions que:
- Se ejecuta automáticamente en push a `main` o PRs
- Compila el OMOD con Java 8
- Genera artefactos descargables (`.omod` y `.jar`)
- Los artefactos se mantienen por 30 días

### Descargar Artefactos del CI

1. Ir a: https://github.com/PROYECTO-SANTACLOTILDE/sih-module-coststructure/actions
2. Seleccionar el workflow más reciente exitoso
3. Descargar el artefacto `coststructure-omod`
4. Descomprimir y usar el archivo `.omod`

## APIs REST

Este módulo expone los siguientes endpoints REST:

- `GET /ws/rest/v1/coststructure` - Listar estructuras de costos
- `POST /ws/rest/v1/coststructure` - Crear estructura de costo
- `GET /ws/rest/v1/coststructure/{uuid}` - Obtener estructura por UUID
- `POST /ws/rest/v1/coststructure/{uuid}` - Actualizar estructura
- `DELETE /ws/rest/v1/coststructure/{uuid}` - Eliminar estructura

Más endpoints para gestión de infraestructura, equipamiento, recursos humanos y suministros.

## Estado del Proyecto

En desarrollo activo. Próximas actualizaciones incluyen integración con Odoo.

## Dependencias

- OpenMRS Core API 1.11.6+
- OpenMRS Web Services REST Module
- Stock Management Module 2.0.3 (opcional)

## Licencia

MPL-2.0
