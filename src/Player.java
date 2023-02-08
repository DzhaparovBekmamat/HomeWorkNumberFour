public class Player {
        private int health;
        private final String name;
        
        public Player(int health, String name) {
            this.health = health;
            this.name = name;
        }
        
        public int getHealth() {
            return this.health;   
        }
        
        public void setHealth(int health) {
            this.health = health;
        }
        
        public String getName() {
            return this.name;
        }
        
         public void setName(int health) {
            this.name = name;
    }
        
    class Medic extends Player {
        private final int healingPower;
        public Medic(int health, String name, int healingPower) {
            super(health, name);
            this.healingPower = healingPower;
        }
            
        public void heal(Player player) {
            if (player.getHealth() < 100 && this.getHealth() > 0 && player != this) {
                player.setHealth(player.getHealth() + this.healingPower);
            }
        }
        public void takeDamage() {
        }
    }
        
    class Golem extends Player {
        public Golem(int health, String name) {
            super(health, name);
        }
            
        public void takeDamage(int damage) {
            int reducedDamage = (int) Math.round(damage * 0.8);
            this.setHealth(this.getHealth() - reducedDamage);
        }
    }
        
    class Thor extends Player {
        public Thor(int health, String name) {
            super(health, name);
        }
        public boolean stun() {
            double chance = Math.random();
            if (chance <= 0.3) {
                System.out.println("Thor has stunned the boss!");
                return true;
            }
            return false;
        }
    }
        
    class Team {
        private Player[] players;
        private Medic medic;
        public Team(Player[] players, Medic medic) {
            this.players = players;
            this.medic = medic;
        }
        public void takeDamage(int damage) {
            for (Player player : players) {
                player.setHealth(player.getHealth() - damage);
            }
            medic.takeDamage();
        }
        public void heal() {
            for (Player player : players) {
                if (player.getHealth() < 100) {
                    medic.heal(player);
                    break;
                }
            }
        }
            
        public boolean stun() {
            for (Player player : players) {
                if (player instanceof Thor) {
                    return ((Thor) player).stun();
                }
            }
            return false;
        }
            
        public void printTeamStatus() {
            for (Player player : players) {
                System.out.println(player.getName() + ": " + player.getHealth() + " health");
            }
            System.out.println("Medic: " + medic.getName() + ": " + medic.getHealth() + " health");
        }
    }

