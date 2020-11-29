package Vargas.Sergio.controllers;

import Vargas.Sergio.objects.Meat;
import Vargas.Sergio.objects.Potato;
import Vargas.Sergio.objects.Product;
import Vargas.Sergio.objects.Rice;
import Vargas.Sergio.storage.Database;
import Vargas.Sergio.views.View;
import java.util.List;

public class Register {


    private Database database;

    public Register(){  //
        database = new Database();
    }

    //este método inicia la registradora
    public void register() {

        int option;
        do {
            View.showHeaderPrincipal();
            View.showGetOption();
            option = View.getOption();
            switch (option) {

                case 1:
                    buy();
                    break;
                case 2:
                    sales();
                    break;
                case 3:
                     showStock();
                     break;
                case 4:
                    showPurchases();
                    break;
                case 5:
                    showSales();
                    break;
                case 6:
                    View.showExitOption();
                default:
                    View.showInvalidOption();

            }
        } while (option >= 1 && option <= 6);

    }


    //mostrará el menú de compras y captura la opción del usuario
       private void buy() {
            View.showBuyHeader();
            int option;
            do{

                View.showGetOption();
                option = View.getOption();
                if(option >=1 && option <=3){
                    buyProduct(option);
                }else if(option == 4){
                     View.showGetBack("Compras");
                     return;
                }else{
                    View.showInvalidOption();
                }

            }while(option < 1 || option > 4);
        }



        //registra en la base de datos el productor comprado
        private void buyProduct(int option){

              Product product = null;
              switch (option){
                  case 1:
                      product = new Potato("Agria");
                      break;
                  case 2 :
                      product = new Rice("Sos");
                      break;
                  case 3:
                      product = new Meat("Lomo");
                      break;
                  default:
                      View.showInvalidOption();
              }
              View.showGetAmount();
              int amount = View.getAmount();
              View.showGetPrice();
              double price = View.getPrice();
              product.setAmount(amount);
              product.setPrice(price);
              database.buy(product);
        }

        private void showStock(){

             View.showStockHeader();
             View.showItemStock(database.getAll());
             View.showAnyKey();
             View.getOption();

        }

    private void sales() {
        View.showSalesHeader();
        int option;
        do{

            View.showGetOption();
            option = View.getOption();
            if(option >=1 && option <=3){
                saleProduct(option);
            }else if(option == 4){
                View.showGetBack("Ventas");
                return;
            }else{
                View.showInvalidOption();
            }

        }while(option < 1 || option > 4);
    }

    private void saleProduct(int option){

        Product product = null;
        if(option<1 || option>3){
            View.showInvalidOption();
            return;
        }

        product = database.getByIndex(option-1);
        View.showGetAmount();
        int amount = View.getAmount();
        if(product.getAmount() <  amount){
            View.showInvaledAmount();
            return;
        }

        product.setAmount(amount);
        database.sales(product);
    }

    private void showPurchases(){
        List<Product> listado = database.getPurchases();
        View.showBuyListHeader();
        View.showPurchases(listado);

    }

    private void showSales(){
        List<Product> listado = database.getSales();
        View.showSalesListHeader();
        View.showSales(listado);


    }




}
