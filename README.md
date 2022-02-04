# BE-settimana8-progetto8
Ewallet
Istruzioni :

Creazione Conto Corrente : @POST
localhost:8080/Ewallet/rest/ewallet/crea
Aggiorna Conto Corrente: @PUT
localhost:8080/Ewallet/rest/ewallet/aggiorna
Elimina Conto Corrente: @DELETE
localhost:8080/Ewallet/rest/ewallet/elimina
Prelievo : @PUT
localhost:8080/Ewallet/rest/ewallet/preleva/iban/importo/data
Versamento : @PUT
localhost:8080/Ewallet/rest/ewallet/versa/iban/importo/data
Lista movimenti : @GET
localhost:8080/Ewallet/rest/ewallet/movimenti
Lista conti : @GET
localhost:8080/Ewallet/rest/ewallet/conti
