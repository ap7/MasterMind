package fr.ap7.mastermind.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album constructor(
    @Expose @SerializedName("albumId") val albumId: Int,
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("title") val title: String,
    @Expose @SerializedName("url") val url: String,
    @Expose @SerializedName("thumbnailUrl") val thumbnailUrl: String): Parcelable {

    init {
        println("Album object was created")
    }

    override fun toString(): String = "Album(albumId=$albumId, id=$id, title='$title', url='$url', thumbnailUrl='$thumbnailUrl')"

    override fun equals(other: Any?): Boolean = super.equals(other)

    override fun hashCode(): Int = super.hashCode()

    override fun describeContents(): Int  = 0

}
