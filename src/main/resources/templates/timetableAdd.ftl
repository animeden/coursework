<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="timetable" action="" method="POST">

    Name:<@spring.formInput "timetableForm.timeOfGoing" "" "text"/>
    <br>
    Birth:<@spring.formInput "timetableForm.timeOfCome" "" "text"/>
    <br>
    Phone:<@spring.formInput "timetableForm.numberOfRoute" "" "text"/>
    <br>
    Adress:<@spring.formInput "timetableForm.ticketPrice" "" "text"/>
    <br>
    Adress:<@spring.formInput "timetableForm.readyID" "" "text"/>
    <br>
    Phone:<@spring.formInput "timetableForm.numberOfPassager" "" "text"/>
    <br>
    Adress:<@spring.formInput "timetableForm.freeSpace" "" "text"/>
    <br>
    Adress:<@spring.formInput "timetableForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>