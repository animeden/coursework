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
    Number of route:<@spring.formInput "timetableForm.numberOfRoute" "" "text"/>
    <br>
    Ticket price:<@spring.formInput "timetableForm.ticketPrice" "" "text"/>
    <br>
    Ready ID:<@spring.formInput "timetableForm.readyID" "" "text"/>
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