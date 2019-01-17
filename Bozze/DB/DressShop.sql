DROP DATABASE IF EXISTS DressShop;
CREATE DATABASE DressShop;
USE DressShop;

CREATE TABLE utenti(
id_utente			int			primary key auto_increment,
nome				varchar(30),
cognome				varchar(30),
email				varchar(30)	not null,
password			varchar(16)	not null,
tipo				varchar(3)
/*tipo:	cli=cliente
		mag=magazziniere
        mkt=gestore marketing
        pro=proprietario
*/
);

CREATE TABLE clienti(
id_cliente			int			primary key,
data_nascita		date,
cellulare			varchar(13),

	foreign key (id_cliente)
    references utenti(id_utente)
		on delete cascade
        on update cascade
);

CREATE TABLE carte_credito(
numero_carta		varchar(16)	primary key,
data_scadenza		date		not null,
cvv					char(3)		not null,
nome_proprietario	varchar(30)	not null,
cognome_proprietario varchar(30)not null,
cliente				int,

	foreign key (cliente)
    references clienti(id_cliente)
		on delete no action	
        on update cascade
);

CREATE TABLE indirizzi(
id_indirizzo		int			primary key auto_increment,
cap					char(5),
provincia			char(2),
citta				varchar(30),
via					varchar(50),
cliente				int,

	foreign key (cliente)
    references clienti(id_cliente)
		on delete no action
        on update cascade
);

CREATE TABLE ordini(
id_ordine			int			primary key auto_increment,
data				date,
pagato				boolean,
carta_credito		varchar(16),
indirizzo			int,
cliente				int,
tipo_spedizione		varchar(10),
costo_spedizione	float,

	foreign key (carta_credito)
	references carte_credito(numero_carta)
		on delete no action
        on update cascade,
        
	foreign key (indirizzo)
    references indirizzi(id_indirizzo)
		on delete no action
        on update cascade,
        
	foreign key (cliente)
    references clienti(id_cliente)
		on delete no action
        on update cascade
);

CREATE TABLE promozioni(
id_promozione		int			primary key auto_increment,
data_inizio			date,
data_fine			date,
sconto				int
);

CREATE TABLE categorie(
id_categoria		int			primary key auto_increment,
nome				varchar(20),
descrizione			varchar(50)
);

CREATE TABLE prodotti(
id_prodotto			int			primary key auto_increment,
codice_prodotto		varchar(20),
descrizione			varchar(50),
marca				varchar(20),
modello				varchar(20),
taglia				varchar(5),
colore				varchar(20),
tipo				varchar(15),	/*tra:	giacche, jeans, camicie,
											intimo, maglie e felpe,
                                            cappotti, pantaloni*/
foto				varchar(30),
categoria			int,
promozione			int,

	foreign key (categoria)
    references categorie(id_categoria)
		on delete no action
        on update cascade,
        
	foreign key (promozione)
    references promozioni(id_promozione)
		on delete set null
        on update cascade
);

CREATE TABLE prodotti_in_catalogo(
id_prodotto			int			primary key,
prezzo				float,
iva					int,
quantità			int,

	foreign key (id_prodotto)
    references prodotti(id_prodotto)
		on delete no action
        on update cascade
);

CREATE TABLE prodotti_in_ordine(
id_prodotto			int			primary key,
prezzo				float,
iva					int,
quantità			int,

	foreign key (id_prodotto)
    references prodotti(id_prodotto)
		on delete no action
        on update cascade
);

CREATE TABLE ordinazione(
ordine				int,
prodotto			int,

	primary key(ordine, prodotto),
    
    foreign key (ordine)
    references ordini(id_ordine)
		on delete no action
        on update no action,
        
	foreign key (prodotto)
    references prodotti_in_ordine(id_prodotto)
);
