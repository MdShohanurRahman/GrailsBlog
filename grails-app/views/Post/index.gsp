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
            <th scope="col">Post title</th>
            <th scope="col">Category</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>

        <g:each var="post" in="${posts}" status="counter">
            <tr>
                <th scope="row">${counter+1}</th>
                <th> <p>${post.title}</p></th>
                <th> <p>${post.category.name}</p></th>
                <th>
                    <div class="btn-group">
                        <g:link controller="post" action="details" class="btn btn-secondary" id="${post.id}"><i class="fas fa-eye"></i></g:link>
                        <g:link controller="post" action="edit" id="${post.id}" class="btn btn-success"><i class="fas fa-edit"></i></g:link>
                        <g:link controller="post" action="delete" id="${post.id}" class = "btn btn-danger delete-confirmation"><i class="fas fa-trash"></i> </g:link>
                    </div>
                </th>
            </tr>
        </g:each>

        </tbody>
    </table>
</div>
