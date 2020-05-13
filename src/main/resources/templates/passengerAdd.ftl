<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="passenger" action="" method="POST">

    Status:<@spring.formInput "passengerForm.status" "" "text"/>
    <br>
    Route ID:<@spring.formSingleSelect "passengerForm.routeID", mavs, ""/>
    <br>
    Description:<@spring.formInput "passengerForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>