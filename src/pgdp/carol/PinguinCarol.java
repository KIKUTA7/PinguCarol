package pgdp.carol;

import static pgdp.MiniJava.*;

public class PinguinCarol {

    public static void main(String[] args) {
        int width = readInt("Enter the playing field width:");
        int height = readInt("Enter pitch height:");
        if (width <= 0 || height <= 0) {
            write("The width and height of the playing field must be greater than zero.");

        } else {
            int board[][] = new int[width][height];
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    board[i][j] = randomInt(-1, 9);


                }

            }
            printPlayground(board);
            int posX = readInt("Starting position x:");
            int posY = readInt("Starting position y:");
            int dir = readInt("Direction of view at the beginning:");
            int blockNum = readInt("Ice blocks at the beginning:");
            if (posX > width - 1 || posX < 0 || posY < 0 || posY > height - 1 || dir < 0 || dir > 3 || blockNum > 10 || blockNum < 0) {
                write("Invalid start values.");
            } else {
                char inst = ' ';
                while (inst != 'e') {
                    inst = readChar("Enter instruction:");
                    if (inst == 'a') {
                        printPlayground(board, posX, posY, dir, blockNum);

                    } else if (inst == 'r') {
                        dir = dir - 1;
                        if (dir == -1) dir = 3;
                    } else if (inst == 'l') {
                        dir = dir + 1;
                        if (dir == 4) dir = 0;
                    } else if (inst == 's') {
                        if (dir == 0) {
                            if (posX + 1 < width && Math.abs(board[posX][posY] - board[posX + 1][posY]) <= 1) {
                                posX++;
                            } else {
                                if (posX + 1 >= width) write("Carol cannot leave the field.");
                                if (Math.abs(board[posX][posY] - board[posX + 1][posY]) > 1)
                                    write("Carol cannot go to the next field because the difference in height is too great.");
                            }
                        } else if (dir == 1) {
                            if (posY + 1 < height && Math.abs(board[posX][posY] - board[posX][posY + 1]) <= 1) {
                                posY++;
                            } else {
                                if (posY + 1 >= height) write("Carol cannot leave the field.");
                                if (Math.abs(board[posX][posY] - board[posX][posY + 1]) > 1)
                                    write("Carol cannot go to the next field because the difference in height is too great.");
                            }
                        } else if (dir == 2) {
                            if (posX - 1 > -1 && Math.abs(board[posX][posY] - board[posX - 1][posY]) <= 1) {
                                posX--;
                            } else {
                                if (posX - 1 < 0) write("Carol cannot leave the field.");
                                if (Math.abs(board[posX][posY] - board[posX - 1][posY]) > 1)
                                    write("Carol cannot go to the next field because the difference in height is too great.");
                            }

                        } else if (dir == 3) {
                            if (posY - 1 > -1 && Math.abs(board[posX][posY] - board[posX][posY - 1]) <= 1) {
                                posY--;
                            } else {
                                if (posY - 1 < 0) write("Carol cannot leave the field.");
                                if (Math.abs(board[posX][posY] - board[posX][posY - 1]) > 1)
                                    write("Carol cannot go to the next field because the difference in height is too great.");
                            }

                        }
                    } else if (inst == 'n') {
                        if (dir == 0) {
                            if (board[posX][posY] != -1 && blockNum < 10 && posX + 1 < width && board[posX + 1][posY] > -1) {
                                board[posX + 1][posY]--;
                                blockNum++;
                            } else {
                                if (blockNum == 10)
                                    write("Carol can't take a block of ice, she's already carrying ten.");
                                if (board[posX][posY] == -1) write("Carol cannot take blocks of ice in the water.");
                                if (posX + 1 >= width) write("Carol cannot take blocks of ice off the field.");
                                if (board[posX + 1][posY] <= -1)
                                    write("Carol can't take a block of ice, there aren't any left.");
                            }
                        } else if (dir == 1) {
                            if (board[posX][posY] != -1 && blockNum < 10 && posY + 1 < height && board[posX][posY + 1] > -1) {
                                board[posX][posY + 1]--;
                                blockNum++;
                            } else {
                                if (blockNum == 10)
                                    write("Carol can't take a block of ice, she's already carrying ten.");
                                if (board[posX][posY] == -1) write("Carol cannot take blocks of ice in the water.");
                                if (posY + 1 >= height) write("Carol cannot take blocks of ice off the field.");
                                if (board[posX][posY + 1] <= -1)
                                    write("Carol can't take a block of ice, there aren't any left.");
                            }
                        } else if (dir == 2) {
                            if (board[posX][posY] != -1 && blockNum < 10 && posX - 1 > -1 && board[posX - 1][posY] > -1) {
                                board[posX - 1][posY]--;
                                blockNum++;
                            } else {
                                if (blockNum == 10)
                                    write("Carol can't take a block of ice, she's already carrying ten.");
                                if (board[posX][posY] == -1) write("Carol cannot take blocks of ice in the water.");
                                if (posX - 1 <= -1) write("Carol cannot take blocks of ice off the field.");
                                if (board[posX - 1][posY] <= -1)
                                    write("Carol can't take a block of ice, there aren't any left.");
                            }
                        } else if (dir == 3) {
                            if (board[posX][posY] != -1 && blockNum < 10 && posY - 1 > -1 && board[posX][posY - 1] > -1) {
                                board[posX][posY - 1]--;
                                blockNum++;
                            } else {
                                if (blockNum == 10)
                                    write("Carol can't take a block of ice, she's already carrying ten.");
                                if (board[posX][posY] == -1) write("Carol cannot take blocks of ice in the water.");
                                if (posY - 1 <= -1) write("Carol cannot take blocks of ice off the field.");
                                if (board[posX][posY - 1] <= -1)
                                    write("Carol can't take a block of ice, there aren't any left.");
                            }
                        }
                    } else if (inst == 'p') {
                        if (dir == 0) {
                            if (board[posX][posY] != -1 && blockNum >= 1 && posX + 1 < width && board[posX + 1][posY] < 9) {
                                board[posX + 1][posY]++;
                                blockNum--;
                            } else {
                                if (blockNum < 1)
                                    write("Carol can't lay a block of ice because she isn't carrying one.");
                                if (board[posX][posY] == -1) write("Carol cannot lay blocks of ice in the water.");
                                if (posX + 1 >= width) write("Carol cannot put blocks of ice off the field of play.");
                                if (board[posX + 1][posY] >= 9)
                                    write("Carol can't lay a block of ice, there are already ten blocks of ice on the field.");
                            }
                        } else if (dir == 1) {
                            if (board[posX][posY] != -1 && blockNum >= 1 && posY + 1 < height && board[posX][posY + 1] < 9) {
                                board[posX][posY + 1]++;
                                blockNum--;
                            } else {
                                if (blockNum < 1)
                                    write("Carol can't lay a block of ice because she isn't carrying one.");
                                if (board[posX][posY] == -1) write("Carol cannot lay blocks of ice in the water.");
                                if (posY + 1 >= height) write("Carol cannot put blocks of ice off the field of play.");
                                if (board[posX][posY + 1] >= 9)
                                    write("Carol can't lay a block of ice, there are already ten blocks of ice on the field.");
                            }
                        } else if (dir == 2) {
                            if (board[posX][posY] != -1 && blockNum >= 1 && posX - 1 > -1 && board[posX - 1][posY] < 9) {
                                board[posX - 1][posY]++;
                                blockNum--;
                            } else {
                                if (blockNum < 1)
                                    write("Carol can't lay a block of ice because she isn't carrying one.");
                                if (board[posX][posY] == -1) write("Carol cannot lay blocks of ice in the water.");
                                if (posX - 1 <= -1) write("Carol cannot put blocks of ice off the field of play.");
                                if (board[posX - 1][posY] >= 9)
                                    write("Carol can't lay a block of ice, there are already ten blocks of ice on the field.");
                            }
                        } else if (dir == 3) {
                            if (board[posX][posY] != -1 && blockNum >= 1 && posY - 1 > -1 && board[posX][posY - 1] < 9) {
                                board[posX][posY - 1]++;
                                blockNum--;
                            } else {
                                if (blockNum < 1)
                                    write("Carol can't lay a block of ice because she isn't carrying one.");
                                if (board[posX][posY] == -1) write("Carol cannot lay blocks of ice in the water.");
                                if (posY - 1 <= -1) write("Carol cannot put blocks of ice off the field of play.");
                                if (board[posX][posY - 1] >= 9)
                                    write("Carol can't lay a block of ice, there are already ten blocks of ice on the field.");
                            }
                        }
                    } else if(inst != 'e') write("Unknown instruction!");
                }


            }

        }
    }
}
