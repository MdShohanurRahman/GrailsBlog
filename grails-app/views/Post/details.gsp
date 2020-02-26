%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="member" args="['Details']"/>
    </div>
    <div class="card-body">
    <div class="row">
        <div class="col-md-6">
            <g:if test="${post}">
                <h1>Title </h1>
                ${post.title} <br>

                <h1>Description</h1>
                <%=post.description%><br>
                <h6>Category : ${post.category.name}</h6>
            </g:if>
        </div>
        <div class="col-md-6">
            <g:if test="${post.image}">
            <img src="${resource(dir: "contact-image", file: "/${post.id}-${post.image}")}" class="img-thumbnail w-50" />

            </g:if>
            <g:else>
            <g:img dir="images" file="blog.jpg" class="profile-img w-25"/>
            </g:else>
        </div>
    </div>

    </div>
</div>

