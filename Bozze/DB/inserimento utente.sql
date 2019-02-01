use DressShop;

insert into UTENTE(nome, cognome, email, password, tipo)
values('mario', 'bianchi', 'uno@due', 'root', 'cli'), ('marco', 'rossi', 'due@tre', 'root', 'pro'), ('antonio', 'verdi', 'tre@quattro', 'root', 'mag'), ('luca', 'gialli', 'quattro@cinque', 'root', 'mkt');

insert into CARTA_CREDITO(numero_carta, data_scadenza, cvv, nome_proprietario, cognome_proprietario, utente)
values('4444444444444444', '2020/10/20', '333', 'mario', 'bianchi', 1)