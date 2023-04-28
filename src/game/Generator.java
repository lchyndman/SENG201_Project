package game;

import java.util.ArrayList;
import java.util.Random;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Generator {

	public final int MAX_LEVEL = 100;
	public final int MIN_LEVEL = 0;
	public ArrayList<String> names = new ArrayList<String>();
	Random rand = new Random();
	
	
	public Generator() {
		
	}
	
	public void fillNames() {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("first_names.txt"));
			String line = reader.readLine();

			while (line != null) {
				this.names.add(line);
				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
