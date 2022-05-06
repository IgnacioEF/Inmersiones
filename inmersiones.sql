-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-03-2017 a las 18:55:42
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inmersiones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `buceadores`
--

CREATE TABLE `buceadores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `titulacion` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `buceadores`
--

INSERT INTO `buceadores` (`id`, `nombre`, `titulacion`) VALUES
(1, 'alberto', 'diveMaster'),
(2, 'Carlos', 'AdvancedWater'),
(3, 'Carla', 'RecateMaritimo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inmersion`
--

CREATE TABLE `inmersion` (
  `id` int(11) NOT NULL,
  `id_monitor` int(11) NOT NULL,
  `lugar` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `duracion` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `inmersion`
--

INSERT INTO `inmersion` (`id`, `id_monitor`, `lugar`, `duracion`) VALUES
(3, 2, 'Sardina', '45:00'),
(4, 1, 'costaBrava', '60:00'),
(5, 3, 'Tarifa', '30:00'),
(6, 2, 'MarinaDelEste', '30:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `monitor`
--

CREATE TABLE `monitor` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `club` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `provincia` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `monitor`
--

INSERT INTO `monitor` (`id`, `nombre`, `club`, `provincia`) VALUES
(1, 'Gonza', 'ScubaWater', 'Granada'),
(2, 'Juanjo', 'DiveMaster', 'Cadiz'),
(3, 'Maria', 'DeepWater', 'Barcelona');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participan`
--

CREATE TABLE `participan` (
  `id_inmersion` int(11) NOT NULL,
  `id_buceador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `buceadores`
--
ALTER TABLE `buceadores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `inmersion`
--
ALTER TABLE `inmersion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `monitor`
--
ALTER TABLE `monitor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `participan`
--
ALTER TABLE `participan`
  ADD PRIMARY KEY (`id_inmersion`,`id_buceador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `buceadores`
--
ALTER TABLE `buceadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `inmersion`
--
ALTER TABLE `inmersion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `monitor`
--
ALTER TABLE `monitor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
