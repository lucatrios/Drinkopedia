package com.example.progetto_oop.modelli;

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.progetto_oop.R;

import java.util.HashMap;

public class Menu {

        private static final int[] COCKTAIL_NAMES = {
                R.string.el001, R.string.el002, R.string.el003, R.string.el004, R.string.el005,
                R.string.el006, R.string.el007, R.string.el008, R.string.el009, R.string.el010,
                R.string.el011, R.string.el012, R.string.el013, R.string.el014, R.string.el015,
                R.string.el016, R.string.el017, R.string.el018, R.string.el019, R.string.el020,
                R.string.el021, R.string.el022, R.string.el023, R.string.el024, R.string.el025,
                R.string.el026, R.string.el027, R.string.el028, R.string.el029, R.string.el030,
                R.string.el031, R.string.el032, R.string.el033, R.string.el034, R.string.el035,
                R.string.el036, R.string.el037, R.string.el038, R.string.el039, R.string.el040,
                R.string.el041, R.string.el042, R.string.el043, R.string.el044, R.string.el045,
                R.string.el046, R.string.el047, R.string.el048, R.string.el049, R.string.el050,
                R.string.el051, R.string.el052, R.string.el053, R.string.el054, R.string.el055,
                R.string.el056, R.string.el057, R.string.el058, R.string.el059, R.string.el060,
                R.string.el061,
        };
        private static final Cocktail[] COCKTAIL = new Cocktail[]{
                new Cocktail(
                        1,
                        "Mojito",
                        "Rum chiaro 50mL   Foglie di menta 8-10 \nZucchero di canna 2 cucchiaini   Lime 1/2 \nSoda o acqua frizzante   Ghiaccio",
                        "Facile",
                        "2 minuti",
                        "Alcolico",
                        "Il mojito è un drink che si compone direttamente nel bicchiere, non ha bisogno di shaker o altro.\n" +
                                "\n" +
                                "Nel bicchiere rinfrescato mettete due cucchiaini di zucchero bianco, poi, con l'ausilio di un premi agrumi, utilizzate il succo di mezzo lime. Inserite la soda o l'acqua frizzante, così da sciogliere lo zucchero, e poi le 10 foglioline di menta prima di mescolare col cucchiaino lungo. Bisogna massaggiare la menta, non pestatela né rompetela perché la clorofilla contenuta all'interno delle foglie è amara e rovina il drink.\n" +
                                "\n" +
                                "Adesso è il momento del rum: se non avete il jigger per misurare i 50 ml di rum non c'è problema, una tazzina di caffè è più che sufficiente e contiene circa 50 ml. Rimescolate e aggiungete del ghiaccio: riempite il bicchiere fino all'orlo così da farlo sciogliere molto più lentamente. Terminate il mojito con un piccolo rabbocco di acqua frizzante o soda e, con l'ausilio del cucchiaino, decorate il bordo interno del bicchiere con le foglioline di menta. Per la guarnizione usate un ciuffettino di menta.",
                        false


                ),
                new Cocktail(
                        2,
                        "Old fashioned",
                        "Whisky 4,5cL   Zucchero 1 zolla \nAngostura 2 gocce",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Adagiate una zolletta di zucchero in un bicchiere old fashioned e bagnatela con due gocce di angostura.\n" +
                                "\n" +
                                "Fate una spruzzata di soda e pestate con il muddler fino a sciogliere completamente lo zucchero.\n" +
                                "\n" +
                                "Aggiungete il ghiaccio fino a riempire tutto il bicchiere, unite il whiskey e mescolate.\n" +
                                "\n" +
                                "Mescolate con un cucchiaio da bar e decorate il bicchiere con una fetta di arancia dopo aver lasciato la sua essenza sul bordo del bicchiere. Inserite nel bicchiere una ciliegia maraschino e servite il cocktail Old Fashioned.",
                        false


                ),
                new Cocktail(
                        3,
                        "Negroni",
                        "Gin 3cL   Bitter Campani 3cL \nVermut rosso 3cL",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "La ricetta del Negroni è molto facile da preparare ma bisogna stare molto attenti alle dosi perché il vermut, prodotto italiano molto apprezzato come base per numerosi cocktail, ha una gradazione alcolica che oscilla tra i 14° e i 28° e il gin è un distillato molto forte.\n" +
                                "\n" +
                                "Versate del ghiaccio in un tumbler basso o in un old fashioned fino a riempirli completamente, scolate l'acqua e aggiungete 1/3 di gin, 1/3 di bitter Campari e 1/3 di Vermut rosso.\n" +
                                "\n" +
                                "Mescolate gli ingredienti delicatamente, per 20 secondi, e guarnite con una fetta d'arancia.",
                        false


                ),
                new Cocktail(
                        4,
                        "Negroni sbagliato",
                        "Spumante brut 3cL   Bitter Campani 3cL \nMartini rosso 3cL",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Mettete 4 cubetti di ghiaccio in un tumbler medio.\n" +
                                "\n" +
                                "Aggiungete il bitter Campari e il Martini Rosso e mescolate delicatamente per qualche secondo con un cucchiaio da bar. Guarnite con una fetta d'arancia.",
                        false


                ),
                new Cocktail(
                        5,
                        "Daiquiri",
                        "Rum bianco 4,5cL   Succo di lime 2cL \nSciroppo di zucchero 0,5cL",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Cominciate e spremere il succo di lime, o in alternativa di limone, e filtratelo.\n" +
                                "\n" +
                                "Versate dei cubetti di ghiaccio nello shaker, aggiungete il rum, il succo di lime e lo sciroppo di zucchero.\n" +
                                "\n" +
                                "Shakerate per 6/8 secondi energicamente e versate nella coppetta precedentemente raffreddata con del ghiaccio: se desiderate potete guarnire con una fettina di lime.",
                        false


                ),
                new Cocktail(
                        6,
                        "Martini cocktail",
                        "Gin 6cL   Vermut 1cL \nScorza di limone 1   Ghiaccio",
                        "Facile",
                        "10 minuti",
                        "Alcolico",
                        "Mettete dei cubetti di ghiaccio in una coppetta, così da raffreddarla. Riempite il mixing glass, il bicchiere di vetro utilizzato per la preparazione dei cocktail, con il ghiaccio.\n" +
                                "\n" +
                                "Versate prima il vermut e poi il gin e rimescolate. Togliete il ghiaccio dalla coppetta e versate il drink, filtrandolo con lo strainer.\n" +
                                "\n" +
                                "Strizzate la scorza di limone sul cocktail e servite. Accompagnate con olive in salamoia a parte, se preferite. Il vostro Martini cocktail è pronto per essere servito.",
                        false


                ),
                new Cocktail(
                        7,
                        "Margarita",
                        "Tequila 3,5cL   Triple sec 2cL \nLime 1,5cL di succo",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Mettete del ghiaccio spezzettato in un bicchiere da Margarita e fatelo raffreddare per 3 minuti.\n" +
                                "\n" +
                                "Togliete il ghiaccio e bagnate il bordo con una fetta di lime cospargendo l'orlo con il sale.\n" +
                                "\n" +
                                "Aggiungete in uno shaker il succo filtrato di un lime, la tequila e il triple sec e shakerate energicamente per qualche secondo.\n" +
                                "\n" +
                                "Versate il succo nella coppa da Margarita e servite.",
                        false


                ),
                new Cocktail(
                        8,
                        "Hugo",
                        "Prosecco 6cL   Seltz 6cL \nSciroppo di fiori di sambuco 3cL   Foglie di menta 8-10",
                        "Facile",
                        "2 minuti",
                        "Alcolico",
                        "Versate gli ingredienti nel bicchiere, possibilmente un calice, con abbondante ghiaccio.\n" +
                                "\n" +
                                "Guarnite con un ciuffetto di menta per completare il vostro spritz bianco.\n" +
                                "\n" +
                                "Se non trovate lo sciroppo di fiori di sambuco, potrete tranquillamente usare lo sciroppo di fiori di melissa perché la differenza è davvero minima.\n" +
                                "\n" +
                                "Ricordate di servire il drink nell'immediato per evitare che il ghiaccio si sciolga compromettendo la qualità del cocktail.",
                        false


                ),
                new Cocktail(
                        9,
                        "Black Russian",
                        "Vodka 5cL   Kahlua 2cL \nGhiaccio 3 cubetti",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Prendete un bicchiere tipo old fashioned e riempitelo con tre cubetti di ghiaccio.\n" +
                                "\n" +
                                "Mescolate con il cucchiaio lungo tipico dei cocktail così da raffreddare il bicchiere in modo uniforme ed eliminate l'eventuale acqua in eccesso.\n" +
                                "\n" +
                                "Versate 5 cl di vodka, unite 2 cl di liquore al caffè tipo kahlua e mescolate delicatamente così da amalgamare i due liquori.",
                        false


                ),
                new Cocktail(
                        10,
                        "Aperol Spritz",
                        "Ghiaccio   Prosecco D.O.C circa 90mL \nAperol circa 60mL   Soda o acqua frizzante circa 30mL \nFettina di arancia 1",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Per preparare uno spritz a regola d'arte, iniziate riempendo di ghiaccio un calice da vino.\n" +
                                "\n" +
                                "Versate tre parti di Prosecco e aggiungete due parti di Aperol.\n" +
                                "\n" +
                                "Completate con una parte di soda o acqua frizzante e guarnite con una bella fettina di arancia.",
                        false


                ),
                new Cocktail(
                        11,
                        "Whiskey Sour",
                        "Whisky 4,5cL   Succo di limone 3cL \nSciroppo di zucchero 1,5cL   Albumi 1 cucchiaino",
                        "Facile",
                        "2 minuti",
                        "Alcolico",
                        "Spremete e filtrate il succo di un limone.\n" +
                                "\n" +
                                "Riempite uno shaker di ghiaccio, versate il whiskey, il succo di limone, lo sciroppo di zucchero ed un cucchiaio di albume di uovo.\n" +
                                "\n" +
                                "Agitate energeticamente per 10/15 secondi e versate, filtrando con l'apposito strumento o con un colino a maglie strette, in un bicchiere tipo old fashioned colmo di ghiaccio.\n" +
                                "\n" +
                                "Servite se lo gradite con una scorzetta di limone oppure con una ciliegia bagnata nel maraschino.",
                        false


                ),
                new Cocktail(
                        12,
                        "Zombie",
                        "Rum chiaro 30mL   Rum scuro 30mL \nApricot brandy 30mL   Rum Bacardi 30mL \nSucco di lime 30mL   Succo di arancia \nGranatina   Ciliegie al maraschino",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "In uno shaker, versate il rum chiaro il rum scuro e l'Apricot Brandy. Aggiungete il succo di lime e la granatina.\n" +
                                "\n" +
                                "Shakerate bene per almeno dieci secondi, quindi scolate in bicchieri highball con qualche cubetto di ghiaccio spaccato.\n" +
                                "\n" +
                                "Aggiungete poco succo d'arancia e infine il rum Bacardi. Mescolate e decorate con una ciliegia al maraschino e una fetta d'arancia a bordo del bicchiere.",
                        false


                ),
                new Cocktail(
                        13,
                        "Mimosa cocktail",
                        "Succo di arancia 7,5cL   Champagne o spumante brut 7,5cL",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Spremete l'arancia e filtrate con un colino a maglie strette.\n" +
                                "\n" +
                                "Versate il succo in un flute e aggiungete lo champagne ben freddo. Guarnite il drink con una fettina d'arancia.\n" +
                                "\n" +
                                "Il vostro Mimosa cocktail è pronto per essere servito freddo e frizzante.",
                        false


                ),
                new Cocktail(
                        14,
                        "Bellini cocktail",
                        "Nettare di pesca bianca 5cL   Spumante brut 10cL",
                        "Facile",
                        "10 minuti",
                        "Alcolico",
                        "Lavate le pesche bianche con acqua corrente e sbucciatele. Ora tagliatele a metà, eliminate il nocciolo centrale e tagliatele a spicchi.\n" +
                                "\n" +
                                "Sistematele in un colino e schiacciatele con un cucchiaio così da estrarne il nettare. Filtrate la purea con un colino a maglie strette, ottenendo così una polpa omogenea.\n" +
                                "\n" +
                                "Versate in un flute il nettare di pesca e aggiungete lo spumante brut o il prosecco ben freddo, fino a colmare il bicchiere.\n" +
                                "\n" +
                                "Servite subito il vostro Bellini cocktail decorato con una fettina di pesca.",
                        false


                ),
                new Cocktail(
                        15,
                        "Gin tonic",
                        "Gin 1 parte   Acqua tonica 4 parti \nLimone 1 fettina   Ghiaccio",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Mettete il ghiaccio in un bicchiere e aggiungete il gin.\n" +
                                "\n" +
                                "Versate l'acqua tonica fino a riempire tutto il calice. Decorate il bicchiere con una fettina di limone.",
                        false


                ),
                new Cocktail(
                        16,
                        "Gin lemon",
                        "Gin 6cL   Limonata 8cL \nCubetti di ghiaccio   Fetta di limone 1",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Per la preparazione del gin lemon non vi servirà lo shaker. Riempite il tumbler con il ghiaccio, versateci sopra il gin e la limonata.\n" +
                                "\n" +
                                "Mescolate delicatamente e decorate con una fetta di limone. Chi preferisce potrà aggiungere anche qualche fogliolina di menta.\n" +
                                "\n" +
                                "Il vostro gin lemon è pronto per essere servito.",
                        false


                ),
                new Cocktail(
                        17,
                        "Gimlet cocktail",
                        "Gin 6cL   Lime cordial 3cL",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Mettete il ghiaccio nella coppetta, così da raffreddarla. Versate altro ghiaccio nello shaker, aggiungete il gin e il lime cordial e agitate per una decina di secondi.\n" +
                                "\n" +
                                "Togliete il ghiaccio dalla coppetta e versate il Gimlet, filtrandolo con lo strainer e il colino conico. Decorate con una fettina di lime.\n" +
                                "\n" +
                                "Il vostro Gimlet cocktail è pronto per essere gustato.",
                        false


                ),
                new Cocktail(
                        18,
                        "Gin fizz",
                        "Soda 8cL   Gin 4,5cL \nSucco di limone fresco 3cL   Sciroppo di zucchero 1cL",
                        "Facile",
                        "10 minuti",
                        "Alcolico",
                        "Spremete il succo di limone e filtratelo. Versatelo nello shaker con ghiaccio, gin e sciroppo di zucchero.\n" +
                                "\n" +
                                "Shakerate per qualche secondo e versate nel tumbler alto pieno di ghiaccio. Aggiungete la soda e completate con una fettina di limone.\n" +
                                "\n" +
                                "Il vostro Gin Fizz è pronto per essere servito.",
                        false


                ),
                new Cocktail(
                        19,
                        "Long island iced tea",
                        "Vodka 1,5cL   Rum bianco 1,5cL \nTriple sec 1,5cL   Tequila 1,5cL \nGin 1,5cL   Succo di limone 2,5cL \nSciroppo di zucchero 3cL   Cola 1 spruzzo",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Mettete il ghiaccio in un bicchiere e aggiungete la vodka, il gin, il rum bianco, il triple sec, la tequila e completate con il succo di limone fresco, lo sciroppo di zucchero e la cola.\n" +
                                "\n" +
                                "Mescolate in maniera decisa e decorate con una fetta di limone.",
                        false


                ),
                new Cocktail(
                        20,
                        "Manhattan",
                        "Whisky 5cL   Vermut rosso 2cL \nCiliegie 1 al maraschino   Angostura 2 gocce",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Mettete in un bicchiere del ghiaccio e aggiungete due gocce di angostura.\n" +
                                "\n" +
                                "Versate il whisky e il vermouth rosso e mescolate bene ma delicatamente. Decorate con una ciliegia al maraschino.",
                        false


                ),
                new Cocktail(
                        21,
                        "Espresso Martini",
                        "Vodka 5cL   Liquore al caffè 1cL \nSciroppo di zucchero 0,5cL   Caffè espresso 1",
                        "Facile",
                        "10 minuti",
                        "Alcolico",
                        "Ghiacciate la coppetta Martini con i cubetti di ghiaccio e preparate il caffè espresso.\n" +
                                "\n" +
                                "Mettete nello shaker 4 cubetti di ghiaccio, la vodka, il liquore al caffè, lo sciroppo di zucchero e la tazzina di caffè e agitate per un minuto in modo vigoroso.\n" +
                                "\n" +
                                "Togliete il ghiaccio dalla coppetta e versate il cocktail filtrandolo con lo staniner. Servite con qualche chicco di caffè.",
                        false


                ),
                new Cocktail(
                        22,
                        "Tequila sunrise",
                        "Tequila 4,5cL   Succo di arancia 9cL \nSciroppo di granatina 1,5cL   Ciliegia candita 1 \nFette di arancia 1",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Per preparare la tequila sunrise versate i cubetti di ghiaccio nel bicchiere, aggiungete prima la tequila, poi il succo d'arancia, potete utilizzare quello già pronto ma l'ideale sarebbe spremere un'arancia, filtrarne il succo e aggiungerlo alla tequila.\n" +
                                "\n" +
                                "Mescolate con uno bar spoon e versate infine la granatina lasciando che si depositi sul fondo del bicchiere donando al cocktail il caratteristico effetto alba. Guarnite con una ciliegina candita o al maraschino e una fetta d'arancia sul bordo del bicchiere.\n" +
                                "\n" +
                                "La vostra tequila sunrise è pronta per essere gustata in tutta la sua freschezza.",
                        false


                ),
                new Cocktail(
                        23,
                        "Vesper Martini",
                        "Gin 6cL   Vodka 1,5cL \nVermut dry 0,75cL   Scorza di limone",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Mettete il ghiaccio nella coppetta Martini e fatela raffreddare.\n" +
                                "\n" +
                                "Mettete nello shaker il gin, la vodka e il vermut con qualche cubetto di ghiaccio e shakerate per una decina di secondi.\n" +
                                "\n" +
                                "Buttate il ghiaccio dalla coppetta e versate il drink, filtrando con lo strainer. Decorate con una fettina lunga di scorza di limone.\n" +
                                "\n" +
                                "Il vostro Vesper Martini è pronto per essere servito.",
                        false


                ),
                new Cocktail(
                        24,
                        "Moscow Mule",
                        "Vodka 4,5cL   Ginger beer 12cL \nLime succo, 0,5cL + una fetta   Ghiaccio",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Riempite di ghiaccio un tumbler alto o una tazza di rame. Aggiungete la vodka, la ginger beer, il succo di lime e decorate con una fettina di lime.\n" +
                                "\n" +
                                "Se preferite, potete aggiungere una fetta di cetriolo o dello zenzero fresco.",
                        false


                ),
                new Cocktail(
                        25,
                        "Bloody Mary",
                        "Succo di pomodoro 9cL   Vodka 4,5cL \nSucco di limone 1,2cL   Salsa Worcestershire 2 gocce \nTabasco 2 gocce   Sale marino \nPepe nero",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Preparate la base del cocktail con il succo di pomodoro, la salsa Worcestershire e il succo di limone e mettetelo in un bicchiere.\n" +
                                "\n" +
                                "Mescolate delicatamente in senso orario per circa 30 secondi. Spolverizzate con un pizzico di sale e di pepe nero, mescolate, aggiungete 5 cubetti di ghiaccio, la vodka e 2 gocce di tabasco.\n" +
                                "\n" +
                                "Mescolate per 30/40 secondi e guarnite con un gambo di sedano.",
                        false


                ),
                new Cocktail(
                        26,
                        "Paloma",
                        "Soda di pompelmo rosa 9cL   Tequila 5cL \nSucco di lime 1,5cL   Sale fino 1pizzico(opzionale)",
                        "Facile",
                        "10 minuti",
                        "Alcolico",
                        "Ricavate il succo dal lime e filtratelo. Aggiungete il sale nel succo e mescolate per scioglierlo.\n" +
                                "\n" +
                                "Versate il ghiaccio in un tumbler basso o in un bicchiere Collins, dal collo alto, e aggiungete la tequila, il succo di lime e la soda.\n" +
                                "\n" +
                                "Mescolate delicatamente con un bar spoon e servite subito con una fetta di lime.\n" +
                                "\n" +
                                "Il vostro Paloma cocktail è pronto per essere gustato.",
                        false


                ),
                new Cocktail(
                        27,
                        "Singapore Sling",
                        "Gin 3cL   Cherry brandy 1,5cL \nCointreau 0,75cL   Dom Benedectine 0,75cL \nSciroppo di granatina 1cL   Succo di ananas 12cL \nSucco di limone 1,5cL   Angostura 1 goccia",
                        "Media",
                        "5 minuti",
                        "Alcolico",
                        "Prendete lo shaker e versate tre cubetti di ghiaccio.\n" +
                                "\n" +
                                "Unite il gin aiutandovi con un misurino e aggiungete lo cherry, il cointreau, il don benedectine, il succo di limone, il succo di ananas, lo sciroppo di granatina ed una goccia di Angostura.\n" +
                                "\n" +
                                "Chiudete lo shaker e agitate per 12-15 secondi. Prendete un bicchiere da long drink tipo highball e versate la miscela ottenuta filtrandola con lo strainer. Guarnite con un quarto di fetta di ananas ed una ciliegia al maraschino e servite subito.",
                        false

                ),
                new Cocktail(
                        28,
                        "Americano",
                        "Bitter 3cL   Vermouth rosso 3cL \nSoda uno spruzzo   Ghiaccio",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Colmate un bicchiere di ghiaccio e unite bitter Campari e vermouth.\n" +
                                "\n" +
                                "Aggiungete la soda e mescolate delicatamente. Unite una fettina di limone al cocktail e decorate con una fetta di arancia.",
                        false

                ),
                new Cocktail(
                        29,
                        "Mai Tai",
                        "Rum chiaro 40mL   Rum scuro 20mL \nOrange curacao 15mL   Sciroppo di orzata 15mL \nSucco di lime 10mL",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Versate il rum bianco, lo sciroppo di orzata, il succo di lime e l'orange curaçao in uno shaker.\n" +
                                "\n" +
                                "Aggiungete una paletta di ghiaccio e agitate fino ad ottenere una mistura ben ghiacciata.\n" +
                                "\n" +
                                "Versate il composto ottenuto in un bicchiere highball e aggiungete delicatamente a filo il rum scuro che dovrà restare in superficie.\n" +
                                "\n" +
                                "Guarnite con un quarto di spicchio di ananas ed una fogliolina di menta e servite.",
                        false

                ),
                new Cocktail(
                        30,
                        "Penicillin",
                        "Scotch whisky 45mL   Islay single malt scotch 1 goccia \nSucco di limone 15mL   Sciroppo di miele 10ml \nSucco di zenzero 5mL   Zenzero candito \nGhiaccio a cubetti",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "La ricetta dello Penicillin cocktail è davvero molto semplice e veloce da preparare. Non ci sono regole particolari da seguire, se non la scelta di alcolici di qualità e ingredienti freschi. Tutti i sapori devono essere ben amalgamati insieme e filtrati in un bicchiere tumbler.\n" +
                                "\n" +
                                "Per preparare lo sciroppo di miele con lo zenzero, fate bollire circa 200ml di acqua a fuoco vivo. Mescolate 5g di miele e 5ml di succo di zenzero. Fate cuocere 5 minuti, lasciate raffreddare e filtrate il succo per raccogliere le parti solide.\n" +
                                "\n" +
                                "In uno shaker mescolate Scotch Whisky e Islay Single Malt Scotch, il succo di limone, il succo di miele e zenzero e dei cubetti di ghiaccio. Agitate in maniera decisa per qualche istate e versate il cocktail in un tumbler. Decorate il bordo del bicchiere con un pezzo di zenzero caramellato.",
                        false

                ),
                new Cocktail(
                        31,
                        "Boulevardier",
                        "Whisky 3cL   Bitter Campari 3cL \nVermut 3cL",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Versate il ghiaccio in un mixing glass, versate il whiskey, il vermut ed il campari: mescolate per 30 secondi e versate il vostro cocktail in un bicchiere Old fashioned.\n" +
                                "\n" +
                                "Tagliate la buccia di un'arancia con un contello ben affilato e guarnite il vostro Boulevardier.",
                        false

                ),
                new Cocktail(
                        32,
                        "Acapulco",
                        "Tequila 1 parte   Rum bianco 1 parte \nSucco di ananas 2 parti   Succo di pompelmo 1 parte \nLatte di cocco 1 parte",
                        "Medio-Facile",
                        "3 minuti",
                        "Alcolico",
                        "Mettete un po' di ghiaccio spezzettato nello shaker e versatevi tequila, rum, succo di ananas, succo di pompelmo e latte di cocco.\n" +
                                "\n" +
                                "Shakerate il drink e versatelo in un hurricane.\n" +
                                "\n" +
                                "Decorate con un pezzetto di ananas e servite con cannucce.",
                        false

                ),
                new Cocktail(
                        33,
                        "Malibu cocktail",
                        "Rum 2 parti   Vodka 2 parti \nSucco di arancia 1 parte",
                        "Facile",
                        "3 minuti",
                        "Alcolico",
                        "Colmate di ghiaccio un bicchiere, versatevi il rum, la vodka e il succo d'arancia, mescolate e sarete a Malibu.",
                        false

                ),
                new Cocktail(
                        34,
                        "Dark\\'n\\'Stormy",
                        "Rum scuro 6cL   Ginger beer 10cL",
                        "Facile",
                        "3 minuti",
                        "Alcolico",
                        "Ricetta elementare: colmate un bicchiere highball di ghiaccio, versate il rum scuro e finite con la ginger beer.\n" +
                                "\n" +
                                "Guarnite con una fetta di lime. Aggiungete 2 cl di succo di lime e avrete il Rum Buck, il corrispettivo del Moscow Mule a base di rum.",
                        false

                ),
                new Cocktail(
                        35,
                        "Clover club",
                        "Gin 4,5cL   Sciroppo di lampone 1,5cL \nSucco di limone 1,5cL   Albume 3 cucchiaini",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Spremete il limone e filtrate il succo.\n" +
                                "\n" +
                                "Versate tutti gli ingredienti in un shaker pieno di ghiaccio, agitate per 12 secondi e poi versate in una coppetta Martini ben raffreddata con il ghiaccio.\n" +
                                "\n" +
                                "Decorate a piacere, lamponi o more sarebbero l’ideale.",
                        false

                ),
                new Cocktail(
                        36,
                        "Piña colada",
                        "Rum bianco 3cL   Latte di cocco 3cL \nSucco di ananas 9cL",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Per preparare la piña colada, versate nello shaker il ghiaccio a cubi, latte di cocco, succo di ananas e rum bianco e mescolate dolcemente per 30 secondi per rendere il cocktail spumoso.\n" +
                                "\n" +
                                "Versate in un bicchiere grande e guarnite con una fetta di ananas.",
                        false

                ),
                new Cocktail(
                        37,
                        "Cosmopolitan",
                        "Vodka Citron 4cL   Cointreau 1,5cL \nSucco di limone 1,5cL   Succo di mirtillo 3cL",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Versate in uno shaker la vodka, il triple sec, il succo di cranberry e qualche cubetto di ghiaccio.\n" +
                                "\n" +
                                "Spremete un limone con uno spremiagrumi, filtratene il succo, versatelo nello shaker, chiudetelo col secondo boccale e shakerate, cioè agitate energicamente i due boccali incastrati fino a far divenire lo shaker ben freddo.\n" +
                                "\n" +
                                "Versate il cocktail nel classico bicchiere a cono e filtrate il ghiaccio con uno strainer o con un semplice colino.\n" +
                                "\n" +
                                "Lavate un lime e tagliate una fetta sottile incidendolo leggermente per applicarla sul bicchiere da guarnire. Gustatelo ancora freddo.",
                        false

                ),
                new Cocktail(
                        38,
                        "Pornstar Martini",
                        "Vodka alla vaniglia 5cL   Liquore al frutto della passione 2cL \nPurea di frutto della passione 5cL   Barspoon di zucchero alla vaniglia 2 \nChampagne 6cL",
                        "Media",
                        "5 minuti",
                        "Alcolico",
                        "Tagliate a metà i frutti della passione, tenete una metà da parte ed estraete la polpa e passatela nel colino fine, schiacciando con un cucchiaio.\n" +
                                "\n" +
                                "Per fare lo zucchero alla vaniglia niente paura: mescolate zucchero e vaniglia in parti uguali, non è zucchero vanigliato in polvere, ma una semplice miscela di zucchero bianco e vaniglia in polvere.\n" +
                                "\n" +
                                "Mettete del ghiaccio in uno shaker, aggiungete la purea di frutto della passione, la vodka alla vaniglia, il liquore di frutto della passione, 2 cucchiaini di zucchero alla vaniglia, agitate velocemente e versate in una coppa martini ghiacciata.\n" +
                                "\n" +
                                "Decorate con una metà di frutto della passione, aggiungete un cucchiaino per estrarre la polpa. Servite il cocktail accompagnato da uno shot di Champagne da 60 ml.\n" +
                                "\n" +
                                "Sembra un cocktail difficile da fare, ma in realtà basta preparare in anticipo tutti gli ingredienti per lavorare poi più velocemente.",
                        false

                ),
                new Cocktail(
                        39,
                        "Caipiroska",
                        "Vodka 5cL   Lime 0,5cL \nZucchero di canna 2 cucchiaini",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Tagliate il lime a spicchi eliminando prima le due estremità e poi il filo bianco centrale.\n" +
                                "\n" +
                                "Mettete gli spicchi di lime in un tumbler basso o in un bicchiere old fashioned insieme allo zucchero.\n" +
                                "\n" +
                                "Pestate il tutto con il muddler e, una volta sciolto lo zucchero, inserite il ghiaccio tritato e versate la vodka. Mescolate aiutandovi con lo stiller o con un cucchiaino.\n" +
                                "\n" +
                                "Decorate come più vi piace, magari con una fettina di lime, aggiungete 2 cannucce corte e servite.",
                        false

                ),
                new Cocktail(
                        40,
                        "Caipirinha",
                        "Cachaca 5cL   Lime metà \nZucchero di canna 2 cucchiaini",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Tagliate il lime in quattro spicchi e mettetelo in un bicchiere capiente con lo zucchero di canna.\n" +
                                "\n" +
                                "Aggiungete la cachaça e pestate vigorosamente per farne uscire il succo. Mescolate bene e aggiungete del ghiaccio spezzettato fino a riempire il bicchiere.\n" +
                                "\n" +
                                "Guarnite con uno spicchio di lime e servite.\n" +
                                "\n" +
                                "Per una caipirinha perfetta, tagliate correttamente il lime: usate un coltello a sega, tagliate ed eliminate le due estremità del frutto con un taglio netto e appoggiate il lime su un tagliere.\n" +
                                "\n" +
                                "Eliminate il filamento bianco centrale con un taglio a V in modo da evitare il gusto amaro durante la spremitura.",
                        false


                ),
                new Cocktail(
                        41,
                        "Cuba Libre",
                        "Rum bianco 5cL   Cola 10cL \nSucco di lime 1cL",
                        "Facile",
                        "5 minuti",
                        "Alcolico",
                        "Versate in un tumbler alto il ghiaccio per raffreddarlo e scolate l'acqua in eccesso.\n" +
                                "\n" +
                                "Aggiungete il rum, la cola e il succo di lime nel bicchiere e mescolate.\n" +
                                "\n" +
                                "Servite con una fetta di lime.",
                        false


                ),
                new Cocktail(
                        42,
                        "Sex on the beach",
                        "Vodka 4cL   Vodka alla pesca 2cL \nSucco di arancia 4cL   Succo di mirtillo 4cL",
                        "Facile",
                        "3 minuti",
                        "Alcolico",
                        "Riempite uno shaker di cubetti di ghiaccio e aggiungete vodka, vodka alla pesca e succo di arancia. Shakerate energicamente.\n" +
                                "\n" +
                                "Preparate un bicchiere tumbler alto e versate il contenuto dello shaker.\n" +
                                "\n" +
                                "Aggiungete il succo di mirtilli senza mescolare in modo da farlo depositare sul fondo e creare il particolare contrasto di colori tra il chiaro del cocktail e il colore intenso del mirtillo.\n" +
                                "\n" +
                                "Decorate con una fetta d'arancia, di ananas o una ciliegina e una cannuccia.",
                        false


                ),
                new Cocktail(
                        43,
                        "Apple killer",
                        "Polpa di mela 2 parti   Polpa di melone 2 parti \nSweet and sour mix 2 parti",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Bisogna utilizzare la tecnica di blend in calice da vino, frullando per bene mela e melone con un tocco di sweet and sour.",
                        false


                ),
                new Cocktail(
                        44,
                        "Green light",
                        "Limone a pezzetti 1/2   Foglie di menta 3 \nSciroppo di menta 2cL   Lemonsoda \nGhiaccio",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Pestiamo delicatamente il mezzo limone a pezzetti e le foglie di menta nel nostro bicchiere.\n" +
                                "\n" +
                                "Aggiungiamo poi lo sciroppo di menta e riempiamo il bicchiere con del ghiaccio.\n" +
                                "\n" +
                                "Concludiamo infine il drink con la lemonsoda e, versandone la quantità che preferiamo. Mescoliamo e completiamo con la guarnizione.",
                        false


                ),
                new Cocktail(
                        45,
                        "Sangria analcolica",
                        "Limone 1   Sanbitter 30cL \nSucco d'uva e di mela frizzante 30cL   Arancia 2 \nFragola 250g",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Spremete il limone e versate il succo in una capiente caraffa piena per metà di ghiaccio.\n" +
                                "\n" +
                                "Servite il Sanbitter, il succo d’uva e il succo di mele. Dividete le arance a piccole fette e dimezzate le fragole.\n" +
                                "\n" +
                                "Aggiungete la frutta nel drink e preparatevi a gustare!",
                        false


                ),
                new Cocktail(
                        46,
                        "Raspberry lemonade",
                        "Sciroppo di lampone 2cL   Club soda 20cL \nGhiaccio tritato   Lime \nLamponi   Menta",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Prendete 10 lamponi, mezzo lime tagliato e pestate il tutto in un bicchiere hurricane.\n" +
                                "\n" +
                                "Riempite il bicchiere fino all’orlo con del ghiaccio tritato e versate lo sciroppo di lampone e la Club soda mescolando delicatamente.\n" +
                                "\n" +
                                "Guarnite il bicchiere con 2 lamponi, uno spicchio di lime e una foglia di menta.",
                        false


                ),
                new Cocktail(
                        47,
                        "Red coconut",
                        "Crema di cocco 5cL   Succo di ananas 5cL \nSciroppo di fragola 2cL",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Versate gli ingredienti in uno shaker con alcuni cubetti di ghiaccio.\n" +
                                "\n" +
                                "Agitate bene e filtrate il tutto nel vostro bicchiere da long drink con ghiaccio tritato.\n" +
                                "\n" +
                                "Decorate infine il cocktail con la guarnizione.",
                        false


                ),
                new Cocktail(
                        48,
                        "Cool passion",
                        "Succo di arancia 1,2cL   Succo di passiflora 1,2cL \nSucco di ananas 5cL",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Mescolate gli ingredienti nelle giuste quantità in un calice di vino bianco con la bocca sporca di zucchero.\n" +
                                "\n" +
                                "Servite il drink con ghiaccio e guarnitelo con una fettina di ananas tagliato a pezzi.",
                        false


                ),
                new Cocktail(
                        49,
                        "Shirley temple",
                        "Granatina 7mL   Ginger ale 10cL",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Colmate il bicchiere con il ghiaccio e versate gli ingredienti mescolandoli dolcemente.\n" +
                                "\n" +
                                "Decorate con una ciliegina al maraschino. Esiste anche una versione alcolica con l’aggiunta di 5 cl di rum scuro.",
                        false


                ),
                new Cocktail(
                        50,
                        "Virgin Mojito",
                        "Lime 1/2   Foglie di menta 10 \nLimonata 2/3   Cucchiaino di zucchero di canna 2 \nGinger ale 1/3",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Mettete nello shaker: il lime a cubetti, la menta, lo zucchero di canna e pestateli.\n" +
                                "Aggiungete il ginger, la limonata ed il ghiaccio tritato.\n" +
                                "Shakerate bene e servite in un bicchiere tipo tumbler.",
                        false


                ),
                new Cocktail(
                        51,
                        "Virgin Colada",
                        "Latte di cocco 250mL   Succo di ananas 100mL \nSucco di lime 1 spruzzo   Ghiaccio \nCiliegia candita 1",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Mettete il latte di cocco nel bicchiere dello shaker con il ghiaccio.\n" +
                                "\n" +
                                "Aggiungete poi il succo d'ananas.\n" +
                                "\n" +
                                "Mettete in ultimo il succo di lime, chiudere con il tappo e shakerate.\n" +
                                "\n" +
                                "Versate in un bicchiere.\n" +
                                "\n" +
                                "Servite il vostro virgin colada con una ciliegia candita ed un ombrellino di carta ovviamente.",
                        false


                ),
                new Cocktail(
                        52,
                        "Virgin Moscow mule",
                        "Ghiaccio in cubetti   Cetriolo 2 fette \nGinger ale 1,2cL   Succo di lime fresco 0,5cL \nZenzero",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Nel bicchiere versate lo zucchero e il succo di lime. Mescolate con un barspoon.\n" +
                                "\n" +
                                "Unite abbondante ghiaccio.\n" +
                                "\n" +
                                "Aggiungete 2 fette di cetriolo. Completate con un fill up di ginger ale, mescolate e servite.",
                        false


                ),
                new Cocktail(
                        53,
                        "Virgin Royal Hawaiian",
                        "Succo di ananas 90g   Latte di mandorle 60g \nSucco di limone 30g   Ananas fresco da guarnire",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Per la ricetta del virgin royal hawaiian, raccogliete nello shaker il succo d'ananas, il latte di mandorle, il succo di limone e abbondante ghiaccio tritato.\n" +
                                "\n" +
                                "Agitate bene quindi filtrate il drink versandolo nel bicchiere ben ghiacciato (va tenuto in freezer).\n" +
                                "\n" +
                                "Guarnite con uno spicchietto di ananas fresco, foglioline del suo ciuffo verde, quindi servite.",
                        false


                ),
                new Cocktail(
                        54,
                        "San Francisco",
                        "Succo di arancia 6cL   Succo di arancia 4cL \nSucco di limone 2,5cL   Succo di pompelmo 2,5cL \nGhiaccio 3 cubetti   Albume 2 pezzi \nGranatina 2 spruzzi   Soda",
                        "Facile",
                        "10 minuti",
                        "Analcolico",
                        "Mettete il ghiaccio nello shaker e aggiungete il succo di arancia, il succo di limone, succo di pompelmo, succo di ananas, la granatina e gli albumi.\n" +
                                "\n" +
                                "Shakerate energicamente e filtrate in una coppetta o in un tumbler alto. Aggiungete la soda e decorate con la fettina di lime.",
                        false


                ),
                new Cocktail(
                        55,
                        "Red sunset",
                        "Succo di ananas 4cL   Succo di arancia 4cL \nSucco di pesca 4cL   Foglie di menta",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Versate nel vostro bicchiere il succo d’ananas e il succo d’arancia.\n" +
                                "\n" +
                                "Aggiungete il ghiaccio e mescolate completando con il succo di pesca. Terminate con la guarnizione.",
                        false


                ),
                new Cocktail(
                        56,
                        "Rose lemon spritzer",
                        "Succo di pompelmo rosa 7cL   Acqua tonica al limone 3cL \nCucchiaino di miele 1",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Riempite il bicchiere con del ghiaccio e versate il succo di pompelmo e l’acqua tonica al limone.\n" +
                                "\n" +
                                "Mescolate aggiungendo il miele e completate con la guarnizione.",
                        false


                ),
                new Cocktail(
                        57,
                        "Virgin Margarita",
                        "Soda di lime 20cL   Succo di arancia 9cL \nGranita di limone 5cL   Succo di lime 3cL \nGhiaccio a cubetti   Fettine di lime e zucchero di canna a guarnire",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Miscelate tutti i succhi e la granita e poneteli in freezer, appena raffreddati e quasi cristallizzati prelevateli e frullate il tutto creando una sorta di sorbetto a cui aggiungere la soda e le fettine di lime, servite in bicchieri larghi guarniti sul bordo da zucchero di canna.",
                        false


                ),
                new Cocktail(
                        58,
                        "Tropical",
                        "Latte 10cL   Sciroppo di menta 2,5cL \nSciroppo di orzata 2,5cL   Ghiaccio",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Prendete uno shaker e lo riempite con del ghiaccio. Aggiungete tutti gli ingredienti ed agitate per circa 15 secondi.\n" +
                                "\n" +
                                "Versate la bevanda nel bicchiere filtrando con uno strainer e completate con la guarnizione.",
                        false


                ),
                new Cocktail(
                        59,
                        "Fruit punch",
                        "Succo di arancia 5cL   Succo di mirtilli 5cL \nSucco di ananas 3cL",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Mescolate gli ingredienti in un tumbler basso pieno di ghiaccio fino a raggiungere un colore rosso acceso e colmate il bicchiere con la soda.\n" +
                                "\n" +
                                "Servite decorandolo con una fettina d’arancia e, se gradite, anche con una sottile fetta di mela.",
                        false


                ),
                new Cocktail(
                        60,
                        "Lemonade fruit",
                        "Succo di limone 5,5cL   Succo di lamponi 5,5cL \nSoda 1cL",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Aggiungete il succo di limone e il succo di lamponi in uno shaker pieno di ghiaccio.\n" +
                                "\n" +
                                "Agitate per qualche secondo e, filtrando con uno strainer, versate il tutto nel nostro bicchiere. Concludete con la soda e la guarnizione.",
                        false


                ),
                new Cocktail(
                        61,
                        "All shook up",
                        "Fragole 12g   Lamponi 12g \nLatte freddo 7cL   Yogurt freddo 60g \nCucchiaino acqua di rose 1   Cucchiaino miele chiaro 1",
                        "Facile",
                        "5 minuti",
                        "Analcolico",
                        "Mettete nel frullatore tutti gli ingredienti ad esclusione del miele e frullate per circa 40 secondi.\n" +
                                "\n" +
                                "Versate il contenuto nel nostro bicchiere e mescolate delicatamente aggiungendo il miele. Completate con la guarnizione.",
                        false


                ),

        };
        @NonNull
        private final static HashMap<String, Integer> COLOR_MAP = new HashMap<>();

