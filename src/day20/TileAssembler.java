package day20;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TileAssembler {
    private String pathString = "src/day20/input.txt";
    private FileReader fileReader = new FileReader();

    public List<Tile> read() {
        List<Tile> tiles = new ArrayList<>();
        List<String> lines = fileReader.read(pathString);
        int size = lines.size();
        for (int i = 0; i < size; i++) {
            if (lines.get(i).startsWith("Tile")) {
                String idString = List.of(lines.get(i).split(" ")).get(1).replace(":", "");
                int id = Integer.parseInt(idString);
                boolean[][] pixels = new boolean[10][10];
                for (int j = 1; j <= 10; j++) {
                    Boolean[] booleans = Arrays.stream(lines.get(i + j).split(""))
                            .map(e -> {
                                if (e.equals("#")) return Boolean.TRUE;
                                else return Boolean.FALSE;
                            })
                            .toArray(Boolean[]::new);
                    boolean[] line = new boolean[10];
                    for (int k = 0; k < 10; k++) {
                        line[k] = booleans[k].booleanValue();
                    }
                    pixels[j - 1] = line;
                }
                tiles.add(new Tile(id, pixels, false, false));

            } else continue;
        }
        return tiles;
    }


    public boolean[][] getCompositeImage(List<List<Tile>> image) {
        int numberOfRows = image.size();
        int sizeOfSinglePicture = image.get(0).get(0).getPixels().length;
        int length = numberOfRows * sizeOfSinglePicture;
        boolean[][] compositeImage = new boolean[length][length];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfRows; j++) {
                boolean[][] pixels = image.get(i).get(j).getPixels();
                for (int k = 0; k < sizeOfSinglePicture; k++) {
                    for (int l = 0; l < sizeOfSinglePicture; l++) {
                        compositeImage[i * sizeOfSinglePicture + k][j * sizeOfSinglePicture + l] = pixels[k][l];
                    }
                }
            }
        }
        return compositeImage;
    }


    public void printCompositeImage(boolean[][] compositeImage) {
        int length = compositeImage.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (compositeImage[i][j]) {
                    System.out.print("#");
                } else System.out.print(".");
            }
            System.out.println();
        }
        System.out.println();
    }


    public boolean[][] turn90DegClockwise(boolean[][] pixels) {
        int length = pixels.length;
        boolean[][] copyOfPixels = pixels.clone();
        for (int i = 0; i < length; i++) {
            copyOfPixels[i] = pixels[i].clone();
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                pixels[i][j] = copyOfPixels[length - 1 - j][i];
            }
        }
        return pixels;
    }


    public boolean[][] flipH(boolean[][] pixels) {
        int length = pixels.length;
        boolean[][] copyOfPixels = pixels.clone();
        for (int i = 0; i < length; i++) {
            copyOfPixels[i] = pixels[i].clone();
        }
        for (int i = 0; i < length; i++) {
            pixels[i] = copyOfPixels[length - 1 - i];
        }
        return pixels;
    }


    public List<List<Tile>> assemble() {
        List<List<Tile>> image = new ArrayList<>();
        List<Tile> inputTiles = read();

        List<Tile> row0 = new ArrayList<>();
        Tile tile0 = inputTiles.get(8);
        inputTiles.remove(tile0);
        row0.add(tile0);

        boolean continueSearch = true;

        while (continueSearch) {
            boolean noTileMatches = true;
            for (Tile tile : inputTiles) {
                boolean foundMatchingRightTile = false;
                for (Integer orientation : List.of(1, 2, 3, 4, 5, 6, 7, 8)) {
                    if (orientation == 2) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 3) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 4) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 5) {
                        tile.turn90DegClockwise();
                        tile.flipH();
                    }
                    if (orientation == 6) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 7) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 8) {
                        tile.turn90DegClockwise();
                    }
                    if (Arrays.equals(tile0.getRightBorder(), tile.getLeftBorder())) {
                        foundMatchingRightTile = true;
                        break;
                    }
                }
                noTileMatches = !(foundMatchingRightTile && noTileMatches);
                if (foundMatchingRightTile) {
                    tile0 = tile;
                    inputTiles.remove(tile0);
                    row0.add(tile0);
                    break;
                }
            }
            continueSearch = !noTileMatches;
        }

        tile0 = row0.get(0);
        continueSearch = true;


        while (continueSearch) {
            boolean noTileMatches = true;
            for (Tile tile : inputTiles) {
                boolean foundMatchingLeftTile = false;
                for (Integer orientation : List.of(1, 2, 3, 4, 5, 6, 7, 8)) {
                    if (orientation == 2) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 3) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 4) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 5) {
                        tile.turn90DegClockwise();
                        tile.flipH();
                    }
                    if (orientation == 6) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 7) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 8) {
                        tile.turn90DegClockwise();
                    }
                    if (Arrays.equals(tile0.getLeftBorder(), tile.getRightBorder())) {
                        foundMatchingLeftTile = true;
                        break;
                    }
                }
                noTileMatches = !(foundMatchingLeftTile && noTileMatches);
                if (foundMatchingLeftTile) {
                    tile0 = tile;
                    inputTiles.remove(tile0);
                    row0.add(0, tile0);
                    break;
                }
            }
            continueSearch = !noTileMatches;
        }

        tile0 = row0.get(0);
        continueSearch = true;
        image.add(row0);


        while (continueSearch) {
            row0 = new ArrayList<>();
            boolean noTileMatches = true;
            for (Tile tile : inputTiles) {
                boolean foundMatchingBottomTile = false;
                for (Integer orientation : List.of(1, 2, 3, 4, 5, 6, 7, 8)) {
                    if (orientation == 2) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 3) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 4) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 5) {
                        tile.turn90DegClockwise();
                        tile.flipH();
                    }
                    if (orientation == 6) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 7) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 8) {
                        tile.turn90DegClockwise();
                    }
                    if (Arrays.equals(tile0.getBottomBorder(), tile.getTopBorder())) {
                        foundMatchingBottomTile = true;
                        break;
                    }
                }
                noTileMatches = !(foundMatchingBottomTile && noTileMatches);
                if (foundMatchingBottomTile) {
                    tile0 = tile;
                    inputTiles.remove(tile0);
                    row0.add(tile0);
                    image.add(row0);
                    break;
                }
            }
            continueSearch = !noTileMatches;
        }

        tile0 = image.get(0).get(0);
        continueSearch = true;

        while (continueSearch) {
            row0 = new ArrayList<>();
            boolean noTileMatches = true;
            for (Tile tile : inputTiles) {
                boolean foundMatchingTopTile = false;
                for (Integer orientation : List.of(1, 2, 3, 4, 5, 6, 7, 8)) {
                    if (orientation == 2) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 3) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 4) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 5) {
                        tile.turn90DegClockwise();
                        tile.flipH();
                    }
                    if (orientation == 6) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 7) {
                        tile.turn90DegClockwise();
                    }
                    if (orientation == 8) {
                        tile.turn90DegClockwise();
                    }
                    if (Arrays.equals(tile0.getTopBorder(), tile.getBottomBorder())) {
                        foundMatchingTopTile = true;
                        break;
                    }
                }
                noTileMatches = !(foundMatchingTopTile && noTileMatches);
                if (foundMatchingTopTile) {
                    tile0 = tile;
                    inputTiles.remove(tile0);
                    row0.add(tile0);
                    image.add(0, row0);
                    break;
                }
            }
            continueSearch = !noTileMatches;
        }


        for (List<Tile> row : image) {
            if (row.size() == 1) {
                row0 = row;
                tile0 = row0.get(0);
                continueSearch = true;

                while (continueSearch) {
                    boolean noTileMatches = true;
                    for (Tile tile : inputTiles) {
                        boolean foundMatchingRightTile = false;
                        for (Integer orientation : List.of(1, 2, 3, 4, 5, 6, 7, 8)) {
                            if (orientation == 2) {
                                tile.turn90DegClockwise();
                            }
                            if (orientation == 3) {
                                tile.turn90DegClockwise();
                            }
                            if (orientation == 4) {
                                tile.turn90DegClockwise();
                            }
                            if (orientation == 5) {
                                tile.turn90DegClockwise();
                                tile.flipH();
                            }
                            if (orientation == 6) {
                                tile.turn90DegClockwise();
                            }
                            if (orientation == 7) {
                                tile.turn90DegClockwise();
                            }
                            if (orientation == 8) {
                                tile.turn90DegClockwise();
                            }
                            if (Arrays.equals(tile0.getRightBorder(), tile.getLeftBorder())) {
                                foundMatchingRightTile = true;
                                break;
                            }
                        }
                        noTileMatches = !(foundMatchingRightTile && noTileMatches);
                        if (foundMatchingRightTile) {
                            tile0 = tile;
                            inputTiles.remove(tile0);
                            row0.add(tile0);
                            break;
                        }
                    }
                    continueSearch = !noTileMatches;
                }


            }
        }


        int idA = image.get(0).get(0).getId();
        int idB = image.get(0).get(image.get(0).size() - 1).getId();
        int idC = image.get(image.size() - 1).get(0).getId();
        int idD = image.get(image.size() - 1).get(image.get(image.size() - 1).size() - 1).getId();
        long answer1Part1 = (long) idA * (long) idB * (long) idC * (long) idD;
        System.out.println("Answer Part 1: " + answer1Part1);
        System.out.println();


