package task1;

import java.io.*;
import java.util.Vector;
public class Main {

    public static void main(String[] args) {

        Vector<Students> a = new Vector<Students>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("score.txt"));
            String line = br.readLine();
            while(line != null){
                String [] words = line.split(" ");
                String sname = words[0];
                String name = words[1];
                int score = Integer.decode(words[2]);

                Students fit = new Students(sname, name, score);

                a.add(fit);

                line = br.readLine();
            }

            br.close();

            for(Students fit: a){
                if(fit.getScore() >= 90) fit.setGrade("A");
                else if(fit.getScore() >= 80) fit.setGrade("B");
                else if(fit.getScore() >= 70) fit.setGrade("C");
                else if(fit.getScore() >= 60) fit.setGrade("D");
                else fit.setGrade("F");
            }

            try {
                BufferedWriter bf = new BufferedWriter(new FileWriter("grades.txt"));

                for (Students fit: a) {
                    bf.write(fit.getSname() + " ");
                    bf.write(fit.getName() + " ");
                    bf.write(fit.getGrade());

                    bf.newLine();
                }

                int max = a.get(0).getScore();
                int min = a.get(0).getScore();
                int sum = 0;

                for(int i = 0; i < a.size(); i++){
                    sum += a.get(i).getScore();
                    if(max < a.get(i).getScore())
                        max = a.get(i).getScore();
                    if(min > a.get(i).getScore())
                        min = a.get(i).getScore();
                }

                int average = sum/a.size();

                bf.newLine();

                bf.write(String.format("Average - %d", average));
                bf.newLine();

                bf.write(String.format("Maximum - %d", max));
                bf.newLine();

                bf.write(String.format("Minimum - %d", min));
                bf.newLine();


                bf.close();
            }
            catch (FileNotFoundException fe) {
                System.out.println("File not found");
            }
            catch (IOException e) {
                System.out.println("Cannot write to file");
            }
        }catch(FileNotFoundException fe){
            System.out.println("File not found");
        }catch(IOException ioe){
            System.out.println("Can't read from file");
        }

    }
}
