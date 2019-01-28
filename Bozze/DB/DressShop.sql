DROP DATABASE IF EXISTS DressShop;
CREATE DATABASE DressShop;
USE DressShop;

CREATE TABLE UTENTE(
id_utente		int		primary key auto_increment,
nome			varchar(30),
cognome			varchar(30),
email			varchar(30)	not null,
password		varchar(16)	not null,
tipo			varchar(3),
/*tipo:	cli=cliente
	mag=magazziniere
	mkt=gestore marketing
	pro=proprietario
*/
data_nascita		date
);

CREATE TABLE CARTA_CREDITO(
numero_carta		varchar(16)	primary key,
data_scadenza		date		not null,
cvv			char(3)		not null,
nome_proprietario	varchar(30)	not null,
cognome_proprietario	varchar(30)	not null,
utente			int,

	foreign key (utente)
	references UTENTE(id_utente)
		on delete no action	
		on update cascade
);

CREATE TABLE INDIRIZZO(
id_indirizzo		int		primary key auto_increment,
nome			varchar(30),
cognome			varchar(30),
cap			char(5),
provincia		char(2),
citta			varchar(30),
via			varchar(50),
cellulare		varchar(13),
utente			int,

	foreign key (utente)
	references UTENTE(id_utente)
		on delete no action
		on update cascade
);

CREATE TABLE ORDINE(
id_ordine		int		primary key auto_increment,
data			date,
pagato			boolean,
carta_credito		varchar(16),
indirizzo		int,
utente			int,
tipo_spedizione		varchar(10),
costo_spedizione	float,

	foreign key (carta_credito)
	references CARTA_CREDITO(numero_carta)
		on delete no action
		on update cascade,
        
	foreign key (indirizzo)
	references INDIRIZZO(id_indirizzo)
		on delete no action
		on update cascade,
        
	foreign key (utente)
	references UTENTE(id_utente)
		on delete no action
		on update cascade
);

CREATE TABLE PROMOZIONE(
id_promozione		int		primary key auto_increment,
data_inizio		date,
data_fine		date,
sconto			int
);

CREATE TABLE PRODOTTO(
id_prodotto		int		primary key auto_increment,
codice_prodotto		varchar(20),
descrizione		varchar(50),
marca			varchar(20),
modello			varchar(20),
taglia			varchar(5),
colore			varchar(20),
categoria		varchar(20),	--maxicategoria.categoria	es:uomo.camicie
					--maxicategorie tra:	uomo, donna, accessori
					--categorie tra:	giacche, jeans, camicie, intimo, maglie e felpe, cappotti, pantaloni
foto			varchar(30),
promozione		int,
        
	foreign key (promozione)
	references PROMOZIONE(id_promozione)
		on delete set null
		on update cascade
);

CREATE TABLE PRODOTTO_IN_CATALOGO(
id_prodotto		int			primary key,
prezzo			float,
iva			int,
quantita 		int,

	foreign key (id_prodotto)
	references PRODOTTO(id_prodotto)
		on delete no action
		on update cascade
);

CREATE TABLE PRODOTTO_IN_ORDINE(
id_prodotto		int			primary key,
prezzo			float,
iva			int,
quantita 		int,
reso			boolean,

	foreign key (id_prodotto)
	references PRODOTTO(id_prodotto)
		on delete no action
		on update cascade
);

CREATE TABLE ORDINAZIONE(
ordine			int,
prodotto		int,

	primary key(ordine, prodotto),

	foreign key (ordine)
	references ORDINE(id_ordine)
		on delete no action
		on update no action,

	foreign key (prodotto)
	references PRODOTTO_IN_ORDINE(id_prodotto)
		on delete no action
		on update no action
);
