package uk.co.cerihughes.mgm.common.viewmodel

import android.arch.lifecycle.ViewModel
import android.support.annotation.DrawableRes
import uk.co.cerihughes.mgm.common.R
import uk.co.cerihughes.mgm.common.model.Image

open class AlbumArtViewModel(private val images: List<Image>) : ViewModel() {

    @DrawableRes
    fun placeholderImage(): Int {
        return R.drawable.album1
    }

    fun coverArtURL(largestDimension: Int): String? {
        var candidate: String? = null
        for (image in images) {
            val size = image.size ?: 0
            if (size > largestDimension) {
                candidate = image.url
            } else {
                return candidate ?: image.url
            }
        }
        return candidate
    }
}