<#import "/spring.ftl" as spring/>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Create/Edith</title>

</head>

<body style="margin: 0; padding: 0; height: 100%; width: 100%; background: #08032b; color: white">

    <form name="timetable" action="" method="POST" style="width: 700px; height: 500px; line-height: 2; margin-left: 15px; margin-top: 8px">

        Time of going:<@spring.formInput "timetableForm.timeOfGoing" "" "text"/>
        <br>
        Date of going:<@spring.formInput "timetableForm.dateOfGoing" "" "text"/>
        <br>
        Time of come:<@spring.formInput "timetableForm.timeOfCome" "" "text"/>
        <br>
        Date of come:<@spring.formInput "timetableForm.dateOfCome" "" "text"/>
        <br>
        Number of route:<@spring.formSingleSelect "timetableForm.numberOfRoute", mavs, ""/>
        <br>
        Ticket price:<@spring.formInput "timetableForm.ticketPrice" "" "text"/>
        <br>
        Number of passengers:<@spring.formInput "timetableForm.numberOfPassager" "" "text"/>
        <br>
        Description:<@spring.formInput "timetableForm.descriction" "" "text"/>
        <br>

        <input type="submit" value="Next" style="width: 70px; height: 28px; background: #206b19"/>

    </form>

</body>

</html>