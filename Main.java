import functions.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Тестирование переопределенных методов Object
            testObjectMethods();
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void testObjectMethods() {
        
        // Тестирование FunctionPoint
        System.out.println("\n1. ТЕСТИРОВАНИЕ FunctionPoint");
        FunctionPoint p1 = new FunctionPoint(1.0, 3.0);
        FunctionPoint p2 = new FunctionPoint(1.0, 3.0);
        FunctionPoint p3 = new FunctionPoint(1.5, 4.5);
        FunctionPoint p4 = new FunctionPoint(1.0, 2.0); // Разный Y
        
        System.out.println("p1: " + p1.toString());
        System.out.println("p2: " + p2.toString());
        System.out.println("p3: " + p3.toString());
        System.out.println("p4: " + p4.toString());
        
        System.out.println("\nСравнение точек:");
        System.out.println("p1.equals(p2): " + p1.equals(p2) + " (ожидается: true)");
        System.out.println("p1.equals(p3): " + p1.equals(p3) + " (ожидается: false)");
        System.out.println("p1.equals(p4): " + p1.equals(p4) + " (ожидается: false)");
        System.out.println("p1.equals(null): " + p1.equals(null) + " (ожидается: false)");
        System.out.println("p1.equals(\"строка\"): " + p1.equals("строка") + " (ожидается: false)");
        
        System.out.println("\nХэш-коды:");
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("p3.hashCode(): " + p3.hashCode());
        System.out.println("p4.hashCode(): " + p4.hashCode());
        
        System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode()) + " (ожидается: true)");
        System.out.println("p1.hashCode() == p3.hashCode(): " + (p1.hashCode() == p3.hashCode()) + " (ожидается: false)");
        System.out.println("p1.hashCode() == p4.hashCode(): " + (p1.hashCode() == p4.hashCode()) + " (ожидается: false)");
        
        FunctionPoint p1Clone = (FunctionPoint) p1.clone();
        System.out.println("\nКлонирование:");
        System.out.println("p1.clone().equals(p1): " + p1Clone.equals(p1) + " (ожидается: true)");
        System.out.println("p1 == p1.clone(): " + (p1 == p1Clone) + " (ожидается: false)");

        // Тестирование ArrayTabulatedFunction
        System.out.println("\n\n2. ТЕСТИРОВАНИЕ ArrayTabulatedFunction");
        FunctionPoint[] points1 = {
            new FunctionPoint(0, 1),
            new FunctionPoint(1, 3),
            new FunctionPoint(2, 5),
            new FunctionPoint(3, 7)
        };
        
        FunctionPoint[] points2 = {
            new FunctionPoint(0, 1),
            new FunctionPoint(1, 3),
            new FunctionPoint(2, 5),
            new FunctionPoint(3, 7)
        };
        
        FunctionPoint[] points3 = {
            new FunctionPoint(0, 1),
            new FunctionPoint(1, 2), // Разное значение Y
            new FunctionPoint(2, 5),
            new FunctionPoint(3, 7)
        };
        
        ArrayTabulatedFunction func1 = new ArrayTabulatedFunction(points1);
        ArrayTabulatedFunction func2 = new ArrayTabulatedFunction(points2);
        ArrayTabulatedFunction func3 = new ArrayTabulatedFunction(points3);
        
        System.out.println("func1: " + func1.toString());
        System.out.println("func2: " + func2.toString());
        System.out.println("func3: " + func3.toString());
        
        System.out.println("\nСравнение функций:");
        System.out.println("func1.equals(func2): " + func1.equals(func2) + " (ожидается: true)");
        System.out.println("func1.equals(func3): " + func1.equals(func3) + " (ожидается: false)");
        System.out.println("func1.equals(null): " + func1.equals(null) + " (ожидается: false)");
        System.out.println("func1.equals(\"строка\"): " + func1.equals("строка") + " (ожидается: false)");
        
        System.out.println("\nХэш-коды:");
        System.out.println("func1.hashCode(): " + func1.hashCode());
        System.out.println("func2.hashCode(): " + func2.hashCode());
        System.out.println("func3.hashCode(): " + func3.hashCode());
        System.out.println("func1.hashCode() == func2.hashCode(): " + (func1.hashCode() == func2.hashCode()) + " (ожидается: true)");
        System.out.println("func1.hashCode() == func3.hashCode(): " + (func1.hashCode() == func3.hashCode()) + " (ожидается: false)");
        System.out.println("func2.hashCode() == func3.hashCode(): " + (func2.hashCode() == func3.hashCode()) + " (ожидается: false)");
        
        ArrayTabulatedFunction func1Clone = (ArrayTabulatedFunction) func1.clone();
        System.out.println("\nКлонирование:");
        System.out.println("func1.clone().equals(func1): " + func1Clone.equals(func1) + " (ожидается: true)");
        System.out.println("func1 == func1.clone(): " + (func1 == func1Clone) + " (ожидается: false)");
        
        // Проверка глубокого клонирования
        System.out.println("\nПроверка глубокого клонирования (ArrayTabulatedFunction):");
        func1.setPointY(1, 999); // Изменяем исходный объект
        System.out.println("После изменения func1:");
        System.out.println("func1.getPointY(1): " + func1.getPointY(1) + " (ожидается: 999.0)");
        System.out.println("func1Clone.getPointY(1): " + func1Clone.getPointY(1) + " (ожидается: 1.0)");
        System.out.println("Клон не изменился: " + (func1Clone.getPointY(1) != 999) + " (ожидается: true)");

        // Тестирование LinkedListTabulatedFunction
        System.out.println("\n\n3. ТЕСТИРОВАНИЕ LinkedListTabulatedFunction");
        LinkedListTabulatedFunction listFunc1 = new LinkedListTabulatedFunction(points1);
        LinkedListTabulatedFunction listFunc2 = new LinkedListTabulatedFunction(points2);
        LinkedListTabulatedFunction listFunc3 = new LinkedListTabulatedFunction(points3);
        
        System.out.println("listFunc1: " + listFunc1.toString());
        System.out.println("listFunc2: " + listFunc2.toString());
        System.out.println("listFunc3: " + listFunc3.toString());
        
        System.out.println("\nСравнение функций:");
        System.out.println("listFunc1.equals(listFunc2): " + listFunc1.equals(listFunc2) + " (ожидается: true)");
        System.out.println("listFunc1.equals(listFunc3): " + listFunc1.equals(listFunc3) + " (ожидается: false)");
        System.out.println("listFunc1.equals(func1): " + listFunc1.equals(func1) + " (ожидается: false - разные классы)");
        
        System.out.println("\nХэш-коды:");
        System.out.println("listFunc1.hashCode(): " + listFunc1.hashCode());
        System.out.println("listFunc2.hashCode(): " + listFunc2.hashCode());
        System.out.println("listFunc3.hashCode(): " + listFunc3.hashCode());
        System.out.println("listFunc1.hashCode() == listFunc2.hashCode(): " + (listFunc1.hashCode() == listFunc2.hashCode()) + " (ожидается: true)");
        System.out.println("listFunc1.hashCode() == listFunc3.hashCode(): " + (listFunc1.hashCode() == listFunc3.hashCode()) + " (ожидается: false)");
        System.out.println("listFunc2.hashCode() == listFunc3.hashCode(): " + (listFunc2.hashCode() == listFunc3.hashCode()) + " (ожидается: false)");

        LinkedListTabulatedFunction listFunc1Clone = (LinkedListTabulatedFunction) listFunc1.clone();
        System.out.println("\nКлонирование:");
        System.out.println("listFunc1.clone().equals(listFunc1): " + listFunc1Clone.equals(listFunc1) + " (ожидается: true)");
        System.out.println("listFunc1 == listFunc1.clone(): " + (listFunc1 == listFunc1Clone) + " (ожидается: false)");
        
        // Проверка глубокого клонирования
        System.out.println("\nПроверка глубокого клонирования (LinkedListTabulatedFunction):");
        listFunc1.setPointY(1, 888); // Изменяем исходный объект
        System.out.println("После изменения listFunc1:");
        System.out.println("listFunc1.getPointY(1): " + listFunc1.getPointY(1) + " (ожидается: 888.0)");
        System.out.println("listFunc1Clone.getPointY(1): " + listFunc1Clone.getPointY(1) + " (ожидается: 1.0)");
        System.out.println("Клон не изменился: " + (listFunc1Clone.getPointY(1) != 888) + " (ожидается: true)");

        // Тестирование согласованности equals и hashCode
        System.out.println("\n\n4. ПРОВЕРКА СОГЛАСОВАННОСТИ equals() И hashCode()");
        FunctionPoint testPoint1 = new FunctionPoint(1.234, 5.678);
        FunctionPoint testPoint2 = new FunctionPoint(1.234, 5.678);
        FunctionPoint testPoint3 = new FunctionPoint(1.235, 5.678); // Небольшое изменение X
        
        System.out.println("testPoint1.equals(testPoint2): " + testPoint1.equals(testPoint2));
        System.out.println("testPoint1.hashCode() == testPoint2.hashCode(): " + 
            (testPoint1.hashCode() == testPoint2.hashCode()));
        
        System.out.println("testPoint1.equals(testPoint3): " + testPoint1.equals(testPoint3));
        System.out.println("testPoint1.hashCode() == testPoint3.hashCode(): " + 
            (testPoint1.hashCode() == testPoint3.hashCode()));
        System.out.println("Изменение хэш-кода при небольшом изменении координат: " + 
            (testPoint1.hashCode() != testPoint3.hashCode()));

        // Тестирование с разным количеством точек
        System.out.println("\n\n5. ТЕСТИРОВАНИЕ С РАЗНЫМ КОЛИЧЕСТВОМ ТОЧЕК");
        FunctionPoint[] points4 = {
            new FunctionPoint(0, 0),
            new FunctionPoint(1, 1),
            new FunctionPoint(2, 4)
        };
        
        ArrayTabulatedFunction func4 = new ArrayTabulatedFunction(points4);
        System.out.println("func1 (4 точки): " + func1.toString());
        System.out.println("func4 (3 точки): " + func4.toString());
        System.out.println("func1.equals(func4): " + func1.equals(func4) + " (ожидается: false)");
        System.out.println("func1.hashCode() == func4.hashCode(): " + (func1.hashCode() == func4.hashCode()) + " (ожидается: false)");
    }
}
