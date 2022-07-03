public class Player {
    private String name;
    private int points;
    private String emotion;
    private boolean isVirtual = false;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public Player(String name, int points, String emotion, boolean isVirtual) {
        this(name, points);
        this.emotion = emotion;
        this.isVirtual = isVirtual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getEmotion() {
        return emotion;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

}
