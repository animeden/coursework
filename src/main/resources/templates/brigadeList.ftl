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
                <td>${brigade.departmentId.name}</td>
                <td>${brigade.descriction}</td>
                <td><a href="/web/brigade/delete/${brigade.id}"><button>Delete</button></a></td>
                <td><a href="/web/brigade/edit/${brigade.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>

    <a href="/web/brigade/create"><button>Create</button></a>

    <div>

        <fieldset>

            <legend>Find brigade</legend>

            <form name="search" action="" method="POST">

                Mission:<@spring.formInput "searchForm.string" "" "text"/>

                <br>

                <input type="submit" value="Search"/>

            </form>

        </fieldset>

    </div>

</div>

<div>

    <a href="/web/brigade/sort"><button>Sort</button></a>

</div>