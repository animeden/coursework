<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form name="administration" action="" method="POST">

        Name:<@spring.formInput "administrationForm.name" "" "text"/>
        <br>
        Birth:<@spring.formInput "administration.birth" "" "text"/>
        <br>
        Phone:<@spring.formInput "administration.phoneNumber" "" "text"/>
        <br>
        Adress:<@spring.formInput "administration.adress" "" "text"/>
        <br>
        Description:<@spring.formInput "administration.descriction" "" "text"/>

        <input type="submit" value="Create"/>

    </form>
</body>
</html>