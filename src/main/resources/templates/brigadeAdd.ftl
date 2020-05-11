<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="brigade" action="" method="POST">

    Name:<@spring.formInput "brigadeForm.mission" "" "text"/>
    <br>
    Birth:<@spring.formInput "brigadeForm.numberOfWorkers" "" "text"/>
    <br>
    Phone:<@spring.formInput "brigadeForm.departmentId" "" "text"/>
    <br>
    Adress:<@spring.formInput "brigadeForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>