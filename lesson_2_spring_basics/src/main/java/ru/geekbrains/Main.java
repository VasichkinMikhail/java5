package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        CartService cart = context.getBean("cartService", CartService.class);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Здравствуйте!!!\n Список товаров:");
        System.out.println(productRepository.findAll().toString());
        do {
            System.out.println("Если Вы хотите добавить товар в корзину введите Add\n" +
                    "Если Вы хотите удалить товар из корзины введите Del\n" +
                    "Если Вы хотите выйти введите Ex\n" +
                    "Узнать что в Вашей корзине Cart...");
            String answer = bufferedReader.readLine();
            if (answer.equals("Ex")) {
                break;
            } else if (answer.equals("Del")) {
                Scanner scannerInput = new Scanner(System.in);
                Product product = new Product();
                System.out.println("Какой товар Вы хотите удалить? Введите id ...");
                long id = scannerInput.nextLong();
                product.setId(id);
                if (!product.getId().equals(productRepository.findById(id))) {
                    System.out.println("Введите корректные данные");
                } else {
                    cart.removeFromCart(id);
                }
                }else if (answer.equals("Cart")) {
                System.out.println(cart.findAll().toString());
            } else if (answer.equals("Add")) {
                Scanner scannerInput = new Scanner(System.in);
                Product product = new Product();
                System.out.println("Какой товар Вы хотите добавить? Введите id ...");
                long id = scannerInput.nextLong();
                product.setId(id);
                if (!product.getId().equals(productRepository.findById(id))) {
                    System.out.println("Введите корректные данные");
                } else {
                    cart.addToCart(productRepository.findById(id));
                }
            }
            context.close();
        } while (true);
    }
}

