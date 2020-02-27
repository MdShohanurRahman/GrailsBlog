package com.myblog

import grails.web.servlet.mvc.GrailsParameterMap

import javax.servlet.http.HttpServletRequest


class PostService {

    AuthenticationService authenticationService

    def save(GrailsParameterMap params, HttpServletRequest request) {
        Post post = new Post(params)
        post.member = authenticationService.getMember()

        //save post_tag
        Post post_tag = new Post(params)
        post_tag.addToTag(new Tag())
        new Tag().addToPost(post_tag)
        post_tag.save()
        //end post_tag

        def response = AppUtil.saveResponse(false, post)
        if (post.validate()) {
            post.save(flush: true)
            if (!post.hasErrors()){
                response.isSuccess = true
                uploadImage(post, request)
            }
        }
        return response
    }

    def update(Post post, GrailsParameterMap params){
        post.properties = params
        Post post_tag = new Post(params)
        post_tag.addToTag(new Tag())
        new Tag().addToPost(post_tag)
        post_tag.save()
        def response = AppUtil.saveResponse(false, post)
        if (post.validate()) {
            post.save(flush: true)
            if (!post.hasErrors()){
                response.isSuccess = true
            }
        }

        return response
    }

    def getByid(Serializable id){
        return Post.get(id)
    }

    def list(GrailsParameterMap params){
        params.max = params.max?:GlobalConfig.itemsPerPage()
        List<Post> postList = Post.createCriteria().list(params) {
            if (params?.colName && params?.colValue){
                like(params.colName, "%" +  params.colValue + "%")
            }
            if (!params.sort){
                order("id","desc")
            }
            eq("member", authenticationService.getMember())
        }
        return [list: postList, count: postList.totalCount]
    }

    def getPostList(){
        return  Post.createCriteria().list {
            eq("member",authenticationService.getMember())
        }
    }

    def delete(Post post){
        try{
            post.delete(flush: true)
        }
        catch (Exception e){
            println(e.getMessage())
        }
        return true
    }

    def uploadImage(Post post, HttpServletRequest request){
        if (request.getFile("contactImage") && !request.getFile("contactImage").filename.equals("")){
            String image = FileUtil.uploadContactImage(post.id, request.getFile("contactImage"))
            if (!image.equals("")){
                post.image = image
                post.save(flush:true)
            }
        }
    }

}


