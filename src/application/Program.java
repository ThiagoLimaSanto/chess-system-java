package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                Ui.clearScreen();
                Ui.printBoard(chessMatch.getPieces());

                System.out.println();

                System.out.print("Source: ");
                ChessPosition source = Ui.readChessPosition(scan);

                boolean [][] possibleMoves = chessMatch.possibleMoves(source);
                Ui.clearScreen();
                
                Ui.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();

                System.out.print("Target: ");
                ChessPosition target = Ui.readChessPosition(scan);

                ChessPiece capturedPiece = chessMatch.performChessMovie(source, target);
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }
    }
}
