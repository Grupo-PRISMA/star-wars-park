BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "tipo_de_promocion" (
	"tipo"	TEXT NOT NULL,
	"activo"	INTEGER NOT NULL DEFAULT 1,
	PRIMARY KEY("tipo")
);
CREATE TABLE IF NOT EXISTS "tipo_de_atraccion" (
	"tipo"	TEXT NOT NULL,
	"activo"	INTEGER NOT NULL DEFAULT 1,
	PRIMARY KEY("tipo")
);
CREATE TABLE IF NOT EXISTS "atraccion" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT,
	"fk_tipo"	TEXT,
	"costo"	NUMERIC,
	"duracion"	REAL,
	"cupo"	INTEGER,
	"activo"	INTEGER NOT NULL DEFAULT 1,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("fk_tipo") REFERENCES "tipo_de_atraccion"("tipo")
);
CREATE TABLE IF NOT EXISTS "promocion" (
	"id"	INTEGER NOT NULL,
	"fk_tipo_promo"	TEXT NOT NULL,
	"fk_tipo_atraccion"	TEXT NOT NULL,
	"activo"	INTEGER NOT NULL DEFAULT 1,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("fk_tipo_promo") REFERENCES "tipo_de_promocion"("tipo"),
	FOREIGN KEY("fk_tipo_atraccion") REFERENCES "tipo_de_atraccion"("tipo")
);
CREATE TABLE IF NOT EXISTS "promocion_atraccion" (
	"fk_id_promocion"	INTEGER NOT NULL,
	"fk_id_atraccion"	INTEGER NOT NULL,
	FOREIGN KEY("fk_id_promocion") REFERENCES "promocion"("id"),
	FOREIGN KEY("fk_id_atraccion") REFERENCES "atraccion"("id"),
	PRIMARY KEY("fk_id_promocion","fk_id_atraccion")
);
CREATE TABLE IF NOT EXISTS "promocion_descuento" (
	"fk_id_promocion"	INTEGER,
	"descuento"	REAL,
	PRIMARY KEY("fk_id_promocion"),
	FOREIGN KEY("fk_id_promocion") REFERENCES "promocion"("id")
);
CREATE TABLE IF NOT EXISTS "promocion_atraccion_gratis" (
	"fk_id_promocion"	INTEGER,
	"fk_id_atraccion"	INTEGER,
	FOREIGN KEY("fk_id_atraccion") REFERENCES "atraccion"("id"),
	FOREIGN KEY("fk_id_promocion") REFERENCES "promocion"("id"),
	PRIMARY KEY("fk_id_promocion","fk_id_atraccion")
);
CREATE TABLE IF NOT EXISTS "visitante" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT,
	"fk_preferencia"	TEXT NOT NULL COLLATE BINARY,
	"presupuesto"	REAL,
	"tiempo"	REAL,
	"usuario"	TEXT NOT NULL UNIQUE,
	"clave"	TEXT NOT NULL,
	"activo"	INTEGER NOT NULL DEFAULT 1,
	"admin"	INTEGER NOT NULL DEFAULT 0,
	FOREIGN KEY("fk_preferencia") REFERENCES "tipo_de_atraccion"("tipo"),
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "itinerario" (
	"id_visitante"	INTEGER NOT NULL,
	"atracciones"	TEXT NOT NULL,
	"costo"	REAL NOT NULL,
	"tiempo"	REAL NOT NULL,
	id_lugar INTEGER NOT NULL,
	tipo_lugar TEXT NOT NULL,

/*	PRIMARY KEY("id_visitante"),*/
	FOREIGN KEY("id_visitante") REFERENCES "visitante"("id")
); 
CREATE TABLE IF NOT EXISTS "itinerario_promocion" (
	"fk_id_itinerario"	INTEGER NOT NULL,
	"fk_id_promocion"	INTEGER NOT NULL,
	FOREIGN KEY("fk_id_itinerario") REFERENCES "itinerario"("fk_id_visitante"),
	FOREIGN KEY("fk_id_promocion") REFERENCES "promocion"("id"),
	PRIMARY KEY("fk_id_itinerario","fk_id_promocion")
);
CREATE TABLE IF NOT EXISTS "itinerario_atraccion" (
	"fk_id_itinerario"	INTEGER NOT NULL,
	"fk_id_atraccion"	INTEGER NOT NULL,
	FOREIGN KEY("fk_id_itinerario") REFERENCES "itinerario"("fk_id_visitante"),
	FOREIGN KEY("fk_id_atraccion") REFERENCES "atraccion"("id"),
	PRIMARY KEY("fk_id_itinerario","fk_id_atraccion")
);
INSERT INTO "tipo_de_atraccion" ("tipo","activo") VALUES ('AVENTURA',1);
INSERT INTO "tipo_de_atraccion" ("tipo","activo") VALUES ('DEGUSTACION',1);
INSERT INTO "tipo_de_atraccion" ("tipo","activo") VALUES ('PAISAJE',1);
INSERT INTO "tipo_de_promocion" ("tipo","activo") VALUES ('ABSOLUTA',1);
INSERT INTO "tipo_de_promocion" ("tipo","activo") VALUES ('AXB',1);
INSERT INTO "tipo_de_promocion" ("tipo","activo") VALUES ('PORCENTUAL',1);

