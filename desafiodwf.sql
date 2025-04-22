-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 31-03-2025 a las 03:54:23
-- Versión del servidor: 9.1.0
-- Versión de PHP: 8.1.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `desafiodwf`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE IF NOT EXISTS `departamento` (
  `id` bigint NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombred` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`id`, `descripcion`, `nombred`) VALUES
(1, 'Departamento encargado de gestión de personal', 'Recursos Humanos'),
(2, 'Departamento encargado de gestionar la publicidad', 'Marketing'),
(3, 'Departamento encargado de gestionar las ventas', 'Ventas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento_seq`
--

DROP TABLE IF EXISTS `departamento_seq`;
CREATE TABLE IF NOT EXISTS `departamento_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `departamento_seq`
--

INSERT INTO `departamento_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `id` bigint NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `cargo` varchar(255) DEFAULT NULL,
  `fecha_contratacion` date NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `salario` double DEFAULT NULL,
  `departamento_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhdjjhohpyjsfta5g6p8b8e00i` (`departamento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id`, `apellido`, `cargo`, `fecha_contratacion`, `nombre`, `salario`, `departamento_id`) VALUES
(1, 'Pérez', 'Analista', '2023-05-20', 'Juan', 1200, 1),
(2, 'Fuentes', 'Lider de Equipo', '2023-05-20', 'Pedro', 1500, 3),
(3, 'Fuentes', 'Coordinador', '2023-05-20', 'Pedro', 1000, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado_seq`
--

DROP TABLE IF EXISTS `empleado_seq`;
CREATE TABLE IF NOT EXISTS `empleado_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `empleado_seq`
--

INSERT INTO `empleado_seq` (`next_val`) VALUES
(101);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FKhdjjhohpyjsfta5g6p8b8e00i` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
