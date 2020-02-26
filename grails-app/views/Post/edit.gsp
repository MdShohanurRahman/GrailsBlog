%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/trix/1.2.1/trix.css"  >
<script src="https://cdnjs.cloudflare.com/ajax/libs/trix/1.2.1/trix-core.js"></script>


<div class="card">
    <div class="card-header">
        Post Update
    <div class="card-body">
        <g:form controller="post" action="update">
            <g:hiddenField name="id" value="${post.id}"/>
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="update" value="${g.message(code: "update")}"/>
                <g:link controller="post" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>