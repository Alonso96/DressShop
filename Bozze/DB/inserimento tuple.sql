use DressShop;

insert into UTENTE(nome, cognome, email, password, tipo)
values('mario', 'bianchi', 'uno@due', 'root', 1), ('marco', 'rossi', 'due@tre', 'root', 4), 
('antonio', 'verdi', 'tre@quattro', 'root', 2), ('luca', 'neri', 'quattro@cinque', 'root', 3);

insert into CARTA_CREDITO(numero_carta, data_scadenza, cvv, nome_proprietario, cognome_proprietario, utente)
values('4444444444444444', '2020/10/20', '333', 'mario', 'bianchi', 1);

insert into INDIRIZZO(nome, cognome, cap, provincia, citta, via, cellulare, utente)
values('mario', 'bianchi', '12345', 'SA', 'Fisciano', 'via Roma, 5', '3456789012', 1);

insert into ORDINE(data, pagato, carta_credito, indirizzo, utente, totale)
values('2018/12/15', true, 1, 1, 1, 50), ('2019/01/21', true, 1,1,1, 80);

insert into PRODOTTO(codice_prodotto, descrizione, marca, modello, prezzo_compl, iva, in_vendita, categoria, foto)
values ('LE222F03O-K12', 'Composizione: 100% cotone, Materiale: Jeans, Vita: Normale, Chiusura: Bottone, Tasche: Tasche posteriori, Tasche laterali',
 'Levis', '501', 0, 0, false, 'jeans.uomo', 'img/levis_501.jpg'), ('ON321E17R-K11', 'Composizione: 97% poliestere, 3% elastan, Avvertenze: Non asciugare in asciugatrice, 
 Lavaggio a macchina a 30 gradi, Restringimento massimo del 5%, Scollo: Schiena scoperta, Fantasia: Floreale', 'Only', 'OnlNova Deep', 15, 22, true, 'camicie.donna', 'img/only_onldeep.jpeg');
 
 insert into TAGLIA values(1, 's', 20), (1, 'm', 30), (1, 'l', 15), (2, 's', 35), (2, 'm', 50), (2, 'l', 40);
 
 insert into PRODOTTO_IN_ORDINE(id_prodotto, prezzo_compl, iva, taglia, quantita, reso) values(2, 15, 22, 'm', 1, false), (2, 18, 22, 'l', 1, false);
 
 insert into ORDINAZIONE values(1, 1), (2, 2);
