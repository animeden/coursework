<#import "/spring.ftl" as spring>
<h3>Administration List</h3>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-dark">
        <tr class="bg-success">
            <th>ID</th>
            <th>Name</th>
            <th>Birth</th>
            <th>Phone Number</th>
            <th>Adress</th>
            <th>Discription</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list administrations as administration>
            <tr class="bg-primary">
                <td>${administration.id}</td>
                <td>${administration.name}</td>
                <td>${administration.birth}</td>
                <td>${administration.phoneNumber}</td>
                <td>${administration.adress}</td>
                <td>${administration.descriction}</td>
                <td><a href="/web/administration/delete/${administration.id}"><button>Delete</button></a></td>
                <td><button>Edit</button></td>
            </tr>
        </#list>
    </table>
</div>