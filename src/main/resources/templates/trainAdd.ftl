<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="train" action="" method="POST">

    Model:<@spring.formInput "trainForm.model" "" "text"/>
    <br>
    Train brigade:<@spring.formSingleSelect "trainForm.trainBrigade", mavs, ""/>
    <br>
    Recovery brigade:<@spring.formSingleSelect "trainForm.recoveryBrigade", mavs, ""/>
    <br>
    Description:<@spring.formInput "trainForm.descriction" "" "text"/>
    <br>

    <input type="submit" value="Create"/>

</form>
</body>
</html>