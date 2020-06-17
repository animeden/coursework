<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Title</title>

</head>

<body style="margin: 0; padding: 0; width: 100%; height: 100%; display: flex; justify-content: center; align-items: center">

    <div style="width: 100%; height: 100%; display: none; justify-content: center; flex-direction: column; align-items: center"; id="er1">

        <h1>Incorrect name</h1>
        <a>-First name, Last name and Middle name must have first big letter</a>
        <a>-First name, Last name and Middle name must have at least 3 symbols</a>
        <a>-First name and Last name can't be longer than 20 symbols</a>
        <a>-Middle name can't be longer than 26 symbols</a>
        <a>-Use "-" between parts of your Last name</a>

    </div>

    <div style="width: 100%; height: 100%; display: none; justify-content: center; flex-direction: column; align-items: center"; id="er2">

        <h1>Incorrect date</h1>
        <a>-Dates lover that 10 must be writed like(09,03,08.....)</a>
        <a>-Days can't be more that 31</a>
        <a>-Mounts can't be more that 12</a>
        <a>-Lower year is 1900</a>
        <a>-Heighter year is 2099</a>
        <a>-You can't use letters</a>

    </div>

    <div style="width: 100%; height: 100%; display: none; justify-content: center; flex-direction: column; align-items: center"; id="er3">

        <h1>Incorrect number</h1>
        <a>-Number start from operator code</a>
        <a>-Number can have max 10 symbols</a>
        <a>-Number can have only Ukrainian operator code</a>
        <a>-Didn't you 'space'</a>

    </div>

    <div style="width: 100%; height: 100%; display: none; justify-content: center; flex-direction: column; align-items: center"; id="er4">

        <h1>Incorrect mission</h1>
        <a>-You can use at max 5 words</a>
        <a>-First word start from big letter</a>

    </div>

    <div style="width: 100%; height: 100%; display: none; justify-content: center; flex-direction: column; align-items: center"; id="er5">

        <h1>Incorrect description</h1>
        <a>-You can use at max 5 words</a>
        <a>-First word start from big letter</a>

    </div>

    <div style="width: 100%; height: 100%; display: none; justify-content: center; flex-direction: column; align-items: center"; id="er6">

        <h1>Incorrect adress</h1>
        <a>-Adress must start from big letter</a>
        <a>-In the end you must write number of house</a>

    </div>

    <div style="width: 100%; height: 100%; display: none; justify-content: center; flex-direction: column; align-items: center"; id="er7">

        <h1>Incorrect number</h1>
        <a>-Higher number is 999</a>
        <a>-Lower number is 1</a>
        <a>-You can use only numbers</a>

    </div>

</body>

</html>

<script>

        window.onload = err();

        function err() {
            let f = window.location.href;
            if(f == "http://localhost:1821/web/administration/error1")
            {
                document.getElementById("er1").style.display = 'flex';
            }
            if(f == "http://localhost:1821/web/administration/error2")
            {
                document.getElementById("er2").style.display = 'flex';
            }
            if(f == "http://localhost:1821/web/administration/error3")
            {
                document.getElementById("er3").style.display = 'flex';
            }
            if(f == "http://localhost:1821/web/brigade/error4")
            {
                document.getElementById("er4").style.display = 'flex';
            }
            if(f == "http://localhost:1821/web/administration/error5")
            {
                document.getElementById("er5").style.display = 'flex';
            }
            if(f == "http://localhost:1821/web/administration/error6")
            {
                document.getElementById("er6").style.display = 'flex';
            }
            if(f == "http://localhost:1821/web/brigade/error7")
            {
                document.getElementById("er7").style.display = 'flex';
            }
            if(f == "http://localhost:1821/web/brigade/error5")
            {
                document.getElementById("er5").style.display = 'flex';
            }
        }

</script>