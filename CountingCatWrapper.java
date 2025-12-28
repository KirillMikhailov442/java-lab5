class CountingCatWrapper implements Meowable {
    private final Cat cat;
    private int meowCount = 0;

    public CountingCatWrapper(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void meow() {
        cat.meow();
        meowCount++;
    }

    public int getMeowCount() {
        return meowCount;
    }
}