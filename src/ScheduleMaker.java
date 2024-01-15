import java.util.*;

public class ScheduleMaker
{
    Scanner scan=new Scanner(System.in);
    ArrayList <String> teams=new ArrayList<>();
    ArrayList <String> coupleTeams=new ArrayList<>();
    int counter=0;

    Random random=new Random();


    public void run()
    {

        boolean status=true;
        while (status)
        {

            System.out.println("""
                Lütfen yapmak istediğiniz işlemi seçiniz:\s
                1-Takım ekleme
                2-Fikstür oluşturma
                0-Çıkış""");

            System.out.println("--------------------");
            int choose=scan.nextInt();


            switch (choose) {
                case 1 : {
                    System.out.print("Eklenecek olan takımın adını giriniz: ");
                    scan.nextLine();
                    String team = scan.nextLine();
                    teams.add(team);
                    System.out.println("Takım eklendi -> " + teams.get(teams.size() - 1));
                    System.out.println("--------------------");
                }
                    break;
                case 2: makeSchedule();
                    break;
                case 0: status = false;
                    break;
                default: System.out.println("Lütfen Geçerli Bir Değer Giriniz!");
                    break;
            }
        }
    }

    public void makeSchedule() {
        if(teams.size() % 2 != 0) {
            teams.add("BAY");
        }

        for(int i = 0; i < teams.size() - 1; i++) {
            String home;
            String away;
            int match = 0;
            String selectedTeams = "";

            while(match < teams.size() / 2) {
                home = teams.get(random.nextInt(teams.size()));
                away = teams.get(random.nextInt(teams.size()));
                    if(!home.equals(away)) {
                        if(!selectedTeams.contains(home) && !selectedTeams.contains(away)) {
                            String match1 = home + " vs " + away;
                            String match2 = away + " vs " + home;

                                if(!coupleTeams.contains(match1) && !coupleTeams.contains(match2)) {
                                    coupleTeams.add(match1);
                                    coupleTeams.add(match2);

                                    selectedTeams += home;
                                    selectedTeams += away;

                                    match++;
                                }
                        }
                    }
            }
        }

        printFixture();
    }

    public void printFixture() {
        for(int i = 0; i < coupleTeams.size(); i +=2) {
            counter++;

            System.out.println("--------Fixture "+counter+"--------");
            int fixtureCounter = 0;
                while(fixtureCounter < teams.size() / 2) {
                    System.out.println(coupleTeams.get(i));
                    fixtureCounter++;
                    i += 2;
                        if(i>=coupleTeams.size()) {
                            break;
                        }
                }
                i -=2;
                System.out.println();
        }

        for (int bringMeet=1;bringMeet<coupleTeams.size();bringMeet+=2)
        {
           
            counter++;
            System.out.println("--------Fixture "+counter+"--------");
            int fixtureCounter=0;
            while (fixtureCounter<teams.size()/2)
            {
                System.out.println(coupleTeams.get(bringMeet));
                fixtureCounter++;
                bringMeet+=2;

                if (bringMeet>=coupleTeams.size())
                {
                    break;
                }
            }
            bringMeet-=2;
            System.out.println();
        }
    }
}