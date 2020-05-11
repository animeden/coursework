<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="train" action="" method="POST">

    Name:<@spring.formInput "trainForm.model" "" "text"/>
    <br>
    Birth:<@spring.formInput "trainForm.trainBrigade" "" "text"/>
    <br>
    Phone:<@spring.formInput "trainForm.recoveryBrigade" "" "text"/>
    <br>
    Adress:<@spring.formInput "trainForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>