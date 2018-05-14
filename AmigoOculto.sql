Create table EVENTO(
id integer primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
titulo varchar(50),
minimo decimal(10,2),
data timestamp,
sorteio timestamp
);

Create table PARTICPANTE(
id integer primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
idEvento integer,
nome varchar(50),
email varchar(30),
senha varchar(30),
idAmigo integer
);
