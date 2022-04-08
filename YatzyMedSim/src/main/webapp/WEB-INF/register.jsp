<%-- Setter contentType og tegnsett --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="no">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="resources/js/FormController.js" defer></script>
<link rel="icon" href="data:," />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<title>Registrer</title>
</head>
<body>
    <h2>Registrer</h2>

    <p>
        <font color="red">${error}</font>
    </p>

    <form method="post">
        <fieldset>
            <label for="navn">Navn:</label> <input type="text"
                name="navn" id="navn" value=""
                placeholder="Fyll inn navn"
                title="Navn må starte med stor forbokstav og innholde kun bokstaver. Antall tegn må være mellom 2 og 20."
                required
                pattern="(^[A-ZÆØÅ])((?![ -]$)[a-zæøå -]){1,19}$" />
            <span class="melding"></span> <label for="brukernavn">Brukernavn:</label>
            <input type="text" name="brukernavn" id="brukernavn"
                value="" placeholder="Fyll inn brukernavn"
                title="Brukernavn må starte med stor forbokstav og innholde kun bokstaver. Antall tegn må være mellom 2 og 20."
                required pattern="(^[A-ZÆØÅ])((?![-]$)[a-zæøå-]){1,19}$" />
            <span class="melding"></span> <label for="epost">Epost:</label>
            <input type="text" name="epost" id="epost" value=""
                placeholder="Fyll inn epost"
                title="Epost må bestå av navn@noe.no" required
                pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" />
            <span class="melding"></span> <label for="passord">Passord:</label>
            <input type="password" name="passord" id="passord" value=""
                placeholder="Velg et passord"
                title="Passordet må bestå av minst 8 tegn, men bør ha minst 14 tegn."
                required pattern=".{8,}" /> <span
                class="melding"></span> <label for="passordRepetert">Passord
                repetert:</label> <input type="password" name="passordRepetert"
                id="passordRepetert" value=""
                placeholder="Gjenta passord" required /> <span
                class="melding"></span>

            <button type="submit">Meld meg på</button>
        </fieldset>
    </form>
</body>
</html>