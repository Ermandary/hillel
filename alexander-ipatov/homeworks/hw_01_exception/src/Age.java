public class Age {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if (age < 8) {
            throw new AgeException("Неверный возраст");
        }
        throw new MyUncheckException();
    }
}
