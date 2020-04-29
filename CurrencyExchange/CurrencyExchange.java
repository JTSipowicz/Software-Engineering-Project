package CurrencyExchange;

public class CurrencyExchange {

    //CurrentUser variable (create User class?)
    //Transaction variable (create Transaction class?)

    double USDtoEUR = .92;
    double EURtoUSD = 1/USDtoEUR;
    double USDtoYen = 107.27;
    double YentoUSD = 1/USDtoYen;
    double USDtoPound = .81;
    double PoundtoUSD = 1/USDtoPound;
    double EURtoYen = 116.13;
    double YentoEUR = 1/EURtoYen;
    double EURtoPound = .87;
    double PoundtoEUR = 1/EURtoPound;
    double YentoPound = .0075;
    double PoundtoYen = 1/YentoPound;

    void createTransaction(){

    }

    double transferBetweenCurrency(char currFrom, char currTo, double currencySpent){
        if(currFrom == 'u'){
            if(currTo == 'e'){
                currencySpent = currencySpent*USDtoEUR;
            } else if(currTo == 'y'){
                currencySpent = currencySpent*USDtoYen;
            } else{
                currencySpent = currencySpent*USDtoPound;
            }
        } else if(currFrom == 'e'){
            if(currTo == 'u'){
                currencySpent = currencySpent*EURtoUSD;
            } else if(currTo == 'y'){
                currencySpent = currencySpent*EURtoYen;
            } else{
                currencySpent = currencySpent*EURtoPound;
            }
        } else if(currFrom == 'y'){
            if(currTo == 'u'){
                currencySpent = currencySpent*YentoUSD;
            } else if(currTo == 'e'){
                currencySpent = currencySpent*YentoEUR;
            } else{
                currencySpent = currencySpent*YentoPound;
            }
        } else if(currFrom == 'p'){
            if(currTo == 'u'){
                currencySpent = currencySpent*PoundtoUSD;
            } else if(currTo == 'e'){
                currencySpent = currencySpent*PoundtoEUR;
            } else{
                currencySpent = currencySpent*PoundtoYen;
            }
        }
        return currencySpent;
    }

    double setCurrencyAfterFees(double currencySpent){
        double transactionFee, deliveryFee, taxFee;
        transactionFee = currencySpent*.01;
        deliveryFee = 10.0;
        taxFee = currencySpent*.0825;
        return currencySpent - transactionFee - deliveryFee - taxFee;
    }


}
