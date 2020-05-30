<#import "/spring.ftl" as spring>
<h3>Timetable List</h3>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-dark">
        <tr class="bg-success">
            <th>ID</th>
            <th>Time of going</th>
            <th>Time of come</th>
            <th>Route</th>
            <th>Ticket price</th>
            <th>Ready</th>
            <th>Number of passenger</th>
            <th>Free space</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list timetables as timetable>
            <tr class="bg-primary">
                <td>${timetable.id}</td>
                <td>${timetable.timeOfGoing}</td>
                <td>${timetable.timeOfCome}</td>
                <td>${timetable.numberOfRoute.stations}</td>
                <td>${timetable.ticketPrice}</td>
                <td>${timetable.readyID.descriction}</td>
                <td>${timetable.numberOfPassager}</td>
                <td>${timetable.freeSpace}</td>
                <td>${timetable.descriction}</td>
                <td><a href="/web/timetable/delete/${timetable.id}"><button>Delete</button></a></td>
                <td><a href="/web/timetable/edit/${timetable.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>

    <a href="/web/timetable/create"><button>Create</button></a>

    <div>

        <fieldset>

            <legend>Find timetable</legend>

            <form name="search" action="" method="POST">

                Time of going:<@spring.formInput "searchForm.string" "" "text"/>

                <br>

                <input type="submit" value="Search"/>

            </form>

        </fieldset>

    </div>

</div>

<div>

    <a href="/web/timetable/sort"><button>Sort</button></a>

</div>