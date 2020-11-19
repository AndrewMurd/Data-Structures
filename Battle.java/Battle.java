public class Battle
{
    public static void main(String[] args) 
    {
        float kroggAttack = 38.5f;
        float kroggDefense = 20.0f;
        float kroggHP = 200f;
        float bossAttack = 25f;
        float bossDefense = 12.5f;
        float bossHP = 200f;
        int round = 1;

        while (bossHP > 0 && kroggHP > 0)
        {
            float damageBoss = kroggAttack - bossDefense;
            bossHP = bossHP - damageBoss;
            float damageKrogg = bossAttack - kroggDefense;
            kroggHP = kroggHP - damageKrogg;
            round++;
            System.out.print("Round " + round + "\n" + "Krogg does " + damageBoss + " points of damage to Boss\n" 
            + "Boss does " + damageKrogg +" points of damage to Krogg\n"
            + "Boss: " +bossHP
            + "Krogg: " + kroggHP + "\n\n");
        }
        if (bossHP <= 0)
        {
            System.out.println("Krogg has won. You are victorious!");
        } else
        {
            System.out.println("Boss has won. You are victorious!");
        }
    }
}