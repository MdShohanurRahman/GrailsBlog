%{--Include Main Layout--}%
<meta name="layout" content="main"/>
<style>

.center {
    margin: auto;
    width: 50%;
    padding: 10px;
}
</style>


<div class="card center mt-5">
    <div class="card-header">
        Tag Create
    </div>
    <div class="card-body">
        <g:form controller="tag" action="save">

            %{--Partial Templating--}%
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="save" value="${g.message(code: "save")}"/>
                <g:link controller="tag" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>