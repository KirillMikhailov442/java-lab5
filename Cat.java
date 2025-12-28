class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "cat: " + name;
    }

    public void meow() {
        System.out.println(name + ": meow!");
    }
}
