//Sebuah Data Class yang digunakan untuk menampung object Menu Makanan
data class MenuMakan(
    val namaMenu: String,
    val harga: Int
)

//class MenuServices yang memiliki seuah atribute menuMakanan dari List MenuMakan
// yang di gunakan untuk menampilkan dan memilih menu
class MenuServices() {

    //    membuat list dari data class MenuMakan
    private val menuMakanan = listOf(
        MenuMakan("Ayam Bakar", 50000),
        MenuMakan("Ayam Goreng", 40000),
        MenuMakan("Ayam Geprek", 40000),
        MenuMakan("Kulit Ayam Crispy", 15000),
        MenuMakan("Sate Usus Ayam", 5000),
    )

    //    function untuk menampilkan list menu dari variabel listof MenuMakan yang dilakukan looping
    fun showMenu() {
        println("List Menu Makanan Restoran Toran :")
        menuMakanan.forEachIndexed { index, menu ->
            println("${index + 1}. ${menu.namaMenu} - Rp${menu.harga}")
        }
    }

    //    function untuk memilih menu makanan yang sudah ditampilkan dengan readln dan mengembalikan nilai data Class MenuMakan
    fun selectMenu(): MenuMakan? {
        println()
        print("Pilih Menu Makanan : ")
        val inputMenu = readlnOrNull()?.toIntOrNull()

//        pengecekan apakah inputan bernilai null, lebih dari 1 dan kurang dari size menumakanan
        return if (inputMenu != null && inputMenu >= 1 && inputMenu <= menuMakanan.size) {
//            jika true maka akan menampilkan menu yang dipilih dan mengembalikan data menu makan yang dipilih
            println("Kamu memilih menu $inputMenu")
            println("Nama Menu: ${menuMakanan[inputMenu - 1].namaMenu}")
            println("Harga: Rp${menuMakanan[inputMenu - 1].harga}")
            menuMakanan[inputMenu - 1]
        } else {
//            jika false maka akan mengembalikan nilai false
            null
        }
    }

}

//class OrderService yang memiliki seuah atribute menuMakanan yang telah dipilih
//digunakan untuk melakukan hal" yang berkaitan dengan order yaitu pembayaran dan pemilihan metode pengiriman.
class OrderServices(private val menuDipilih: MenuMakan) {

    //    function pembayaran yang mengembalikan nilai boolean dari inputan user
    fun pembayaran() {
        println()
        print("Masukan Pembayaran : ")
        val pembayaran = readlnOrNull()?.toIntOrNull()

//        pengecekan apakah inputan user tidak sama dengan null dan lebih dari harga menu yang dipilih
        if (pembayaran != null && pembayaran >= menuDipilih.harga) {
            println("Terima kasih, Anda berhasil memesan makanan")

        } else {
            println("Maaf, pembayaran Anda gagal!")

        }
    }


}

class PengirimanServices() {
    fun showMetodePengiriman() {
//        membuat sebuah list untuk metode pembayaran dan lakukan sebuah looping dengan foreach untuk menampilkannya
        val metode = listOf("Take Away", "Delivery")

        println()
        println("Metode Pengiriman Makanan :")
        metode.forEachIndexed { index, s ->
            println("${index + 1}. $s")
        }
    }

    fun processPengiriman() {
        print("Pilih metode pengiriman : ")

        val pengiriman = readlnOrNull()?.toIntOrNull()

        when (pengiriman) {
            1 -> {

//                melakukan looping pada titik dengan range yang telah ditentukan
//                dan setiap langkan akan berjalan selama 1 menit
                print("Makananmu sedang dimasak (5 detik) ")
                for (i in 1..5) {
                    print(".")
                    Thread.sleep(1000)
                }

                println()
                print("Makananmu sudah siap! Silahkan ambil di resto ya! (5 detik) ")
                for (i in 1..5) {
                    print(".")
                    Thread.sleep(1000)
                }

                println()
                print("Pesanan Selesai (3 detik) ")
                for (i in 1..3) {
                    print(".")
                    Thread.sleep(1000)
                }

            }

            2 -> {

//                hampir sama dengan diatas hanya saja untuk tulisan keterangan berbeda
                print("Makananmu sedang dimasak (5 detik) ")
                for (i in 1..5) {
                    print(".")
                    Thread.sleep(1000)
                }
                println()
                print("Makananmu sudah siap! Driver segera menuju tempatmu! (5 detik) ")
                for (i in 1..5) {
                    print(".")
                    Thread.sleep(1000)
                }
                println()
                print("Driver sampai! Pesanan Selesai (3 detik) ")
                for (i in 1..3) {
                    print(".")
                    Thread.sleep(1000)
                }
            }

            else -> {
//                jika user menginputkan selain 1 atau 2 maka akan menampikan keterangan berikut
                println("Metode Pengiriman yang dipilih salah!")
            }
        }
    }


}

fun main() {

    val menuService = MenuServices()
    menuService.showMenu()
    val menuDipilih = menuService.selectMenu()

//    pengecekan menuDipilih null atau tidak
    if (menuDipilih != null) {

        val orderServices = OrderServices(menuDipilih)
        orderServices.pembayaran()

        val pengirimanServices = PengirimanServices()
        pengirimanServices.showMetodePengiriman()
        pengirimanServices.processPengiriman()


    } else {
        println("Pilihan menu tidak valid!")
    }
}