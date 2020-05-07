<#import "/spring.ftl" as spring>
<h3>Brigade List</h3>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-dark">
        <tr class="bg-success">
            <th>ID</th>
            <th>Mission</th>
            <th>Number of worker</th>
            <th>Department</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list brigades as brigade>
            <tr class="bg-primary">
                <td>${brigade.id}</td>
                <td>${brigade.mission}</td>
                <td>${brigade.numberOfWorkers}</td>
                <td>${brigade.departmentId}</td>
                <td>${brigade.descriction}</td>
                <td><a href="/web/brigade/delete/${brigade.id}"><button>Delete</button></a></td>
                <td><button>Edit</button></td>
            </tr>
        </#list>
    </table>
</div>