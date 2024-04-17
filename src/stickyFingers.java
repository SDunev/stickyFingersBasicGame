import java.util.Scanner;

public class stickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = new String[size][size];
        fillMatrix(matrix,scanner);
        int currentRow = -1;
        int currentCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("D")){
                    currentRow = row;
                    currentCol = col;
                }
            }
        }
        int stolenMoney = 0;
        boolean isCaught = false;
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "left":
                    if (currentCol - 1 >= 0) {
                        matrix[currentRow][currentCol] = "+";
                        currentCol = currentCol - 1;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "right":
                    if (currentCol + 1 < size) {
                        matrix[currentRow][currentCol] = "+";
                        currentCol = currentCol + 1;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }

                    break;
                case "up":
                    if (currentRow - 1 >= 0) {
                        matrix[currentRow][currentCol] = "+";
                        currentRow = currentRow - 1;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    if (currentRow + 1 < size) {
                        matrix[currentRow][currentCol] = "+";
                        currentRow = currentRow + 1;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("$")) {
                matrix[currentRow][currentCol] = "+";
                int currentStolenMoney = currentRow * currentCol;
                stolenMoney = stolenMoney + currentStolenMoney;
                System.out.printf("You successfully stole %d$.%n", currentStolenMoney);
            }
            if (matrix[currentRow][currentCol].equals("P")) {
                matrix[currentRow][currentCol] = "#";
                System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                isCaught = true;
                break;
            }

            matrix[currentRow][currentCol] = "D";
        }
        if (!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        }

        for (int i = 0; i < matrix.length ; i++) {
            System.out.println(String.join(" ",matrix[i]));
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length ; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
