%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        Category Lists
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Category Name</th>
            <th scope="col">Action</th>
        </tr>
        </thead>

        <tbody>

        <g:each var="category" in="${categories}" status="counter">
            <tr>
                <th scope="row">${counter+1}</th>
                <th> <p>${category.name}</p></th>
                <th>
                    <div class="btn-group">
                        <g:link controller="category" action="details" class="btn btn-secondary" id="${category.id}"><i class="fas fa-eye"></i></g:link>
                        <g:link controller="category" action="edit" id="${category.id}" class="btn btn-success"><i class="fas fa-edit"></i></g:link>
                        <g:link controller="category" action="delete" id="${category.id}" class = "btn btn-danger delete-confirmation"><i class="fas fa-trash"></i> </g:link>
                    </div>
                </th>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

