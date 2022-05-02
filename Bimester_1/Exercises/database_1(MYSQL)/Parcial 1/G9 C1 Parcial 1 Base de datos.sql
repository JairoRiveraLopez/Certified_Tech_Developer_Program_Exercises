CREATE SCHEMA IF NOT EXISTS proyecto_el_descubierto DEFAULT CHARACTER SET utf8 ;

USE proyecto_el_descubierto ;

CREATE TABLE IF NOT EXISTS proyecto_el_descubierto.ciudad (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  codigo_postal INT NOT NULL,
  pais VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS proyecto_el_descubierto.cliente (
  identificador INT NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  domicilio VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  telefono_movil INT NOT NULL,
  PRIMARY KEY (identificador)
);

CREATE TABLE IF NOT EXISTS proyecto_el_descubierto.caja_ahorro (
  numero_caja_ahorro INT NOT NULL AUTO_INCREMENT,
  tipo_interes VARCHAR(50) NOT NULL,
  estado TINYINT(1) NOT NULL,
  ejecutivo_asignado TINYINT(1) NOT NULL,
  PRIMARY KEY (numero_caja_ahorro)
  );

CREATE TABLE IF NOT EXISTS proyecto_el_descubierto.cuenta_corriente (
  numero_cuenta_corriente INT NOT NULL AUTO_INCREMENT,
  descubierto_otorgado BIGINT NOT NULL,
  estado TINYINT(1) NOT NULL,
  ejecutivo_asignado TINYINT(1) NOT NULL,
  PRIMARY KEY (numero_cuenta_corriente)
  );

CREATE TABLE IF NOT EXISTS proyecto_el_descubierto.sucursal (
  numero_de_sucursal INT NOT NULL,
  ciudad_id INT NOT NULL,
  PRIMARY KEY (numero_de_sucursal),
  CONSTRAINT fk_sucursales_ciudad FOREIGN KEY (ciudad_id) REFERENCES proyecto_el_descubierto.ciudad (id)
    );
    
CREATE TABLE IF NOT EXISTS proyecto_el_descubierto.empleado(
  numero_legajo INT NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  domicilio VARCHAR(500) NOT NULL,
  email VARCHAR(50) NOT NULL,
  telefono_movil VARCHAR(100) NOT NULL,
  fecha_alta_contrato DATE NOT NULL,
  numero_de_sucursal INT NOT NULL,
  PRIMARY KEY (numero_legajo),
  CONSTRAINT fk_empleado_sucursales1 FOREIGN KEY (numero_de_sucursal) REFERENCES proyecto_el_descubierto.sucursal (numero_de_sucursal)
  );

CREATE TABLE IF NOT EXISTS proyecto_el_descubierto.prestamo (
  numero_prestamo INT NOT NULL,
  sucursal VARCHAR(100) NOT NULL,
  cliente VARCHAR(100) NOT NULL,
  fecha DATE NOT NULL,
  importe_del_prestamo BIGINT NOT NULL,
  cuotas INT NOT NULL,
  ejecutivo_asignado TINYINT(1) NOT NULL,
  numero_de_sucursal INT NOT NULL,
  PRIMARY KEY (numero_prestamo),
  CONSTRAINT fk_prestamo_sucursales1 FOREIGN KEY (numero_de_sucursal) REFERENCES `proyecto_el_descubierto`.`sucursal` (`numero_de_sucursal`)
);

CREATE TABLE IF NOT EXISTS proyecto_el_descubierto.pago (
  numero_de_pago INT NOT NULL,
  numero_de_cuota INT NOT NULL,
  importe_pagado INT NOT NULL,
  fecha_hora DATETIME NOT NULL,
  prestamo_id INT NOT NULL,
  PRIMARY KEY (numero_de_pago),
  CONSTRAINT fk_pagos_prestamo1 FOREIGN KEY (prestamo_id) REFERENCES proyecto_el_descubierto.prestamo (numero_prestamo)
);

CREATE TABLE IF NOT EXISTS proyecto_el_descubierto.cliente_x_cuenta_corriente (
  cliente_identificador INT NOT NULL,
  numero_cuenta_corriente INT NOT NULL,
  saldo BIGINT NOT NULL,
  historial_accesos DATETIME NOT NULL,
  PRIMARY KEY (cliente_identificador, numero_cuenta_corriente),
  CONSTRAINT fk_cliente_has_cuenta_corriente_cliente1 FOREIGN KEY (cliente_identificador) REFERENCES proyecto_el_descubierto.cliente (identificador),
  CONSTRAINT fk_cliente_has_cuenta_corriente_cuenta_corriente1 FOREIGN KEY (numero_cuenta_corriente) REFERENCES proyecto_el_descubierto.cuenta_corriente (numero_cuenta_corriente)
);

CREATE TABLE IF NOT EXISTS proyecto_el_descubierto.cliente_x_prestamo (
  cliente_identificador INT NOT NULL,
  numero_prestamo INT NOT NULL,
  PRIMARY KEY (cliente_identificador, numero_prestamo),
  CONSTRAINT fk_cliente_has_prestamo_cliente1 FOREIGN KEY (cliente_identificador) REFERENCES proyecto_el_descubierto.cliente (identificador),
  CONSTRAINT fk_cliente_has_prestamo_prestamo1 FOREIGN KEY (numero_prestamo) REFERENCES proyecto_el_descubierto.prestamo (numero_prestamo)
);

CREATE TABLE IF NOT EXISTS proyecto_el_descubierto.cliente_x_caja_ahorro (
  cliente_identificador INT NOT NULL,
  numero_caja_ahorro INT NOT NULL,
  saldo BIGINT NOT NULL,
  historia_accesos DATETIME NOT NULL,
  PRIMARY KEY (cliente_identificador, numero_caja_ahorro),
  CONSTRAINT fk_cliente_has_cuenta_ahorro_cliente1 FOREIGN KEY (cliente_identificador) REFERENCES proyecto_el_descubierto.cliente (identificador),
  CONSTRAINT fk_cliente_has_cuenta_ahorro_cuenta_ahorro1 FOREIGN KEY (numero_caja_ahorro) REFERENCES proyecto_el_descubierto.caja_ahorro (numero_caja_ahorro)
);
