<#import "/spring.ftl" as spring>

<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Freight train</title>

</head>

<div style="width: 100%; height: 100%; background: #08032b">

    <div style="width: 100%; height: max-content; background: #08032b">

        <div style="display: flex">

            <div style="width: 10%; height: 159px; position: fixed; display: flex; flex-direction: column; justify-content: space-around; align-items: flex-start">
                <div style="height: 35px; background: darkblue; width: 100px; display: flex; justify-content: center; align-items: center; border-top-right-radius: 20px; border-bottom-right-radius: 20px">
                    <a class="pt-1" href="http://localhost:1821" style="color: white; text-decoration: none; display: block; height: 100%; width: 100%">Main menu</a>
                </div>
                <div style="height: 35px; background: dodgerblue; width: 70px; display: flex; justify-content: center; align-items: center; border-top-right-radius: 20px; border-bottom-right-radius: 20px">
                    <a class="pl-2 pt-1" href="#src" style="color: black; text-decoration: none; display: block; height: 100%; width: 100%">Search</a>
                </div>
                <div style="height: 35px; background: deeppink; width: 70px; display: flex; justify-content: center; align-items: center; border-top-right-radius: 20px; border-bottom-right-radius: 20px" id="sr" onclick="fup()">
                    <a class="pl-3 pt-1" href="/web/ftrain/sort" style="color: black; text-decoration: none; display: block; height: 100%; width: 100%">Sort</a>
                </div>
                <div style="height: 35px; background: rebeccapurple; width: 70px; display: none; justify-content: center; align-items: center; border-top-right-radius: 20px; border-bottom-right-radius: 20px" id="nsr" onclick="fup()">
                    <a class="pl-2 pt-1" href="/web/ftrain/get/list" style="color: black; text-decoration: none; display: block; height: 100%; width: 100%">Unsort</a>
                </div>
                <div style="height: 35px; background: limegreen; width: 70px; display: flex; justify-content: center; align-items: center; border-top-right-radius: 20px; border-bottom-right-radius: 20px">
                    <a class="pl-2 pt-1" href="/web/ftrain/create" style="color: black; text-decoration: none; display: block; height: 100%; width: 100%">Create</a>
                </div>
            </div>

        </div>

        <a name="src"></a>
        <div class="mb-4 pt-3 text-center" style="width: 100%; color: white">
            <h1>FTrain List</h1>
        </div>

        <div>

            <fieldset class="text-center" style="color: white">

                <legend>Find train</legend>

                <form name="search" action="" method="POST">

                    Model:<br/><@spring.formInput "searchForm.string" "" "text"/>

                    <br/>

                    <input class="btn btn-primary mt-1" type="submit" value="Search"/>

                </form>

            </fieldset>

        </div>

        <div class="pt-4">

            <table border="3", bgcolor="#d10000", class="table table-dark">

                <tr style="background-color: #a81919">

                    <th>ID</th>
                    <th>Model</th>
                    <th>Train Brigade</th>
                    <th>Recovery Brigade</th>
                    <th>Year of manufacture</th>
                    <th>Load capasity</th>
                    <th>Description</th>
                    <th>Edit</th>
                    <th>Delete</th>

                </tr>

                <#list ftrains as ftrain>

                <tr style="background: white; color: black">

                    <td>${ftrain.id}</td>
                    <td>${ftrain.model}</td>
                    <td>${ftrain.trainBrigade.number + " " + ftrain.trainBrigade.mission}</td>
                    <td>${ftrain.recoveryBrigade.number + " " + ftrain.recoveryBrigade.mission}</td>
                    <td>${ftrain.yearOfManufacture}</td>
                    <td>${ftrain.loadCapasity}</td>
                    <td>${ftrain.descriction}</td>

                    <td><a href="/web/ftrain/edit/${ftrain.id}"><button class="btn" style="background: #def511">Edit</button></a></td>
                    <td><a href="/web/ftrain/delete/${ftrain.id}" style="color: white"><button class="btn" style="background: #d60202; color: white">Delete</button></a></td>

                </tr>

            </#list>

            </table>

        </div>

        <div style="width: 100%; height: 20px"></div>

    </div>

</div>

<script>

    window.onload = src();

    function src() {
        let f = window.location.href;
        if (f == "http://localhost:1821/web/ftrain/sort")
        {
            document.getElementById("sr").style.display = 'none';
            document.getElementById("nsr").style.display = 'flex';
        }
        if (f == "http://localhost:1821/web/ftrain/get/list")
        {
            document.getElementById("sr").style.display = 'flex';
            document.getElementById("nsr").style.display = 'none';
        }
    }

</script>