# Java Product Manager

Aplicación de consola desarrollada en Java para la gestión de productos mediante una base de datos MySQL.

## 🚀 Funcionalidades

- Crear productos
- Listar todos los productos
- Modificar productos
- Eliminar productos
- Conexión con base de datos MySQL
- Gestión de operaciones mediante DAO

## 🛠️ Tecnologías utilizadas

- Java
- MySQL
- JDBC
- Eclipse IDE
- Git
- GitHub

## 📂 Estructura del proyecto

```text
src/
├── app/
│   └── Start.java
├── conexion/
│   └── conexionbd.java
└── modelo/
    ├── producto.java
    └── ProductoDAO.java
```

## 🗄️ Base de datos

El proyecto utiliza MySQL mediante JDBC.

La aplicación se conecta a una base de datos llamada `tienda`.

Antes de ejecutar el proyecto, es necesario tener disponible una instalación de MySQL y configurar la base de datos correspondiente.

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio.
2. Importar el proyecto en Eclipse.
3. Crear y configurar la base de datos MySQL.
4. Comprobar los datos de conexión en `conexionbd.java`.
5. Ejecutar `Start.java`.

## 🎯 Objetivo

Proyecto realizado como parte de mi formación en Desarrollo de Aplicaciones Web (DAW), aplicando conceptos de programación en Java, acceso a bases de datos y patrón DAO.

## 👨‍💻 Autor

**Francisco Javier Porras Morales**

Estudiante de Desarrollo de Aplicaciones Web (DAW).