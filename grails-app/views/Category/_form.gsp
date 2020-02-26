<div class="form-group">
    <label> <g:message code="Name"/> </label>
    <g:textField name="name" class="form-control" value="${category?.name}" placeholder = "Category Name" />
    <UIHelper:renderErrorMessage fieldName="title" model="${category}" errorMessage="please.enter.category.name"/>
</div>

