-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-02-2024 a las 20:57:11
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionganado`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `animal`
--

CREATE TABLE `animal` (
  `id` int(11) NOT NULL,
  `especie` varchar(30) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `edad` int(11) NOT NULL,
  `estado` varchar(10) NOT NULL,
  `id_explotacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `animal`
--

INSERT INTO `animal` (`id`, `especie`, `sexo`, `edad`, `estado`, `id_explotacion`) VALUES
(1, 'Vaca', 'H', 3, 'Saludable', 1),
(2, 'Cerdo', 'M', 2, 'Enfermo', 3),
(3, 'Oveja', 'H', 1, 'Saludable', 2),
(4, 'Pollo', 'M', 0, 'Saludable', 2),
(5, 'Caballo', 'H', 5, 'Enfermo', 1),
(6, 'Vaca', 'M', 3, 'Saludable', 1),
(7, 'Cerdo', 'F', 2, 'Enfermo', 2),
(8, 'Vaca', 'M', 1, 'Saludable', 3),
(9, 'Cerdo', 'F', 4, 'Herido', 4),
(10, 'Vaca', 'M', 5, 'Saludable', 5),
(11, 'Tigre', 'F', 7, 'Enfermo', 1),
(12, 'Elefante', 'M', 10, 'Saludable', 2),
(13, 'Ratón', 'F', 1, 'Herido', 3),
(14, 'Loro', 'M', 2, 'Saludable', 4),
(15, 'Serpiente', 'F', 3, 'Enfermo', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `animal_movimiento`
--

CREATE TABLE `animal_movimiento` (
  `id_animal` int(11) NOT NULL,
  `id_movimiento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `animal_movimiento`
--

INSERT INTO `animal_movimiento` (`id_animal`, `id_movimiento`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `explotacion`
--

CREATE TABLE `explotacion` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `ubicacion` varchar(30) NOT NULL,
  `tipo_animal` varchar(30) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `id_ganadero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `explotacion`
--

INSERT INTO `explotacion` (`id`, `nombre`, `ubicacion`, `tipo_animal`, `capacidad`, `id_ganadero`) VALUES
(1, 'Granja A', 'Calle Granjera', 'Ganado Lechero', 100, 1),
(2, 'Granja B', 'Avenida Rural', 'Ganado de Carne', 75, 2),
(3, 'Granja C', 'Camino Ganadero', 'Avícola', 50, 3),
(4, 'Granja D', 'Rincón Agrícola', 'Ovino', 30, 1),
(5, 'Granja E', 'Sendero Ganadero', 'Equino', 20, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ganadero`
--

CREATE TABLE `ganadero` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `correo` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ganadero`
--

INSERT INTO `ganadero` (`id`, `nombre`, `direccion`, `telefono`, `correo`, `password`) VALUES
(1, 'Pedro', 'Direccion 3', '987654321', 'correo3@example.com', '12345'),
(2, 'Juan Pérez', 'Calle 123, Ciudad', '555-1234', 'juan@example.com', ''),
(3, 'María Rodríguez', 'Avenida 456, Ciudad', '555-5678', 'maria@example.com', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matadero`
--

CREATE TABLE `matadero` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `telefono` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `matadero`
--

INSERT INTO `matadero` (`id`, `nombre`, `direccion`, `telefono`) VALUES
(2, 'Matadero S.A.', 'Avenida Central', '555-4321'),
(3, 'Carnicería del Valle', 'Calle 456, Ciudad', '555-8765'),
(4, 'Carnes Frescas', 'Carrera 789, Pueblo', '555-9876'),
(5, 'Sabor a Carne', 'Callejón 123, Villa', '555-1111'),
(6, 'El Buen Asador', 'Avenida 789, Ciudad', '555-2222');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `id` int(11) NOT NULL,
  `tipo` varchar(10) DEFAULT NULL,
  `id_matadero` int(11) DEFAULT NULL,
  `id_explotacion` int(11) DEFAULT NULL,
  `fecha` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`id`, `tipo`, `id_matadero`, `id_explotacion`, `fecha`) VALUES
(1, 'Compra', NULL, 1, NULL),
(2, 'Venta', NULL, 2, NULL),
(3, 'Traslado', NULL, 3, NULL),
(4, 'Compra', NULL, 4, NULL),
(5, 'Venta', NULL, 5, NULL),
(6, 'matadero', 2, NULL, NULL),
(7, 'VENTA', NULL, 4, '1998-08-02'),
(14, 'VENTA', NULL, 4, NULL),
(16, 'VENTA', NULL, 1, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_explotacion` (`id_explotacion`);

--
-- Indices de la tabla `animal_movimiento`
--
ALTER TABLE `animal_movimiento`
  ADD PRIMARY KEY (`id_animal`,`id_movimiento`),
  ADD KEY `id_animal` (`id_animal`,`id_movimiento`),
  ADD KEY `id_movimiento` (`id_movimiento`);

--
-- Indices de la tabla `explotacion`
--
ALTER TABLE `explotacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ganadero` (`id_ganadero`);

--
-- Indices de la tabla `ganadero`
--
ALTER TABLE `ganadero`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `matadero`
--
ALTER TABLE `matadero`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_matadero` (`id_matadero`),
  ADD KEY `id_explotacion` (`id_explotacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `animal`
--
ALTER TABLE `animal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `ganadero`
--
ALTER TABLE `ganadero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `matadero`
--
ALTER TABLE `matadero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`id_explotacion`) REFERENCES `explotacion` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `animal_movimiento`
--
ALTER TABLE `animal_movimiento`
  ADD CONSTRAINT `animal_movimiento_ibfk_1` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `animal_movimiento_ibfk_2` FOREIGN KEY (`id_movimiento`) REFERENCES `movimiento` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `explotacion`
--
ALTER TABLE `explotacion`
  ADD CONSTRAINT `explotacion_ibfk_1` FOREIGN KEY (`id_ganadero`) REFERENCES `ganadero` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `movimiento_ibfk_1` FOREIGN KEY (`id_matadero`) REFERENCES `matadero` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `movimiento_ibfk_2` FOREIGN KEY (`id_explotacion`) REFERENCES `explotacion` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
