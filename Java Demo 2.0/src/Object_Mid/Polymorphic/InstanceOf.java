package Object_Mid.Polymorphic;

//instanceof的使用: 判断对象的运行类型是否是一个XX类型,或是它的子类型。

class AA {}
class BB extends AA {}

class instanceOf {
    public static void main(String[] args) {
        BB bb = new BB();
        System.out.println(bb instanceof BB);   //true
        System.out.println(bb instanceof AA);   //true

        AA aa = new BB();
        System.out.println(aa instanceof BB);   //true
        System.out.println(aa instanceof AA);   //true
    }
}
