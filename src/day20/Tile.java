package day20;

public class Tile {
    private int id;
    private boolean[][] pixels = new boolean[10][10];
    private boolean hFlipped = false;
    private boolean vFlipped = false;

    public Tile(int id, boolean[][] pixels, boolean hFlipped, boolean vFlipped) {
        this.id = id;
        this.pixels = pixels;
        this.hFlipped = hFlipped;
        this.vFlipped = vFlipped;
    }

    public int getId() {
        return id;
    }

    public boolean[][] getPixels() {
        return pixels;
    }

    public void setPixels(boolean[][] pixels) {
        this.pixels = pixels;
    }

    public boolean isHFlipped() {
        return hFlipped;
    }

    public boolean isVFlipped() {
        return vFlipped;
    }

    public void flipH() {
        boolean [][] copyOfPixels = pixels.clone();
        for (int i = 0; i < 10; i++) {
            copyOfPixels[i] = pixels[i].clone();
        }
        for (int i = 0; i < 10; i++) {
                pixels[i] = copyOfPixels[9-i];
        }
        hFlipped = !hFlipped;
    }

    public void flipV() {
        boolean [][] copyOfPixels = pixels.clone();
        for (int i = 0; i < 10; i++) {
            copyOfPixels[i] = pixels[i].clone();
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                pixels[i][j] = copyOfPixels[i][9-j];
            }
        }
        vFlipped = !vFlipped;
    }

    public void turn90DegClockwise() {
        boolean [][] copyOfPixels = pixels.clone();
        for (int i = 0; i < 10; i++) {
            copyOfPixels[i] = pixels[i].clone();
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                pixels[i][j] = copyOfPixels[9-j][i];
            }
        }
    }

    public void print() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (pixels[i][j] == true) System.out.print("#");
                else if (pixels[i][j] == false) System.out.print(".");
                else System.out.print("O");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean[] getRightBorder() {
        boolean[] border = new boolean[10];
        for (int i = 0; i < 10; i++) {
            border[i] = pixels[i][9];
        }
        return border;
    }

    public boolean[] getLeftBorder() {
        boolean[] border = new boolean[10];
        for (int i = 0; i < 10; i++) {
            border[i] = pixels[i][0];
        }
        return border;
    }

    public boolean[] getTopBorder() {
        return pixels[0];
    }

    public boolean[] getBottomBorder() {
        return pixels[9];
    }

    private void printBorder(boolean[] border) {
        for (int i = 0; i < 10; i++) {
            if (border[i] == true) System.out.print("#");
            else if (border[i] == false) System.out.print(".");
            else System.out.print("O");
        }
        System.out.println();
        System.out.println();
    }

    public void printRightBorder() {
        printBorder(getRightBorder());
    }

    public void printLeftBorder() {
        printBorder(getLeftBorder());
    }

    public void printTopBorder() {
        printBorder(getTopBorder());
    }

    public void printBottomBorder() {
        printBorder(getBottomBorder());
    }

}
