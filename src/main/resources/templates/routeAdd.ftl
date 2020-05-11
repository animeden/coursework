<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="route" action="" method="POST">

    Start:<@spring.formInput "routeForm.start" "" "text"/>
    <br>
    End:<@spring.formInput "routeForm.end" "" "text"/>
    <br>
    Stations:<@spring.formInput "routeForm.stations" "" "text"/>
    <br>
    Type of route:<@spring.formInput "routeForm.typeOfRoute" "" "text"/>
    <br>
    Description:<@spring.formInput "routeForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>