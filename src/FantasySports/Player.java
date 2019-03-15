package FantasySports;

public class Player implements SportProfessional {

    private String name;
    private int hardness; //1-10 On The Moe's Scale Of Hardness
    private int weight; //1-100 Kilograms
    private int chutzpah; //1-200 Chutzpah Points
    private int luster; //1-10 Arbitrary Scale
    private String catchphrase; //Random Catchphrase String for Giggles
    private int catchphraseRating; //1-10 Based On How Good/Bad It Is; 1 = Good, 10 = Bad

    private int Strength;

    @Override
    public int modifyStrength(int strength) {

        int newStrength = strength;

        newStrength += (.5 * hardness); //Adds 1/2 Times Hardness
        newStrength += (.25 * luster); //Adds 1/4 Times Luster
        newStrength -= catchphraseRating; //Subtracts Catchphrase Rating
        newStrength *= (.01 * chutzpah); //Multiplies By 1/100 The Chutzpah

        return newStrength;

    }
}
