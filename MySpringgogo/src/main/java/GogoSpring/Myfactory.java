package GogoSpring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface Myfactory {

  static Object createService(Object realObject) {
    InvocationHandler handler =
        (proxy, method, args) -> {
          Method method1 =
              realObject.getClass().getMethod(method.getName(), method.getParameterTypes());
          Object object;

          if (method1.getAnnotation(MytimeStart.class) != null) {

            long startTime = System.nanoTime();
            object = method.invoke(realObject, args);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("MyTime Start = " + startTime);
            System.out.println("My Time End = " + endTime);
            System.out.println("Duration = " + duration);

          } else {
            object = method.invoke(realObject, args);
          }

          return object;
        };

    ClassLoader classLoader = realObject.getClass().getClassLoader();
    Class[] classes = realObject.getClass().getInterfaces();
    Object time = Proxy.newProxyInstance(classLoader, classes, handler);
    return time;
  }
}
