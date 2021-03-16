package daniel.ornelas.popcornfactory

import android.os.Parcel
import android.os.Parcelable

data class Pelicula(var titulo: String?, var image: Int, var header: Int, var sinopsis: String, var seats: ArrayList<Cliente>) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString().toString(),
            parcel.readArrayList(Cliente.javaClass.classLoader) as ArrayList<Cliente>){
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeInt(image)
        parcel.writeInt(header)
        parcel.writeString(sinopsis)
        parcel.writeTypedList(seats)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pelicula> {
        override fun createFromParcel(parcel: Parcel): Pelicula {
            return Pelicula(parcel)
        }

        override fun newArray(size: Int): Array<Pelicula?> {
            return arrayOfNulls(size)
        }
    }


}
