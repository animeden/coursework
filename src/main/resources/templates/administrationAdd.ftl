<#import "/spring.ftl" as spring/>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Create/Edith</title>

</head>

<body style="margin: 0; padding: 0; height: 100%; width: 100%; background: #08032b; color: white">

    <form name="administration" action="" method="POST" style="width: 700px; height: 500px; line-height: 2; margin-left: 15px; margin-top: 8px">

        Full name:<@spring.formInput "administrationForm.name" "" "text"/>
        <br>
        Birth date(Day.Month.Year):<@spring.formInput "administrationForm.birth" "" "text"/>
        <br>
        Phone:<@spring.formInput "administrationForm.phoneNumber" "" "text"/>
        <br>
        Adress:<@spring.formInput "administrationForm.adress" "" "text"/>
        <br>
        Description:<@spring.formInput "administrationForm.descriction" "" "text"/>
        <br>

        <input type="submit" value="Next" style="width: 70px; height: 28px; background: #206b19"/>

    </form>

</body>

</html>