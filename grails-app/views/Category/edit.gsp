%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card center">
    <div class="card-header">
        <g:message code="category.update"/>
    </div>
    <div class="card-body">
        <g:form controller="category" action="update">
            <g:hiddenField name="id" value="${category.id}"/>

            %{--Partial Templating--}%
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="update" value="${g.message(code: "update")}"/>
                <g:link controller="category" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>

