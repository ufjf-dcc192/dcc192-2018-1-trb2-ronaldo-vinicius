Create table EVENTO(
id integer primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
titulo varchar(50),
minimo decimal(10,2),
data varchar(11),
datasorteio varchar(11),
sorteado varchar(1)
);

Create table PARTICIPANTE(
id integer primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
nome varchar(50),
email varchar(100),
senha varchar(30),
idAmigo integer
);

Create Table PARTICIPANTE_EVENTO(
ID_EVENTO varchar(3),
ID_PARTICIPANTE varchar(3),
ID_AMIGO varchar(3)
);
