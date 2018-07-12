Create table EVENTO(
id integer primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
titulo varchar(50),
minimo decimal(10,2),
data timestamp,
datasorteio timestamp
);

Create table PARTICIPANTE(
id integer primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
nome varchar(50),
email varchar(30),
senha varchar(30),
idAmigo integer
);

Create Table PARTICIPANTE_EVENTO(
ID_EVENTO INTEGER,
ID_PARTICIPANTE INTEGER,
ID_AMIGO INTEGER
);
