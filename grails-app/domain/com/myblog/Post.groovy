package com.myblog

class Post {
    Integer id
    String title
    String description
    String image
    Member member // foreign key
    Category category // foreign key

    Set<Tag> tag // postInstance.tag -> get all tags

    static hasMany = [tag: Tag]  // Post has many Tag (one to many)

    Date dateCreated
    Date lastUpdated


    static constraints = {
        description size: 2..15000
        image nullable: true, blank: true
        tag nullable: true, blank: true
        description widget: 'textarea'
    }

}
