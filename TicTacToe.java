import java.util.Scanner;
public class TicTacToe
{   
    public static char[][] getBoard()
    {
        char[][] board=new char[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=' ';
            }
        }
        return board;
    }
    public static void printboard(char[][] board)
    {
        System.out.println();
        for(int i=0;i<3;i++)
        {
            System.out.println(" ");
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j]);
                if(j<2) System.out.print(" | ");
            }
            System.out.println();
            if(i<2) System.out.print("---------");
        }
        System.out.println();
    }

    public static boolean Winner(char[][] board, char currentPlayer)
    {
     for(int i=0;i<3;i++)
     {
         if((board[i][0]==currentPlayer  && board[i][1]==currentPlayer && board[i][2]==currentPlayer)||
            (board[0][i]==currentPlayer && board[1][i]==currentPlayer && board[2][i]==currentPlayer))
             return true;
     }
         if((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)||
             (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer))
             return true;

             return false;
    }   

    public static boolean isDraw(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==' ')
                    return false;
            }
        }
        return true;
    }
public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        char board[][]=getBoard();
        //System.out.println();
        System.out.println("This is a terminal Based Tic Tac Toe Game");
        System.out.println("       Lets Start");
        char currentPlayer='X';
        while(true)
        {
          printboard(board);
          System.out.println("Current Player: "+ currentPlayer+ " turn");
          System.out.print("Enter row(0-2) and colm(0-2): ");
          int row=sc.nextInt();
          int col=sc.nextInt();
          if(row>2 || row<0 || col>2 || col<0 || board[row][col]!=' ')
          {
              System.out.println();
              System.out.println("Invalid Move! Try Again...");
              continue;
          }   

          board[row][col]=currentPlayer;

          if(Winner(board, currentPlayer))
          {
            printboard(board);
            System.out.println();
            System.out.println("   Game Over   ");
            System.out.println("The Winner is: "+ currentPlayer);
            break;
          }
          if(isDraw(board))
          {
            printboard(board);
            System.out.println("Its a draw!!!!");
            break;
          }
          currentPlayer=(currentPlayer=='X') ? 'O' : 'X';
        }     
        }      
}