<#import "/spring.ftl" as spring>

<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Timetable</title>

</head>

<div style="width: 100%; height: 100%; background: #08032b">

    <div style="width: 100%; height: max-content; background: #08032b">

        <div style="display: flex">

            <div style="width: 10%; height: 159px; position: fixed; display: flex; flex-direction: column; justify-content: space-around; align-items: flex-start">
                <div style="height: 35px; background: darkblue; width: 100px; display: none; justify-content: center; align-items: center; border-top-right-radius: 20px; border-bottom-right-radius: 20px" id="mp1">
                    <a class="pt-1" href="http://localhost:1821" style="color: white; text-decoration: none; display: block; height: 100%; width: 100%">Main menu</a>
                </div>
                <div style="height: 35px; background: darkblue; width: 100px; display: none; justify-content: center; align-items: center; border-top-right-radius: 20px; border-bottom-right-radius: 20px" id="mp2">
                    <a class="pt-1" href="https://animedenapp.herokuapp.com" style="color: white; text-decoration: none; display: block; height: 100%; width: 100%">Main menu</a>
                </div>
                <div style="height: 35px; background: dodgerblue; width: 70px; display: flex; justify-content: center; align-items: center; border-top-right-radius: 20px; border-bottom-right-radius: 20px">
                    <a class="pl-2 pt-1" href="#src" style="color: black; text-decoration: none; display: block; height: 100%; width: 100%">Search</a>
                </div>
                <div style="height: 35px; background: deeppink; width: 70px; display: flex; justify-content: center; align-items: center; border-top-right-radius: 20px; border-bottom-right-radius: 20px" id="sr" onclick="fup()">
                    <a class="pl-3 pt-1" href="/web/timetable/sort" style="color: black; text-decoration: none; display: block; height: 100%; width: 100%">Sort</a>
                </div>
                <div style="height: 35px; background: rebeccapurple; width: 70px; display: none; justify-content: center; align-items: center; border-top-right-radius: 20px; border-bottom-right-radius: 20px" id="nsr" onclick="fup()">
                    <a class="pl-2 pt-1" href="/web/timetable/get/list" style="color: black; text-decoration: none; display: block; height: 100%; width: 100%">Unsort</a>
                </div>
                <div style="height: 35px; background: limegreen; width: 70px; display: flex; justify-content: center; align-items: center; border-top-right-radius: 20px; border-bottom-right-radius: 20px">
                    <a class="pl-2 pt-1" href="/web/timetable/create" style="color: black; text-decoration: none; display: block; height: 100%; width: 100%">Create</a>
                </div>
            </div>

        </div>

        <a name="src"></a>
        <div class="mb-4 pt-3 text-center" style="width: 100%; color: white">
            <h1>Timetable Listt</h1>
        </div>

        <div>

            <fieldset class="text-center" style="color: white">

                <legend>Find timetable</legend>

                <form name="search" action="" method="POST">

                    Time of going:<br/><@spring.formInput "searchForm.string" "" "text"/>

                    <br/>

                    <input class="btn btn-primary mt-1" type="submit" value="Search"/>

                </form>

            </fieldset>

        </div>

        <div class="pt-4">

            <table border="3", bgcolor="#d10000", class="table table-dark">

                <tr style="background-color: #a81919">

                    <th>ID</th>
                    <th>Time of going</th>
                    <th>Date of going</th>
                    <th>Time of come</th>
                    <th>Date of come</th>
                    <th>Route number</th>
                    <th>Ticket price</th>
                    <th>Number of passenger</th>
                    <th>Description</th>
                    <th>Edit</th>
                    <th>Delete</th>

                </tr>

                <#list timetables as timetable>

                    <tr style="background: white; color: black">

                        <td>${timetable.id}</td>
                        <td>${timetable.timeOfGoing}</td>
                        <td>${timetable.dateOfGoing}</td>
                        <td>${timetable.timeOfCome}</td>
                        <td>${timetable.dateOfCome}</td>
                        <td>${timetable.numberOfRoute.stations}</td>
                        <td>${timetable.ticketPrice}</td>
                        <td>${timetable.numberOfPassager}</td>
                        <td>${timetable.descriction}</td>

                        <td><a href="/web/timetable/edit/${timetable.id}"><button class="btn" style="background: #def511">Edit</button></a></td>
                        <td><a href="/web/timetable/delete/${timetable.id}" style="color: white"><button class="btn" style="background: #d60202; color: white">Delete</button></a></td>

                    </tr>

                </#list>

            </table>

        </div>

        <div style="width: 100%; height: 20px"></div>

    </div>

</div>

<script>

    window.onload = src();

    function src() {
        let f = window.location.href;
        if (f == "http://localhost:1821/web/timetable/sort" || f == "https://animedenapp.herokuapp.com/web/timetable/sort")
        {
            document.getElementById("sr").style.display = 'none';
            document.getElementById("nsr").style.display = 'flex';
        }
        if (f == "http://localhost:1821/web/timetable/get/list" || f == "https://animedenapp.herokuapp.com/web/timetable/get/list")
        {
            document.getElementById("sr").style.display = 'flex';
            document.getElementById("nsr").style.display = 'none';
        }
        if(f == "http://localhost:1821/web/timetable/sort" || f == "http://localhost:1821/web/timetable/get/list")
        {
            document.getElementById("mp1").style.display = 'flex';
            document.getElementById("mp2").style.display = 'none';
        }
        if(f == "https://animedenapp.herokuapp.com/web/timetable/sort" || f == "https://animedenapp.herokuapp.com/web/timetable/get/list")
        {
            document.getElementById("mp1").style.display = 'none';
            document.getElementById("mp2").style.display = 'flex';
        }
    }

</script>