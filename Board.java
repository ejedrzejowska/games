package pl.sda.java.basics;

import java.awt.*;

public class Board {
    private int points = 0;
    private int height;
    private int width;
    private int[][] matrix = new int[10][10];


    public Board(int height, int width){
        this.height = height;
        this.width = width;
        generateBoard(); // W przypadku typów prymitywnych, mają one zawsze domyślną wartość (dla int jest to 0),
        // więc nie musimy zerować tablicy przy inicjalizacji w tym wypadku.
        // Gdyby byłaby to tablica obiektów to jak najbardziej trzeba by ją najpierw zainicjalizować
    }

    public void generateBoard(){    // Jak najbardziej, bardzo przydatna metoda. Dzięki niej możemy resetować planszę przed kolejną grą.
        // Trzeba by jedynie dodać resetowanie punktacji jeżeli byśmy chcieli jej użyć w taki sposób
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                matrix[i][j] = 0;
            }
        }
    }

    public void createShip(Point p1, Point p2){
        int x1 = (int)p1.getX();    // Klasa Point posiada publiczne pola x i y, które są intami,
        int y1 = (int)p1.getY();
        int x2 = (int)p2.getX();
        int y2 = (int)p2.getY();    // zmieniając użycie getterów na bezpośrednie użycie tych zmiennych uprościłoby nieco logikę tej metody
        // W tym wypadku gettery nieco mogły zmylić :)
        if(y1 < height && y2 < height && y1 >= 0 && y2 >= 0 && x1 < width && x2 < width && x1 >= 0 && x2 >= 0){
            if(x1 == x2) {
                for(int i = y1; i <= y2; i++) {
                    if(matrix[x1][i] == 1) {
                        System.out.println("1. Invalid coordinate!");
                        return;
                    }
                    else {
                        matrix[x1][i] = 1;
                    }
                }
            } else if (y1 == y2){
                for(int i = x1; i <= x2; i++) {
                   if(matrix[i][y1] == 1) {
                       System.out.println("2. Invalid coordinate!");
                       return;
                   }
                   else{
                       matrix[i][y1] = 1;
                   }
                }
            } else {
                System.out.println("3. Invalid coordinate!");
            }
        } else {
            System.out.println("4. Invalid coordinate!");
        }
    }

    // Przy bardziej rozbudowanych warunkach logicznych warto jest wyodrębnić do osobnej metody. Np. tak jak poniżej.
    // Dzięki temu możemy nadać jej odpowiednią nazwę, która ułatwi czytanie kodu pozostałym programistą
    // (oraz sobie jak po dłuższym czasie zajrzymy jeszcze raz do naszego kodu :))
    private boolean inBoardBounds(int x1, int y1, int x2, int y2) {
        return y1 < height && y2 < height && y1 >= 0 && y2 >= 0 && x1 < width && x2 < width && x1 >= 0 && x2 >= 0;
    }

    public boolean shootShip(int x, int y){
        if(matrix[x][y] == 1){
            points += 1;
            matrix[x][y] = -1;
            System.out.println("trafiony");
            if(gameOver()) System.out.println("GAME OVER");;
            return true;
        } else {
            System.out.println("pudło");
            return false;
        }
    }
    // Aby nie sprawdzać za każdym razem wszystkich pól na planszy można by zliczać ile statków zostało dodanych do niej.
    // Przy zestrzeleniu zmniejszać ilość statków i jedynie sprawdzać czy ilość statków > 0

    public boolean gameOver(){
        boolean flag = true;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(matrix[i][j] == 1) {
                    flag = false;
                    return flag;
                    // Tak na prawdę nie potrzebujesz zmiennej lokalnej flag,
                    // możesz od razu zwrócić false w tym miejscu, a w ostatnim return true
                }
            }
        }
        return flag;
    }

    public int getPoints(){
        return points;
    }

}
