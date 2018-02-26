package com.imooc.reflect;

import java.lang.reflect.Method;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.imooc.reflect
 * @Description:Class 类的基本API操作
 * @date 2018/2/26 下午10:46
 */
public class ClassUtil {

    /**
     * 打印类的信息，包括类的成员函数，成员变量
     * @param obj 该对象所属类的信息
     */
    public static void pringClassMessage(Object obj){
        //要获取类的信息，首先要获取类的类类型
        Class c = obj.getClass();//传递的是哪个子类的对象，c就是该子类的类类型
        //获取类的名称
        System.out.println("类的名称：" + c.getName());
        /**
         * Method类，方法对象
         * 一个成员方法就是一个Method对象
         * getMethods()方法获取的所有的public的函数，包括父类继承过来的
         * getDeclaredMethods()获取的是所有该类自己声明的方法，不管访问权限
         */
        Method[] ms = c.getMethods();//c.etDeclaredMethods()
        for(int i=0; i<ms.length; i++){
            //得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            //得到方法的名称
            System.out.print(ms[i].getName() + "(");
            //获取参数类型，得到的是参数列表的类型的类类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for(Class class1:paramTypes){
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }

    }
}
