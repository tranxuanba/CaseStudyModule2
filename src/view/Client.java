package view;

import controller.ProducManager;
import model.Product;
import storage.FileBinary;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
   static ProducManager producManager = new ProducManager();
   static FileBinary fileBinary = new FileBinary();
    static ArrayList<Product> products = new ArrayList<>();




    public static void main(String[] args) {
        Product product = new Product("1", "batran", 123.4, 12, "ba dep trai");
        Product product1 = new Product("2", "batran", 123.4, 12, "ba dep trai");
        Product product2 = new Product("3", "batran", 123.4, 12, "ba dep trai");
        producManager.productArrayList.add(product1);
        producManager.productArrayList.add(product);
        producManager.productArrayList.add(product2);
        Client client = new Client();
        client.menuProduct();
    }

    public static void menuProduct() {
        try {
            do {
                System.out.println("menu quan ly san pham");
                System.out.println("1: Xem danh sach");
                System.out.println("2: them moi san pham");
                System.out.println("3: cap nhat san pham");
                System.out.println("4: xoa san pham");
                System.out.println("5: sap xep san pham");
                System.out.println("6: tim san pham co gia dat nhat");
                System.out.println("7: ghi file");
                System.out.println("8: doc file");
                System.out.println("0: thoat");
                System.out.println("--------");
                System.out.println("moi ban nhap lua chon");
                Scanner scanner = new Scanner(System.in);
                Scanner scanner1 = new Scanner(System.in);
                int check = scanner1.nextInt();
                switch (check) {
                    case 1:
                        producManager.display();
                        break;
                    case 2:
                        try {
                            System.out.println("moi nhap id");
                            String id = scanner.nextLine();
                            System.out.println("moi nhap vao ten san pham");
                            String name = scanner.nextLine();
                            System.out.println("moi nhap vao gia san pham");
                            double price = scanner1.nextDouble();
                            System.out.println("moi nhap vao so luong san pham ");
                            int amount = scanner1.nextInt();
                            System.out.println("moi nhap vao mo ta san pham");
                            String describe = scanner.nextLine();
                            Product product = new Product(id, name, price, amount, describe);
                            producManager.addProduct(product);
                        }catch (InputMismatchException e) {
                            System.out.println("sai kieu du lieu");
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("moi ban nhap id");
                            String id = scanner.nextLine();
                            int check1 = producManager.checkId(id);
                            if (check1 == -1) {
                                System.out.println("khong co san pham can sua trong danh sach");
                            }else {
                                System.out.println("moi nhap id");
                                String newId = scanner.nextLine();
                                System.out.println("moi nhap vao ten san pham");
                                String newName = scanner.nextLine();
                                System.out.println("moi nhap vao gia san pham");
                                double newPrice = scanner1.nextDouble();
                                System.out.println("moi nhap vao so luong san pham ");
                                int newAmount = scanner1.nextInt();
                                System.out.println("moi nhap vao mo ta san pham");
                                String newDescribe = scanner.nextLine();
                                Product product = new Product(newId, newName, newPrice, newAmount, newDescribe);
                                producManager.editProduct(check1, product);
                            }
                        }catch (InputMismatchException e) {
                            System.out.println("ban nhap sai du lieu");
                        }
                        break;
                    case 4:
                        try {
                            System.out.print("Mời bạn nhập ID: ");
                            String id = scanner.nextLine();
                            int check2 = producManager.checkId(id);
                            if (check2 == -1) {
                                System.out.println("Không có sản phẩm theo ID");
                            } else {
                                producManager.deleteProduct(check2);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Bạn đã nhập sai dữ liệu");
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("1. Sắp xếp");
                            System.out.println("2. Hiển thị danh sách đã sắp xếp");
                            System.out.println("3. Trở về menu chính");
                            int case5 = scanner.nextInt();
                            switch (case5){
                                case 1:
                                    producManager.sortByPrice();
                                    break;
                                case 2:
                                    producManager.display();
                                    break;
                                case 3:
                                    menuProduct();
                                    break;
                            }
                }catch (InputMismatchException e){
                            System.out.println("ban da nhap sai du lieu");
                        }
                        break;
                    case 6:
                        producManager.sortByPrice();
                        ArrayList<Product> products = producManager.productArrayList;
                        System.out.println(products.get(products.size()-1));
                        break;
                    case 7:
                        fileBinary.writerFile(producManager.productArrayList, "produc.dat");
                        break;
                    case 8:
                        producManager.productArrayList = fileBinary.readFile("produc.dat");
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("lua chon khong ton tai, moi ban nhap lai");
                        break;
            }
        }while (true);
    }catch (Exception e) {
            System.out.println("ban nhap sai duc lieu");
            System.out.println("-----------");
            menuProduct();
        }
}
}
