<#import "/spring.ftl" as spring>
<h3>Worker List</h3>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-dark">
        <tr class="bg-success">
            <th>ID</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Adress</th>
            <th>Birth</th>
            <th>Subclass</th>
            <th>Brigade</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list workers as worker>
            <tr class="bg-primary">
                <td>${worker.id}</td>
                <td>${worker.fullName}</td>
                <td>${worker.phone}</td>
                <td>${worker.adress}</td>
                <td>${worker.birth}</td>
                <td>${worker.subclass}</td>
                <td>${worker.brigateID}</td>
                <td>${worker.descriction}</td>
                <td><a href="/web/worker/delete/${worker.id}"><button>Delete</button></a></td>
                <td><button>Edit</button></td>
            </tr>
        </#list>
    </table>
</div>