<#import "/spring.ftl" as spring/>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Title</title>

</head>

<body style="margin: 0; padding: 0; height: 100%; width: 100%; background: #08032b; color: white">

    <form name="worker" action="" method="POST" style="width: 700px; height: 500px; line-height: 2; margin-left: 15px; margin-top: 8px">

        Name:<@spring.formInput "workerForm.fullName" "" "text"/>
        <br>
        Phone:<@spring.formInput "workerForm.phone" "" "text"/>
        <br>
        Adress:<@spring.formInput "workerForm.adress" "" "text"/>
        <br>
        Birth(Day.Month.Year):<@spring.formInput "workerForm.birth" "" "text"/>
        <br>
        Subclass:<@spring.formInput "workerForm.subclass" "" "text"/>
        <br>
        Brigade ID:<@spring.formSingleSelect "workerForm.brigateID", mavs, ""/>
        <br>
        Experience:<@spring.formInput "workerForm.experience" "" "text"/>
        <br>
        Description:<@spring.formInput "workerForm.descriction" "" "text"/>
        <br>

        <input type="submit" value="Next" style="width: 70px; height: 28px; background: #206b19"/>

    </form>

</body>

</html>