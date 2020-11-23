import random


def generar():
    
    mayuscula = ["A", "B", "C", "D", "E", "F"]
    minuscula = ["a", "b", "c", "e", "f", "g"]
    simbolos = ["(", ")", "@", "|", "&" ,"$"]
    numeros = ["1","2","3","4","5","6"]

    caracteres = mayuscula + minuscula + simbolos + numeros

    password = []

    for i in range(20):
        caracter_aleatorio = random.choice(caracteres)
        password.append(caracter_aleatorio)


    password = "".join(password)

    return password



def run ():
    contrasena = generar()
    print("La nueva contraseña es: " + contrasena)






if __name__ == "__main__":

    run()

