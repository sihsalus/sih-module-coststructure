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

```bash
mvn clean install
```

El archivo `.omod` compilado se generará en `omod/target/coststructure-[version].omod`

## Instalación

1. Compilar el módulo
2. Copiar el archivo `.omod` al directorio `modules/` de OpenMRS
3. Reiniciar OpenMRS
4. El módulo se cargará automáticamente

## Desarrollo

Para desarrollo con hot-reload:

```bash
./watch.sh
```

## Microfrontend ESM

El frontend de este módulo está en un repositorio separado:
https://github.com/PROYECTO-SANTACLOTILDE/sihsalus-esm-coststructure-app

## Estado del Proyecto

En desarrollo activo. Próximas actualizaciones incluyen integración con Odoo.

## Licencia

MPL-2.0
