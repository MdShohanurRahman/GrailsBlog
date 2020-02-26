package com.myblog

class Tag {

    Integer id
    String name

    static belongsTo = Post
    static hasMany = [post: Post]

    static constraints = {
        name nullable: false, unique: true, blank: false

    }

    static mapping = {
        version(false)
    }

}
