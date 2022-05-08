import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

class MyClassLoad extends ClassLoader{

    public static void main(String[] args) {
        String className = "Hello";
        String methodName = "hello";
        MyClassLoad myClassLoad = new MyClassLoad();
        try {
            Class<?> aClass = myClassLoad.loadClass(className);
            for(Method m : aClass.getDeclaredMethods()){
                System.out.println(aClass.getSimpleName()+"." + m.getName());
            }

            Object o = aClass.getDeclaredConstructor().newInstance();
            Method method = aClass.getMethod(methodName);
            method.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String resourcesPath = name.replace(".","/");
        final String suffix = ".xlass";
        try (InputStream resourceAsStream = this.getClass().getClassLoader()
                .getResourceAsStream("Hello.xlass")) {
            int available = resourceAsStream.available();
            byte[] bytes = new byte[available];
            resourceAsStream.read(bytes);
            byte[] decode = decode(bytes);
            return defineClass(name, decode, 0, decode.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private static byte[] decode(byte[] array){
        byte[] nByte = new byte[array.length];
        for(int i=0;i<array.length;i++){
            nByte[i] = (byte)(255 - array[i]);
        }
        return nByte;
    }


}