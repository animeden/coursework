<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="department" action="" method="POST">

    Name:<@spring.formInput "departmentForm.name" "" "text"/>
    <br>
    Birth:<@spring.formInput "departmentForm.adress" "" "text"/>
    <br>
    Phone:<@spring.formInput "departmentForm.administrationID" "" "text"/>
    <br>
    Adress:<@spring.formInput "departmentForm.numberOfBrigates" "" "text"/>
    <br>
    Adress:<@spring.formInput "departmentForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>