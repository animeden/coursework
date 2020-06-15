<#import "/spring.ftl" as spring/>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Title</title>

</head>

<body style="margin: 0; padding: 0; height: 100%; width: 100%; background: #08032b; color: white">

    <form name="train" action="" method="POST" style="width: 700px; height: 500px; line-height: 2; margin-left: 15px; margin-top: 8px">

        Model:<@spring.formInput "trainForm.model" "" "text"/>
        <br>
        Train brigade:<@spring.formSingleSelect "trainForm.trainBrigade", mavs, ""/>
        <br>
        Recovery brigade:<@spring.formSingleSelect "trainForm.recoveryBrigade", mavs, ""/>
        <br>
        Description:<@spring.formInput "trainForm.descriction" "" "text"/>
        <br>

        <input type="submit" value="Next" style="width: 70px; height: 28px; background: #206b19"/>

    </form>

</body>

</html>