<div class="form-group">
    <label><g:message code="Post.title"/> *</label>
    <g:textField name="title" class="form-control" value="${post?.title}" placeholder="Please Enter Post title"/>
    <UIHelper:renderErrorMessage fieldName="title" model="${post}" errorMessage="please.enter.post.title"/>
</div>


%{--<div class="form-group">--}%
    %{--<label><g:message code="post.description"/></label> <br>--}%
    %{--<div class="trix-content">--}%

    %{--</div>--}%
    %{--<g:textArea name="description" value="${post?.description}" rows="5" cols="80" placeholder="Post description" />--}%
%{--</div>--}%


<div class="form-group">
    <label><g:message code="image"/></label>
    <g:field name="contactImage" class="form-control" type="file" placeholder="Please Upload Image"/>
    <g:if test="${post?.image}">
        <img src="${resource(dir: "contact-image", file: "/${post.id}-${post.image}")}" class="img-thumbnail" style="margin-top: 10px; height: 100px; width: 100px;"/>
    </g:if>
</div>


<div class="form-group">
    <label for="content">Description</label>
    <input id="content" type="hidden" value="${post?.description}"  name="description">
    <trix-editor input="content"></trix-editor>
</div>



<div class="form-group">
    <div class="form-row">
        <div class="form-group col-md-6">
            <g:if test = "${category}">
                <label><g:message code="post.category"/></label> <br>
                <UIHelper:category value="${post?.category*.id}"/>
            </g:if>
        </div>
        <div class="form-group col-md-6 mt-1">
            <br>
            <g:link controller="category" action="create" class="btn  btn-success">Create Category</g:link>
        </div>
    </div>
</div>

<div class="form-group">
    <label>Select Tags</label>
    <UIHelper:tags value="${post?.tag*.id}"/>
</div>



%{--<div class="form-group">--}%
    %{--<g:if test = "${tag}">--}%
        %{--<label><g:message code="post.category"/></label> <br>--}%
        %{--<g:select name="tag" from="${tag}" value="${post?.tag*.id}"--}%
                  %{--optionKey="id" optionValue="name" noSelection="['':'Please Select...']"/>--}%
    %{--</g:if>--}%
    %{--<g:link controller="tag" action="create" class="btn btn-sm btn-success">Create Tag</g:link>--}%

%{--</div>--}%







