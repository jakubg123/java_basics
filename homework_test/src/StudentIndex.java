import java.util.*;

public class StudentIndex {
    private String surname;
    private int subjects;
    private List<Integer> marks;

    public StudentIndex(String surname, int subjects) {
        this.surname = surname;
        this.subjects = subjects;
        this.marks = new ArrayList<>();
    }

    public List<Integer> insertMarks(Scanner scanner) {
        System.out.println("Ile masz ocen");
        int numOfMarks = scanner.nextInt();

        for (int i = 0; i < numOfMarks; i++) {
            marks.add(scanner.nextInt());
        }
        scanner.close();
        return marks;
    }

    public void printMarks() {
        for (int data : marks) {
            System.out.println(data);
        }
    }

    public void describe() {
        System.out.println(surname);
        for (int mark : marks) {
            switch (mark) {
                case 2 -> {
                    System.out.println("Niedostateczny");
                }
                case 3 -> {
                    System.out.println("Dostateczny");
                }
                case 4 -> {
                    System.out.println("Dobry");
                }
                case 5 -> {
                    System.out.println("Bardzo dobry");
                }
                default -> {

                }
            }
        }
    }

    public int maxMark() {
        if (marks.isEmpty()) {
            return 0;
        }
        return Collections.max(marks);
    }

    public void notAcquired() {
        Set<Integer> foundMarks = new HashSet<>(marks);
        for (int mark = 2; mark <= 5; mark++) {
            if (!foundMarks.contains(mark)) {
                System.out.println("Brak oceny: " + mark);
            }
        }
    }


    public void addGrades(List<Integer> grades) throws StudentMarkException {

        for(int grade : grades){
            if(grade != 2 &&  grade != 3 && grade != 4 && grade != 5)
            {
                throw new StudentMarkException("Can't add that mark");
            }
            this.marks.add(grade);
        }

    }

    public double calculateAvg()
    {

        if(marks.isEmpty())
            return 0;

        double avg = 0;
        for(int mark : this.marks){
            avg+=mark;
        }


        return avg / marks.size();
    }


}