/*        System.out.println();
        for (List<Tile> row:image) {
            System.out.println(row.stream().map(e -> e.getId()).collect(Collectors.toList()));
        }
        System.out.println();*/


        for (List<Tile> row : image) {
            for (Tile tile : row) {
                boolean[][] pixels1 = tile.getPixels();
                boolean[][] pixels2 = new boolean[8][8];
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        pixels2[i][j] = pixels1[i + 1][j + 1];
                    }
                }
                tile.setPixels(pixels2);
            }
        }
        return image;
    }

    public boolean checkAreaForMonster(boolean[][] area) {
        String[] row1 = "                  # ".split("");
        String[] row2 = "#    ##    ##    ###".split("");
        String[] row3 = " #  #  #  #  #  #   ".split("");

        boolean containsMonster = true;

        for (int i = 0; i < row1.length; i++) {
            if (row1[i].equals("#")) {
                containsMonster = containsMonster && area[0][i];
            }
        }
        for (int i = 0; i < row1.length; i++) {
            if (row2[i].equals("#")) {
                containsMonster = containsMonster && area[1][i];
            }
        }
        for (int i = 0; i < row1.length; i++) {
            if (row3[i].equals("#")) {
                containsMonster = containsMonster && area[2][i];
            }
        }


        return containsMonster;
    }


    public int countMonsters(boolean[][] compositeImage) {
        int length = compositeImage.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (i + 3 > length) continue;
            for (int j = 0; j < length; j++) {
                if (j + 20 > length) continue;
                boolean[][] area = new boolean[3][20];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 20; l++) {
                        area[k][l] = compositeImage[i + k][j + l];
                    }
                }
                if (checkAreaForMonster(area)) count++;
            }
        }
        return count;
    }


    public int findMonsters() {
        List<List<Tile>> assembled = assemble();
        boolean[][] compositeImage = getCompositeImage(assembled);

        for (Integer orientation : List.of(1, 2, 3, 4, 5, 6, 7, 8)) {
            if (orientation == 2) {
                compositeImage = turn90DegClockwise(compositeImage);
            }
            if (orientation == 3) {
                compositeImage = turn90DegClockwise(compositeImage);
            }
            if (orientation == 4) {
                compositeImage = turn90DegClockwise(compositeImage);
            }
            if (orientation == 5) {
                compositeImage = turn90DegClockwise(compositeImage);
                compositeImage = flipH(compositeImage);
            }
            if (orientation == 6) {
                compositeImage = turn90DegClockwise(compositeImage);
            }
            if (orientation == 7) {
                compositeImage = turn90DegClockwise(compositeImage);
            }
            if (orientation == 8) {
                compositeImage = turn90DegClockwise(compositeImage);
            }
            int count = countMonsters(compositeImage);
            if (count > 0) return count;
        }

        return 0;
    }


    public int countHashes() {
        List<List<Tile>> assembledImage = assemble();
        int count = 0;
        for (List<Tile> row:assembledImage) {
            for (Tile tile:row) {
                boolean[][] pixels = tile.getPixels();
                for (int i = 0; i < pixels.length; i++) {
                    for (int j = 0; j < pixels.length; j++) {
                        if (pixels[i][j]) count++;
                    }
                }
            }
        }
        return count;
    }




















}



