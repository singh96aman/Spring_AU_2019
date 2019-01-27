import { Component, OnInit } from "@angular/core";
import { BookService } from "src/app/providers/book.service";
import { Book } from "src/app/model/book";
import { Checkout } from "src/app/model/checkout";

@Component({
  selector: "app-home-page",
  templateUrl: "./home-page.component.html",
  styleUrls: ["./home-page.component.scss"]
})
export class HomePageComponent implements OnInit {
  books: any = [];
  AllBooks: any = [];
  id: string;
  bookName: string;
  authorName: string;
  price: number;
  description: string;

  constructor(private bookService: BookService) {}

  ngOnInit() {
    this.bookService.getAllBooks().subscribe(response => {
      this.AllBooks = response;
    });
  }

  postData() {
    const book = new Book(
      this.id,
      this.bookName,
      this.authorName,
      this.price,
      this.description
    );
    this.bookService.addBook(book).subscribe(response => {
      console.log(response);
    });
  }

  checkOutBook(id, bookName) {
    console.log(id + " " + bookName);
    const checkout = new Checkout(id, bookName);
    this.bookService.checkoutBook(checkout).subscribe(response => {
      console.log(response);
    });
  }
}
