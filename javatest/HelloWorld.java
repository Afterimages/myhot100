

class HelloWorld {    
    public static void main(String[] arg){
        Animal a1 = new Animal("Sophia",18); // 创建一个类的实例
        System.out.println(a1.getName());
        a1.setName("new name");

        System.out.println(a1.getName());

        Cat c1 = new Cat("rose",2,"white");
        c1.eat();
        c1.eat("fish");
        c1.SayHi();
    }
}

class Animal{
    private String name = "zhangsan"; //私有化属性，使得属性无法在外部修改(但构造函数的参数能传入，只是不能使用)，即如果使用了构造方法创造实例，当在类外使用类内的私有化参数（a1.name或a1.age）就会报错
    private int age = 10;

    // 构造方法，需要与类同名，这样在使用构造方法创建实例的时候就能接收传入的参数，通过this作为实例属性
    public Animal(String name, int age){
        this.name = name; //添加属性并赋予默认值
        this.age = age;
    }

    public void SayHi(){
        System.out.println("你好"+this.name);
    }
    public void eat(){
        System.out.println(this.name+"正在吃饭");
    }
    
    // 使用getset函数，这样即使属性private私有化了也能在外部使用和修改属性
    public String getName(){
        return this.name;
    }

    public void setName(String newValue){
        this.name = newValue;
    }
}

class Cat extends Animal{
    private String skinColor;
    public Cat(String name, int age,String skinColor){ // 还可以为子类添加新属性
        super(name,age);// 调用父类的构造方法，继承属性，传入可能存在的参数
        this.skinColor = skinColor;
    }
    @Override
    public void SayHi(){
        System.out.println("喵！我的名字叫做"+super.getName());
    }
    
    public void eat(String item){
        System.out.println("I am eating"+item);
    }
}

// class Animal{
//     String name = "zhangsan";
//     int age = 10;

//     // 构造方法，需要与类同名，这样在使用构造方法创建实例的时候就能接收传入的参数，通过this作为实例属性
//     public Animal(String name, int age){
//         this.name = name; //添加属性并赋予默认值
//         this.age = age;
//     }
// }
