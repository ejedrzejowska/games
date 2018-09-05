package pl.sda.java.basics;

import java.awt.*;
import java.util.Scanner;

public class Ships {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Podaj wysokosc (max. 10): ");
        int height = input.nextInt();
        System.out.print("Podaj szerokosc (max. 10): ");
        int width = input.nextInt();

        Board board1 = new Board(height, width);
        Board board2 = new Board(height, width);

        board1.generateBoard(); // Ta metoda jest już wywołana w konstruktorze, więc nie trzeba jej już tutaj wywoływać.
        board2.generateBoard();

        board1.createShip(new Point(1, 1), new Point(1, 4));
        System.out.println("Podaj współrzędne początkowe x: ");
        int x1 = input.nextInt();
        System.out.println("Podaj współrzędne początkowe y: ");
        int y1 = input.nextInt();
        System.out.println("Podaj współrzędne końcowe x: ");
        int x2 = input.nextInt();
        System.out.println("Podaj współrzędne końcowe y: ");
        int y2 = input.nextInt();

        board1.createShip(new Point(x1, y1), new Point(x2, y2));

        //board2.createShip(new Point(1, 1), new Point(1, 4));
        board2.createShip(new Point(2, 1), new Point(2, 1));

        board1.shootShip(0,0);
        board2.shootShip(2, 1);

        System.out.println("Player1: " + board2.getPoints() + "; Player2: " + board1.getPoints());
    }
}
