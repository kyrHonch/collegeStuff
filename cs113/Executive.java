package cs113;

public class Executive extends Employee
{
    private double bonus;
    //-----------------------------------------------------------------
//  Sets up an executive with the specified information.
//-----------------------------------------------------------------
    public Executive (String eName, String eAddress, String ePhone,
                      String socSecNumber, double rate)
    {
        super (eName, eAddress, ePhone, socSecNumber, rate);
        bonus = 0;  // bonus has yet to be awarded
    }
    //-----------------------------------------------------------------
//  Awards the specified bonus to this executive.
//-----------------------------------------------------------------
    public void awardBonus (double execBonus) throws BonusTooLowException
    {
        if(execBonus < 2000.0){
            throw new BonusTooLowException("Bonus amount cannot be less than $2000.");
        }
        bonus = execBonus;
    }
    //-----------------------------------------------------------------
//  Computes and returns the pay for an executive, which is the
//  regular employee payment plus a one-time bonus.
//-----------------------------------------------------------------
    public double pay()
    {
        double payment = super.pay() + bonus;
        bonus = 0;
        return payment;
    }

    public int vacation(){
        return super.vacation() + 7;
    }

    public String toString(){
        return super.toString() + (bonus==0 ? "" : "\nBonus: " + bonus);
    }
}