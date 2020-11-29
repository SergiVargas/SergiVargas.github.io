package Vargas.Sergio.views;

import Vargas.Sergio.objects.Product;
import java.util.List;
import java.util.Scanner;

public class View {


    public static void showHeaderPrincipal(){

        asteriscoC();
        System.out.println("\t\t* BIENVENIDO A LA CAJA REGISTRADORA *");
        asteriscoC();
        System.out.println("\t\t\t 1.Comprar");
        System.out.println("\t\t\t 2.Vender");
        System.out.println("\t\t\t 3.Inventario");
        System.out.println("\t\t\t 4.Compras");
        System.out.println("\t\t\t 5.Ventas");
        System.out.println("\t\t\t 6.Salir");
        espacio();
    }

    public static void showGetOption() {

        System.out.print("\t\tDigite la Opción: ");


    }

    public static void showInvalidOption(){
        System.out.println("Opción no válida");
        espacio();
    }


    public static int getOption(){

        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    public static int getAmount(){

        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    public static double getPrice(){

        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    public static void showGetAmount(){

        System.out.print("\t\tDigite la cantidad: ");

    }

    public static void showGetPrice(){

        System.out.print("\t\tDigite el precio: ");

    }



    public static void showBuyHeader(){

        asteriscoC();
        System.out.println("\t\t*          MENÚ DE COMPRAS          *");
        asteriscoC();
        showItemsMenu();
    }


    public static void showSalesHeader(){

        asteriscoC();
        System.out.println("\t\t*          MENÚ DE VENTAS           *");
        asteriscoC();
        showItemsMenu();
    }


    public static void showGetBack(String name){

        System.out.println("\t\t\tSaliendo del módulo " + name);
        espacio();

    }

    public static void showAnyKey(){

        System.out.print("\t\tPresione una tecla para continuar ");

    }


    public static void showItemHeader(){

        System.out.println("\t\t------------------------------------------------------");
        System.out.println("\t\t* PRODUCTO\t| Cantidad\t | Vr Unitario\t |Vr Total\t *");
        System.out.println("\t\t------------------------------------------------------");

    }

    public static void showExitOption(){

        System.out.println("\t\tGRACIAS POR UTILIZAR NUESTRA APLICACIÓN");
        System.exit(0);
    }

    public static void asteriscoL(){

        System.out.println("\t\t******************************************************");

    }


    public static void asteriscoC(){

        System.out.println("\t\t*************************************");

    }


    public static void showStockHeader(){

        asteriscoL();
        System.out.println("\t\t*                 I N V E N T A R I O                *");
        asteriscoL();
        showItemHeader();

    }


    public static void showBuyListHeader(){

        asteriscoL();
        System.out.println("\t\t*                     C O M P R A S                  *");
        asteriscoL();
        showItemHeader();

    }


    public static void showSalesListHeader(){

        asteriscoL();
        System.out.println("\t\t*                      V E N T A S                   *");
        asteriscoL();
        showItemHeader();

    }

    public static void showItemsMenu(){

        System.out.println("\t\t\t 1.Papas");
        System.out.println("\t\t\t 2.Arroz");
        System.out.println("\t\t\t 3.Carne");
        System.out.println("\t\t\t 4.Volver");

    }

    public static void espacio(){

        System.out.println("");
    }

    public static void showInvaledAmount(){
        System.out.println("La cantidad no es válida");
    }

    public static void showItemStock(Product[] products){

        for(Product v : products){
            System.out.println("\t\t* " + v.getName()+ "\t\t\t| " + v.getAmount() + "\t\t\t| " + v.getPrice() + "" +
                    "\t\t\t| " + v.getAmount()*v.getPrice() + "\t\t*");

        }
        System.out.println("");


    }

    public static void showSales(List<Product> listado){

        for(Product v : listado){

            System.out.println("\t\t* " + v.getName()+ "\t\t\t| " + v.getAmount() + "\t\t\t| " + v.getPrice() + "" +
                    "\t\t\t| " + v.getAmount()*v.getPrice()*1.25 + "\t\t*");
        }
    }

    public static void showPurchases(List<Product> listado){

         for(Product v : listado){

             System.out.println("\t\t* " + v.getName()+ "\t\t\t| " + v.getAmount() + "\t\t\t| " + v.getPrice() + "" +
                     "\t\t\t| " + v.getAmount()*v.getPrice() + "\t\t*");

         }




    }




}
