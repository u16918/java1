package MyProgect.Test.T9_1;

class Person {
    public String name;
    public Person(String name) {
        this.name = name;
    }

    abstract static class PersonCompare {
        public int compare(Person p1, Person p2) {
            return 0;
        }
    }

    public static void main(String[] args) {

        PersonCompare personCompare =
                new PersonCompare(){
                    @Override
                   public int compare(Person p1, Person p2) {
                        return p1.name.compareTo(p2.name);
                    }
                };
        System.out.println(personCompare);
        System.out.println(new Person("num").name);
    }
}