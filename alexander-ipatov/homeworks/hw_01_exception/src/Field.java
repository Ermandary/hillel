public class Field {

    public static void main(String[] args) {
        Age user1 = new Age();

        try {
            user1.setAge(0);
        } catch (AgeException e) {
            e.printStackTrace();
        } finally {
            System.out.println("внутри finally");
        }
    }
}
