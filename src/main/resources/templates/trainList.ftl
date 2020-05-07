<#import "/spring.ftl" as spring>
<h3>Train List</h3>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-dark">
        <tr class="bg-success">
            <th>ID</th>
            <th>Model</th>
            <th>Train Brigade</th>
            <th>Recovery Brigade</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list trains as train>
            <tr class="bg-primary">
                <td>${train.id}</td>
                <td>${train.model}</td>
                <td>${train.trainBrigade}</td>
                <td>${train.recoveryBrigade}</td>
                <td>${train.descriction}</td>
                <td><a href="/web/train/delete/${train.id}"><button>Delete</button></a></td>
                <td><button>Edit</button></td>
            </tr>
        </#list>
    </table>
</div>