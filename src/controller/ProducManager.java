package controller;

import model.Product;
import storage.FileBinary;
import view.Client;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProducManager {
   public ArrayList<Product> productArrayList = new ArrayList<>();
   public void display() {
      for (Product x:
           productArrayList) {
         System.out.println(x.toString());
      }
   }
   public void addProduct(Product product) {
      productArrayList.add(product);
   }
   public void editProduct(int id, Product product) {
      productArrayList.set(id, product);
   }
   public void deleteProduct(int id) {
      productArrayList.remove(id);
   }
   public int checkId(String id) {
      int check = -1;
      for (int i = 0; i < productArrayList.size(); i++) {
         if (id.equalsIgnoreCase(productArrayList.get(i).getId())){
            check=i;
         }
      }return check;
   }
   public void sortByPrice(){
      productArrayList.sort(Comparator.comparingDouble(Product::getPrice));
   }

}
