import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
 * 2018/4/19 
 * Author:Nialys
 * テキストファイル読み込んでイイ感じの言葉を作る的な奴
 */

public class Main {

	public static void main(String[] args){


		try {
			if(Integer.parseInt(args[0]) > 1000 ||  Integer.parseInt(args[0]) < 1){
				System.out.println("引数が1~10ではありません");
			}
			else {
				ArrayList<String> wordList1 = new ArrayList<String>();
				ArrayList<String> wordList2 = new ArrayList<String>();


				File modifier = new File("C:\\Users\\Nialys\\Documents\\Java File\\modifier.txt");
				File name = new File("C:\\Users\\Nialys\\Documents\\Java File\\Name.txt");

				FileReader nameReader = new FileReader(name);
				FileReader modifierReader = new FileReader(modifier);

				BufferedReader nbr = new BufferedReader(nameReader);
				BufferedReader mbr = new BufferedReader(modifierReader);

				String str;
				while((str = nbr.readLine()) != null) {
					wordList1.add(str);
				}
				while((str = mbr.readLine()) != null) {
					wordList2.add(str);
				}

				int maxWords1 = wordList1.size();
				int maxWords2 = wordList2.size();

				Random rnd = new Random();

				for(int i = 0;i<Integer.parseInt(args[0]);i++) {
					System.out.print(wordList2.get(rnd.nextInt(maxWords2)));
					System.out.println(wordList1.get(rnd.nextInt(maxWords1))+" ");
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("読み込み失敗");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("一行読み込み失敗");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("引数が設定されていません");
			e.printStackTrace();
		}

	}

}
