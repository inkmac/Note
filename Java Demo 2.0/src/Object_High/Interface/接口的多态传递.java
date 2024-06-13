package Object_High.Interface;

//接口的多态传递: 多态怎么用, 接口就怎么用

class InterfacePolyPass {
    public static void main(String[] args) {
        IB ib = new Manager();
        //如果IB继承了IA, 那Manager就变相的需要实现了IA接口
        IA ia = new Manager();
    }
}

interface IA {}
interface IB extends IA{}
class Manager implements IB {}
// 继承接口时,接口 IB 会自动包含接口 IA 中定义的所有方法
// 需要提供 IA 和 IB 的具体实现