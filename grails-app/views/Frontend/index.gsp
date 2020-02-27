<meta name="layout" content="frontend"/>

<!-- Blog Post -->


<g:if test="${posts}">
    <g:each var="post" in ="${posts}">
        <div class="card mb-4">
            <g:if test="${post.image}">
                <img src="${resource(dir: "contact-image", file: "/${post.id}-${post.image}")}" class="card-img-top" />

            </g:if>
            <g:else>
                <g:img dir="images" file="blog.jpg" class="card-img-top"/>
            </g:else>
            <div class="card-body">
                <h2 class="card-title">${post.title}</h2>
                <p class="card-text text-truncate"><%=post.description%></p>
                <g:link controller="frontend" action="details" id="${post.id}" class="btn-btn-primary" >Read More...</g:link>

            </div>
            <div class="card-footer text-muted">
                Posted on ${post.dateCreated}
            </div>
        </div>
    </g:each>

    <!-- Pagination -->
    <ul class="pagination justify-content-center mb-4">
        <li class="page-item">
            <a class="page-link" href="#">← Older</a>
        </li>
        <li class="page-item disabled">
            <a class="page-link" href="#">Newer →</a>
        </li>
    </ul>
</g:if>
<g:else>
    <div class="alert alert-info">
        No post Available
    </div>
</g:else>


<!-- Blog Post -->