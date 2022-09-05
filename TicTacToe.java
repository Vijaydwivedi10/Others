import java.util.Scanner;

public class TicTacToe {

  // A function for detecting if the player played the chance won the game or not.
  static int winner(int[] a) {
    int win = 0;
    if (((a[1] == a[2] && a[2] == a[3] && a[1] != -1) || (a[4] == a[5] && a[5] == a[6] && a[5] != -1)
        || (a[7] == a[8] && a[8] == a[9] && a[9] != -1)
        || (a[1] == a[4] && a[4] == a[7] && a[1] != -1) || (a[2] == a[5] && a[5] == a[8] && a[5] != -1)
        || (a[3] == a[6] && a[6] == a[9] && a[9] != -1) ||
        (a[1] == a[5] && a[5] == a[9] && a[1] != -1) || (a[3] == a[5] && a[5] == a[7] && a[5] != -1)))
      win = 1;
    return win;
  }

  // Function for printing the TicTacToe Game
  static void print(int[] a) {

    char[] arr = new char[10];
    for (int i = 1; i <= 9; i++) {
      if (a[i] == 1)
        arr[i] = 'X';
      else if (a[i] == 0)
        arr[i] = 'O';
      else
        arr[i] = ' ';
    }
    System.out.println("\n   ___ ___ ___ ");
    for (int i = 1; i <= 9; i += 3) {
      System.out.println("  |   |   |   |");
      System.out.println("  | " + arr[i] + " | " + arr[i + 1] + " | " + arr[i + 2] + " |");
      System.out.println("  |___|___|___|");
    }
    System.out.println("\n\n");
  }

