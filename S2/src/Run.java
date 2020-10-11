public class Run {
    public static void main(String[] args) {
        Student std1 = new Student("Ehsan", "Edalat", "999999");
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
        Student std3 = new Student("Ahmad", "Asadi", "9031054");

        std1.setGrade(15);
        std1.print();

        std2.setGrade(11);
        std2.print();

        std3.setFirstName("HamidReza");
        std3.setGrade(12);
        std3.print();
    }
}


