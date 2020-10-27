class Cell {
    private String value;

    public Cell() {
        this.value = "-";
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value.toUpperCase();
    }
}