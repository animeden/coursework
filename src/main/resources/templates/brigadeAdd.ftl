<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="brigade" action="" method="POST">

    Mission:<@spring.formInput "brigadeForm.mission" "" "text"/>
    <br>
    Number of workers:<@spring.formInput "brigadeForm.numberOfWorkers" "" "text"/>
    <br>
    Department ID:<@spring.formSingleSelect "brigadeForm.departmentId", mavs, ""/>
    <br>
    Description:<@spring.formInput "brigadeForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>