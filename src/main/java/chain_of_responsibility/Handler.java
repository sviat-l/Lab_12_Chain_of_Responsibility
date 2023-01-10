package chain_of_responsibility;

public abstract class Handler {
    public int quintity;
    private Handler next;

    public Handler(int quintity){
        this.quintity = quintity;
    }

    public void setNext(Handler next){
        this.next = next;
    }

    public void process(int amount) throws IllegalArgumentException{
        if (next != null){
            next.process(amount%quintity);
        } else if (amount%quintity>0){
            throw new IllegalArgumentException();
        }
        System.out.println(quintity + " * " + amount/quintity);
    }
}
