import javax.swing.*;

public class Main {

    // Método para Adivinar Número
    public static int adivinar(int plata) {
        int guess, numero, cont = 0, min = 0, max = 100;
        numero = (int) (Math.random() * 101);
        do {
            guess = Integer.parseInt(JOptionPane.showInputDialog("El número está entre " + min + " y " + max));
            cont++;
            if (guess == numero) {
                JOptionPane.showMessageDialog(null, "Felicidades, el número era: " + numero + " y usted adivinó en " + cont + " intentos");
            } else {
                if (guess < numero) {
                    min = guess;
                } else {
                    max = guess;
                }
            }
        } while (guess != numero);
        switch (cont) {
            case 1,2,3,4 -> plata += 25;
            case 5,6 -> plata += 10;
            case 7,8 -> plata += 5;
            case 9,10 -> plata += 0;
            default -> plata -= 10;
        }
        return plata;

    }

    // Método para Jugar Dados
    public static int dados(int plata) {
        int sumadados = 0, dado1, dado2, dado3, apuesta, ganancia = 0;
        boolean flag = true;
        apuesta = Integer.parseInt(JOptionPane.showInputDialog("Usted tiene $" + plata + "\n--------------\nIngrese su apuesta"));
        dado1 = (int) (Math.random() * 6) + 1;
        dado2 = (int) (Math.random() * 6) + 1;
        dado3 = (int) (Math.random() * 6) + 1;
        sumadados = dado1 + dado2 + dado3;
        switch (sumadados) {
            case 3, 18 -> ganancia = 3 * apuesta;
            case 6, 9, 12 -> ganancia = 2 * apuesta;
            default -> {
                flag = false;
                ganancia = apuesta;
            }
        }
        if (flag) {
            plata += ganancia;
            JOptionPane.showMessageDialog(null, "DADO 1 : " + dado1 + "\nDADO 2: " + dado2 + "\nDADO 3: " + dado3 + "\nTOTAL: " + sumadados + "\n------------\nUsted Gana " + ganancia);
        } else {
            plata -= ganancia;
            JOptionPane.showMessageDialog(null, "DADO 1 : " + dado1 + "\nDADO 2: " + dado2 + "\nDADO 3: " + dado3 + "\nTOTAL: " + sumadados + "\n------------\nUsted Pierde " + ganancia);
        }
        if (plata >0) {

        } else {
            JOptionPane.showMessageDialog(null, "Usted se quedó sin plata.\nGracias por jugar");

        }


        return plata;
    }

    //Método para jugar Piedra, Papel...
    public static int piedra(int plata) {
        int pc = 0, user = 0;
        String[] opcion = new String[] {"Piedra", "Papel","Tijera","Lagarto","Spock"};

        return plata;
    }
    public static void main(String[] args) {
        int plata = 100;
        String menu = "";
        String [] opciones = new String[]{"Adivinar Número", "Juego de Dados", "FIN"};
        do {
            menu = (String) JOptionPane.showInputDialog(null, "USted tiene $" + plata +"\nElija juego", "JUGUEMOS",
                    JOptionPane.INFORMATION_MESSAGE,null,
                    opciones,null  );
            switch (menu){
                case "Adivinar Número"-> plata = adivinar(plata);
                case "Juego de Dados" -> plata = dados(plata);
                case "FIN" -> JOptionPane.showMessageDialog(null,"Gracias por jugar!!!\nUsted tiene $" + plata);
            }

        } while (plata >0 && !(menu.equals("FIN")));




    }

}
