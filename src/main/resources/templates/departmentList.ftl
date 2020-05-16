<#import "/spring.ftl" as spring>
<h3>Department List</h3>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<div>
    <table border="3", bgcolor="f0f8ff", class="table table-dark">
        <tr class="bg-success">
            <th>ID</th>
            <th>Name</th>
            <th>Adress</th>
            <th>Administration</th>
            <th>Number of Brigades</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list departments as department>
            <tr class="bg-primary">
                <td>${department.id}</td>
                <td>${department.name}</td>
                <td>${department.adress}</td>
                <td>${department.administrationID}</td>
                <td>${department.numberOfBrigates}</td>
                <td>${department.descriction}</td>
                <td><a href="/web/department/delete/${department.id}"><button>Delete</button></a></td>
                <td><a href="/web/department/edit/${department.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>

    <a href="/web/department/create"><button>Create</button></a>

    <div>

        <fieldset>

            <legend>Find department</legend>

            <form name="search" action="" method="POST">

                Name:<@spring.formInput "searchForm.string" "" "text"/>

                <br>

                <input type="submit" value="Search"/>

            </form>

        </fieldset>

    </div>

</div>