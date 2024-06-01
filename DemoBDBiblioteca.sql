-- Creación de la tabla 'roles'
CREATE TABLE roles (
    id INT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Creación de la tabla 'usuarios'
CREATE TABLE usuarios (
    id INT PRIMARY KEY,
    email VARCHAR(255),
    password VARCHAR(255),
    rol_id INT,
    FOREIGN KEY (rol_id) REFERENCES roles(id)
);

-- Creación de la tabla 'clientes'
CREATE TABLE clientes (
    id INT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    telefono VARCHAR(50),
    dpi VARCHAR(50),
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Creación de la tabla 'empleados'
CREATE TABLE empleados (
    id INT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    telefono VARCHAR(50),
    dpi VARCHAR(50),
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)

);

-- Creación de la tabla 'libros'
CREATE TABLE libros (
    isbn VARCHAR(50) PRIMARY KEY,
    titulo VARCHAR(255),
    autor VARCHAR(255),
    anioPublicacion DATE,
    editorial VARCHAR(255),
    cantidadDisponible INT
);

-- Creación de la tabla 'prestamos'
CREATE TABLE prestamos (
    id INT PRIMARY KEY,
    cliente_id INT,
    isbn VARCHAR(50),
    fecha_prestamo DATE,
    fecha_devolucion_estimada DATE not null,
    fecha_devolucion DATE,
    multa NUMERIC(10, 2) DEFAULT 0.00 CHECK (multa >= 0),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (isbn) REFERENCES libros(isbn)
);