<div class="form-group">
    <label> <g:message code="Name"/> </label>
    <g:textField name="name" class="form-control" value="${tag?.name}" placeholder = "Tag Name" />
    <UIHelper:renderErrorMessage fieldName="title" model="${tag}" errorMessage="please.enter.category.name"/>
</div>