  public static void main(String[] args) {

    Scanner obj = new Scanner(System.in);
    System.out.print("press 1 for Player vs player game or press 2 for player vs computer Game : ");
    int prs = obj.nextInt();

    if (prs == 2) { // if user pressed 2 then --> player vs Computer Game is started

      System.out.print("Enter player's name : ");
      Scanner ob = new Scanner(System.in);
      String n1 = ob.nextLine();
      System.out.println("\n\n  Hello " + n1 + " welcome to the player vs Computer Game \n");
      System.out.println("  NOTE :  THESE 1-9 NUMBERS ARE THE APPROPRIATE POSTION");

      System.out.println("\n   ___ ___ ___ ");
      for (int i = 1; i <= 9; i += 3) {
        System.out.println("  |   |   |   |");
        System.out.println("  | " + i + " | " + (i + 1) + " | " + (i + 2) + " |");
        System.out.println("  |___|___|___|");
      }
      System.out.println("\n\n");

      int[] a = new int[10];
      a[0] = -1;
      for (int i = 1; i < 10; i++) {
        a[i] = -1;
      }

      for (int i = 1; i <= 9; i++) {

        Scanner sc = new Scanner(System.in);
        if (i % 2 == 1) {
          System.out.print(n1+"'s chance : ");
          int pp = sc.nextInt(); // pp is the position where player is played his/her chance
          if (a[pp] == -1) {
            a[pp] = 1;
          } else {
            System.out.println("  Not a valid move enter again!");
            i--;
            continue;
          }
          int ck = winner(a);
          if (ck == 1) { // if ck==1 --> player won the Game
            System.out.println("  Hurrayy! " + n1 + " you won the game");

            print(a);

            System.out.println("\nEnter 0 to exit or Enter 1 to Replay : ");
            int rep = obj.nextInt();
            if (rep == 1) {
              i = 0;
              System.out.println("\n  THE GAME IS RESTARTED \n\n");
              for (int j = 1; j < 10; j++) {
                a[j] = -1;
              }
              continue;
            } else if (rep == 0)
              break;
            else {
              System.out.println("  Not a valid number! EXIT");
            }

          }
        }

        else {
          int pos = -1;
          if (i == 2) { // for the first time computer will choose the 5th or 9th postion 
            if (a[5] == -1)
              pos = 5;
            else
              pos = 9;
            System.out.println("\nComputer chooses the position: " + pos);
            a[pos] = 0;
            print(a);
          }

          else {
            int psn = ifwin(a); // checking if computer can win with any chance 
            a[psn] = 0;
            int ck = winner(a);
            if (ck == 0) { // if computer can't win then coputer will try to stop the player's win
              a[psn] = -1;
              psn = stopwin(a);
              a[psn] = 0;
            }
            System.out.println("\nComputer choosen the position: " + psn);
            a[psn] = 0;
            print(a);
            ck = winner(a);
            if (ck == 1) {
              System.out.println("  Computer won the game .. Good luck for the next game");

              System.out.print("\nEnter 0 to exit or Enter 1 to Replay : ");
              int rep = obj.nextInt();
              if (rep == 1) {
                i = 0;
                System.out.println("\n  THE GAME IS RESTARTED \n\n");
                for (int j = 1; j < 10; j++) {
                  a[j] = -1;
                }
                continue;
              } else if (rep == 0)
                break;
              else {
                System.out.println("  Not a valid number! EXIT");
              }

            }
          }
        }
        if (i == 9) {  // if all places aree filled and No one won the game
          System.out.println("  The Game is Drawn! ");

          System.out.print("\nEnter 0 to exit or Enter 1 to Replay : ");
          int rep = obj.nextInt();
          if (rep == 1) {
            i = 0;
            System.out.println("\n  THE GAME IS RESTARTED \n\n");
            for (int j = 1; j < 10; j++) {
              a[j] = -1;
            }
            continue;
          } else if (rep == 0)
            break;
          else {
            System.out.println("  Not a valid number! EXIT");
          }
        }

      }
    }

    else if (prs == 1) { // if user pressed 1 --> player vs player game started
      System.out.print("Enter player 1 name : ");
      Scanner scn = new Scanner(System.in);
      String n1 = scn.nextLine();
      System.out.print("Enter player 2 name : ");
      String n2 = scn.nextLine();
      System.out.println("\n  Hello " + n1 + " and " + n2 + " welcome to the player vs player Game ");

      System.out.println("\n   ___ ___ ___ ");
      for (int i = 1; i <= 9; i += 3) {
        System.out.println("  |   |   |   |");
        System.out.println("  | " + i + " | " + (i + 1) + " | " + (i + 2) + " |");
        System.out.println("  |___|___|___|");
      }
      System.out.println("\n\n");

      int[] a = new int[10];
      a[0] = -1;
      for (int i = 1; i < 10; i++) {
        a[i] = -1;
      }

      for (int i = 1; i <= 9; i++) {

        Scanner sc = new Scanner(System.in);
        if (i % 2 == 1) {
          System.out.print(n1 + "'s chance : ");
          int pp = sc.nextInt();
          if (a[pp] == -1) {
            a[pp] = 1;
          } else {
            System.out.println("  Not a valid move enter again!");
            i--;
            continue;
          }
          int ck = winner(a);

          print(a);

          if (ck == 1) {
            System.out.println("  Hurrayy! " + n1 + " you won the game");

            System.out.print("\nEnter 0 to exit or Enter 1 to Replay : ");
            int rep = obj.nextInt();
            if (rep == 1) {
              i = 0;
              System.out.println("\n  THE GAME IS RESTARTED \n\n");
              for (int j = 1; j < 10; j++) {
                a[j] = -1;
              }
              continue;
            } else if (rep == 0)
              break;
            else {
              System.out.println("  Not a valid number! EXIT");
            }

          }
        }

        else {

          System.out.print(n2 + "'s chance : ");
          int pp = sc.nextInt();
          if (a[pp] == -1) {
            a[pp] = 0;
          } else {
            System.out.println("  Not a valid move enter again");
            i--;
            continue;
          }
          int ck = winner(a);

          print(a);

          if (ck == 1) {
            System.out.println("  Hurrayy! " + n2 + " you won the game");

            System.out.print("\nEnter 0 to exit or Enter 1 to Replay : ");
            int rep = obj.nextInt();
            if (rep == 1) {
              i = 0;
              System.out.println("\n  THE GAME IS RESTARTED \n\n");
              for (int j = 1; j < 10; j++) {
                a[j] = -1;
              }
              continue;
            } else if (rep == 0)
              break;
            else {
              System.out.println("  Not a valid number! EXIT");
            }

          }

        }
        if (i == 9) {
          System.out.println("  The Game is Drawn! ");

          System.out.println("\nEnter 0 to exit or Enter 1 to Replay : ");
          int rep = obj.nextInt();
          if (rep == 1) {
            i = 0;
            System.out.print("\n  THE GAME IS RESTARTED \n\n");
            for (int j = 1; j < 10; j++) {
              a[j] = -1;
            }
            continue;
          } else if (rep == 0)
            break;
          else {
            System.out.println("  Not a valid number! EXIT");
          }
        }

      }
    } else
      System.out.println("  Not a valid entry! ");
  }

