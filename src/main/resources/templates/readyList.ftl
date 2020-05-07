<#import "/spring.ftl" as spring>
<h3>Ready List</h3>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-dark">
        <tr class="bg-success">
            <th>ID</th>
            <th>Train</th>
            <th>Review</th>
            <th>Clear</th>
            <th>Food</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list readies as ready>
            <tr class="bg-primary">
                <td>${ready.id}</td>
                <td>${ready.trainID}</td>
                <td>${ready.review}</td>
                <td>${ready.clear}</td>
                <td>${ready.food}</td>
                <td>${ready.descriction}</td>
                <td><a href="/web/ready/delete/${ready.id}"><button>Delete</button></a></td>
                <td><button>Edit</button></td>
            </tr>
        </#list>
    </table>
</div>