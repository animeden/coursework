<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="route" action="" method="POST">

    Name:<@spring.formInput "routeForm.start" "" "text"/>
    <br>
    Birth:<@spring.formInput "routeForm.end" "" "text"/>
    <br>
    Phone:<@spring.formInput "routeForm.stations" "" "text"/>
    <br>
    Adress:<@spring.formInput "routeForm.typeOfRoute" "" "text"/>
    <br>
    Adress:<@spring.formInput "routeForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>