<#import "/spring.ftl" as spring>
<h3>Route List</h3>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-dark">
        <tr class="bg-success">
            <th>ID</th>
            <th>Start point</th>
            <th>End point</th>
            <th>Stations</th>
            <th>Type of route</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list routes as route>
            <tr class="bg-primary">
                <td>${route.id}</td>
                <td>${route.start}</td>
                <td>${route.end}</td>
                <td>${route.stations}</td>
                <td>${route.typeOfRoute}</td>
                <td>${route.descriction}</td>
                <td><a href="/web/route/delete/${route.id}"><button>Delete</button></a></td>
                <td><button>Edit</button></td>
            </tr>
        </#list>
    </table>
</div>