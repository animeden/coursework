<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="timetable" action="" method="POST">

    Time of going:<@spring.formInput "timetableForm.timeOfGoing" "" "text"/>
    <br>
    Time of come:<@spring.formInput "timetableForm.timeOfCome" "" "text"/>
    <br>
    Number of route:<@spring.formSingleSelect "timetableForm.numberOfRoute", mavs, ""/>
    <br>
    Ticket price:<@spring.formInput "timetableForm.ticketPrice" "" "text"/>
    <br>
    Ready ID:<@spring.formSingleSelect "timetableForm.readyID", mavss, ""/>
    <br>
    Number of passengers:<@spring.formInput "timetableForm.numberOfPassager" "" "text"/>
    <br>
    Free space:<@spring.formInput "timetableForm.freeSpace" "" "text"/>
    <br>
    Description:<@spring.formInput "timetableForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>