public class Character {
    private final int maxHealth;
    private int health;

    Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    void heal(int amount) {
        health += amount;
        if (health > maxHealth) health = maxHealth;
    }

    int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("After damage: " + c.getHealth());
        c.heal(50);
        System.out.println("After heal (capped): " + c.getHealth());
        c.takeDamage(150);
        System.out.println("After big damage (floored): " + c.getHealth());
    }
}