  // function for checking if there is a chance so that computer can win or not
  static int ifwin(int[] a) {
    int pos = -1;
    // Row - 1
    if (a[1] == a[2] && a[1] == 0 && a[3] == -1)
      pos = 3;
    else if (a[1] == a[3] && a[1] == 0 && a[2] == -1)
      pos = 2;
    else if (a[2] == a[3] && a[2] == 0 && a[1] == -1)
      pos = 1;

    // Column - 1
    else if (a[1] == a[4] && a[1] == 0 && a[7] == -1)
      pos = 7;
    else if (a[1] == a[7] && a[1] == 0 && a[4] == -1)
      pos = 4;
    else if (a[4] == a[7] && a[4] == 0 && a[1] == -1)
      pos = 1;

    // Diagonal -1
    else if (a[1] == a[5] && a[1] == 0 && a[9] == -1)
      pos = 9;
    else if (a[1] == a[9] && a[1] == 0 && a[5] == -1)
      pos = 5;
    else if (a[5] == a[9] && a[5] == 0 && a[1] == -1)
      pos = 1;

    // Row -2
    else if (a[4] == a[5] && a[4] == 0 && a[6] == -1)
      pos = 6;
    else if (a[4] == a[6] && a[4] == 0 && a[5] == -1)
      pos = 5;
    else if (a[5] == a[6] && a[5] == 0 && a[4] == -1)
      pos = 4;

    // Row -3
    else if (a[7] == a[8] && a[7] == 0 && a[9] == -1)
      pos = 9;
    else if (a[7] == a[9] && a[7] == 0 && a[8] == -1)
      pos = 8;
    else if (a[9] == a[8] && a[9] == 0 && a[7] == -1)
      pos = 7;

    // Column - 2
    else if (a[2] == a[5] && a[2] == 0 && a[8] == -1)
      pos = 8;
    else if (a[8] == a[5] && a[8] == 0 && a[2] == -1)
      pos = 2;
    else if (a[2] == a[8] && a[2] == 0 && a[5] == -1)
      pos = 5;

    // Column - 3
    else if (a[3] == a[6] && a[3] == 0 && a[9] == -1)
      pos = 9;
    else if (a[3] == a[9] && a[3] == 0 && a[6] == -1)
      pos = 6;
    else if (a[6] == a[6] && a[6] == 0 && a[3] == -1)
      pos = 3;

    // diagonal - 2
    else if (a[3] == a[5] && a[3] == 0 && a[7] == -1)
      pos = 7;
    else if (a[3] == a[7] && a[3] == 0 && a[5] == -1)
      pos = 5;
    else if (a[5] == a[7] && a[5] == 0 && a[3] == -1)
      pos = 3;

    if (pos == -1) {
      for (int j = 1; j <= 9; j++) {
        if (a[j] == -1)
          pos = j;
      }
    }
    return pos;

  }

