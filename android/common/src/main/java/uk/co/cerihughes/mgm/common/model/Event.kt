package uk.co.cerihughes.mgm.common.model

import java.util.*

data class Event(val number: Int,
                 val location: Location?,
                 val date: Date?,
                 val playlist: Playlist?,
                 val classicAlbum: Album?,
                 val newAlbum: Album?)