package com.myblog

import grails.web.servlet.mvc.GrailsParameterMap


class TagService {

    def save(GrailsParameterMap params){
        Tag tag = new Tag(params)
        def response = AppUtil.saveResponse(false,tag)
        if (tag.validate()){
            tag.save(flush:true)
            if (!tag.hasErrors()){
                response.isSuccess = true
            }
        }
        return response
    }

    def update(Tag tag, GrailsParameterMap params){
        tag.properties = params
        def response = AppUtil.saveResponse(false, tag)
        if (tag.validate()) {
            tag.save(flush: true)
            if (!tag.hasErrors()){
                response.isSuccess = true
            }
        }

        return response
    }

    def getByid(Serializable id){
        return Tag.get(id)
    }

    def list(GrailsParameterMap params){
        params.max = params.max?:GlobalConfig.itemsPerPage()
        Tag <Tag> tagList = Tag.createCriteria().list {params}
        if(params?.colName && params?.colValue){
            like(params.colName, "%" + params.colValue + "%")
        }
        if(params.sort()){
            order("id","desc")
        }
        return [list:tagList, count:tagList.totalCount]
    }



    def getTagList(){
        return Tag.list()
    }

    def delete(Tag tag){
        try{
            tag.delete(flush: true)
        }
        catch (Exception e){
            println(e.message)
        }
        return true
    }

}
