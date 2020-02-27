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

            </g:if>

            <div class="category">
                <h4>Category : ${post.category.name}</h4>
            </div>

            <div class="tags">
                <h4>Post Tags :</h4>
                <g:if test = "${post.tag}">
                    <g:each var = "t" in ="${post.tag}">
                        <span class="badge badge-dark"> ${t.name}</span>
                    </g:each>

                </g:if>

            </div>
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

