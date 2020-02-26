package com.myblog

import grails.web.servlet.mvc.GrailsParameterMap


class CategoryService {

    def save(GrailsParameterMap params){
        Category category = new Category(params)
        def response = AppUtil.saveResponse(false,category)
        if (category.validate()){
            category.save(flush:true)
            if (!category.hasErrors()){
                response.isSuccess = true
            }
        }
        return response
    }

    def update(Category category, GrailsParameterMap params){
        category.properties = params
        def response = AppUtil.saveResponse(false, category)
        if (category.validate()) {
            category.save(flush: true)
            if (!category.hasErrors()){
                response.isSuccess = true
            }
        }

        return response
    }

    def getByid(Serializable id){
        return Category.get(id)
    }

    def list(GrailsParameterMap params){
        params.max = params.max?:GlobalConfig.itemsPerPage()
        Category<Category> categoryList = Category.createCriteria().list(params) {
            if (params?.colName && params?.colValue){
                like(params.colName, "%" +  params.colValue + "%")
            }
            if (!params.sort){
                order("id","desc")
            }
        }
        return [list: categoryList, count: categoryList.totalCount]
    }

    def getCategoryList(){
        return  Category.list()
    }

    def delete(Category category){
        try{
            category.delete(flush: true)
        }
        catch (Exception e){
            println(e.getMessage())
        }
        return true
    }
}
