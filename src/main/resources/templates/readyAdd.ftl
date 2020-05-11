<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="ready" action="" method="POST">

    Name:<@spring.formInput "readyForm.trainID" "" "text"/>
    <br>
    Birth:<@spring.formInput "readyForm.review" "" "text"/>
    <br>
    Phone:<@spring.formInput "readyForm.clear" "" "text"/>
    <br>
    Adress:<@spring.formInput "readyForm.food" "" "text"/>
    <br>
    Adress:<@spring.formInput "readyForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>