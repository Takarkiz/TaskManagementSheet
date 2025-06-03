package org.khaki.projects

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform