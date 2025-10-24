import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Exercise1 {
    public static void main(String[] args) {
        double efficiencyMilesPerGallon = 30;
        double milesIn1Km = 0.6214;
        double costPerLitre = 1.34;
        double litresInAPint = 0.5683;
        double pintsInAGallon = 8;

        // efficiency of the vehicle in km per gallon to two decimal places
        DecimalFormat twoDp = new DecimalFormat("0.##");
        double kmPerGallon = efficiencyMilesPerGallon / milesIn1Km;
        System.out.println("The efficiency of the vehicle in kilometers per gallon"
                            +" to an accuracy of 2 decimal places is: " + twoDp.format(kmPerGallon));

        // the distance travelled per litre of petrol to the nearest meter
        double metersPerGallon = kmPerGallon * 1000;
        double litresInAGallon = litresInAPint * pintsInAGallon;
        int metersPerLitre = (int)metersPerGallon/(int)litresInAGallon;
        System.out.println("The distance travelled per litre of petrol"
                            + " to the nearest meter is " + metersPerLitre);

        // cost of driving 100 km
        double kmPerLitre = (double)metersPerLitre/1000;
        double costOfDriving = (100/kmPerLitre) * costPerLitre;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("The cost of driving 100 km is " + currency.format(costOfDriving));
    }
}