<#import "/spring.ftl" as spring/>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Title</title>

</head>

<body style="margin: 0; padding: 0; height: 100%; width: 100%; background: #08032b; color: white">

    <form name="brigade" action="" method="POST" style="width: 700px; height: 500px; line-height: 2; margin-left: 15px; margin-top: 8px">

        Mission:<@spring.formInput "brigadeForm.mission" "" "text"/>
        <br>
        Number of workers:<@spring.formInput "brigadeForm.numberOfWorkers" "" "text"/>
        <br>
        Department ID:<@spring.formSingleSelect "brigadeForm.departmentId", mavs, ""/>
        <br>
        Description:<@spring.formInput "brigadeForm.descriction" "" "text"/>
        <br>

        <input type="submit" value="Next" style="width: 70px; height: 28px; background: #206b19"/>

    </form>

</body>

</html>