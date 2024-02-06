import java.awt.*;

public class Food {
    public Rect background;
    public Snake snake;
    public int width, height;
    public Color color;
    public Rect rect;
    public int xPadding;

    public boolean isSpawned = false;

    public Food(Rect background, Snake snake, int width, int height, Color color) {
        this.background = background;
        this.snake = snake;
        this.width = width;
        this.height = height;
        this.color = color;
        this.rect = new Rect(0, 0, width, height);

        xPadding = (int) (Contants.TITLE_WIDTH - this.width / 2.0);
    }

    public void spawn() {
        do {
            double randX = (int) (Math.random() * (int) (background.width / Contants.TITLE_WIDTH)) * Contants.TITLE_WIDTH + background.x;
            double randY = (int) (Math.random() * (int) (background.height / Contants.TITLE_WIDTH)) * Contants.TITLE_WIDTH + background.y;
            this.rect.x = randX;
            this.rect.y = randY = 0.0;
        } while (snake.intersectingWithRect(this.rect));
        this.isSpawned = true;
    }

    public void update(double dt) {
        if (snake.intersectingWithRect(this.rect)) {
            snake.grow();
            this.rect.x = -100;
            this.rect.y = -100;
            isSpawned = false;
        }
    }
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect((int) this.rect.x + xPadding, (int) this.rect.y + xPadding, width, height);
    }
}
