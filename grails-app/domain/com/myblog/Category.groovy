package com.myblog

class Category {
    Integer id
    String name

    static hasMany = [post:Post]

    static constraints = {
        name nullable: false, unique: true, blank: false
    }

    static mapping = {
        version(false)
        // if category delete all post of this member will delete
        post(cascade: 'all-delete-orphan')
    }
}
