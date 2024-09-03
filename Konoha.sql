
use b23coebzh1kuvhyzuysu;

create table Ninja (
	ID_Ninja INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    Nombre VARCHAR(25) NOT NULL,
    Rango ENUM('Iniciante', 'Novato', 'Amateur', 'Experimentado' ) NOT NULL,
    Aldea VARCHAR(25) NOT NULL
);

create table Mision (
	ID_Mision INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Descripcion TEXT,
    Rango ENUM('Iniciante', 'Novato', 'Amateur', 'Experimentado' ) NOT NULL,
    Recompensa VARCHAR(25) NOT NULL
);

create table Mision_Ninja (
	ID_Ninja INT,
    ID_Mision INT,
    FechaInicio DATE NOT NULL,
	FechaFin DATE NOT NULL,
    FOREIGN KEY (ID_Ninja) REFERENCES Ninja(ID_Ninja),
    FOREIGN KEY (ID_Mision) REFERENCES Mision(ID_Mision),
    PRIMARY KEY (ID_Ninja, ID_Mision)
);

create table Habilidades(
	ID_Habilidad INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ID_Ninja INT,
    Nombre VARCHAR(55) NOT NULL,
    Descripcion TEXT,
    FOREIGN KEY (ID_Ninja) REFERENCES Ninja(ID_Ninja)
);