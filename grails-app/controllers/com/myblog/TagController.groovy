package com.myblog

class TagController {

    TagService tagService

    def index() {
        [tags:Tag.list()]
    }

    def details(Integer id) {
        def response = tagService.getByid(id)
        def  posts = Post.findAllWhere(tag: Tag.get(id))
        if (!response) {
            redirect(controller: "tag", action: "index")
        } else {

            [tag: response, allPosts:posts]
        }
    }



    def create() {
        [tag: flash.redirectParams]
    }


    def save() {
        def response = tagService.save(params)
        if (response.isSuccess) {
            flash.message = AppUtil.infoMessage(g.message(code: "saved"))
            redirect(controller: "tag", action: "index")
        } else {
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.save"), false)
            redirect(controller: "tag", action: "create")
        }
    }

//    def FormSave() {
//        def tag = new Tag(params)
//        tag.save()
//        flash.message = AppUtil.infoMessage(g.message(code: "saved"))
//        redirect(controller: "tag", action: "index")
//    }





    def edit(Integer id) {
        if (flash.redirectParams) {
            [category: flash.redirectParams]
        } else {
            def response = tagService.getByid(id)
            if (!response) {
                flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
                redirect(controller: "tag", action: "index")
            } else {
                [tag: response]
            }
        }
    }

    def update() {
        def response = tagService.getByid(params.id)
        if (!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "tag", action: "index")
        } else {
            response = tagService.update(response, params)
            if (!response.isSuccess) {
                flash.redirectParams = response.model
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
                redirect(controller: "tag", action: "edit")
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "updated"))
                redirect(controller: "tag", action: "index")
            }
        }
    }



    def delete(Integer id) {
        def response = tagService.getByid(id)
        if (!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "tag", action: "index")
        } else {
            def tag = Tag.get(id)
            def posts = [] + tag.post?: []
            posts.each {Post post ->
                post.removeFromTag(tag)
            }
            response = tagService.delete(response)
            if (!response) {
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.delete"), false)
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "deleted"))
            }
            redirect(controller: "tag", action: "index")
        }
    }

}


