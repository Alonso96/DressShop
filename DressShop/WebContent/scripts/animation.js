// attivo il codice al document ready
$(document).ready(function()
{
    // creo una variabile con il riferimento al nostro bottone
    var $btt = $("#back_to_top");

    // nascono il bottone al caricamento della pagina
    $btt.hide();

    // intercetto lo scroll di pagina
    $(window).scroll(function()
    {
        // se lo scroll supera i 300 pixel dal margine superiore mostro il bottone (se nascosto)
        if ($("body").scrollTop() > 300) {
            if ($btt.is(":hidden")) $btt.show();
        // in caso contrario lo nascondo (se visibile)
        }else{
            if ($btt.is(":visible")) $btt.hide();
        }
    });

    // gestisco il click sul bottone
    $btt.click(function()
    {
        // torno ad inizio pagina con movenza fluida
        $("html,body").animate({scrollTop: 0}, 500, function(){});
    });
});


