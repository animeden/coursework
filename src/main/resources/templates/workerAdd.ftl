<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="worker" action="" method="POST">

    Name:<@spring.formInput "workerForm.fullName" "" "text"/>
    <br>
    Birth:<@spring.formInput "workerForm.phone" "" "text"/>
    <br>
    Phone:<@spring.formInput "workerForm.adress" "" "text"/>
    <br>
    Adress:<@spring.formInput "workerForm.birth" "" "text"/>
    <br>
    Adress:<@spring.formInput "workerForm.subclass" "" "text"/>
    <br>
    Phone:<@spring.formInput "workerForm.brigateID" "" "text"/>
    <br>
    Adress:<@spring.formInput "workerForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>