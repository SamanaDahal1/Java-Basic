package oop;
/*
### Q7: Constructor Overloading

Create a `Book` class with:

* `title`
* `author`
* `price`

Create **2 constructors**:

1. A constructor that takes `title` and `author`.
2. A constructor that takes `title`, `author`, and `price`.

Create:

* `displayBook()` → display the book details.

In `main()`:

* Create one book using each constructor.
* Display both books.

**🆕 New concept:** **Constructor overloading** — same constructor name, but different parameters.

 */

class Book{
    String title;
    String author;
    int price;

    Book(String title,String author){
        this.title=title;
        this.author=author;

    }
    Book(String title,String author,int price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public void displayBook(){
        System.out.printf("Title: %s\nAuthor: %s\nPrice: %d\n",title,author,price);
    }

}
public class QuestionSeven {
    public static void main(String[] args){
        Book book1 = new Book("Summer","Harry Zen",100);
        Book book2 = new Book("Summer","Harry Zen");
        book1.displayBook();
        System.out.println();
        book2.displayBook();
    }
}
