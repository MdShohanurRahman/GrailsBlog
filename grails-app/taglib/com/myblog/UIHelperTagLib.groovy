package com.myblog


class UIHelperTagLib {

    static namespace = "UIHelper"

    AuthenticationService authenticationService
    CategoryService categoryService
    TagService tagService


    def renderErrorMessage = { attrs, body ->
        def model = attrs.model
        String fieldName = attrs.fieldName
        String errorMessage = attrs.errorMessage? g.message(code: attrs.errorMessage): g.message(code: "invalid.input")
        if (model && model.errors && model.errors.getFieldError(fieldName)){
            out << "<small class='form-text text-danger''><strong>${errorMessage}</strong></small>"
        }
    }


    def memberActionMenu = { attrs, body ->
        out << '<li class="nav-item dropdown show">'
        out << g.link(class:"nav-link dropdown-toggle", "data-toggle":"dropdown"){authenticationService.getMemberName()}
        out << '<div class="dropdown-menu">'
        out << g.link(controller: "authentication", action: "logout", class: "dropdown-item"){g.message(code:"logout")}
        out << "</div></li>"
    }

    def authenticatUser = { attrs, body ->
        if (authenticationService.isAuthenticated()){

            user = authenticationService.getMemberInfo()
            out<< {user.firstName}
        }else
            out<< {null}
    }



    def leftNavigation = { attrs, body ->
        List navigations = [
                [controller: "dashboard", action: "index", name: "dashboard"],

                [controller: "All Posts", action: "index", name: "post"],
        ]

        if(authenticationService.isAdministratorMember()){
            navigations.add([controller: "member", action: "index", name: "create.member"])
            navigations.add([controller: "category", action: "create", name: "create.category"])
            navigations.add([controller: "tag", action: "create", name: "create.tag"])
            navigations.add([controller: "post", action: "create", name: "create.post"])
        }

        navigations.each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }

    def category = { attrs, body ->
        String name = attrs.name ?: "category"
        out << g.select(class:"form-control", optionValue: "name", optionKey: "id", value: attrs.value, name: name, from: categoryService.getCategoryList())
    }

    def tags = { attrs, body ->
        String name = attrs.name ?: "tag"
        out << g.select(class:"form-control tags-selector", multiple: "multiple", optionValue: "name", optionKey: "id", value: attrs.value, name: name, from: tagService.getTagList())
    }



    def appBaseURL = { attrs, body ->
        out << AppUtil.baseURL();
    }

}
