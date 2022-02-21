package Exercise3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {

        ArrayList<Team> ft_obj=new ArrayList<>();
        ArrayList<Team> bb_obj=new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Exercise3/teams.csv"));
            String line="";

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data[0].equals("Football")) {
                    Football ft = new Football(data[1], Integer.parseInt(data[2]), data[3]);
                    ft_obj.add(ft);
                }
                else{
                    Basketball bb = new Basketball(data[1], Integer.parseInt(data[2]));
                    bb_obj.add(bb);
                }
            }
            br.close();


            Collections.sort(ft_obj, Comparator.comparing(Team::getPoints));
            Collections.reverse(ft_obj);
            System.out.println("Football Previous Standing:");
            System.out.println("  ");
            for(Team o:ft_obj) {
                System.out.println(o.getTeamName()+"-->"+o.getPoints()+"-->"+o.getSponser());
            }
            System.out.println("  ");

            Collections.sort(bb_obj, Comparator.comparing(Team::getPoints));
            Collections.reverse(bb_obj);
            System.out.println("Basketball Previous Standing:");
            System.out.println("  ");
            for(Team o:bb_obj) {
                System.out.println(o.getTeamName()+"-->"+o.getPoints());
            }
            System.out.println("  ");


            BufferedReader br1 = new BufferedReader(new FileReader("src/main/resources/Exercise3/results.csv"));
            String line2;

            while ((line2 = br1.readLine()) != null) {
                String[] data1 = line2.split(",");
                for(Team o:ft_obj) {
                    if(data1[0].equals(o.getTeamName())) {
                        o.updatePoints(data1[1]);
                    }
                }
                for(Team o:bb_obj) {
                    if(data1[0].equals(o.getTeamName())) {
                        o.updatePoints(data1[1]);
                    }
                }
            }
            br1.close();

            Collections.sort(ft_obj, Comparator.comparing(Team::getPoints));
            Collections.reverse(ft_obj);
            System.out.println("************************************************************************************");

            System.out.println("Football Current Standing:");
            System.out.println("  ");
            for(Team o:ft_obj) {
                System.out.println(o.getTeamName()+"-->"+o.getPoints()+"-->"+o.getSponser());
            }
            System.out.println("  ");

            Collections.sort(bb_obj, Comparator.comparing(Team::getPoints));
            Collections.reverse(bb_obj);
            System.out.println("Basketball Current Standing:");
            System.out.println("  ");
            for(Team o:bb_obj) {
                System.out.println(o.getTeamName()+"-->"+o.getPoints());
            }
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
}
