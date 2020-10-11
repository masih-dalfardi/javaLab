public class Daneshkade {
    // sal vorodi mored nazar
    private int year;
    //shmare daneshjoii
    private int ID;
    //tedad vorodi har sal
    private int Cap;
    //moadel daneshjoian har dore
    private double avg;
    //tedad daneshjoiane eskan grfte dore dar khabgah
    private int esk;
    //saat lab baraie har dore
    private String labti;
    //nesbate daneshjoian khabgahi b daneshjoian sakene tehran
    private double per;

    /**
     * Create a new daneshkade with a given year and cap number.
     *
     * @param yr1 the desired year
     */
    public Daneshkade(int yr1, int esk1) {
        year = yr1;
        esk = esk1;
    }

    public int getCap() {

        return Cap;
    }

    public void setCap(int Cap1) {

        Cap = Cap1;
    }

    public double getAvg() {

        return avg;
    }

    public void setAvg(double avg1) {

        avg = avg1;
    }

    public String getLabti() {

        return labti;
    }

    public void setLabti(String labti1) {
        labti = labti1;
    }

    public void findper(int esk,int cap) {
        per = ((esk / Cap)*100) ;


    }

    public void print() {
        System.out.printf("considered year :" + year + "\ncourse capacity :" + Cap + "\nAVG of students :" + avg + "\nnesbate tedade daneshjoiane khabgahi b sakene tehran :" + per + "\nroze LAB danshjoiane dore:" + labti);

    }


}