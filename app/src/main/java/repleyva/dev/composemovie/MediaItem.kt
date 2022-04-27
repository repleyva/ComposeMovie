package repleyva.dev.composemovie

data class MediaItem(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val type: Type
) {
    enum class Type { PHOTO, VIDEO }
}

fun getMedia() = (1..10).map {
    MediaItem(
        id = it,
        title ="Media Item $it",
        imageUrl = "https://placeimg.com/400/400/people/$it",
        type = if (it % 3 == 0) MediaItem.Type.PHOTO else MediaItem.Type.VIDEO
    )
}


