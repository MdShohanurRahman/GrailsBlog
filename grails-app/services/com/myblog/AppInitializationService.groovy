package com.myblog


class AppInitializationService {

    static initialize() {
        initMember()
        initCategory()
    }

    private static initMember() {
        if (Member.count() == 0) {
            Member member = new Member()
            member.firstName = "Shohanur"
            member.lastName = "Rahman"
            member.email = "shohan@gmail.com"
            member.password = "123456"
            member.memberType = GlobalConfig.USER_TYPE.ADMINISTRATOR
            member.save(flash: true)
        }
    }

    private static initCategory(){
        if(Category.count() == 0){
            Category category = new Category()
            category.id = 1
            category.name = "First_Category"
        }
    }
}
