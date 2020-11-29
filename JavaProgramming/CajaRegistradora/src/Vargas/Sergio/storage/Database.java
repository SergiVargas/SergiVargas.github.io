package Vargas.Sergio.storage;

import Vargas.Sergio.objects.Meat;
import Vargas.Sergio.objects.Potato;
import Vargas.Sergio.objects.Product;
import Vargas.Sergio.objects.Rice;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private Product[] products; //al crear la clase abstracta puedo tener un array de productos
                                 // si creo una clase para cada producto no podria hacer el array

    private List<Product> purchases; //creo una lista porque es más flexible que el array, este es estático,
    private List<Product> sales; //estas listas almacenan objetos del tipo Product



    //Constructor
    public Database(){ //al crear la DB creo una instancia de esos productos

        products = new Product[3]; //al usar el constructor instanciamos una clase del producto
                                   //observar que es como si "product" fuera edad y new produc un int (estoy
                                   // haciendo una instancias de un dato y tipo de dato que es un array de mis objetos
        Product potato = new Potato("Agria");
        Product rice = new Rice("Sos");
        Product meat = new Meat("Lomo");

        //ya tengo creado el array y los productos (tengo los objetos y el array de ellos)
        //con el paso siguiente cuando haga una instancia de la base de datos, a parte de crearme
        //el array y los productos me los va a meter dentro

        products[0] = potato;
        products[1] = rice;
        products[2]= meat;

        purchases = new ArrayList<>(); //las listas hay que inicializaras omo arrayList
        sales = new ArrayList<>();

    }

    public Product getByIndex(int i) {  //metodo que devuelve un objeto del tipo Product referenciado por un índice

        if (i < 0 || i > 2) {
            System.out.println("Índice no válido!");
            return null;  //vuelvo a poner return para no poner else, es mas eficiente
        }
        Product result = null;   //estoy capturando la excepcion que necesita clone para funcionar
        try {
            result = products[i].clone();  //retorna el producto de ese índice clonado

        } catch (CloneNotSupportedException cnse) {

            System.out.println(cnse);
        }

        return result;

    }





    public Product[] getAll() {   //igual devuelve objeto del tipo Produc pero esta vez como array

        Product[] result = new Product[3];

        try {
            result[0] = products[0].clone();
            result[1] = products[1].clone();
            result[2] = products[2].clone();
        } catch (CloneNotSupportedException cnse) {

            System.out.println(cnse);
        }
        return result;
    }


    public void buy(Product product){

        Product temp;  //variable de tipo Product para saber lo que hay en el array y poder cambiarlo
        switch (product.getClass().getSimpleName()){ //este método dentro del switch me trae el nombre de la clase de
                                                      //producto para pasarlo al switch

            case "Potato":
                temp = products[0];
                break;

            case "Rice":
                temp = products[1];
                break;

            case "Meat":
                temp = products[2];
                break;

            default:
                System.out.println("No válido");
                return; //me saca de la compra (del switch)

        }

        temp.setAmount(temp.getAmount() + product.getAmount());  //a tempo le mando lo que tenía antes (getAmo) mas
                                                                  //lo que estoy comprando prodo.getAmon
        temp.setPrice(product.getPrice());
        purchases.add(product); //le meto al array list el producto, como en Python


    }


    public void sales(Product product){

        Product temp;  //variable de tipo Product para saber lo que hay en el array y poder cambiarlo
        switch (product.getClass().getSimpleName()){ //este método dentro del switch me trae el nombre de la clase de
            //producto para pasarlo al switch

            case "Potato":
                temp = products[0];
                break;

            case "Rice":
                temp = products[1];
                break;

            case "Meat":
                temp = products[2];
                break;

            default:
                System.out.println("No válido");
                return; //me saca de la compra (del switch)

        }

        temp.setAmount(temp.getAmount() - product.getAmount());  //a tempo le mando lo que tenía antes (getAmo) mas
        //lo que estoy comprando prodo.getAmon
        product.setPrice(temp.getPrice()* 1.25);  //es la ganancia, aumento el precio en 25 pro ciento
        sales.add(product); //le meto al array list el producto, como en Python


    }

    public List<Product> getPurchases(){

        return purchases;
    }

    public List<Product> getSales(){

        return sales;
    }
}
