package com.example.Challenge_4.Controller;

import com.example.Challenge_4.Model.*;
import com.example.Challenge_4.Service.MerchantService;
import com.example.Challenge_4.Service.OrderService;
import com.example.Challenge_4.Service.ProductService;
import com.example.Challenge_4.Service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Component
@Slf4j
public class BinarController {
    public static Scanner scanner = new Scanner(System.in);

    private Logger log;
    @Autowired
    public ProductService productService;

    @Autowired
    public UsersService usersService;

    @Autowired
    public OrderService orderService;

    @Autowired
    public MerchantService merchantService;

    public void Menu() throws ParseException {
        log.info("Processing mainMenu() -- ini level info");
        System.out.println("Selamat Datang di BinarFud\n" +
                "Sebelum itu kamu harus daftar akunmu terlebih dahulu untuk bisa masuk ke BinarFud \n" +
                "Daftar Akun : \n" +
                "1. Merchant \n" +
                "2. Pengguna \n" +
                "0. Keluar");
        System.out.println("===>");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        switch(pilihan){
            case 1:
                this.AddNewUser();
                System.out.println("Akun kamu udah terdaftar");
                System.out.println("Pilih salah satu : ");
                System.out.println("1. Menu Selanjutnya");
                System.out.println("0. Keluar");
                int pilih = scanner.nextInt();
                if(pilih == 1){
                    System.out.println("1. Menambahkan menu makanan/minuman");
                    System.out.println("2. Mengupdate menu manakan/minuman");
                    System.out.println("0. Keluar");
                    int Pilihan = scanner.nextInt();
                    if(Pilihan == 1){
                        addFood();
                        System.out.println("Makanan/minuman berhasil di tambahkan");
                    }else if(Pilihan == 2){
                        updateFood();
                        System.out.println("Makanan/minuman berhasil di update");
                    }else if(pilihan == 0){
                        System.exit(0);
                    }else{
                        System.out.println("Pilihan kamu salah");
                    }
                }else if(pilihan == 0){
                    System.exit(0);
                }else{
                    System.out.println("Yang kamu masukan salah");

                }
                break;
            case 2:
                AddNewMerchant();
                System.out.println("Akun kamu udah terdaftar");
                System.out.println("Pilih salah satu : ");
                System.out.println("1. Menu Selanjutnya");
                System.out.println("2. Update User");
                System.out.println("3. Delete User");
                System.out.println("0. Keluar");
                System.out.println("===>");
                int pilihan1 = scanner.nextInt();
                if(pilihan1 == 1){
                    tampilMenu();
                }else if(pilihan1 == 2){
                    updateUser();
                    System.out.println("Berhasil di update");
                }else if(pilihan == 3){
                    deleteUser();
                    System.out.println("Akun kamu telah dihapus");

                }else if (pilihan1 == 0) {
                    System.exit(0);
                }else{
                    System.out.println("Yang kamu pilih salah");
                }
                break;
            default:
                System.out.println("Yang kamu masukan salah");
        }


    }

    public void AddNewUser() throws ParseException {
        System.out.println("Silahkan isi data berikut ini : ");
        System.out.println("Masukkan alamat email kamu : ");
        String EmailAddress = scanner.nextLine();
        System.out.println("Masukkan username kamu : ");
        String username = scanner.nextLine();
        System.out.println("Masukkan password kamu : ");
        String password = scanner.nextLine();

//        Users newUsers = Users.builder()
//                .EmailAddress(EmailAddress)
//                .username(username)
//                .password(password)
//                .build();
        //Users users = newUsers;
        // ini buildnya error kak jadi aku komen karena ngga bisa dibuat jar makasih
        System.out.println("Bisa menambahkan akun");
        this.Menu();
    }

    public void AddNewMerchant() throws ParseException{
        System.out.println("Silahkan isi data berikut ini : ");
        System.out.println("Masukkan nama toko kamu : ");
        String MerchantName = scanner.nextLine();
        System.out.println("Masukkan lokasi toko kamu : ");
        String MerchantLocation= scanner.nextLine();
//        Merchant newMerchant = Merchant.builder()
//                .MerchantName(MerchantName)
//                .MerchantLocation(MerchantLocation)
//                .build();
//        Merchant merchant = newMerchant;
        // ini buildnya error kak jadi aku komen karena ngga bisa dibuat jar makasih
        System.out.println("Bisa menambahkan akun");
        this.Menu();

    }

    public void addFood() throws ParseException{
        System.out.println("Silahkan isi data berikut ini : ");
        System.out.println("Masukkan nama makanan,minuman : ");
        String ProductName = scanner.nextLine();
        System.out.println("Masukkan harga makanan/minuman : ");
        Long Price = scanner.nextLong();

//        Product newProduct = Product.builder()
//                .ProductName(ProductName)
//                .Price(Price)
//                .builder();
//        Product product = newProduct;
        // ini buildnya error kak jadi aku komen karena ngga bisa dibuat jar makasih
        System.out.println("Bisa menambahkan produk yey!!!");
        this.Menu();
    }

    public void updateUser(){
        // TODO: do update
    }

    public void updateFood(){
        // TODO: do update
    }

    public void deleteUser(){
        // TODO : do delete users by UserId
    }


    public void tampilMenu(){
        System.out.println("=================================");
        System.out.println("Selamat datang di BinarFud");
        System.out.println("=================================");
        System.out.println();
        List<Product> product = productService.getAllProduct();
        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar Aplikasi");

        pilihMenu(); // Memanggil method pilihMenu
    }

    public void pilihMenu() { // Membuat method dengan nama pilihMenu tanpa parameter
        System.out.print("qrt => ");
        int userInput = scanner.nextInt(); // Sebuah inputan dari user

        if (userInput >= 1 && userInput <= 5) { // Pengecekan kondisi inputan dari user
           List<Order> order = orderService.getAllOrder(); // Mendapatkan object menu dari list berdasarkan inputan user

            System.out.println("\n\n\n================================");
            System.out.println("Berapa pesanan Anda");
            System.out.println("================================");
            System.out.println();

            System.out.println(order); // Menampilkan informasi menu
            System.out.println("\n(input 0 untuk kembali)");
            masukanJumlah(order); // Memanggil method masukanJumlah dengan parameter menu
        } else if (userInput == 99) {
            // Memproses pembayaran
            //pesanDanBayar();
        } else if (userInput == 0) {
            // Keluar dari aplikasi
            System.out.println("Terima kasih telah menggunakan BinarFud.\n");
            System.exit(0);
        } else {
            System.out.println("Pilihan tidak valid.\n");
            tampilMenu();
        }
    }

    public void masukanJumlah(List<Order> order) { // Membuat method dengan nama masukanJumlah dengan parameter menu
        System.out.print("Masukkan jumlah pesanan: ");
        int jumlah = scanner.nextInt(); // Inputan user
        System.out.print("\n\n");
        Optional<OrderDetail> orderDetails = Optional.empty();
        if (jumlah > 0) {
            OrderDetail orderDetail = new OrderDetail();
            Optional<OrderDetail> OrderDetail = Optional.of(orderDetail);
        }
        tampilMenu(); // Memanggil method tampilkanMenu
    }

    // Sorry kak udah stuck banget disini


}
