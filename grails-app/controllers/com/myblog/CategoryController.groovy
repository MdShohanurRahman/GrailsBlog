package com.myblog

class CategoryController {

    CategoryService categoryService

    def index() {
//        def response = categoryService.getCategoryList()
        [categories: Category.list()]
    }

    def details(Integer id) {
        def response = categoryService.getByid(id)
        def  posts = Post.findAllWhere(category: Category.get(id))
        if (!response) {
            redirect(controller: "category", action: "index")
        } else {

            [category: response, allPosts:posts]
        }
    }



    def create() {
        [category: flash.redirectParams]
    }


    def save() {
        def response = categoryService.save(params)
        if (response.isSuccess) {
            flash.message = AppUtil.infoMessage(g.message(code: "saved"))
            redirect(controller: "category", action: "index")
        } else {
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.save"), false)
            redirect(controller: "category", action: "create")
        }
    }



    def edit(Integer id) {
        if (flash.redirectParams) {
            [category: flash.redirectParams]
        } else {
            def response = categoryService.getByid(id)
            if (!response) {
                flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
                redirect(controller: "category", action: "index")
            } else {
                [category: response]
            }
        }
    }

    def update() {
        def response = categoryService.getByid(params.id)
        if (!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "category", action: "index")
        } else {
            response = categoryService.update(response, params)
            if (!response.isSuccess) {
                flash.redirectParams = response.model
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
                redirect(controller: "category", action: "edit")
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "updated"))
                redirect(controller: "category", action: "index")
            }
        }
    }



    def delete(Integer id) {
        def response = categoryService.getByid(id)
        if (!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "category", action: "index")
        } else {
            response = categoryService.delete(response)
            if (!response) {
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.delete"), false)
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "deleted"))
            }
            redirect(controller: "category", action: "index")
        }
    }
}
