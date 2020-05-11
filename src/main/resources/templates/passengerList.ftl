<#import "/spring.ftl" as spring>
<h3>Passenger List</h3>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-dark">
        <tr class="bg-success">
            <th>ID</th>
            <th>Status</th>
            <th>Route</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list passengers as passenger>
            <tr class="bg-primary">
                <td>${passenger.id}</td>
                <td>${passenger.status}</td>
                <td>${passenger.routeID}</td>
                <td>${passenger.descriction}</td>
                <td><a href="/web/passenger/delete/${passenger.id}"><button>Delete</button></a></td>
                <td><a href="/web/passenger/edit/${passenger.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>

    <a href="/web/passenger/create"><button>Create</button></a>

</div>