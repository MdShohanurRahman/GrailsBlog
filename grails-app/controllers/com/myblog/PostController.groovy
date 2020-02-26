package com.myblog

class PostController {

    PostService postService

    def index() {
        def response = postService.list(params)
        [posts: response.list, total: response.count, all_post:Post.list()]
    }

    def details(Integer id) {
        def response = postService.getByid(id)
        if (!response) {
            redirect(controller: "post", action: "index")
        } else {
            [post: response]
        }
    }

    def create() {
        [post: flash.redirectParams, category:Category.list(), tag:Tag.list()]
    }



    def save() {
        def response = postService.save(params, request)
        if (response.isSuccess) {
            flash.message = AppUtil.infoMessage(g.message(code: "saved"))
            redirect(controller: "post", action: "index")
        } else {
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.save"), false)
            redirect(controller: "post", action: "create")
        }
    }

    def edit(Integer id) {
        if (flash.redirectParams) {
            [post: flash.redirectParams]
        } else {
            def response = postService.getByid(id)
            if (!response) {
                flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
                redirect(controller: "post", action: "create")
            } else {
                [post: response, category: Category.list()]
            }
        }
    }

    def update() {
        def response = postService.getByid(params.id)
        if (!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "post", action: "index")
        } else {
            response = postService.update(response, params)
            if (!response.isSuccess) {
                flash.redirectParams = response.model
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
                redirect(controller: "post", action: "edit")
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "updated"))
                redirect(controller: "post", action: "index")
            }
        }
    }



    def delete(Integer id) {
        def response = postService.getByid(id)
        if (!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "contactGroup", action: "index")
        } else {
            response = postService.delete(response)
            if (!response) {
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.delete"), false)
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "deleted"))
            }
            redirect(controller: "post", action: "index")
        }
    }

}
