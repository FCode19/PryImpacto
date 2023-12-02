DROP DATABASE IF EXISTS bdtienda;
CREATE DATABASE bdtienda;
USE bdtienda;
CREATE TABLE Categorias (
    Categoria_id INT(10) AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50)
);

CREATE TABLE Proveedores (
    Proveedor_id INT(10) AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50),
    Email VARCHAR(50),
    Direccion VARCHAR(50),
    Telefono CHAR(9)
);

CREATE TABLE Clientes (
    Cliente_id INT(10) AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50),
    Direccion VARCHAR(50),
    Email VARCHAR(50),
    Telefono CHAR(9)
);

CREATE TABLE Productos (
    Producto_id INT(10) AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(80),
    PrecioUnitario DECIMAL(10, 2),
    Stock INT,
    Categoria_id INT(10),
    Proveedor_id INT(10),
    FOREIGN KEY (Categoria_id) REFERENCES Categorias(Categoria_id),
    FOREIGN KEY (Proveedor_id) REFERENCES Proveedores(Proveedor_id)
);

CREATE TABLE Pedidos (
    Pedido_id INT(10) AUTO_INCREMENT PRIMARY KEY,
    Fecha DATE,
    Cliente_id INT(10),
    FOREIGN KEY (Cliente_id) REFERENCES Clientes(Cliente_id)
);

CREATE TABLE DetallesPedidos (
    Detalle_id INT(10) AUTO_INCREMENT PRIMARY KEY,
    Pedido_id INT(10),
    Producto_id INT(10),
    Cantidad INT,
    Precio_Unitario DECIMAL(10, 2),
    FOREIGN KEY (Pedido_id) REFERENCES Pedidos(Pedido_id),
    FOREIGN KEY (Producto_id) REFERENCES Productos(Producto_id)
);

INSERT INTO Categorias (Nombre)
VALUES
    ('Procesadores'),
    ('Monitores'),
    ('Fuente de Poder'),
    ('Placa Madre'),
    ('Tarjeta Grafica'),
    ('RAM'),
    ('Disco Duro'),
    ('Perifericos');
INSERT INTO Proveedores (Nombre, Email, Direccion, Telefono)
VALUES
    ('ACER', 'ACER2023@gmail.com', 'Calle Arbeloa 4090', '567457333'),
    ('ADATA', 'ADATA2023@gmail.com', 'Av.Los Magallanes 2050', '234123567'),
    ('ANTRYX', 'ANTRYX2023@gmail.com', 'Calle Maria Auxiliadora 2050', '897666598'),
    ('AMD', 'AMD2023@gmail.com', 'Calle Aurelio Parra 1150', '776892111'),
    ('LOGITECH', 'LOGITECH2023@gmail.com', 'Calle Julio Andrade 2150', '227689211'),
    ('NVIDIA', 'NVIDIA2023@gmail.com', 'Calle Juan Lomas 3150', '654345789'),
    ('INTEL', 'INTEL2023@gmail.com', 'Jirón Andrade 2150', '333452123'),
    ('LENOVO', 'LENOVO2023@gmail.com', 'Jirón Terrier 3150', '423252123'),
    ('ASUS', 'ASUS2023@gmail.com', 'Av.Martinez 5150', '983252123'),
    ('GIGABYTE', 'GIGABYTE2023@gmail.com', 'Av.Prada 6150', '923252123'),
    ('MSI', 'MSI2023@gmail.com', 'Av.Lupaca 9150', '922252123'),
    ('SEAGATE', 'SEAGATE2023@gmail.com', 'Av.Torres 2150', '891725463'),
    ('CORSAIR', 'CORSAIR2023@gmail.com', 'Av.Kingston 1150', '442252123');
    
INSERT INTO Clientes (Nombre, Direccion, Email, Telefono)
VALUES
    ('Juan Garces', 'Av.Garzon 2050', 'Juangar30@gmail.com', '956728190'),
    ('Raul Prada', 'Jirón Washington 3030', 'Raulprada222@yahoo.com', '986728190'),
    ('Patricio Llerena', 'Jirón Terry 4830', 'Patrillerena421@hotmail.com', '952728190');    
INSERT INTO Productos (Nombre, PrecioUnitario, Stock, Categoria_id, Proveedor_id)
VALUES
    ('AUDIFONOS JBL Quantum 200', 200.99, 50, 8, 1),
    ('PROCESADOR AMD RYZEN 7 5700X 4.0GHZ - 32MB ', 800.50, 10, 1, 4),
    ('AUDIFONOS JBL Quantum 400', 500.99, 10, 8, 1),
    ('PROCESADOR AMD RYZEN 3 2600G 3.6GHZ - 32MB ', 700.50, 10, 1, 4),
    ('PROCESADOR AMD RYZEN 5 5600X 3.8GHZ - 32MB ', 500.50, 10, 1, 4),
    ('MOUSE GAMER LOGITECH G203', 150.99, 20, 8, 5),
    ('MOUSE REDRAGON M602 RGB', 120.00, 20, 8, 2),
    ('TARJETA GRAFICA NVIDIA GTX1050TI 4GB GDDR5', 550.99, 10, 5, 6),
    ('TARJETA GRAFICA ASUS ROG STRIX NVIDIA GEFORCE RTX 3080 TI OC 12GB GDDR6XI', 11.100, 2, 5, 6),
    ('PLACA MADRE MSI GAMING PLUS B550 GAMING PLUS', 800.100, 2, 4, 11),
    ('DISCO DURO INTERNO BARRACUDA 5TB SATA', 665.100, 2, 7, 12),
    ('DISCO DURO DE ESCRITORIO SEAGATE 1TB INTERNO', 265.100, 2, 7, 12),
    ('MEMORIA RAM DE ESCRITORIO CORSAIR VENGEANCE RGB PRO DE 16GB(2X8GB) DDR4 3200 MHz', 465.100, 2, 6, 13),
    ('PLACA MADRE ASUS ROG STRIX B460 H GAMING 128 LGA 120', 695.39, 8, 4, 9);   
INSERT INTO Pedidos (Fecha, Cliente_id)
VALUES    
    ('2023-10-08', 1),
    ('2023-10-09', 2),
    ('2023-10-15', 3),
    ('2023-10-04', 1),
    ('2023-09-09', 2),
    ('2023-08-18', 3),
    ('2023-07-17', 1),
    ('2023-06-17', 2),
    ('2023-05-17', 3);
INSERT INTO DetallesPedidos (Pedido_id, Producto_id, Cantidad, Precio_Unitario)
VALUES
    (1, 1, 5, 200.99),
    (2, 2, 3, 800.50),
    (3, 3, 2, 500.99);