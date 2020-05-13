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
    Adress:<@spring.formInput "departmentForm.adress" "" "text"/>
    <br>
    Administration ID:<@spring.formSingleSelect "departmentForm.administrationID", mavs, ""/>
    <br>
    Number of Brigade:<@spring.formInput "departmentForm.numberOfBrigates" "" "text"/>
    <br>
    Description:<@spring.formInput "departmentForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>