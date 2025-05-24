# Sistema de Gestión de Motores

Este proyecto implementa un sistema CRUD (Create, Read, Update, Delete) para la gestión de motores, permitiendo manejar tanto motores de gasolina como motores eléctricos.

## Características

- Registro de nuevos motores (gasolina y eléctricos)
- Listado de todos los motores en el sistema
- Búsqueda de motores por número de serie
- Actualización de información de motores existentes
- Eliminación de motores del sistema

## Tipos de Motores

### Motor de Gasolina
- Número de motor
- Caballos de fuerza
- Cilindraje
- Consumo de combustible (L/100km)
- Tipo de gasolina

### Motor Eléctrico
- Número de motor
- Caballos de fuerza
- Cilindraje
- Voltaje
- Autonomía

## Estructura del Proyecto

```
ESTRUCTURE_2025/
├── Motores/
│   ├── controller/
│   │   └── MotorController.java
│   ├── model/
│   │   ├── Motor.java
│   │   ├── MotorGasolina.java
│   │   └── MotorElectrico.java
│   └── view/
│       └── Main.java
```

## Cómo Usar

1. Ejecute la aplicación desde la clase `Main.java`
2. Use el menú interactivo para:
   - Opción 1: Registrar un nuevo motor
   - Opción 2: Ver lista de motores
   - Opción 3: Buscar un motor específico
   - Opción 4: Actualizar información de un motor
   - Opción 5: Eliminar un motor
   - Opción 6: Salir del programa

## Requisitos

- Java JDK 8 o superior
- IDE compatible con Java (Eclipse, IntelliJ IDEA, etc.)

## Contribución

Si desea contribuir al proyecto, por favor:
1. Haga un fork del repositorio
2. Cree una nueva rama para sus cambios
3. Envíe un pull request con sus mejoras

## Licencia

Este proyecto está bajo la licencia MIT.
