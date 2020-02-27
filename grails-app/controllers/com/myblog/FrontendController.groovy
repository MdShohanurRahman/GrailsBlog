package com.myblog

class FrontendController {
    PostService postService

    def index() {
        def response = postService.list(params)
        [posts: response.list, total: response.count, all_post:Post.list()]
    }

    def details(Integer id) {
        def response = postService.getByid(id)
        if (!response) {
            redirect(controller: "frontend", action: "index")
        } else {
            [post: response]
        }
    }
}


