
Drop database if Exists prog;
Create database prog; 
Use prog;






DROP TABLE IF EXISTS utenti;

CREATE TABLE utenti (
 Id int not null AUTO_INCREMENT,
 Nome varchar(20) not null,
 Cognome varchar(20) not null,
 Nickname varchar(45) not null,
 Admin int (1) not null,
 Email varchar(20) not null,
 Indirizzo varchar(45) NOT NULL,
 Cap varchar(5) NOT NULL,
 
 Città varchar(45) NOT NULL,
 Password varchar(20) NOT NULL,
  PRIMARY KEY (Id),
  INDEX `prova` (`Nickname` ASC)
  );



LOCK TABLES utenti WRITE;

INSERT INTO utenti(Nome,Cognome,Nickname,Admin,Email,Indirizzo,Cap,Città,Password) VALUES ('Alfonso','Luciani','Alfo',0,'alf@mail.com','p.zza garibaldi','84100','Salerno','alf1'),('Alex','Bacco','Bacco96',0,'bacco@mail.com','p.zza del sapere','84100','Salerno','bac1'), ('Sig','Amministratore','Admin',1,'admin@mail.com','via venezia','84100','Battipaglia','admin1');

UNLOCK TABLES;








DROP TABLE IF EXISTS prodotti ;


CREATE TABLE prodotti  (
  Id  int not null AUTO_INCREMENT,
  Codice  varchar(45) NOT NULL,
  Prodotto  varchar(30) NOT NULL,
  Prezzo_acquisto  float ,
  IvaAcquisto  float ,
  Marca  varchar(20) NOT NULL,
  IvaVendita  float not null,
  Prezzo_vendita  float NOT NULL,
  CodCategoria  int ,
  urlImmagine varchar(30),
  quantita  int ,
 	
 
  PRIMARY KEY ( Id ),
 INDEX  idx_prodotto  ( Prodotto  ASC)
 )
 ENGINE=InnoDB DEFAULT CHARSET=utf8;





INSERT INTO prodotti(Codice,Prodotto,Prezzo_acquisto,IvaAcquisto,Marca,IvaVendita,Prezzo_Vendita,CodCategoria,urlImmagine,quantita)  VALUES ('CNP01' , 'CAPPOTTO VINTAGE XL ',50,22, 'Conbipel' ,22,75,1,'vestiti_donna/img1.jpeg',10),('CNP02', 'PULLOVER L' ,10,22, 'Conbipel' ,22,40,2,'vestiti_donna/img2d.jpg',23),('LEV01', 'T-SHIRT GRAFICA XL' ,10,22, 'Levis' ,22,20,3,'vestiti_donna/img3d.jpeg',10),('ARM01','JEANS SKINNY 50',50,22,'Giorgio Armani',22,120,4,'vestiti_donna/img4d.jpeg',20),('CNP03','CAMICIA BLACK XXL',5,22,'Conbipel',22,20,5,'vestiti_donna/img5d.jpg',30),('CNP04','CAMICIA WHITE L',5,22,'Conbipel',22,20,5,'vestiti_donna/img6d.jpeg',4);                                                                                ;


DROP TABLE IF EXISTS categorie ;
create table  categorie (
 Id  int not null AUTO_INCREMENT,
 Categoria  varchar(25) not null,
PRIMARY KEY( Id )
) ENGINE= InnoDB DEFAULT CHARSET=utf8;




INSERT INTO  categorie(Categoria)  VALUES ( 'CAPPOTTI' ),(' PULLOVER' ),('T-SHIRT' ),( 'JEANS' ),('CAMICIE');



DROP TABLE IF EXISTS carrello ;


CREATE TABLE carrello  (  
  Id int not null AUTO_INCREMENT,
  Nickname varchar(20) not null,
  IdProdotto int not null,
  Data varchar(10),
  quantità int,
 Primary Key(Id),
 Foreign Key(Nickname) References utenti(Nickname)

 On Delete cascade On Update cascade,
 
 Foreign Key (IdProdotto) References prodotti(Id)
 On Delete cascade On Update cascade
 

  
);













