%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        Category Details
    </div>

    <div class="card-body">
        <g:if test="${category}">
            <h2>Category Name <span class="badge badge-dark text-capitalize"> ${category.name}</span></h2>
        </g:if>
    </div>
</div>

<div class="card mt-5">
    <div class="card-header">
        All Posts
    </div>
    <div class="row p-2">
        <g:each var="post" in="${allPosts}">
            <div class="col md-3 mb-3">
                <div class="card" style="width: 18rem;">
                    <g:img dir="images" file="blog.jpg" class="card-img-top"/>
                    <div class="card-body">
                        <h5 class="card-title">${post.title}</h5>
                        <small>${post.dateCreated}</small>

                        <p class="card-text text-truncate">${post.description}</p>
                        <g:link controller="post" action="details" id="${post.id}"  class="btn btn-primary">Read More...</g:link>
                    </div>
                </div>
            </div>
        </g:each>
    </div>
</div>

