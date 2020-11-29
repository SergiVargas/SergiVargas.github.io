package Vargas.Sergio.objects;

public abstract class Product implements Cloneable {

    private String name;
    private int amount;
    private double price;


    public Product(){} //creo este constructor por defecto porque lo he sobrecargado el otro
                       //si no lo uso luego no lo va a entender el super, probarlo y a ver que pasa

    public Product(String n){

        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount <0){

            System.out.println("No se puede asignar una cantidad negativa");
            return; //mirar que es mejor un return aca que un else, ver que pasa
        }
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price<0){
            System.out.println("No puede tener un precio negativo");
            return;
        }
        this.price = price;
    }

    @Override
    public String toString(){
        return this.name + " - " + this.amount + " - " + this.price;
    }


    // creo un método para manejar el cloneable y poder cronar , me va a devolver un Produc con el clone

    public Product clone() throws CloneNotSupportedException{

        return (Product) super.clone();  //el super.clone devuelve un objeto (clonado) como tal, por eso pongo Product, es un casitn
                                          // porque el metodo me está devolviendo un Product, si no cambia el tipo que devuelve
    }
}
