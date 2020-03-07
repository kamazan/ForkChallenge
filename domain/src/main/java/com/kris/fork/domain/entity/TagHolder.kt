package com.kris.fork.domain.entity

data class TagHolder(val name: String, val tagsList: List<Tag>) {
    val tags: String
        get() = tagsList.joinToString(", ", transform = { tag -> tag.name })
}