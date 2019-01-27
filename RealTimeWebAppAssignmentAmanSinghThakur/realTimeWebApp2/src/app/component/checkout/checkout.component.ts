import { Component, OnInit } from "@angular/core";
import { BookService } from "src/app/providers/book.service";

@Component({
  selector: "app-checkout",
  templateUrl: "./checkout.component.html",
  styleUrls: ["./checkout.component.scss"]
})
export class CheckoutComponent implements OnInit {
  AllBooks: any[];

  constructor(private bookService: BookService) {}

  ngOnInit() {
    this.bookService.getAllCheckoutBooks().subscribe(response => {
      this.AllBooks = response;
      console.log(this.AllBooks);
    });
  }
}