INSERT INTO "atraccion" ("id","nombre","fk_tipo","costo","duracion","cupo","activo") VALUES (1,'Hoth','AVENTURA',10,2.0,6,1);
INSERT INTO "atraccion" ("id","nombre","fk_tipo","costo","duracion","cupo","activo") VALUES (2,'Tatooine','PAISAJE',5,2.5,25,1);
INSERT INTO "atraccion" ("id","nombre","fk_tipo","costo","duracion","cupo","activo") VALUES (3,'Coruscant','DEGUSTACION',3,6.5,150,1);
INSERT INTO "atraccion" ("id","nombre","fk_tipo","costo","duracion","cupo","activo") VALUES (4,'Estrella de la Muerte','AVENTURA',25,3.0,4,1);
INSERT INTO "atraccion" ("id","nombre","fk_tipo","costo","duracion","cupo","activo") VALUES (5,'Kashyyk','PAISAJE',5,2.0,15,1);
INSERT INTO "atraccion" ("id","nombre","fk_tipo","costo","duracion","cupo","activo") VALUES (6,'Geonosis','DEGUSTACION',35,1.0,30,1);
INSERT INTO "atraccion" ("id","nombre","fk_tipo","costo","duracion","cupo","activo") VALUES (7,'Naboo','PAISAJE',12,3.0,32,1);
INSERT INTO "atraccion" ("id","nombre","fk_tipo","costo","duracion","cupo","activo") VALUES (8,'Kamino','AVENTURA',3,4.0,12,1);
INSERT INTO "promocion" ("id","fk_tipo_promo","fk_tipo_atraccion","activo") VALUES (1,'PORCENTUAL','AVENTURA',1);
INSERT INTO "promocion" ("id","fk_tipo_promo","fk_tipo_atraccion","activo") VALUES (2,'ABSOLUTA','DEGUSTACION',1);
INSERT INTO "promocion" ("id","fk_tipo_promo","fk_tipo_atraccion","activo") VALUES (3,'AXB','PAISAJE',1);
INSERT INTO "promocion_atraccion" ("fk_id_promocion","fk_id_atraccion") VALUES (1,1);
INSERT INTO "promocion_atraccion" ("fk_id_promocion","fk_id_atraccion") VALUES (1,4);
INSERT INTO "promocion_atraccion" ("fk_id_promocion","fk_id_atraccion") VALUES (2,3);
INSERT INTO "promocion_atraccion" ("fk_id_promocion","fk_id_atraccion") VALUES (2,6);
INSERT INTO "promocion_atraccion" ("fk_id_promocion","fk_id_atraccion") VALUES (3,5);
INSERT INTO "promocion_atraccion" ("fk_id_promocion","fk_id_atraccion") VALUES (3,2);
INSERT INTO "promocion_descuento" ("fk_id_promocion","descuento") VALUES (1,0.2);
INSERT INTO "promocion_descuento" ("fk_id_promocion","descuento") VALUES (2,3.0);
INSERT INTO "promocion_atraccion_gratis" ("fk_id_promocion","fk_id_atraccion") VALUES (3,7);

INSERT INTO "visitante" ("id","nombre","fk_preferencia","presupuesto","tiempo","usuario","clave","activo","admin") VALUES (1,'Administrador','DEGUSTACION',100.0,8.0,'admin','$2a$13$.zrpUQLgRmj02gqplqBzEO1n/vdjIeJSE/dyaURT1uUVhz4REfMqa',1,1);

COMMIT;
