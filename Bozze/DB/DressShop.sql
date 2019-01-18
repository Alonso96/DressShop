DROP DATABASE IF EXISTS DressShop;
CREATE DATABASE DressShop;
USE DressShop;

CREATE TABLE UTENTI(
id_utente		int		primary key auto_increment,
nome			varchar(30),
cognome			varchar(30),
email			varchar(30)	not null,
password		varchar(16)	not null,
tipo			varchar(3)
/*tipo:	cli=cliente
	mag=magazziniere
	mkt=gestore marketing
	pro=proprietario
*/
);

CREATE TABLE CLIENTI(
id_cliente		int		primary key,
data_nascita		date,
cellulare		varchar(13),

	foreign key (id_cliente)
	references UTENTI(id_utente)
		on delete cascade
		on update cascade
);

CREATE TABLE CARTE_CREDITO(
numero_carta		varchar(16)	primary key,
data_scadenza		date		not null,
cvv			char(3)		not null,
nome_proprietario	varchar(30)	not null,
cognome_proprietario	varchar(30)	not null,
cliente			int,

	foreign key (cliente)
	references CLIENTI(id_cliente)
		on delete no action	
		on update cascade
);

CREATE TABLE INDIRIZZI(
id_indirizzo		int		primary key auto_increment,
cap			char(5),
provincia		char(2),
citta			varchar(30),
via			varchar(50),
cliente			int,

	foreign key (cliente)
	references CLIENTI(id_cliente)
		on delete no action
		on update cascade
);

CREATE TABLE ORDINI(
id_ordine		int		primary key auto_increment,
data			date,
pagato			boolean,
carta_credito		varchar(16),
indirizzo		int,
cliente			int,
tipo_spedizione		varchar(10),
costo_spedizione	float,

	foreign key (carta_credito)
	references CARTE_CREDITO(numero_carta)
		on delete no action
		on update cascade,
        
	foreign key (indirizzo)
	references INDIRIZZI(id_indirizzo)
		on delete no action
		on update cascade,
        
	foreign key (cliente)
	references CLIENTI(id_cliente)
		on delete no action
		on update cascade
);

CREATE TABLE PROMOZIONI(
id_promozione		int		primary key auto_increment,
data_inizio		date,
data_fine		date,
sconto			int
);

CREATE TABLE CATEGORIE(
id_categoria		int		primary key auto_increment,
nome			varchar(20),
descrizione		varchar(50)
);

CREATE TABLE PRODOTTI(
id_prodotto		int		primary key auto_increment,
codice_prodotto		varchar(20),
descrizione		varchar(50),
marca			varchar(20),
modello			varchar(20),
taglia			varchar(5),
colore			varchar(20),
tipo			varchar(15),	/*tra:	giacche, jeans, camicie,
						intimo, maglie e felpe,
						cappotti, pantaloni*/
foto			varchar(30),
categoria		int,
promozione		int,

	foreign key (categoria)
	references CATEGORIE(id_categoria)
		on delete no action
		on update cascade,
        
	foreign key (promozione)
	references PROMOZIONI(id_promozione)
		on delete set null
		on update cascade
);

CREATE TABLE PRODOTTI_IN_CATALOGO(
id_prodotto		int			primary key,
prezzo			float,
iva			int,
quantità		int,

	foreign key (id_prodotto)
	references PRODOTTI(id_prodotto)
		on delete no action
		on update cascade
);

CREATE TABLE PRODOTTI_IN_ORDINE(
id_prodotto		int			primary key,
prezzo			float,
iva			int,
quantità		int,

	foreign key (id_prodotto)
	references PRODOTTI(id_prodotto)
		on delete no action
		on update cascade
);

CREATE TABLE ORDINAZIONE(
ordine			int,
prodotto		int,

	primary key(ordine, prodotto),

	foreign key (ordine)
	references ORDINI(id_ordine)
		on delete no action
		on update no action,

	foreign key (prodotto)
	references PRODOTTI_IN_ORDINE(id_prodotto)
		on delete no action
		on update no action
);
