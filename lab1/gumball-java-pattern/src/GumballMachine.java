

public class GumballMachine {
 
	State soldOutState;
	State noCoinState;
	State hasCoinState;
	State soldState;
 
	State state = soldOutState;
	int numberGumballs = 0;
	int price = 0;
	int total = 0;
 
	public GumballMachine(int numberGumballs, int typeMachine) {
		soldOutState = new SoldOutState(this);
		noCoinState = new NoCoinState(this);
		hasCoinState = new HasCoinState(this);
		soldState = new SoldState(this);

		this.numberGumballs = numberGumballs;
		
		if (numberGumballs > 0) {
			state = noCoinState;
		} 
		
		if(typeMachine == 1){
			price = 25;
		}
		
		else if (typeMachine == 2){
			price = 50;
		}
		
		else if (typeMachine == 3){
			price = 50;
		}
		
 		
	}
 
	public void insertCoin(int coin) {
		state.insertCoin(coin);
	}
 
	public void ejectCoin() {
		state.ejectCoin();
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}
 
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (numberGumballs != 0) {
			numberGumballs = numberGumballs - 1;
		}
	}
 
	int getCount() {
		return numberGumballs;
	}
 
	void refill(int count) {
		this.numberGumballs = count;
		state = noCoinState;
	}

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getSoldState() {
        return soldState;
    }
    
    public int getPrice(){
    	return price;
    }
 
    public int getTotal(){
    	
    }
    
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + numberGumballs + " gumball");
		if (numberGumballs != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}
