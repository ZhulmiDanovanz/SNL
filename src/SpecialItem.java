/**
 * -----------------------------------------------------
// * ES234211 - Programming Fundamental
// * Genap - 2023/2024
// * Group Capstone Project: Snake and Ladder Game
// * -----------------------------------------------------
// * Class    : C
// * Group    : 15
// * Members  :
// * 1. 5026231227 - Arjuna Veetaraq
// * 2. 5026231172 - M. Zhulmi Danovanz Hidanasukha
// * 3. 5026231192 - Ikhwanul Hafidz
// * ------------------------------------------------------
// */
//SpecialItem.java

public abstract class SpecialItem {
    private String userName;
    private boolean used;

    public SpecialItem(String name) {
        this.userName = name;
        this.used = false;
    }

    public String getName() {
        return userName;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public abstract void use(Player player);

    // SnakeReversalItem.java
    public class SnakeReversalItem extends SpecialItem {
        public SnakeReversalItem() {
            super("Snake Reversal");
        }

        @Override
        public void use(Player player) {
            // Implementasi khusus untuk mengubah arah ular jika pemain mendarat di kepala ular
            int currentPosition = player.getPosition();
            // Kode untuk membalikkan posisi pemain jika diperlukan
            System.out.println("Player " + player.getUserName() + " used Snake Reversal item.");
        }

        // DoubleMoveItem.java
        public class DoubleMoveItem extends SpecialItem {
            public DoubleMoveItem() {
                super("Double Move");
            }

            @Override
            public void use(Player player) {
                // Implementasi untuk mengizinkan pemain bergerak dua kali dalam satu giliran
                int currentPosition = player.getPosition();
                // Kode untuk memperbolehkan pemain melempar dadu dua kali dan menghitung total langkah
                System.out.println("Player " + player.getUserName() + " used Double Move item.");
            }
        }

        // SnakeRepellentItem.java
        public class SnakeRepellentItem extends SpecialItem {
            public SnakeRepellentItem() {
                super("Snake Repellent");
            }

            @Override
            public void use(Player player) {
                // Implementasi untuk melindungi pemain dari tergigit ular sekali
                int currentPosition = player.getPosition();
                // Kode untuk memeriksa dan menangani pemain saat mendarat di kepala ular
                System.out.println("Player " + player.getUserName() + " used Snake Repellent item.");
            }
        }
    }
}