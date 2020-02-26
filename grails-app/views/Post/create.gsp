%{--Include Main Layout--}%
<meta name="layout" content="main"/>


<div class="card center">
    <div class="card-header">
        <g:message code="post.create"/>
    </div>
    <div class="card-body">
        <g:form controller="post" action="save" enctype="multipart/form-data">
            %{--Partial Templating--}%
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="login" value="${g.message(code: "save")}"/>
                <g:link controller="post" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>

</div>



<script>hljs.initHighlightingOnLoad();</script>

%{--Externel Scripts--}%
<div id="css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/trix/1.0.0/trix.css">
    <link rel="stylesheet"
          href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.18.1/styles/default.min.css">
</div>

<div id="script">

    <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.18.1/highlight.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/trix/1.0.0/trix.js"></script>
</div>