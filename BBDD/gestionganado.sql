-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-01-2024 a las 14:15:53
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `animal_movimiento`
--

CREATE TABLE `animal_movimiento` (
  `id_animal` int(11) NOT NULL,
  `id_movimiento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ganadero`
--

CREATE TABLE `ganadero` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `correo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ganadero`
--

INSERT INTO `ganadero` (`id`, `nombre`, `direccion`, `telefono`, `correo`) VALUES
(1, 'Pedro', 'Direccion 3', '987654321', 'correo3@example.com'),
(2, 'Juan Pérez', 'Calle 123, Ciudad', '555-1234', 'juan@example.com'),
(3, 'María Rodríguez', 'Avenida 456, Ciudad', '555-5678', 'maria@example.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matadero`
--

CREATE TABLE `matadero` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `telefono` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `id` int(11) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `id_matadero` int(11) DEFAULT NULL,
  `id_explotacion` int(11) DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ganadero`
--
ALTER TABLE `ganadero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `matadero`
--
ALTER TABLE `matadero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
