package ru.avalon.java.dev.ocpjp.labs;

import ru.avalon.java.dev.ocpjp.labs.models.Commodity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        final Collection<Commodity> commodities = Commodity.random(100);
      
        /*
         * TODO(Студент): С использованием Java Stream API выполнить задачи из списка:
         * 1. Выполнить поиск самого дорого товара
         * 2. Найти товары с минимальным остатком
         * 3. Найти товары с остатком меньшим 5 и вывести в консоль их названия
         * 4. Подсчитать общую стоимость товаров с учётом их остатка
         * 5. Найти товар, с самым длинным названием и вывести его на экран
         * 6. Выполнить сортировку коллекции commodities
         * 7. Найти среднюю стоимость товаров
         * 8. Найти моду (медиану) стоимости товаров
         */
        
        System.out.println(commodities.stream()
                        .map((s)-> s.getPrice())
                        .max(Double::compare)
                        .toString());
        
         System.out.println(commodities.stream()
                        .map((s)-> s.getResidue())
                        .min(Integer::compare)
                        .toString());
         
        commodities.stream()
                        .filter((s) -> (s.getResidue()) < 5)
                        .forEach((s) -> System.out.println(s.getName()));
                                
            
         System.out.println(commodities.stream()
                 .mapToDouble((s)-> (s.getResidue() * s.getPrice()))
                 .sum()
                 );
         
                 
         System.out.println(commodities.stream()
                        .mapToInt((s)-> s.getName().length())
                        .max());
                 
         System.out.println(commodities.stream()
                        .sorted());

                 
         System.out.println(commodities.stream()
                        .mapToDouble((s)-> s.getPrice())
                        .average());

                 
        List list  = commodities.stream()
                        .map((s)-> s.getPrice())
                        .collect(Collectors.toList());                               
         
        if(list.size()%2 != 0){
            System.out.println(list.get((int) Math.ceil(list.size()/2)).toString());
        } else {
            System.out.println(list.get((int)(list.size()/2)).toString());
        }
       }
}
