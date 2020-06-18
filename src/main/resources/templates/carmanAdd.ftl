<#import "/spring.ftl" as spring/>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Title</title>

</head>

<body style="margin: 0; padding: 0; height: 100%; width: 100%; background: #08032b; color: white">

<form name="carman" action="" method="POST" style="width: 700px; height: 500px; line-height: 2; margin-left: 15px; margin-top: 8px">

    Name:<@spring.formInput "carmanForm.fullName" "" "text"/>
    <br>
    Phone:<@spring.formInput "carmanForm.phone" "" "text"/>
    <br>
    Adress:<@spring.formInput "carmanForm.adress" "" "text"/>
    <br>
    Birth(Day.Month.Year):<@spring.formInput "carmanForm.birth" "" "text"/>
    <br>
    Subclass:<@spring.formInput "carmanForm.subclass" "" "text"/>
    <br>
    Brigade ID:<@spring.formSingleSelect "carmanForm.brigateID", mavs, ""/>
    <br>
    Experience:<@spring.formInput "carmanForm.driveExperience" "" "text"/>
    <br>
    Type of train:<@spring.formInput "carmanForm.typeOfTrains" "" "text"/>
    <br>
    Description:<@spring.formInput "carmanForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Next" style="width: 70px; height: 28px; background: #206b19"/>

</form>

</body>

</html>