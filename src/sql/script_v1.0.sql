CREATE TABLE `currency` (
  `currency_id` varchar(64) NOT NULL,
  `currency_name` varchar(50) NOT NULL,
  `currency_sign` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`currency_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `estimate` (
  `estimate_id` varchar(64) NOT NULL,
  `currency_id` int NOT NULL,
  `estimate_value` decimal(12,2) DEFAULT NULL,
  `estimate_date` date DEFAULT NULL,
  PRIMARY KEY (`estimate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

