<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="ready" action="" method="POST">

    Train ID:<@spring.formSingleSelect "readyForm.trainID", mavs, ""/>
    <br>
    Review:<@spring.formInput "readyForm.review" "" "text"/>
    <br>
    Clear:<@spring.formInput "readyForm.clear" "" "text"/>
    <br>
    Food:<@spring.formInput "readyForm.food" "" "text"/>
    <br>
    Description:<@spring.formInput "readyForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>