        public static void setup(@NonNull Context context) {
                final Resources res = context.getResources();

                String[] keys = res.getStringArray(R.array.ptBlocks);
                int[] colorValues = res.getIntArray(R.array.ptBlockColors);
                for (int i = 0; i < keys.length; i++) {
                        COLOR_MAP.put(keys[i], colorValues[i]);
                }
        }

        private static final HashMap<Integer, Cocktail> ID_MAP = new HashMap<>(COCKTAIL.length);

        static {
                for (int i = 0; i < COCKTAIL.length; i++) {
                        ID_MAP.put(COCKTAIL[i].id, COCKTAIL[i]);
                }
        }
        @Nullable
        public static Cocktail getCocktail(int number) {
                if (number < 1 || number > COCKTAIL.length) {
                        return null;
                }
                return COCKTAIL[number - 1];
        }
        public static Cocktail getCocktailById(int number){
                for(int i=0; i< COCKTAIL.length; i++){

                        if(COCKTAIL[i].id == number)
                                return COCKTAIL[i];

                }
                return null;
        }
        public static int getImageCocktail(Cocktail cocktail){

                if(cocktail.category == "Alcolico")
                        return R.drawable.Alcolico;
                if(cocktail.category == "Analcolico")
                        return R.drawable.Analcolico;

                return 0;
        }
        @NonNull
        public static Cocktail[] getCocktail() {
                return COCKTAIL.clone();
        }

        public static int getNumeroCocktail() {
                return COCKTAIL.length;
        }

        public static int getCocktailName(int number) {
                if (number > COCKTAIL_NAMES.length) {
                        return R.string.sconosciuto;
                }

                return COCKTAIL_NAMES[number - 1];
        }
        public static Cocktail[] getListaAlcolici()
        {
                Cocktail[] Alcolici =new Cocktail[42];
                int i=0;
                for(Cocktail e : Menu.getCocktail()){
                        if(i==42)
                                break;
                        Alcolici[i]=new Cocktail(e.id,e.nome,e.ingredients,e.difficulty,e.time,e.category,e.preparation,e.salvata);

                        i++;

                }


                return Alcolici;
        }


        public static Cocktail[] getListaAnalcolici()
        {
                Cocktail[] Alcolici=new Cocktail[19];
                int i=0;
                int j=0;
                for(Cocktail e : Menu.getCocktail()){

                        if(j<42){
                                j++;
                                continue;}

                        if(i==19)
                                break;
                        Alcolici[i]=new Cocktail(e.id,e.nome,e.ingredients,e.difficulty,e.time,e.category,e.preparation,e.salvata);

                        i++;

                }


                return Alcolici;
        }

}

