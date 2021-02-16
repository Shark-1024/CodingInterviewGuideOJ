import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hanlin.zhou
 * @date 2021/2/16 16:19
 */
public class CatDogQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long sum = Long.parseLong(bufferedReader.readLine());
        MyQueue catDogQueue = new MyQueue();
        for (int i=0;i<sum;i++){
            String[] readLine = bufferedReader.readLine().trim().split(" ");
            if("add".equals(readLine[0])){
                Pet pet;
                if ("cat".equals(readLine[1])){
                    pet = new Cat(Long.parseLong(readLine[2]));
                } else{
                    pet = new Dog(Long.parseLong(readLine[2]));
                }
                catDogQueue.add(pet);
            } else {
                switch(readLine[0]){
                    case "pollAll":
                        catDogQueue.pollAll();
                        break;
                    case "pollDog":
                        catDogQueue.pollDog();
                        break;
                    case "pollCat":
                        catDogQueue.pollCat();
                        break;
                    case "isEmpty":
                        System.out.println(catDogQueue.isEmpty() ? "yes" : "no");
                        break;
                    case "isDogEmpty":
                        System.out.println(catDogQueue.isDogEmpty() ? "yes" : "no");
                        break;
                    case "isCatEmpty":
                        System.out.println(catDogQueue.isCatEmpty() ? "yes" : "no");
                        break;
                }
            }
        }
        bufferedReader.close();
    }

}

class MyQueue{
    private long rank;
    private Queue<PetEnterQueue> catQueue;
    private Queue<PetEnterQueue> dogQueue;

    MyQueue(){
        this.catQueue = new LinkedList<>();
        this.dogQueue = new LinkedList<>();
        rank = 0L;
    }

    public void add(Pet pet){
        PetEnterQueue petEnter = new PetEnterQueue(pet, rank++);
        if ("cat".equals(pet.getType())){
            catQueue.add(petEnter);
        } else if("dog".equals(pet.getType())){
            dogQueue.add(petEnter);
        }
    }

    public void pollAll(){
        while (!catQueue.isEmpty() || !dogQueue.isEmpty()){
            long catCount = catQueue.isEmpty() ? Long.MAX_VALUE : catQueue.peek().getRank();
            long dogCount = dogQueue.isEmpty() ? Long.MAX_VALUE : dogQueue.peek().getRank();
            PetEnterQueue petEnter = catCount < dogCount ? catQueue.poll() : dogQueue.poll();
            System.out.println(petEnter.getPet().getType() + " " + petEnter.getPet().getNo());
        }
    }

    public void pollDog(){
        while(!dogQueue.isEmpty()){
            PetEnterQueue petEnter = dogQueue.poll();
            System.out.println(petEnter.getPet().getType() + " " + petEnter.getPet().getNo());
        }
    }

    public void pollCat(){
        while(!catQueue.isEmpty()){
            PetEnterQueue petEnter = catQueue.poll();
            System.out.println(petEnter.getPet().getType() + " " + petEnter.getPet().getNo());
        }
    }

    public boolean isEmpty(){
        return isDogEmpty() && isCatEmpty();
    }

    public boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return catQueue.isEmpty();
    }


}

class PetEnterQueue{
    /**
     * rank  记录出入队列的先后顺序
     * no  用来区分狗与狗，猫与猫
     */
    private long rank;
    private Pet pet;

    PetEnterQueue(Pet pet, long count){
        this.pet = pet;
        this.rank = count;
    }

    public long getRank() {
        return rank;
    }

    public Pet getPet() {
        return pet;
    }
}

class Pet{
    private String type;
    private long no;

    Pet(String type, long no){
        this.type = type;
        this.no = no;
    }

    public String getType(){
        return this.type;
    }

    public long getNo() {
        return no;
    }
}

class Cat extends Pet{
    Cat(long no){
        super("cat", no);
    }
}

class Dog extends Pet{
    Dog(long no){
        super("dog", no);
    }
}
