/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package waldonsm.games.cubefield2D;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author shawn
 */
public class HighScoreRecorder {
    private static final File scoreFile = new File("HighScores.txt");

    public static void score(int score) {
		ArrayList<ScoreData> data = getArrayListFromFile(scoreFile);
		if (data.size() < 10 || score > data.get(9).getScore()) {
			int index = data.size();
			for (;index >= 1 && data.get(index-1).getScore() < score; index--) {
			}
			String name;
			do {
			name = JOptionPane.showInputDialog("High Score!!!\nEnter your name:");
			} while (name != null && name.indexOf(":") != -1 && name.indexOf(" - ") != -1);
			if (name != null)
				data.add(index, new ScoreData(name,score));
			if (data.size() > 10) {
				data.remove(10);
			}
			writeDataToFile(data,scoreFile);
			String message = "";
			for (ScoreData d: data) {
				message += d.getName() + " - " + d.getScore() + "\n";
			}
			JOptionPane.showMessageDialog(null, message, "High Scores:", JOptionPane.INFORMATION_MESSAGE);
		}
    }

     /**
	 * displays the high scores at this difficulty and growth rate
	 * @param gRate the growthRate setting of the game
	 */
	public static void viewHighScores() {
		ArrayList<ScoreData> data = getArrayListFromFile(scoreFile);
		String message = "";
		for (ScoreData d: data) {
			message += d.getName() + " - " + d.getScore() + "\n";
		}
		JOptionPane.showMessageDialog(null, message, "High Scores:", JOptionPane.INFORMATION_MESSAGE);
	}


        /**
	 * takes a File object and extracts the high scores stored inside it to an ArrayList
	 * @param file the file to extract from
	 * @return an ArrayList of ScoreData objects in sorted order
	 */
	public static ArrayList<ScoreData> getArrayListFromFile(File file) {
		ArrayList<ScoreData> data = new ArrayList<ScoreData>();
		try {
			Scanner scan = new Scanner(file);
			scan.useDelimiter(":");
			while (scan.hasNext()) {
				data.add(new ScoreData(scan.next(), scan.nextInt()));
			}
			scan.close();
		} catch (IOException e) {}
		return data;
	}

	/**
	 * writes the ArrayList of ScoreData objects to the File
	 * @param data the ArrayList to be written
	 * @param file the File to be written to
	 */
	public static void writeDataToFile(ArrayList<ScoreData> data, File file) {
		try {
			PrintWriter pw = new PrintWriter(file);
			for (ScoreData d: data) {
				pw.print(d.getName() + ":" + d.getScore() + ":");
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
