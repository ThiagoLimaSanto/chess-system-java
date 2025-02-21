package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            Ui.printBoard(chessMatch.getPieces());

            System.out.println();

            System.out.print("Source: ");
            ChessPosition source = Ui.readChessPosition(scan);

            System.out.println();

            System.out.println("Target: ");
            ChessPosition target = Ui.readChessPosition(scan);
            
            ChessPiece capturedPiece = chessMatch.perfomChessMovie(source, target);
        }
    }
}