  // if player have chance to win then computer will try to stop that winning with
  // this function
  static int stopwin(int[] a) {
    int pos = -1;
    // Row - 1
    if (a[1] == a[2] && a[1] == 1 && a[3] == -1)
      pos = 3;
    else if (a[1] == a[3] && a[1] == 1 && a[2] == -1)
      pos = 2;
    else if (a[2] == a[3] && a[2] == 1 && a[1] == -1)
      pos = 1;

    // Column - 1
    else if (a[1] == a[4] && a[1] == 1 && a[7] == -1)
      pos = 7;
    else if (a[1] == a[7] && a[1] == 1 && a[4] == -1)
      pos = 4;
    else if (a[4] == a[7] && a[4] == 1 && a[1] == -1)
      pos = 1;

    // Diagonal -1
    else if (a[1] == a[5] && a[1] == 1 && a[9] == -1)
      pos = 9;
    else if (a[1] == a[9] && a[1] == 1 && a[5] == -1)
      pos = 5;
    else if (a[5] == a[9] && a[5] == 1 && a[1] == -1)
      pos = 1;

    // Row -2
    else if (a[4] == a[5] && a[4] == 1 && a[6] == -1)
      pos = 6;
    else if (a[4] == a[6] && a[4] == 1 && a[5] == -1)
      pos = 5;
    else if (a[5] == a[6] && a[5] == 1 && a[4] == -1)
      pos = 4;

    // Row -3
    else if (a[7] == a[8] && a[7] == 1 && a[9] == -1)
      pos = 9;
    else if (a[7] == a[9] && a[7] == 1 && a[8] == -1)
      pos = 8;
    else if (a[9] == a[8] && a[9] == 1 && a[7] == -1)
      pos = 7;

    // Column - 2
    else if (a[2] == a[5] && a[2] == 1 && a[8] == -1)
      pos = 8;
    else if (a[8] == a[5] && a[8] == 1 && a[2] == -1)
      pos = 2;
    else if (a[2] == a[8] && a[2] == 1 && a[5] == -1)
      pos = 5;

    // Column - 3
    else if (a[3] == a[6] && a[3] == 1 && a[9] == -1)
      pos = 9;
    else if (a[3] == a[9] && a[3] == 1 && a[6] == -1)
      pos = 6;
    else if (a[6] == a[6] && a[6] == 1 && a[3] == -1)
      pos = 3;

    // diagonal - 2
    else if (a[3] == a[5] && a[3] == 1 && a[7] == -1)
      pos = 7;
    else if (a[3] == a[7] && a[3] == 1 && a[5] == -1)
      pos = 5;
    else if (a[5] == a[7] && a[5] == 1 && a[3] == -1)
      pos = 3;

    // other pos

    else if (a[2] == a[4] && a[2] == 1 && a[1] == -1)
      pos = 1;
    else if (a[2] == a[6] && a[2] == 1 && a[3] == -1)
      pos = 3;
    else if (a[8] == a[4] && a[4] == 1 && a[7] == -1)
      pos = 7;
    else if (a[6] == a[8] && a[6] == 1 && a[9] == -1)
      pos = 9;

    else if (a[2] == a[9] && a[2] == 1 && a[1] == -1)
      pos = 1;
    else if (a[2] == a[7] && a[2] == 1 && a[3] == -1)
      pos = 3;
    else if (a[8] == a[3] && a[4] == 1 && a[7] == -1)
      pos = 7;
    else if (a[1] == a[8] && a[6] == 1 && a[9] == -1)
      pos = 9;

    else if (a[3] == a[4] && a[2] == 1 && a[1] == -1)
      pos = 1;
    else if (a[1] == a[6] && a[2] == 1 && a[3] == -1)
      pos = 3;
    else if (a[9] == a[4] && a[4] == 1 && a[7] == -1)
      pos = 7;
    else if (a[6] == a[7] && a[6] == 1 && a[9] == -1)
      pos = 9;

    if (pos == -1) {
      for (int j = 1; j <= 9; j++) {
        if (a[j] == -1)
          pos = j;
      }
    }
    return pos;

  }

}